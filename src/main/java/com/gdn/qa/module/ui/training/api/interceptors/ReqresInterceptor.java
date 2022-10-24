package com.gdn.qa.module.ui.training.api.interceptors;

import com.gdn.qa.automation.core.restassured.ServiceInterceptor;
import io.restassured.config.ParamConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

@Component("com.gdn.qa.module.ui.training.api.interceptors.ReqresInterceptor")
public class ReqresInterceptor implements ServiceInterceptor {
    @Override
    public boolean isSupport(String serviceName) {
        return serviceName.equalsIgnoreCase("reqres");
    }

    @Override
    public void prepare(RequestSpecification specification) {
        specification.config(RestAssuredConfig.config() .paramConfig(ParamConfig.paramConfig().replaceAllParameters())).log().all();
    }

}