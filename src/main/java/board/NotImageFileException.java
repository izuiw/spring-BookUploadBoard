package board;

public class NotImageFileException extends RuntimeException {
	
	public NotImageFileException (String message) {
		super(message);
	}
	
	public NotImageFileException() {}
}
