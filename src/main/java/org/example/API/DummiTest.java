package org.example.API;

import org.example.API.DTO.CreateRequesBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.with;

public class DummiTest extends BaseApiTest {
    @Test
    public void createTest() {
        CreateRequesBody body = new CreateRequesBody("TestAt", 900, 45);
        String requetBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

        String requetBodyTest = """
            {
            "name" : "test",
            "salary" : "123"
            "age" : "25"
            }
            """;
        with().body(body).when().post("https://dummy.restapiexample.com/api/v1/create").then().assertThat().statusCode(200).and().log().body();

    }

}