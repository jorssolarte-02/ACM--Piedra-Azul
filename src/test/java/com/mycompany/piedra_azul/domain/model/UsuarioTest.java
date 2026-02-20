/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.piedra_azul.domain.model;

/*import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
*/
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void testConstructorSinId() {
        Usuario u = new Usuario(
                "juan123",
                "hash123",
                "Juan Perez",
                Rol.ADMINISTRADOR
        );

        assertEquals("juan123", u.getUsername());
        assertEquals("hash123", u.getPasswordHash());
        assertEquals("Juan Perez", u.getNombreCompleto());
        assertEquals(Rol.ADMINISTRADOR, u.getRol());
        assertTrue(u.isActivo());
        assertEquals(0, u.getIntentosFallidos());
    }

    @Test
    public void testSettersYGetters() {
        Usuario u = new Usuario();

        u.setId(10);
        u.setUsername("ana");
        u.setPasswordHash("hash456");
        u.setNombreCompleto("Ana Lopez");
        u.setRol(Rol.PACIENTE); // ESTE sí existe en tu enum
        u.setActivo(false);
        u.setIntentosFallidos(3);

        assertEquals(10, u.getId());
        assertEquals("ana", u.getUsername());
        assertEquals("hash456", u.getPasswordHash());
        assertEquals("Ana Lopez", u.getNombreCompleto());
        assertEquals(Rol.PACIENTE, u.getRol());
        assertFalse(u.isActivo());
        assertEquals(3, u.getIntentosFallidos());
    }
}