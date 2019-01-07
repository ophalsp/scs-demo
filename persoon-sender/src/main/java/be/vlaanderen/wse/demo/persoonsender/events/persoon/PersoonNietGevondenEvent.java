package be.vlaanderen.wse.demo.persoonsender.events.persoon;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class PersoonNietGevondenEvent implements PersoonEvent {

    private String correlationId;
    private Date tijdstip = new Date();
}
