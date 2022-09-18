package com.boczar.RepositoryAPI.model.exceptions;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class XmlException extends ResponseStatusException {

    public XmlException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
