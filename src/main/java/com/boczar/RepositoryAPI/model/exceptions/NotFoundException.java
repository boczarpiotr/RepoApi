package com.boczar.RepositoryAPI.model.exceptions;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

}

