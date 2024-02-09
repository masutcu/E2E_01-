package stepdefinitions.e2e_test;

import io.cucumber.java.en.*;
import pojos.RoomPojo;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.e2e_test.MedunnaRoomStepDefinitions.roomNumberFaker;

public class DataBaseRoomStepDefs {
    Connection connection;
    Statement statement;
    /*
    önce dependency ekledik
     <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.5.0</version>
        </dependency>

     */
    @Given("connect to database")
    public void connect_to_database() throws SQLException {
        //1. adım Connection
       connection= DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2",
               "select_user",
               "Medunna_pass_@6");
       //2. adım statement oluştur
       statement=connection.createStatement();



    }
    @Then("read room and validate")
    public void read_room_and_validate() throws SQLException {
        //3. adım execute query
        String sqlQuery="SELECT * FROM room WHERE room_number = "+roomNumberFaker;
        ResultSet resultSet=statement.executeQuery(sqlQuery);//Query ile çağrılan data result set içerisinde yer alacak.
        resultSet.next();//herbir next ile bir satır aşağı kayar, next() methodu pointer ı sıradaki satıra alır

        //expected data mız
        RoomPojo expectedData=new RoomPojo(roomNumberFaker,"SUITE",true,123.00,"Created For End To End Test");

        //actual datalarımız
        String roomType=resultSet.getString("room_type");
        Boolean status=resultSet.getBoolean("status");
        Double price=resultSet.getDouble("price");
        String description=resultSet.getString("description");
        Integer roomNumber=resultSet.getInt("room_number");

        assertEquals(expectedData.getRoomType(), roomType);
        assertEquals(expectedData.getStatus(), status);
        assertEquals(expectedData.getPrice(), price);
        assertEquals(expectedData.getDescription(), description);
        assertEquals(expectedData.getRoomNumber(), roomNumber);




    }

}
