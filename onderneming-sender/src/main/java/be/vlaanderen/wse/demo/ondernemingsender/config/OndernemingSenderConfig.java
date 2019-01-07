package be.vlaanderen.wse.demo.ondernemingsender.config;

import be.vlaanderen.wse.demo.ondernemingsender.events.onderneming.OndernemingGevondenEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@Configuration
@EnableBinding(Channels.class)
public class OndernemingSenderConfig {

    @Bean
    @InboundChannelAdapter(value = Channels.WSE_EVENTS, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
    public MessageSource timerMessageSource() {
        return () -> MessageBuilder
                .withPayload(OndernemingGevondenEvent.builder()
                        .correlationId(UUID.randomUUID().toString())
                        .ondernemingUuid(UUID.randomUUID().toString())
                        .build())
                .build();
    }
}
