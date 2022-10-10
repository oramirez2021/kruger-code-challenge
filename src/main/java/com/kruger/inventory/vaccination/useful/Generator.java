package com.kruger.inventory.vaccination.useful;

import com.kruger.inventory.vaccination.model.Employee;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * This Generator class allows us to handle the principal operations
 * about generating random necessary stuff as password and usernames
 */
public class Generator {
    /**
     *
     * @param len gets the length of the password required
     * @return returns the string with the random password
     */
    public String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random(len, chars);
    }

    /**
     *
     * @param employee gets the entire employee object in order to deserialize and generate a userName based in the input data
     * @return returns the string with the random userName
     */
    public String generateUsername(Employee employee) {

        Random generator = new Random();
        String user = employee.getNames().replaceAll("\\s+", "").toLowerCase().substring(0, 2)
                + employee.getSureNames().replaceAll("\\s+", "").toLowerCase().substring(0, 6)
                + String.valueOf(generator.nextInt(89) + 10);

        return user;
    }
}
