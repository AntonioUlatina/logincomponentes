package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Publicaciones database table.
 * 
 */
@Entity
@Table(name="Publicaciones")
@NamedQuery(name="Publicacione.findAll", query="SELECT p FROM Publicacione p")
public class Publicacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PublicacionePK id;

	private String contenido;

	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;

	private String titulo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="Persona_id",insertable=false, updatable=false)
	private Persona persona;

	//bi-directional many-to-one association to RedSocial
	@ManyToOne
	@JoinColumn(name="RedSocial_id",insertable=false, updatable=false)
	private RedSocial redSocial;

	public Publicacione() {
	}

	public PublicacionePK getId() {
		return this.id;
	}

	public void setId(PublicacionePK id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public RedSocial getRedSocial() {
		return this.redSocial;
	}

	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}

}