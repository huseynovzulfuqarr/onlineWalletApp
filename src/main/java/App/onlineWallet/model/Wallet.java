package App.onlineWallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="wallet")
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="name can not be blank")
	@Size(min=2,max = 30)
	private String name;
	
	@Size(min=2,max = 30)
	private String accountNumber;
	@Size(max=100)
	private String description;
	
	@Min(1)
	@Max(3)
	private Integer priority;
	
	
	private Double currentBalance;
	
	public void setBalance() {
		this.currentBalance=new Double(0);
		
	}
	
	

}
