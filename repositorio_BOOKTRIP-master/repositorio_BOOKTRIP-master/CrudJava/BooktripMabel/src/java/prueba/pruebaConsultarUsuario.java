/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import modelo.usuario;
import controlador.usuarioDao;

/**
 *
 * @author 57321
 */
public class pruebaConsultarUsuario {

    public static void main(String[] args) {

        usuarioDao usuarioC = new usuarioDao();
        usuario user = usuarioC.consultarUsuario(1);

        if (user != null) {
            System.out.println("Encontrado el usuario "
                    + user.getIdUsuario() + " - "
                    + user.getIdTipoDocumento() + " - "
                    + user.getIdRol() + " - "
                    + user.getNombre() + " - "
                    + user.getApellido() + " - "
                    + user.getDireccion() + " - "
                    + user.getTelefono() + " - "
                    + user.getFechaNacimiento() + " - "
                    + user.getEmail() + " - "
                    + user.getPassword());

        } else {
            System.out.println("El usuario no se encontro");
        }

    }

}