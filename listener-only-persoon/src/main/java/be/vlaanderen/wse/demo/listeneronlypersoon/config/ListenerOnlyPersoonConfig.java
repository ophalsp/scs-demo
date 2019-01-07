package be.vlaanderen.wse.demo.listeneronlypersoon.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Channels.class)
public class ListenerOnlyPersoonConfig {
}
