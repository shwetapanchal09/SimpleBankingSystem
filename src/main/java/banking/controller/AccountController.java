package banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.dto.Accountdto;
import banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts") //base url
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	
//add account rest API 
	@PostMapping
	public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
		Accountdto saved=accountService.createAccount(accountdto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
//get account by id 
	@GetMapping("/{id}")
	public ResponseEntity<Accountdto> getAccountById(@PathVariable("id") long id){
		Accountdto saved=accountService.getAccountById(id);
		return ResponseEntity.ok(saved);
	}
	
	
	//deposit api
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<Accountdto> deposit(@PathVariable("id") Long id,@RequestBody Map<String,Double>request ){
		Double amount=request.get("amount");
		Accountdto accountDto =accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	//withdraw api
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<Accountdto> withdraw(@PathVariable("id") Long id,@RequestBody Map<String,Double> request){
		Double amount=request.get("amount"); //key name is amount
		Accountdto updatedacc=accountService.withdraw(id,amount);
		return ResponseEntity.ok(updatedacc);
	}

	
	//get all accounts 
	
	@GetMapping("/getall")
	public ResponseEntity<List<Accountdto>> getAllAccounts(){
		 List<Accountdto> allAccounts= accountService.getAllAccounts();
		 return ResponseEntity.ok(allAccounts);
	}
	
	//delete 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("account deleted successfully");
	}
}
