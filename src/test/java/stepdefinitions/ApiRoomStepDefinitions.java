package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.MedunnaRoomStepDefinitions.roomId;
import static stepdefinitions.MedunnaRoomStepDefinitions.roomNumberFaker;

public class ApiRoomStepDefinitions {
    Response response;
    @Given("send get request to url")
    public void send_get_request_to_url() {
        //Set the url--> https://medunna.com/api/rooms?sort=createdDate,desc
        spec.pathParams("first","api","second","rooms")
                .queryParams("sort","createdDate,desc");

        //Set the expected data

        //Send the request and get the response
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();


    }
    @When("validate body")
    public void validate_body() {
        //Do assertion
        Object actualRoomType = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomType").get(0);//Groovy language kullanıyoruz.
        // Gelen body içinden bizim oluşturduğumuz odanın numarası ile filtreleme yapıyoruz.
        Object actualStatus = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.status").get(0);//Filtrelenen bodyden gerekli datayı nokta sonrasına belirterek alıyoruz.
        Object actualPrice = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.price").get(0);
        Object actualDescription = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.description").get(0);
        Object actualRoomNumber = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomNumber").get(0);

        assertEquals("PREMIUM_DELUXE", actualRoomType);
        assertEquals(true, actualStatus);
        assertEquals( "123.0", actualPrice+"");
        assertEquals( "Created For End To End Test", actualDescription);
        assertEquals( roomNumberFaker, actualRoomNumber);


    }

    @Given("send get request to url by id")
    public void sendGetRequestToUrlById() {
        //set the url https://medunna.com/api/rooms/54994
        spec.pathParams("first","api","second","rooms","third",roomId);
        //set the expected data



    }

    @When("validate response body")
    public void validateResponseBody() {
    }
}
