package banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 // Data Transfer Object (DTO) for transferring account information.
 
@Data                        // Generates getters, setters, toString(), equals(), and hashCode() methods
@NoArgsConstructor           // Generates a no-argument constructor
@AllArgsConstructor          // Generates a constructor with all fields
public class Accountdto {

    private Long id;            				// Unique identifier for the account

    private String accountHolderName; 			// Name of the account holder

    private double balance;     				// Account balance
}
