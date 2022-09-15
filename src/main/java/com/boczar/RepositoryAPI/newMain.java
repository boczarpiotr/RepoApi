package com.boczar.RepositoryAPI;

import com.boczar.RepositoryAPI.Model.Branch;
import com.boczar.RepositoryAPI.Util.BranchService;
import com.boczar.RepositoryAPI.Util.RepoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class newMain {

    public static void main(String[] args) throws IOException {
        BranchService branchService = new BranchService();
        RepoService repoService = new RepoService();
        List<Branch[]> listOfLists = new ArrayList<>();

        List<String> repos = repoService.getRepoNamesByUserName("peter");

        for (String repo : repos) {
            Branch[] branches = branchService.getBranchesByRepoName("peter", repo);
            listOfLists.add(branches);

        }
        List<Branch> finalList = listOfLists.stream()
                .flatMap(Stream::of)
                .toList();

        for(Branch branch : finalList){
            System.out.println(branch.getCommit().getSha());
        }
    }
}
