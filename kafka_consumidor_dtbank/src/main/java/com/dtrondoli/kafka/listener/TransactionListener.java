package com.dtrondoli.kafka.listener;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.dtrondoli.kafka.avro.generated.AvroTransaction;

@Component
public class TransactionListener {
	
	private final static String QUERY_ACCOUNT_INFO = "{\"query\":\"{ account(id: %d){ status, balance }}\"}"; 
	private final static String MUTATION_ATT_BALANCE = "{\"query\":\"mutation{ attBalance(id: %d, newBalance: %.2f)}\"}";
	private final static String STATUS_OPEN = "OPEN";
	
	@KafkaListener(topics = "dtbank.transactions")
	public void listen(AvroTransaction t) {
		System.out.println("New Transaction Recived=> " + t);
		
		switch(t.getType()) {
		case "DEPOSIT":
			processDeposit(t);
			break;
		case "WITHDRAW":
			processWithdraw(t);
			break;
		case "TRANSFER":
			processTransfer(t);
			break;
		}
				
	}
	
	private void processTransfer(AvroTransaction t) {
		boolean success = false;
		
		Map<String, Object> sourceInfo = getAccountInfo(t.getAccountSource());
		Map<String, Object> targetInfo = getAccountInfo(t.getAccountTarget());
		
		var sourceOpen = ((String) sourceInfo.get("status")).equals(STATUS_OPEN);
		var targetOpen = ((String) targetInfo.get("status")).equals(STATUS_OPEN);		
		
		var sourceBalance = ((BigDecimal) sourceInfo.get("balance")).doubleValue();
		var targetBalance = ((BigDecimal) targetInfo.get("balance")).doubleValue();
		
		if(sourceOpen && targetOpen  && sourceBalance - t.getAmount() >= 0) {
			var newBalanceSource = sourceBalance - t.getAmount();
			var newBalanceTarget = targetBalance + t.getAmount();
			
			success = processTransaction(t.getAccountSource(), newBalanceSource);
			if(success) {
				success = processTransaction(t.getAccountTarget(), newBalanceTarget);
			}
		}
		
		if(success) {
			System.out.println("Transaction processed Successfully");
		}else{
			System.out.println("Transaction Failed");				
		}
	}

	private void processWithdraw(AvroTransaction t) {
		boolean success = false;
		
		Map<String, Object> accountInfo = getAccountInfo(t.getAccountSource());
		var balance = (BigDecimal) accountInfo.get("balance");		
		var status = (String) accountInfo.get("status");
		if(status.equals("OPEN") && balance.doubleValue() - t.getAmount() >= 0) {
			var newBalance = balance.doubleValue() - t.getAmount();
			success = processTransaction(t.getAccountSource(), newBalance);
		}
		
		if(success) {
			System.out.println("Transaction processed Successfully");
		}else{
			System.out.println("Transaction Failed");				
		}
	}

	private void processDeposit(AvroTransaction t) {
		
		boolean success = false;
		
		Map<String, Object> accountInfo = getAccountInfo(t.getAccountTarget());
		var balance = (BigDecimal) accountInfo.get("balance");		
		var status = (String) accountInfo.get("status");
		if(status.equals("OPEN")) {
			var newBalance = balance.doubleValue() + t.getAmount();
			success = processTransaction(t.getAccountTarget(), newBalance);
		}
		
		if(success) {
			System.out.println("Transaction processed Successfully");
		}else{
			System.out.println("Transaction Failed");				
		}
	}
	
	private boolean processTransaction(Long id, double newBalance) {		
		boolean success = false;
		
		String queryJson = String.format(Locale.US, MUTATION_ATT_BALANCE, id, newBalance);
		HttpResponse<String> response = executeGraphQLRequest(queryJson);
		
		if(response.statusCode() == 200) {
			JSONObject j = new JSONObject(response.body());
			var data = j.getJSONObject("data");
			
			success = (boolean) data.get("attBalance");
		}
		return success;
	}

	private Map<String,Object> getAccountInfo(Long id){
		var values = new HashMap<String, Object>();
		try {
			
			String queryJson = String.format(QUERY_ACCOUNT_INFO, id);
			// create a request
			
			HttpResponse<String> response = executeGraphQLRequest(queryJson);
			
			if(response.statusCode() == 200) {
				JSONObject j = new JSONObject(response.body());
				var account = j.getJSONObject("data").getJSONObject("account");
				
				values.put("balance", account.get("balance"));
				values.put("status", account.get("status"));
				
			}
//			// the response:
//			HttpHeaders headers = response.headers();
//	        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
//
//	        // print status code
//	        System.out.println(response.statusCode());
//
//	        // print response body
//	        System.out.println(response.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return values;
	}
	
	private HttpResponse<String> executeGraphQLRequest(String queryJson) {
		try {
			var request = HttpRequest.newBuilder(URI.create("http://localhost:5050/graphql"))
					.header("accept", "application/json").header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(queryJson)).build();

			// create a client
			var client = HttpClient.newHttpClient();
			
			// use the client to send the request
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Bean
	public NewTopic adviceTopic() {
		return new NewTopic("dtbank.transactions", 1, (short) 1);
	}

}
