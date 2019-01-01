package client;

import constant.HttpMethodType;
import constant.LibraryType;
import factory.ApacheHttpResponseFactory;
import model.GitHubResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static util.PrintHelper.printInfoAboutIoSyntaxException;

public class ApacheClient implements IRestClient {

    @Override
    public GitHubResponse executeRequest(HttpMethodType methodType) {
        CloseableHttpResponse httpResponse = ApacheHttpResponseFactory.getResponse(methodType);
        String body = null;
        try {
            body = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            printInfoAboutIoSyntaxException(e);
        }
        return new GitHubResponse(body, httpResponse.getStatusLine().getStatusCode());
    }

    @Override
    public LibraryType getType() {
        return LibraryType.APACHE_HTTP;
    }
}
