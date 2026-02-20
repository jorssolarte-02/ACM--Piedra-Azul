package com.mycompany.piedra_azul.domain.model;

/*import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;*/
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julian david
 */



public class RolTest {

    @Test
    public void testValoresDelEnum() {
        Rol[] valores = Rol.values();

        assertEquals(4, valores.length);
        assertEquals(Rol.ADMINISTRADOR, valores[0]);
        assertEquals(Rol.MEDICO_TERAPISTA, valores[1]);
        assertEquals(Rol.PACIENTE, valores[2]);
        assertEquals(Rol.AGENDADOR, valores[3]);
    }

    @Test
    public void testValueOf() {
        Rol rol = Rol.valueOf("ADMINISTRADOR");
        assertEquals(Rol.ADMINISTRADOR, rol);

        rol = Rol.valueOf("PACIENTE");
        assertEquals(Rol.PACIENTE, rol);
    }

    @Test
    public void testNombreDelEnum() {
        Rol rol = Rol.MEDICO_TERAPISTA;
        assertEquals("MEDICO_TERAPISTA", rol.name());
    }
}