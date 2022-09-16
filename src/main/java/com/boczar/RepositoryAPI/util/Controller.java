package com.boczar.RepositoryAPI.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.boczar.RepositoryAPI.model.XmlException.getXmlException;


@RestController
public class Controller {

    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/getRepos/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson(@PathVariable String name) throws IOException {
        return responseService.getResponseByName(name);
    }

    @GetMapping(value = "/print")
    public String getAllheaders(@RequestHeader Map<String, String> headers) {
        if (headers.get("accept").equals("application/xml")) {
            return getXmlException();
        } else {
            return "this is json";
        }
    }
}