package com.dtrondoli.kafka.producer;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.dtrondoli.domain.Transaction;
import com.dtrondoli.kafka.avro.generated.AvroTransaction;
import com.dtrondoli.kafka.config.KafkaProducerConfig;

@Component
public class TransactionProducer {
	
	@Autowired
	KafkaTemplate<String, AvroTransaction> transactionKafkaTemplate;
	@Autowired
	KafkaProducerConfig kc;
	
	public void sendTransaction(Transaction t) {		
		
		AvroTransaction avro = new AvroTransaction();
		avro.setId(t.getId());
		avro.setAmount(t.getAmount());
		avro.setType(t.getType());
		avro.setAccountSource(t.getAccountSource() != null ? t.getAccountSource().getId() : null);
		avro.setAccountTarget(t.getAccountTarget() != null ? t.getAccountTarget().getId() : null);
		
		try {
			
			KafkaProducerConfig config = new KafkaProducerConfig();
			config.init();
			transactionKafkaTemplate = config.transactionKafkaTemplate();
			
        	transactionKafkaTemplate.sendDefault(avro).completable().get();
            System.out.println("Wrote transaction to broker => " + avro);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
	}
}
