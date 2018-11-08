package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Correos database table.
 * 
 */
@Entity
@Table(name="Correos")
@NamedQuery(name="Correo.findAll", query="SELECT c FROM Correo c")
public class Correo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String correo;

	//bi-directional many-to-many association to ListaCorreo
	@ManyToMany(mappedBy="correos")
	private List<ListaCorreo> listaCorreos;

	public Correo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<ListaCorreo> getListaCorreos() {
		return this.listaCorreos;
	}

	public void setListaCorreos(List<ListaCorreo> listaCorreos) {
		this.listaCorreos = listaCorreos;
	}

}