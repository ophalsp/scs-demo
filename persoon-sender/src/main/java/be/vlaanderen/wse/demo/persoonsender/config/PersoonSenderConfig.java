package be.vlaanderen.wse.demo.persoonsender.config;


import be.vlaanderen.wse.demo.persoonsender.events.persoon.PersoonGevondenEvent;
import be.vlaanderen.wse.demo.persoonsender.events.persoon.RandomInvalidPersoonEvent;
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
public class PersoonSenderConfig {

    @Bean
    @InboundChannelAdapter(value = Channels.WSE_EVENTS, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
    public MessageSource sendPersoonGevonden() {
        return () -> MessageBuilder
                .withPayload(PersoonGevondenEvent.builder()
                        .correlationId(UUID.randomUUID().toString())
                        .persoonUuid(UUID.randomUUID().toString())
                        .build())
                .setHeader("type", PersoonGevondenEvent.class.getSimpleName())
                .setHeader("routing", "wse.persoon.event.PersoonGevondenEvent")
                .build();
    }

    @Bean
    @InboundChannelAdapter(value = Channels.WSE_EVENTS, poller = @Poller(fixedDelay = "20000", maxMessagesPerPoll = "1"))
    public MessageSource sendPersoonNietGevonden() {
        return () -> MessageBuilder
                .withPayload(PersoonGevondenEvent.builder()
                        .correlationId(UUID.randomUUID().toString())
                        .build())
                .setHeader("type", PersoonGevondenEvent.class.getSimpleName())
                .setHeader("routing", "wse.persoon.event.PersoonGevondenEvent")
                .build();
    }

    @Bean
    @InboundChannelAdapter(value = Channels.WSE_EVENTS, poller = @Poller(fixedDelay = "20000", maxMessagesPerPoll = "1"))
    public MessageSource sendRandomInvalidPersoon() {
        return () -> MessageBuilder
                .withPayload(RandomInvalidPersoonEvent.builder()
                        .correlationId(UUID.randomUUID().toString())
                        .build())
                .setHeader("type", RandomInvalidPersoonEvent.class.getSimpleName())
                .setHeader("routing", "wse.persoon.event.RandomInvalidPersoonEvent")
                .build();
    }
}
