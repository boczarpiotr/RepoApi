package com.boczar.RepositoryAPI.model;

import com.google.gson.Gson;

public class NotFoundException {
    private final String status = "404";
    private final String Message = "There is no such a login";

    public static String getNotFoundException(){
        return new Gson().toJson(new NotFoundException());
    }
}
