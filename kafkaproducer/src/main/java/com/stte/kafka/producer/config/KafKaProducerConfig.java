package com.stte.kafka.producer.config;

import com.stte.kafka.producer.domain.RecordMessage;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * create by BloodFly at 2018/12/31
 */
@Configuration
@EnableKafka
public class KafKaProducerConfig {

    private final Logger logger = LoggerFactory.getLogger(KafKaProducerConfig.class);

    /**
     * 定义记录消息转换器
     *
     * @return
     */
    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

//    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory<Object, Object> kafaConsumerFactory,
            KafkaTemplate<Object, Object> template
    ) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafaConsumerFactory);
        return factory;
    }


    @KafkaListener(id = "groupA", topics = "topicA")
    public void consumerA(RecordMessage recordMessage) {
        logger.info("received from topicA:{}", recordMessage);
    }

    @KafkaListener(id = "groupB", topics = {"topicA.DLT"})
    public void consumerB(String recordMessage) {
        logger.info("received from topicA.DLT:{}" + recordMessage);
    }


    @Bean
    public NewTopic topicA() {
        // 新建主题，指定复制因子和分区数
        return new NewTopic("topicA", 1, (short) 1);
    }

    @Bean
    public NewTopic topicADlt() {
        return new NewTopic("topicA.DLT", 1, (short) 1);
    }
}
