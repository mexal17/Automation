package client;

import constant.HttpMethodType;
import factory.ApacheHttpResponseFactory;
import model.GitHubResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static util.PrintHelper.printInfoAboutIoSyntaxException;

public class ApacheClient implements IRestClient {

    @Override
    public GitHubResponse executeRequest(String url, HttpMethodType methodType) {
        CloseableHttpResponse httpResponse = ApacheHttpResponseFactory.generateRequest(url, methodType);
        String body = null;
        try {
            body = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            printInfoAboutIoSyntaxException(e);
        }
        return new GitHubResponse(body, httpResponse.getStatusLine().getStatusCode());
    }
}
