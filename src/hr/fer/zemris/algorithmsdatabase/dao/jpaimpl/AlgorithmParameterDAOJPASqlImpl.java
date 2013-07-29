package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgParameterDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.model.AlgorithmParameter;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class AlgorithmParameterDAOJPASqlImpl extends JPADAOBase implements
		IAlgParameterDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public AlgorithmParameterDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IAlgParameterDAO#addAlgorithmParameter(hr.fer.zemris.algorithmsdatabase.model.AlgorithmParameter)
	 */
	@Override
	public void addAlgorithmParameter(AlgorithmParameter algorithmParameter)
			throws DAOException {
		getEntityManager().persist(algorithmParameter);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IAlgParameterDAO#listAlgorithmParameters()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AlgorithmParameter> listAlgorithmParameters()
			throws DAOException {
		return getEntityManager().createNamedQuery("AlgorithmParameter.list")
				.getResultList();
	}

}
