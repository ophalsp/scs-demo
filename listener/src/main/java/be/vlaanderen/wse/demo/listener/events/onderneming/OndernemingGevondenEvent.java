package be.vlaanderen.wse.demo.listener.events.onderneming;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class OndernemingGevondenEvent implements OndernemingEvent {

    private String correlationId;

    private Date tijdstip = new Date();

    private String ondernemingUuid;
}
