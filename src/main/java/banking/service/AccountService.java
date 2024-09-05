package banking.service;

import java.util.List;
import banking.dto.Accountdto;


// Service interface for account management.
 
public interface AccountService {

    // Creates a new account
    Accountdto createAccount(Accountdto account);

    // Retrieves an account by its ID
    Accountdto getAccountById(long id);

    // Deposits an amount into an account
    Accountdto deposit(Long id, double amount);

    // Withdraws an amount from an account
    Accountdto withdraw(Long id, double amount);

    // Retrieves all accounts
    List<Accountdto> getAllAccounts();

    // Deletes an account by its ID
    void deleteAccount(Long id);
}
