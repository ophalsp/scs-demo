package be.vlaanderen.wse.demo.listener.events.persoon;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class PersoonGevondenEvent implements PersoonEvent {

    private String correlationId;
    private Date tijdstip = new Date();
    private String persoonUuid;
}
