package com.kruger.inventory.vaccination.useful;

import com.kruger.inventory.vaccination.model.Employee;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Generator {
    public String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random(len, chars);
    }

    public String generateUsername(Employee employee) {

        Random generator = new Random();
        String user = employee.getNames().replaceAll("\\s+", "").toLowerCase().substring(0, 2)
                + employee.getSureNames().replaceAll("\\s+", "").toLowerCase().substring(0, 6)
                + String.valueOf(generator.nextInt(89) + 10);

        return user;
    }
}
