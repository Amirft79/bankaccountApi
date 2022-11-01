package ir.cactus.restspringapi;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class SpringRestClient {

    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8082/customers";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringRestClient springRestClient=new SpringRestClient();
        springRestClient.getCustomers();

    }

    private void getCustomers() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
                String.class);
        System.out.println(result);
    }
}
