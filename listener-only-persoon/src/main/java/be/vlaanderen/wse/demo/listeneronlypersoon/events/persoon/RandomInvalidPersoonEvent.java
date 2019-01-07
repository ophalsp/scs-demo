package be.vlaanderen.wse.demo.listeneronlypersoon.events.persoon;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class RandomInvalidPersoonEvent implements PersoonEvent {

    private String correlationId;
    private Date tijdstip = new Date();
}
