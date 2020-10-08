package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, byte[]> byteKafkaTemplate;

    public void sendTopicString(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void sendTopicByte(String topic, byte[] message) {
        byteKafkaTemplate.send(topic, message);
    }


}
