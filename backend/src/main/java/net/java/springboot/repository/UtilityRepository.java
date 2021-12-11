package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Utility;


@Repository
public interface UtilityRepository extends JpaRepository<Utility, Long>{
	/*@Query("SELECT SUM(amount) FROM utility")
	Float selectTotals();*/
}
