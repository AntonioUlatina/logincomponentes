package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ListaCorreos database table.
 * 
 */
@Entity
@Table(name="ListaCorreos")
@NamedQuery(name="ListaCorreo.findAll", query="SELECT l FROM ListaCorreo l")
public class ListaCorreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Correo
	@ManyToMany
	@JoinTable(
		name="CorreoPorListaCorreos"
		, joinColumns={
			@JoinColumn(name="ListaCorreos_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Correos_id")
			}
		)
	private List<Correo> correos;

	public ListaCorreo() {
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

	public List<Correo> getCorreos() {
		return this.correos;
	}

	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}

}