package exception;

public class ServerDownException extends Exception {
	public ServerDownException(String errorMessage) {
		super(errorMessage);
	}
}
