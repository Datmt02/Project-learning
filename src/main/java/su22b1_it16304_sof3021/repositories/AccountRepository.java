package su22b1_it16304_sof3021.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import su22b1_it16304_sof3021.entities.Account;

public interface AccountRepository
	extends JpaRepository<Account, Integer> {
	@Query("SELECT acc FROM Account acc WHERE email LIKE %:username% ")
	public Account findByEmailFPT(@Param("username") String username);
}
