package be.vlaanderen.wse.demo.listeneronlypersoon.listener;

import be.vlaanderen.wse.demo.listeneronlypersoon.config.Channels;
import be.vlaanderen.wse.demo.listeneronlypersoon.events.persoon.PersoonEvent;
import be.vlaanderen.wse.demo.listeneronlypersoon.events.persoon.RandomInvalidPersoonEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventsListener {

    @StreamListener(target = Channels.WSE_EVENTS_PERSOON, condition = "headers['type']=='RandomInvalidPersoonEvent'")
    public void handlePersoonEvents(@Payload RandomInvalidPersoonEvent event) {
        log.info("handlePersoonEvents: " + ReflectionToStringBuilder.toString(event));
    }
}
