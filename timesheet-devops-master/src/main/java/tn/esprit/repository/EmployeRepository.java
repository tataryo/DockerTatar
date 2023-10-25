package tn.esprit.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.entities.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {

}
