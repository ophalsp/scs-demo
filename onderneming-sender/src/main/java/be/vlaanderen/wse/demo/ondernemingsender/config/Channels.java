package be.vlaanderen.wse.demo.ondernemingsender.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {

    String WSE_EVENTS = "wse_events";

    @Output(Channels.WSE_EVENTS)
    MessageChannel wse_events();
}
