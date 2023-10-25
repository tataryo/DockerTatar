package tn.esprit.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter 
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			l.info("In Methode retrieveAllUsers :");
			users = (List<User>) userRepository.findAll();  
			l.debug("connexion à la DB Ok : ");
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs
				l.debug("user " + user.getLastName());
			} 
			// TODO Log à ajouter à la fin de la méthode
			l.info("out of methode retiveAllUsers with success");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			l.error("out of methode retriveAllUsers with error: " + e );
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Methode addUser :");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out of Methode addUser :");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		l.info("In Methode updateUser :");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out of Methode updateUser :");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Methode deleteUser :");
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out of Methode deleteUser :");
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Methode retrieveUser :");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode
		l.info("Out of Methode retrieveUser :");
		return u; 
	}

}