package be.vlaanderen.wse.demo.listeneronlypersoon.events.persoon;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RandomInvalidPersoonEvent.class, name = "RandomInvalidPersoonEvent")
})
public interface PersoonEvent {

    String getCorrelationId();

    Date getTijdstip();

}
