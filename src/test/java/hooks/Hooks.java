package hooks;

import io.cucumber.java.Before;

import static base_urls.MedunnaBaseUrl.setUp;

public class Hooks {

    @Before("@e2e")//Sadece parantez içinde belirtilen tag senaryoları öncesi çalışır
    public void beforeApi(){

        setUp();

    }


}
