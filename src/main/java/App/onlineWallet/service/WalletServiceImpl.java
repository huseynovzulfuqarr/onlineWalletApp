package App.onlineWallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import App.onlineWallet.exception.WalletException;

import App.onlineWallet.model.Wallet;
import App.onlineWallet.repository.WalletRepository;

public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public List<Wallet> getAllWallets() {

		return this.walletRepository.findAllByOrderByPriority();
	}

	@Override
	public Wallet createWallet(Wallet wallet) {

		return this.walletRepository.save(wallet);
	}

	@Override
	public Wallet getWalletById(Long id) {
		Optional<Wallet> wallet = this.walletRepository.findById(id);
		if (wallet.isPresent()) {

			return wallet.get();
		}
		throw new WalletException(id + " does not exists");
	}

	@Override
	public Wallet updateWallet(Wallet wallet, Long id) {
		Optional<Wallet> wallet2 = this.walletRepository.findById(id);
		if (wallet2.isPresent()) {
			Wallet updateWallet = wallet2.get();
			updateWallet.setName(wallet.getName());
			updateWallet.setAccountNumber(wallet.getAccountNumber());
			updateWallet.setCurrentBalance(wallet.getCurrentBalance());
			updateWallet.setDescription(wallet.getDescription());
			updateWallet.setPriority(wallet.getPriority());
			return updateWallet;
		}

		throw new WalletException(id + " does not exists");
	}

	@Override
	public boolean deleteWallet(Long id) {
		if (this.walletRepository.findById(id).isPresent()) {
			this.walletRepository.deleteById(id);
			return true;
		}
		throw new WalletException(id + " does not exists");
	}

}
