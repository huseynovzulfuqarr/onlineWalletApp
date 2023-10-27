package App.onlineWallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import App.onlineWallet.model.Wallet;

@Service
public interface WalletService {
	
	List<Wallet> getAllWallets();
	
	Wallet createWallet(Wallet wallet);
	
	Wallet getWalletById(Long id);
	
	Wallet updateWallet(Wallet wallet,Long id);
	
	boolean deleteWallet(Long id);
	
	
	

}
