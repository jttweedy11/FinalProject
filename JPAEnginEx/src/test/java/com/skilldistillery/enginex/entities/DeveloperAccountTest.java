package com.skilldistillery.enginex.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeveloperAccountTest {
	public static EntityManagerFactory emf;
	private EntityManager em;
	private DeveloperAccount devAcct;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAEnginEx");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
		
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		devAcct = em.find(DeveloperAccount.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		devAcct = null;
		
	}

	@Test
	void test() {
		assertNotNull(devAcct);
		assertEquals("Ron", devAcct.getFirstName());
	}

}
