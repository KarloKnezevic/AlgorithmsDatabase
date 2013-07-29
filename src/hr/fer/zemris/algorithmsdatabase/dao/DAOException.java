package hr.fer.zemris.algorithmsdatabase.dao;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class DAOException extends RuntimeException {

	/** Serijski broj */
	private static final long serialVersionUID = 1L;

	/**
	 * Defaultni konstruktor.
	 */
	public DAOException() {
	}

	/**
	 * Konstruktor koji prima tekst poruke.
	 * 
	 * @param message
	 *            poruka
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * Konstruktor koji prima tekst poruke kao i iznimku koju je potrebno
	 * zamotati u ovu iznimku.
	 * 
	 * @param message
	 *            poruka
	 * @param cause
	 *            iznimka koja se zamata
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Konstruktor koji prima iznimku koju je potrebno zamotati u ovu iznimku.
	 * 
	 * @param cause
	 *            iznimka koja se zamata
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}

}
