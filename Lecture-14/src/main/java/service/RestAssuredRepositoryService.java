package service;

import client.IRestClient;
import constant.HttpMethodType;
import deserializer.Deserializer;
import model.GitHubResponse;
import model.GitUser;

import java.util.List;

public class RestAssuredRepositoryService implements IRepositoryService {

    private final IRestClient restClient;
    private static final String URI_COLLABORATORS = "/repos/mexal17/Lecture-2/collaborators";
    private GitHubResponse gitHubResponseFromGet;
    private GitHubResponse gitHubResponseFromPut;

    public RestAssuredRepositoryService(IRestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<GitUser> getCollaborators() {
        gitHubResponseFromGet = restClient.executeRequest(URI_COLLABORATORS, HttpMethodType.GET);
        return Deserializer.getListUsersFromJson(gitHubResponseFromGet);
    }

    @Override
    public String sendInvitation() {
        gitHubResponseFromPut = restClient.executeRequest(URI_COLLABORATORS + "/user5", HttpMethodType.PUT);
        return gitHubResponseFromPut.getBody();
    }

    public GitHubResponse getGitHubResponseFromGet() {
        return gitHubResponseFromGet;
    }

    public GitHubResponse getGitHubResponseFromPut() {
        return gitHubResponseFromPut;
    }
}
