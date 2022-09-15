package com.boczar.RepositoryAPI.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Response {
    private String login;
    private List<Branch> branches;

}
