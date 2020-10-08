package com.example.demo.controller;

import com.example.demo.service.KafkaService;
import com.example.demo.util.GzipUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaService kafkaService;

    @GetMapping(value = "/string")
    public Map<String, Object> callString() {
        String message = "hello!";
        kafkaService.sendTopicString("test-string-topic", message);

        Map<String, Object> output = new Hashtable<>();
        output.put("code", 0);
        output.put("msg", "success");
        return output;
    }

    @GetMapping(value = "/byte")
    public Map<String, Object> callByte() throws Exception {
        byte[] message = GzipUtil.compress("hello!");
        kafkaService.sendTopicByte("test-byte-topic", message);

        Map<String, Object> output = new Hashtable<>();
        output.put("code", 0);
        output.put("msg", "success");
        return output;
    }
}
