package App.onlineWallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import App.onlineWallet.model.Transaction;
import App.onlineWallet.model.Wallet;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	 List<Transaction> findByWallet(Wallet wallet);
}
