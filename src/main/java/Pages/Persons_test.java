package Pages;

import Utility.DBUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Persons_test {

    @BeforeClass
    public void startUp(){
        DBUtils.setConnection();
    }

    @AfterClass
    public void tearDown() throws SQLException {
        DBUtils.closeConnection();
    }

    @Feature("Database test")
    @Story("DBT-001: validation of Persons details")
    @Test(description = "to verify the Persons records are fetched correctly from DB")
    @Description("Validation of Persons Record")
    public void getEmployeeTest() throws SQLException {
        Persons_page Employee = null;
        ResultSet resultSet = DBUtils.getValues(Persons_page.getEmployeeSQL);
        resultSet.next();
        Persons_page.verifyPersonID(resultSet,2022001);
        Persons_page.verifyLastName(resultSet,"AmitDada");
        Persons_page.verifyFirstName(resultSet,"korde");
        Persons_page.verifyAddress(resultSet,"Zensar Colony");
        Persons_page.verifyCity(resultSet,"Sangamner");
    }
}
