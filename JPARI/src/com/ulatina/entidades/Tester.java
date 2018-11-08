package com.ulatina.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;

	public static void startEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("JPARI");
				em = entityManagerFactory.createEntityManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void stopEntityManagerFactory() {
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
			entityManagerFactory = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
try {
	List<Persona> listPersonas = new ArrayList<Persona>();
	Persona mateo = new Persona();
	mateo.setApellido("Marin");
	mateo.setContrasena("Hola");
	mateo.setCorreo("Lol");
	mateo.setFechaNacimiento(new Date());
	mateo.setNombre("Mateo");
	mateo.setSegundoApellido("Lopera");
	listPersonas.add(mateo);
		startEntityManagerFactory();
		Role admin = new Role();
		admin.setDescripcion("Que susto");
		admin.setNombreRol("Trabajo social");
		admin.setPersonas(listPersonas);
		
		em.getTransaction().begin();
		em.persist(admin);
		em.getTransaction().commit();
		stopEntityManagerFactory();
		System.out.println("Aqui paro");
}catch(Exception e) {
	e.printStackTrace();
}
	}
 
}
