package App.onlineWallet.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import App.onlineWallet.model.Wallet;
import App.onlineWallet.service.WalletService;
import App.onlineWallet.validation.ValidationErrorService;

@RestController
@RequestMapping("/online")
@CrossOrigin
public class WalletController {
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private ValidationErrorService errorService;
	
	@GetMapping("/wallets")
	public ResponseEntity<?> getAllWallets(){
		return new ResponseEntity<>(this.walletService.getAllWallets(),HttpStatus.OK);
	}
	
	@GetMapping("/wallets/{id}")
	public ResponseEntity<?> getWalletById(@PathVariable("id") Long id){
		return new ResponseEntity<>(this.walletService.getWalletById(id),HttpStatus.OK);
	}
	
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createWallet(@Valid @RequestBody Wallet wallet,
			BindingResult result){
		ResponseEntity errors=errorService.validate(result);
		if(errors!=null) return errors;
		Wallet createWallet=this.walletService.createWallet(wallet);
		return new ResponseEntity<Wallet>(createWallet,HttpStatus.CREATED);
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateWallet(@PathVariable("id") Long id,Wallet wallet){
		return new ResponseEntity(walletService.updateWallet(wallet, id),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteWallet(@PathVariable("id") Long id) {
		this.walletService.deleteWallet(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	

}
