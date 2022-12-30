package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {
    protected RequestSpecification spec;

    public GoRestBaseUrl() {
    }

    @Before
    public void setup() {
        this.spec = (new RequestSpecBuilder()).setBaseUri("https://gorest.co.in/public/v1").build();
    }
}
