package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RedSocial database table.
 * 
 */
@Entity
@NamedQuery(name="RedSocial.findAll", query="SELECT r FROM RedSocial r")
public class RedSocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Publicacione
	@OneToMany(mappedBy="redSocial")
	private List<Publicacione> publicaciones;

	public RedSocial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Publicacione> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacione> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacione addPublicacione(Publicacione publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setRedSocial(this);

		return publicacione;
	}

	public Publicacione removePublicacione(Publicacione publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setRedSocial(null);

		return publicacione;
	}

}