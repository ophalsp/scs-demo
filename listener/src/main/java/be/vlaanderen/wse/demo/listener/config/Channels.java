package be.vlaanderen.wse.demo.listener.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    String WSE_EVENTS_PERSOON = "wse_events_persoon";

    @Input(Channels.WSE_EVENTS_PERSOON)
    SubscribableChannel wse_events_persoon();

    String WSE_EVENTS_ONDERNEMING = "wse_events_onderneming";

    @Input(Channels.WSE_EVENTS_ONDERNEMING)
    SubscribableChannel wse_events_onderneming();
}
