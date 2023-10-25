package tn.esprit.services;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.entities.Entreprise;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService us;
	
	@Test
	@Order(1)
	public void TestRetriveAllEntreprises() {
		
		List<Entreprise> listEntreprises = us.retrieveAllEntreprise();
		
		Assertions.assertEquals(6, listEntreprises.size());
	}
	
	@Test
	@Order(2)
	public void testAddEntreprise() throws ParseException{
		Entreprise E = new Entreprise("entr", "ent");
		Entreprise entrepriseAdd = us.addEntreprise(E);
		Assertions.assertEquals(entrepriseAdd.getName(),E.getName());
	}
	
	@Test
	@Order(3)
	public void testModifyEntreprise() throws ParseException{
		
		Entreprise E = new Entreprise(2,"eee", "eee");
		Entreprise entrepriseUpdate = us.updateEntreprise(E);
		
		Assertions.assertEquals(E.getName(), entrepriseUpdate.getName());
	}
	
	@Test
	@Order(4)
	public void testDeleteEntreprise(){
		us.deleteEntreprise(16);
		Optional<Entreprise> e = us.getEntreprise(16);
		Assertions.assertTrue(!e.isPresent());
	}
	
	@Test
	@Order(5)
	public void testRetrieveUser(){
		Entreprise entrepriseRetrieve = us.retrieveEntreprise(6);
		Assertions.assertEquals(6, entrepriseRetrieve.getId());
	}
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	
	///Ou bien on fait l'order des tests avec une autre methode 
	/*
	@Test
	public void testAll(){
		try{
			l.info("In test All()");
			TestRetriveAllUsers();
			testAddUser();
			testModifyUser();
			testDeleteUser();
			testRetrieveUser();
			l.info("out of test all");
		} catch (Exception e) {
		l.error("Out of testAll with errors:  "+ e);
		}
	}
	*/
}
