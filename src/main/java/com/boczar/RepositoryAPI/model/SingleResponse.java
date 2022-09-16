package com.boczar.RepositoryAPI.model;

import lombok.Data;

@Data
public class SingleResponse {
    private String repositoryName;
    private Branch[] branches;
}
