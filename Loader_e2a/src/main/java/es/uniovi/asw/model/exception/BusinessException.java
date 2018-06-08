package es.uniovi.asw.model.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 6193644331843268598L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
