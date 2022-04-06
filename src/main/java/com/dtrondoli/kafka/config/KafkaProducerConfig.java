package com.dtrondoli.kafka.config;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.dtrondoli.kafka.avro.generated.AvroTransaction;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

@Configuration
public class KafkaProducerConfig {
	private static final Logger LOGGER = LogManager.getLogger(KafkaProducerConfig.class);
	
	@Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.schema-registry-server}")
    private String schemaRegistryServer;

    private Map<String, Object> producerConfigs;
    
    @PostConstruct
    public void init() {
        this.producerConfigs = new HashMap<>();
        producerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        producerConfigs.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        LOGGER.warn("Kafka producer configs: {}", producerConfigs);
    }

    @Bean
    public KafkaTemplate<String, AvroTransaction> transactionKafkaTemplate() {
        KafkaTemplate<String, AvroTransaction> kafkaTemplate = new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(this.producerConfigs));
        kafkaTemplate.setDefaultTopic("dtbank.transactions");
        return kafkaTemplate;
    }
    
}	
