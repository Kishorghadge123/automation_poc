package Pages;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Persons_page {
    static String getEmployeeSQL = "Select * from Persons ";

    @Step("validate PersonID")
    public static void verifyPersonID(ResultSet resultSet, int expected) throws SQLException {
        Assert.assertEquals(resultSet.getInt("PersonID"),expected,"PersonID mismatch");
    }
    @Step("validate LastName")
    public static void verifyLastName(ResultSet resultSet, String expected) throws SQLException {
        Assert.assertEquals(resultSet.getString("LastName"),expected,"LastName mismatch");
    }
    @Step("validate FirstName")
    public static void verifyFirstName(ResultSet resultSet, String expected) throws SQLException {
        Assert.assertEquals(resultSet.getString("FirstName"),expected,"FirstName mismatch");
    }
    @Step("validate Address")
    public static void verifyAddress(ResultSet resultSet, String expected) throws SQLException {
        Assert.assertEquals(resultSet.getString("Address"),expected,"Address mismatch");
    }
    @Step("validate City")
    public static void verifyCity(ResultSet resultSet, String expected) throws SQLException {
        Assert.assertEquals(resultSet.getString("City"),expected,"City mismatch");
    }

}
