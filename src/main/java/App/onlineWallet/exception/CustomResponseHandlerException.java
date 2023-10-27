package App.onlineWallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestController
@ControllerAdvice
public class CustomResponseHandlerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public final ResponseEntity<?> handleWalletException(WalletException exception,WebRequest request){
		WalletExceptionResponse exceptionResponse=new WalletExceptionResponse(exception.getMessage());
		return new ResponseEntity<WalletExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}

}
