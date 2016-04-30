package com.conversantmedia.core.jms.domain

import com.conversantmedia.core.Application
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.channel.QueueChannel
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import spock.lang.Specification

@SpringApplicationConfiguration(value = [Application])
class GlobalWireTapTest extends Specification {
    @Autowired
    ObjectMapper objectMapper

    @Autowired
    @Qualifier("testChannel")
    QueueChannel testChannel

    @Autowired
    @Qualifier("inboundChannel")
    DirectChannel inboundChannel

    @Autowired
    @Qualifier("otherTappedChannel")
    DirectChannel otherTappedChannel


    def "Taps channels"(){
        given: "A message to put into the inboundChannel"
        String payload = "my payload"

        when: "The message is sent"
        inboundChannel.send(MessageBuilder.withPayload(payload).build())

        then: "The message is copied to the testChannel"
        Message receivedMessage = testChannel.receive(2000)
        receivedMessage

        and: "The channel interceptor list should be populated"
        otherTappedChannel.getChannelInterceptors().size() > 0
    }
}
