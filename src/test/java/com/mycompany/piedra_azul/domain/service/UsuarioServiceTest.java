/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.piedra_azul.domain.service;

import com.mycompany.piedra_azul.domain.model.Rol;
import com.mycompany.piedra_azul.domain.model.Usuario;
/*import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;*/
import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.piedra_azul.domain.repository.IUsuarioRepository;
import com.mycompany.piedra_azul.utils.PasswordUtils;

import java.util.List;
import java.util.ArrayList;

public class UsuarioServiceTest {

    // Repositorio falso (mock manual)
    private class UsuarioRepositoryFake implements IUsuarioRepository {

        private Usuario usuarioFake;

        public UsuarioRepositoryFake() {
            usuarioFake = new Usuario(
                "juan",
                PasswordUtils.hashPassword("1234"),
                "Juan Perez",
                Rol.PACIENTE
            );
            usuarioFake.setActivo(true);
        }

        @Override
        public Usuario findByUsername(String username) {
            if (username.equals("juan")) {
                return usuarioFake;
            }
            return null;
        }

        @Override
        public Usuario authenticate(String username, String passwordHash) {
            if (username.equals("juan") && usuarioFake.getPasswordHash().equals(passwordHash)) {
                return usuarioFake;
            }
            return null;
        }

        @Override
        public boolean create(Usuario usuario) {
            return true;
        }

        @Override
        public List<Usuario> findAll() {
            return new ArrayList<>();
        }

        @Override
        public boolean update(Usuario usuario) {
            return true;
        }

        @Override
        public boolean deactivate(int id) {
            return true;
        }

        @Override
        public boolean usernameExists(String username) {
            return username.equals("juan");
        }

        @Override
        public void registrarIntentoFallido(String username) {
            // simulación
        }

        @Override
        public void resetearIntentosFallidos(String username) {
            // simulación
        }
    }

    @Test
    public void testAutenticarUsuarioCorrecto() {
        UsuarioService service = new UsuarioService(new UsuarioRepositoryFake());

        Usuario u = service.autenticar("juan", "1234");

        assertNotNull(u);
        assertEquals("juan", u.getUsername());
    }

    @Test
    public void testAutenticarUsuarioIncorrecto() {
        UsuarioService service = new UsuarioService(new UsuarioRepositoryFake());

        Usuario u = service.autenticar("juan", "malaclave");

        assertNull(u);
    }

    @Test
    public void testCrearUsuarioCorrecto() {
        UsuarioService service = new UsuarioService(new UsuarioRepositoryFake());

        boolean creado = service.crearUsuario(
                "nuevo",
                "Clave@123",
                "Nuevo Usuario",
                Rol.PACIENTE
        );

        assertTrue(creado);
    }
}