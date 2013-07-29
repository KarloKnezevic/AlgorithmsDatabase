package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgorithmDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.model.Algorithm;

import java.util.List;

/**
 * Algorithm DAO implementation in JPA.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class AlgorithmDAOJPASqlImpl extends JPADAOBase implements IAlgorithmDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public AlgorithmDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IAlgorithmDAO#addAlgorithm(hr.fer.zemris.algorithmsdatabase.model.Algorithm)
	 */
	@Override
	public void addAlgorithm(Algorithm algorithm) throws DAOException {
		getEntityManager().persist(algorithm);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IAlgorithmDAO#listAlgorithms()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Algorithm> listAlgorithms() throws DAOException {
		return getEntityManager().createNamedQuery("Algorithm.list")
				.getResultList();
	}

}
