package com.boczar.RepositoryAPI.util;


import com.boczar.RepositoryAPI.model.exceptions.XmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;


@RestController
public class Controller {

    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/getRepos/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson(@PathVariable String name, @RequestHeader HttpHeaders headers) throws IOException {
        if (Objects.equals(headers.get("accept"), "application/xml")) {
            throw new XmlException(HttpStatus.NOT_ACCEPTABLE, "Header 'Adcept' must be 'application/json");
        } else {
            return responseService.getResponseByName(name);
        }
    }
}