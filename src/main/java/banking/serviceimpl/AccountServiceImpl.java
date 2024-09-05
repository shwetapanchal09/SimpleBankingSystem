package banking.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.dto.Accountdto;
import banking.entity.Account;
import banking.mapper.AccountMapper;
import banking.repository.AccountRepo;
import banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo; // Injects the AccountRepo dependency


    //Creates a new account using the provided account dto.
     
    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        // Convert DTO to entity
        Account account = AccountMapper.mapToAccount(accountdto);
        // Save the entity to the database
        Account savedAccount = accountRepo.save(account);
        // Convert the saved entity back to DTO and return
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    //Retrieves an account by its ID.
    
    @Override
    public Accountdto getAccountById(long id) {
        // Find the account by ID or throw an exception if not found
        Account account = accountRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exist"));
        // Convert the account entity to DTO and return
        return AccountMapper.mapToAccountDto(account);
    }

    //Deposits a specified amount into an account.
     
    @Override
    public Accountdto deposit(Long id, double amount) {
        // Find the account by ID or throw an exception if not found
        Account account = accountRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("ID not found"));
        // Update the account balance
        double updatedAmount = account.getBalance() + amount;
        account.setBalance(updatedAmount);
        // Save the updated account and convert it to DTO
        return AccountMapper.mapToAccountDto(accountRepo.save(account));
    }

     //Withdraws a specified amount from an account.
     
    @Override
    public Accountdto withdraw(Long id, double amount) {
        // Find the account by ID or throw an exception if not found
        Account account = accountRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("ID not found"));
        // Check if the balance is sufficient
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        // Update the account balance
        double updatedAmount = account.getBalance() - amount;
        account.setBalance(updatedAmount);
        // Save the updated account and convert it to DTO
        return AccountMapper.mapToAccountDto(accountRepo.save(account));
    }

     //Retrieves all accounts.
     
    @Override
    public List<Accountdto> getAllAccounts() {
        // Find all accounts
        List<Account> allAccounts = accountRepo.findAll();
        // Convert each account entity to DTO and return as a list
        return allAccounts.stream()
            .map(AccountMapper::mapToAccountDto)
            .collect(Collectors.toList());
    }

     //Deletes an account by its ID.

    @Override
    public void deleteAccount(Long id) {
        // Find the account by ID or throw an exception if not found
        Account account = accountRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exist"));
        // Delete the account from the database
        accountRepo.delete(account);
    }
}
