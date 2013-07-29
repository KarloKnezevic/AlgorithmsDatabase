package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IResultDAO;
import hr.fer.zemris.algorithmsdatabase.model.Result;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ResultDAOJPASqlImpl extends JPADAOBase implements IResultDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ResultDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IResultDAO#addResult(hr.fer.zemris.algorithmsdatabase.model.Result)
	 */
	@Override
	public void addResult(Result result) throws DAOException {
		getEntityManager().persist(result);

	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IResultDAO#listResults()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Result> listResults() throws DAOException {
		return getEntityManager().createNamedQuery("Result.list")
				.getResultList();
	}

}
