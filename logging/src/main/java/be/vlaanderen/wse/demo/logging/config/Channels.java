package be.vlaanderen.wse.demo.logging.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    String WSE_EVENTS = "wse_events";

    @Input(Channels.WSE_EVENTS)
    SubscribableChannel wse_events();
}
