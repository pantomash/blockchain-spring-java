package pl.pantomash.blockainspringjava;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

@Service
public class BlockChainService {
	
	private final Web3j web3j;
	
	public BlockChainService(Web3j web3j) {
		this.web3j = web3j;
	}

	public TransactionPayload executeTransaction(TransactionPayload transactionPayload) throws IOException {	
		Transaction etherTransaction = Transaction.createEtherTransaction(
				transactionPayload.getFrom(), 
				null, 
				null, 
				null, 
				transactionPayload.getTo(),
				transactionPayload.getValue().toBigInteger());
		
		EthSendTransaction sentTransaction = web3j.ethSendTransaction(etherTransaction).send();
		transactionPayload.setId(sentTransaction.getTransactionHash());
		return transactionPayload;
	}

}
