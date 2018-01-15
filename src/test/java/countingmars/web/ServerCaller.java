package countingmars.web;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class ServerCaller {
    private TestRestTemplate testRestTemplate;

    public ServerCaller(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }
    public <T> ResponseEntity<T> get(String url, Class<T> clazz) {
        return call(HttpMethod.GET, url, null, clazz);
    }
    public <T> ResponseEntity<T> delete(String url, Class<T> clazz) {
        return call(HttpMethod.DELETE, url, null, clazz);
    }
    public <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType) {
        return call(HttpMethod.POST, url, request, responseType);
    }
    public <T> ResponseEntity<T> put(String url, Object request, Class<T> responseType) {
        return call(HttpMethod.PUT, url, request, responseType);
    }

    private <T> ResponseEntity<T> call(HttpMethod method, String url, Object request, Class<T> responseType) {
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity(request, requestHeaders);
        return testRestTemplate.exchange(
                url,
                method,
                requestEntity,
                responseType
        );
    }
}
