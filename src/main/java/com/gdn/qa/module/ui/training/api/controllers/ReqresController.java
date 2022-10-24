package com.gdn.qa.module.ui.training.api.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gdn.qa.automation.core.json.JsonApi;
import com.gdn.qa.automation.core.restassured.ResponseApi;
import com.gdn.qa.automation.core.restassured.ServiceApi;
import com.gdn.qa.module.ui.training.models.responses.reqres.ListUsers;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("com.gdn.qa.module.ui.training.api.services.ReqresController")
public class ReqresController extends ServiceApi {

    @Autowired
    private JsonApi jsonApi;

    public ResponseApi<ListUsers> getListUsers(int page) {

        Response response = service("reqres")
                .queryParam("page", page)
                .get("users");

        response.getBody().prettyPrint();

        return jsonApi.fromJson(response, new TypeReference<ListUsers>(){});
    }

}