package be.vlaanderen.wse.demo.ondernemingsender.events.onderneming;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OndernemingGevondenEvent.class, name = "OndernemingGevondenEvent"),
})
public interface OndernemingEvent {

    String getCorrelationId();

    Date getTijdstip();

}
