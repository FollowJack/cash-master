package services;

import org.junit.Before;
import org.junit.Test;
import util.date.DateHelper;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Deniel on 17.02.2015.
 */
public class TestDateHelper {


    @Before
    public void initialize() {
    }

    @Test
    public void TestAddMonth() {
        // Arrange - create december
        Date november = DateHelper.getFullDate("15.11.2014 15:00:17");
        Date januar = DateHelper.getFullDate("15.01.2015 15:00:17");
        // Act - add month
        Date result = DateHelper.addMonth(november,2);
        // Assert - check if month is now january next year
        assertEquals(result,januar);
    }

    @Test
    public void TestAddMonth_withEmptyParameter() {
        // Act - add month
        Date result = DateHelper.addMonth(null,2);
        // Assert - check if month is now january next year
        assertEquals(result,null);
    }
}
