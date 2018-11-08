package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CorreosEnviar database table.
 * 
 */
@Entity
@NamedQuery(name="CorreosEnviar.findAll", query="SELECT c FROM CorreosEnviar c")
public class CorreosEnviar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CorreosEnviarPK id;

	@Lob
	private String asunto;

	private String contenido;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="Persona_id",insertable=false, updatable=false)
	private Persona persona;
	

	public CorreosEnviar() {
	}

	public CorreosEnviarPK getId() {
		return this.id;
	}

	public void setId(CorreosEnviarPK id) {
		this.id = id;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}