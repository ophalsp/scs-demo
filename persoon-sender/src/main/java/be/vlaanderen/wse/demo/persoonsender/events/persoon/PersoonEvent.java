package be.vlaanderen.wse.demo.persoonsender.events.persoon;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersoonGevondenEvent.class, name = "PersoonGevondenEvent"),
        @JsonSubTypes.Type(value = PersoonNietGevondenEvent.class, name = "PersoonNietGevondenEvent"),
        @JsonSubTypes.Type(value = RandomInvalidPersoonEvent.class, name = "RandomInvalidPersoonEvent")
})
public interface PersoonEvent {

    String getCorrelationId();

    Date getTijdstip();

}
