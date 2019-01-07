package be.vlaanderen.wse.demo.listener.events.persoon;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Date;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersoonGevondenEvent.class, name = "PersoonGevondenEvent"),
        @JsonSubTypes.Type(value = PersoonNietGevondenEvent.class, name = "PersoonNietGevondenEvent")
})
public interface PersoonEvent extends Serializable {

    String getCorrelationId();

    Date getTijdstip();

}
