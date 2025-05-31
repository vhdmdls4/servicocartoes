package com.victorduarte.servicocartoes.infra.queues;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardIssuingSubscriber {
    @RabbitListener(queues = "${mq.queues.card-issuing}")
    public void handleIssuingRequest(@Payload String payload){
       log.info("[Message received - mq.queues.card-issuing]: Payload - {}", payload);
    }
}
