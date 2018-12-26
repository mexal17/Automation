package client;

import com.jayway.restassured.response.Response;
import constant.HttpMethodType;
import factory.RestAssuredResponseFactory;
import model.GitHubResponse;

public class RestAssuredClient implements IRestClient{

    @Override
    public GitHubResponse executeRequest(String url, HttpMethodType methodType) {
        Response response = RestAssuredResponseFactory.generateRequest(url, methodType);
        return new GitHubResponse(response.asString(),response.statusCode());
    }
}
