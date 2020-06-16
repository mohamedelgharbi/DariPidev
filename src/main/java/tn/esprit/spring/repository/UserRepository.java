package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email=:email and u.password=:password")
	public User getUserByEmailAndPassword(@Param("email") String login, @Param("password") String password);

	@Query("SELECT count(*) FROM User WHERE role=:role")
	public int countagent(@Param("role") Role role);

	@Query("SELECT u FROM User u WHERE u.role=:role")
	public List<User> getUserByRole(@Param("role") Role role);

	@Query(value = "SELECT *  FROM `user` ORDER BY `banned` DESC", nativeQuery = true)
	List<User> topscore();

}
