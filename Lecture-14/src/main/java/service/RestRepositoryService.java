package service;

import client.IRestClient;
import constant.HttpMethodType;
import deserializer.Deserializer;
import model.GitHubResponse;
import model.GitUser;

import java.util.List;

public class RestRepositoryService implements IRepositoryService {

    private final IRestClient restClient;
    private GitHubResponse gitHubResponseFromGet;
    private GitHubResponse gitHubResponseFromPut;

    public RestRepositoryService(IRestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<GitUser> getCollaborators() {
        gitHubResponseFromGet = restClient.executeRequest(HttpMethodType.GET);
        return Deserializer.getListUsersFromJson(gitHubResponseFromGet);
    }

    @Override
    public String sendInvitation() {
        gitHubResponseFromPut = restClient.executeRequest(HttpMethodType.PUT);
        return gitHubResponseFromPut.getBody();
    }

    public GitHubResponse getGitHubResponseFromGet() {
        return gitHubResponseFromGet;
    }

    public GitHubResponse getGitHubResponseFromPut() {
        return gitHubResponseFromPut;
    }

    public IRestClient getRestClient() {
        return restClient;
    }
}
