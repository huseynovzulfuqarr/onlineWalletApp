package App.onlineWallet.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Min(1)
	@NotBlank(message="amount can not be null")
	private Double amount;
	
	private String description;
	@Min(1)
	@Max(3)
	private int type ;//1 for income;2 for expense;3 for transfer
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date transactionDate;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="wallet_id",nullable = false)
	@JsonIgnore
	private Wallet wallet;
	
	
	public void setTransactionDate() {
		this.transactionDate=new Date();
		
	}
	

}
