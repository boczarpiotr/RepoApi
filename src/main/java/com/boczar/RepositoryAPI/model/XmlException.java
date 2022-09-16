package com.boczar.RepositoryAPI.model;

import com.google.gson.Gson;

public class XmlException {
    private final String status = "406";
    private final String Message = "Header 'accept' should be 'application/json'";

    public static String getXmlException(){
        return new Gson().toJson(new XmlException());
    }
}
