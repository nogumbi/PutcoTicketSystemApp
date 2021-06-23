package tests;

import org.junit.jupiter.api.Test;
import putcoTicketingSystem.passwordValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidTest
{
    @Test
    public void passValidTest()
    {
        String str1 = "Geeks@portal20";
        passwordValidator valid = new passwordValidator();
        assertEquals(valid.isValidPassword(str1), true);
    }
}
