package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Users;
@Repository
public interface UsersRepository extends CrudRepository<Users,Integer>{

	@Query("SELECT e FROM Users e WHERE e.email=:email and e.password=:password")
	public Users getUsersByEmailAndPassword(@Param("email") String login, @Param("password") String password);

	
	Users findByEmail(String username);
}
