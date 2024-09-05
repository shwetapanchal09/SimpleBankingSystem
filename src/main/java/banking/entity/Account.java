package banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter 				// Automatically generates setter methods for all fields
@Getter 				// Automatically generates getter methods for all fields
@NoArgsConstructor 		// Generates a no-argument constructor
@AllArgsConstructor 	// Generates an all-argument constructor

// Mapping this class to a database table named "accounts"
@Table(name="accounts")

//Marks this class as a JPA entity that maps to a table in the database
@Entity 
public class Account {

    
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Id 			   					// Marks this field as the primary key of the entity
    private Long id; 

    
    @Column(name="account_holder_name") // Maps the 'accountHolderName' field to a column named "account_holder_name" in the database table
    private String accountHolderName; 

    
    private double balance;    			// Maps the 'balance' field to a column in the database table
}
