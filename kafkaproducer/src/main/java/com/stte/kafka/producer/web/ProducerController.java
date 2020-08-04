package com.stte.kafka.producer.web;

import com.stte.kafka.producer.domain.RecordMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * create by BloodFly at 2018/12/31
 */
@RestController

public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping(path = "/send/topicA/{what}")
    public void sendToTopicA(@PathVariable String what) {
        logger.info("sendToTopicA:{}", what);
        RecordMessage recordMessage = new RecordMessage();
        recordMessage.setId(System.currentTimeMillis());
        recordMessage.setMessage("this is topicA");
        recordMessage.setSendTime(new Date());
        template.send("topicA", recordMessage);
    }
}
