package ar.edu.unq.po2.tp6.clienteEmail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServidorAdminPop implements IServidorCorreo {

	private Map<String, String> usuarios = new HashMap<String, String>();
	private Map<String, List<Correo>> buzones = new HashMap<String, List<Correo>>();

	public void registrarUsuario(String usuario, String pass) {
		this.usuarios.put(usuario, pass);
		this.buzones.put(usuario, new ArrayList<Correo>());
	}

	private boolean esUsuarioValido(String usuario, String pass) {
		return pass != null && pass.equals(this.usuarios.get(usuario));
	}

	private void autenticar(String usuario, String pass) {
		if (!this.esUsuarioValido(usuario, pass)) {
			throw new IllegalArgumentException("Usuario o contraseña inválidos");
		}
	}

	public List<Correo> recibirNuevos(String user, String pass) {
		this.autenticar(user, pass);
		List<Correo> retorno = new ArrayList<Correo>(this.buzones.get(user));
		this.buzones.get(user).clear();
		return retorno;
	}

	public void conectar(String nombreUsuario, String passusuario) {
		this.autenticar(nombreUsuario, passusuario);
	}

	public void enviar(Correo correo) {
		if (this.buzones.containsKey(correo.destinatario)) {
			this.buzones.get(correo.destinatario).add(correo);
		}
	}
}
