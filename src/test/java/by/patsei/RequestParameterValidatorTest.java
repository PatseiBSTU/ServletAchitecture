package by.patsei;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class RequestParameterValidatorTest {


    private final static boolean VALID = true;
    private final static boolean INVALID = false;

    @DataProvider
    public static Object[][] DataForLoginValidation(){
        return new Object[][]{
                {"",INVALID},
                {"admin",VALID}
        };
    }

    @Test
    @UseDataProvider( "DataForLoginValidation")
    public void shouldValidateLogin(String login, boolean isValid) {
      //  Assert.assertEquals(VALIDATOR.isLoginValid(login),isValid);
    }
}
