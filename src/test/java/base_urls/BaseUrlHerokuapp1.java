package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuapp1 {
    protected RequestSpecification spec;

    public BaseUrlHerokuapp1() {
    }

    @Before
    public void setup() {
        this.spec = (new RequestSpecBuilder()).setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
