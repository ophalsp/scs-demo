package be.vlaanderen.wse.demo.listener.events.onderneming;

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
        @JsonSubTypes.Type(value = OndernemingGevondenEvent.class, name = "OndernemingGevondenEvent"),
})
public interface OndernemingEvent extends Serializable {

    String getCorrelationId();

    Date getTijdstip();

}
