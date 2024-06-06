package Modelo;

import Controlador.UsuarioControlador;

public class Usuario {
	private int id;
	private String name;
	private String email;
	

	public Usuario(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
	}

	public Usuario(String name, String email) {
		this.name = name;
		this.email = email;
		
	}

	public Usuario() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public static String IniciarSesion(String name, String mail) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (controlador.getAllUsers().isEmpty()) {
			return "No hay usuarios";
		} else {
			
			for (Usuario usuario : controlador.getAllUsers()) {
				if (usuario.getName().equals(name) && usuario.getEmail().equals(mail)) {
				}
			}
			return "No se encontró";

		}

	}


	public static String Registrarse(String name, String mail) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (name.length()>3 ) {
			if (mail.length()>3) {
				for (Usuario usuario : controlador.getAllUsers()) {
					if (usuario.getName().equals(name)) {
						return "Usuario existente";
					}
				}
				controlador.addUser(new Usuario(name,mail));
				return "Ok";
			} else {
				return "Ingrese un mail valido(Minimo 4 letras)";
			}
		} else {
			return "Ingrese un nombre valido(Minimo 4 letras)";

		}
		
		

	}
}
