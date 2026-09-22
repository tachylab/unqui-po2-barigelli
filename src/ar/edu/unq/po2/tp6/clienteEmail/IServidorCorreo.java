package ar.edu.unq.po2.tp6.clienteEmail;

import java.util.List;

public interface IServidorCorreo {

    public List<Correo> recibirNuevos(String user, String pass);

    public void conectar(String nombreUsuario, String passusuario);

    public void enviar(Correo correo);
}
