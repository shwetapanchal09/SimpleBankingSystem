package banking.mapper;

import banking.dto.Accountdto;
import banking.entity.Account;

public class AccountMapper {
	
	// Create a new Account entity using values from the DTO
	public static Account mapToAccount(Accountdto accountDto) {
		Account account=new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()
				);
		return account;
	}
	
	// Create a new Accountdto using values from the Account entity
	public static Accountdto mapToAccountDto(Account account) {
		Accountdto accountdto=new Accountdto(
				account.getId() ,
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountdto;
	}

}
