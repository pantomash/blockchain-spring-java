package pl.pantomash.blockainspringjava;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockChainApi {
	BlockChainService blockChainService;
	
	public BlockChainApi(BlockChainService blockChainService) {
		this.blockChainService = blockChainService;
	}

	@PostMapping
	public TransactionPayload get(@RequestBody TransactionPayload transactionPayload) throws IOException {
		return blockChainService.executeTransaction(transactionPayload);
	}
}
