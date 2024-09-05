package banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banking.entity.Account;

//Extends JpaRepository to provide CRUD operations and query methods.
public interface AccountRepo extends JpaRepository<Account, Long>{

}
