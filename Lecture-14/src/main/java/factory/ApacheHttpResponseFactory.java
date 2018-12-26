package factory;

import constant.HttpMethodType;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

import static util.PrintHelper.printInfoAboutIoSyntaxException;
import static util.PrintHelper.printInfoAboutUriSyntaxException;

public class ApacheHttpResponseFactory {

    private static final String TOKEN = "9831d26fead1dcb4cd9419a9107a84555742f0a3";
    private static final CloseableHttpClient httpClient = HttpClients.custom().build();

    private ApacheHttpResponseFactory() {
    }

    public static CloseableHttpResponse generateRequest(String url, HttpMethodType methodType) {
        switch (methodType) {
            case GET: {
                CloseableHttpResponse httpResponse = null;
                try {
                    URIBuilder builderColl = new URIBuilder(url);
                    builderColl.setParameter("access_token", TOKEN);
                    HttpGet httpGetColl = new HttpGet(builderColl.build());
                    httpResponse = httpClient.execute(httpGetColl);
                } catch (URISyntaxException e1) {
                    printInfoAboutUriSyntaxException(e1);
                } catch (IOException e2) {
                    printInfoAboutIoSyntaxException(e2);
                }
                return httpResponse;
            }
            case PUT: {
                CloseableHttpResponse httpResponse = null;
                try {
                    URIBuilder builderUser = new URIBuilder(url);
                    builderUser.setParameter("access_token", TOKEN);
                    HttpPut httpPutUser = new HttpPut(builderUser.build());
                    System.out.println("\n Request: \n" + httpPutUser.getRequestLine());
                    httpResponse = httpClient.execute(httpPutUser);
                } catch (URISyntaxException e1) {
                    printInfoAboutUriSyntaxException(e1);
                } catch (IOException e2) {
                    printInfoAboutIoSyntaxException(e2);
                }
                return httpResponse;
            }
            default: {
                return null;
            }
        }
    }
}
