package com.gdn.qa.module.ui.training.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component("com.gdn.qa.module.ui.training.properties.WebProperties")
@ConfigurationProperties(prefix = "web")
public class WebProperties {
    private Map<String, String> endpoint;
}
