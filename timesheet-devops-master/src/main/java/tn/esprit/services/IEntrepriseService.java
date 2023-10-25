package tn.esprit.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.entities.Entreprise;

public interface IEntrepriseService {

	List<Entreprise> retrieveAllEntreprise(); 
	Entreprise addEntreprise(Entreprise E);
	void deleteEntreprise(int id);
	Entreprise updateEntreprise(Entreprise E);
	Entreprise retrieveEntreprise(int id);
	Optional<Entreprise> getEntreprise(int id);
}
