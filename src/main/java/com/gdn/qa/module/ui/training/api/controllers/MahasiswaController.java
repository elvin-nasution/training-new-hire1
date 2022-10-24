package com.gdn.qa.module.ui.training.api.controllers;

import com.gdn.qa.automation.core.restassured.ServiceApi;
import com.gdn.qa.automation.core.template.TemplateApi;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller("com.gdn.qa.module.ui.training.api.controllers.MahasiswaController")
public class MahasiswaController extends ServiceApi {

    @Autowired
    private TemplateApi templateApi;

    public void insertMahasiswa(Map<String, String > mahasiswaData){
        String body = templateApi.create("InsertMahasiswa", mahasiswaData);

        Response response = service("badak")
                .body(body)
                .post();

        response.getBody().prettyPrint();
    }

}