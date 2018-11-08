package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido;

	private String contrasena;

	private String correo;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre;

	private String segundoApellido;

	private String sexo;

	private String telefono;

	//bi-directional many-to-one association to CorreosEnviar
	@OneToMany(mappedBy="persona")
	private List<CorreosEnviar> correosEnviars;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="personas")
	private List<Role> roles;

	//bi-directional many-to-one association to Publicacione
	@OneToMany(mappedBy="persona")
	private List<Publicacione> publicaciones;

	public Persona() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<CorreosEnviar> getCorreosEnviars() {
		return this.correosEnviars;
	}

	public void setCorreosEnviars(List<CorreosEnviar> correosEnviars) {
		this.correosEnviars = correosEnviars;
	}

	public CorreosEnviar addCorreosEnviar(CorreosEnviar correosEnviar) {
		getCorreosEnviars().add(correosEnviar);
		correosEnviar.setPersona(this);

		return correosEnviar;
	}

	public CorreosEnviar removeCorreosEnviar(CorreosEnviar correosEnviar) {
		getCorreosEnviars().remove(correosEnviar);
		correosEnviar.setPersona(null);

		return correosEnviar;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Publicacione> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacione> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacione addPublicacione(Publicacione publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setPersona(this);

		return publicacione;
	}

	public Publicacione removePublicacione(Publicacione publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setPersona(null);

		return publicacione;
	}

}