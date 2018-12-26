package client;

import constant.HttpMethodType;
import model.GitHubResponse;

public interface IRestClient {

    GitHubResponse executeRequest(String url, HttpMethodType methodType);
}
