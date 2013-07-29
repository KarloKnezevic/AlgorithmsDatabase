package hr.fer.zemris.algorithmsdatabase.dao;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IDAOOperations {

	/**
	 * Metoda započinje transakciju. Kod implementacija koje objekt za
	 * perzistenciju pohranjuju u kontekst dretve, ako u kontekstu trenutne
	 * dretve ne postoji povezan objekt za perzistenciju podataka, tipično
	 * ponašanje je da ga ovaj poziv implicitno stvara i povezuje.
	 * 
	 * @throws DAOException
	 *             u slučaju pogreške pri perzistenciji
	 */
	public void beginTransaction() throws DAOException;

	/**
	 * Metoda oslobađa/zatvara objekt koji je sudjelovao u perzistenciji
	 * podataka. Za detalje pogledajte metodu {@linkplain #getObject()}.
	 * 
	 * @throws DAOException
	 *             u slučaju pogreške pri perzistenciji
	 */
	public void closeObject() throws DAOException;

	/**
	 * Metoda završava transakciju. Kod implementacija koje objekt za
	 * perzistenciju pohranjuju u kontekst dretve, ako u kontekstu trenutne
	 * dretve ne postoji povezan objekt za perzistenciju podataka, tipično
	 * ponašanje je da ga ovaj poziv implicitno stvara i povezuje.
	 * 
	 * @throws DAOException
	 *             u slučaju pogreške pri perzistenciji
	 */
	public void commitTransaction() throws DAOException;

	/**
	 * Metoda dohvaća objekt kojim se obavlja perzistencija. Primjerice, radimo
	 * li direktno s SQL-om, ovo može biti {@linkplain java.sql.Connection}.
	 * Radimo li s JPA specifikacijom, ovo bi mogao biti EntityManager. Što će
	 * točno biti, ovisi o samoj implementaciji. Ovaj objekt tipično će se
	 * stvoriti na zahtjev, povezati u kontekst dretve pozivatelja, i tamo
	 * živjeti sve do poziva {@linkplain #closeObject()}.
	 * 
	 * @return objekt koji se koristi za perzistenciju
	 * @throws DAOException
	 *             u slučaju pogreške pri perzistenciji
	 */
	public Object getObject() throws DAOException;

	/**
	 * Metoda poništava transakciju. Kod implementacija koje objekt za
	 * perzistenciju pohranjuju u kontekst dretve, ako u kontekstu trenutne
	 * dretve ne postoji povezan objekt za perzistenciju podataka, tipično
	 * ponašanje je da ga ovaj poziv implicitno stvara i povezuje.
	 * 
	 * @throws DAOException
	 *             u slučaju pogreške pri perzistenciji
	 */
	public void rollbackTransaction() throws DAOException;

	void rollbackTransactionIfNeeded() throws DAOException;
}
