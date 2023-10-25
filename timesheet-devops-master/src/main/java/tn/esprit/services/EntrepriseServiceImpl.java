package tn.esprit.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Entreprise;
import tn.esprit.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	
	public List<Entreprise> retrieveAllEntreprise(){ 
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In Methode retrieveAllEntreprises :");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			l.debug("connexion à la DB Ok : ");
			for (Entreprise entreprise : entreprises) {
			l.debug("entreprise " + entreprise.getName());
			} 
			l.info("out of methode retiveAllentreprises with success");
		}catch (Exception e) {
			l.error("out of methode retriveAllEntreprises with error: " + e );
		}

		return entreprises;
	}
	
	
	
	@Override
	public Entreprise addEntreprise(Entreprise u){
		l.info("In Methode addEntreprise :");
		Entreprise e_saved = entrepriseRepository.save(u); 
		l.info("Out of Methode addEntreprise :");
		return e_saved; 
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise u) {
		l.info("In Methode updateEntreprise :");
		Entreprise e_saved = entrepriseRepository.save(u); 
		l.info("Out of Methode updateUser :");
		return e_saved; 
	}

	@Override
	public void deleteEntreprise(int id) {
		l.info("In Methode deleteEntreprise :");
		entrepriseRepository.deleteById(id); 
		l.info("Out of Methode deleteEntreprise :");
	}

	@Override
	public Entreprise retrieveEntreprise(int id) {
		l.info("In Methode retrieveEntreprise :");
		Entreprise u =  entrepriseRepository.findById(id).get(); 
		l.info("Out of Methode retrieveEntreprise :");
		return u; 
	}



	@Override
	public Optional<Entreprise> getEntreprise(int id) {
		return  entrepriseRepository.findById(id);
	}
}
