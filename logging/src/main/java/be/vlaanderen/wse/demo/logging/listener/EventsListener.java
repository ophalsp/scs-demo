package be.vlaanderen.wse.demo.logging.listener;

import be.vlaanderen.wse.demo.logging.config.Channels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventsListener {

    @StreamListener(Channels.WSE_EVENTS)
    public void handleEvents(@Payload String event){
        log.info("logging: " + event);
    }
}
