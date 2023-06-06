package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AthenticationMedunna {
    public static String generateToken(){
        /*
        body
        {
  "password": "Mark.123",
  "rememberMe": true,
  "username": "mark_twain"
}
end point : https://medunna.com/api/authenticate
body yi end pointe get request yaptığımızda token alacağız.
body içinde admin kullanıcı adı ve şifre var.
Bu bilgileri sweger dökümanından buluyoruz.
         */
        String body ="{ \"password\": \"Mark.123\", \"rememberMe\": true, \"username\": \"mark_twain\" }";

        Response response=given().contentType(ContentType.JSON).body(body).post("https://medunna.com/api/authenticate");
        response.prettyPrint();
        return response.jsonPath().getString("id_token");

    }
}
