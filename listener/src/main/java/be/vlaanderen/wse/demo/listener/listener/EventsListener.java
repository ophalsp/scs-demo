package be.vlaanderen.wse.demo.listener.listener;

import be.vlaanderen.wse.demo.listener.config.Channels;
import be.vlaanderen.wse.demo.listener.events.onderneming.OndernemingEvent;
import be.vlaanderen.wse.demo.listener.events.persoon.PersoonEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventsListener {

    @StreamListener(target = Channels.WSE_EVENTS_PERSOON)
    public void handlePersoonEvents(@Payload PersoonEvent event) {
        log.info("handlePersoonEvents: " + ReflectionToStringBuilder.toString(event));
    }

    @StreamListener(target = Channels.WSE_EVENTS_ONDERNEMING)
    public void handleOndernemingEvents(@Payload OndernemingEvent event) {
        log.info("handleOndernemingEvents: " + ReflectionToStringBuilder.toString(event));
    }
}
