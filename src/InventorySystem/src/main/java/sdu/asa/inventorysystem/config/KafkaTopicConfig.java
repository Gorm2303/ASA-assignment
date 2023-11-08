package sdu.asa.inventorysystem.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic order(){
        return TopicBuilder.name("order")
                .build();
    }

    @Bean
    public NewTopic orderPart(){
        return TopicBuilder.name("order-part")
                .build();
    }
}
