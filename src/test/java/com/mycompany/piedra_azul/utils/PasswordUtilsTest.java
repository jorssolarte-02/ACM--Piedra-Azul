/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.piedra_azul.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julian david
 */

public class PasswordUtilsTest {

    @Test
    public void testHashPasswordNoEsIgualAlTextoPlano() {
        String password = "1234";
        String hash = PasswordUtils.hashPassword(password);

        assertNotEquals(password, hash);
        assertNotNull(hash);
    }

    @Test
    public void testVerifyPasswordCorrecta() {
        String password = "ClaveSegura123";
        String hash = PasswordUtils.hashPassword(password);

        boolean resultado = PasswordUtils.verifyPassword(password, hash);

        assertTrue(resultado);
    } 

    @Test
    public void testVerifyPasswordIncorrecta() {
        String password = "ClaveSegura123";
        String hash = PasswordUtils.hashPassword(password);

        boolean resultado = PasswordUtils.verifyPassword("otraClave", hash);

        assertFalse(resultado);
    }
}