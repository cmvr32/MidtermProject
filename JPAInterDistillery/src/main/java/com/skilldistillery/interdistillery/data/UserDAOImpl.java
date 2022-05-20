package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.User;

public class UserDAOImpl implements UserDAO {

	public User createUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + user);
		em.persist(user);
		System.out.println("After persist: " + user);
		em.flush();
		em.getTransaction().commit();

		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return user;
	}

	@Override
	public boolean destroyUser(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;
	}

}
