package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IProblemParameterDAO;
import hr.fer.zemris.algorithmsdatabase.model.ProblemParameter;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ProblemParameterDAOJPASqlImpl extends JPADAOBase implements
		IProblemParameterDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ProblemParameterDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IProblemParameterDAO#addProblemParameter(hr.fer.zemris.algorithmsdatabase.model.ProblemParameter)
	 */
	@Override
	public void addProblemParameter(ProblemParameter problemParameter)
			throws DAOException {
		getEntityManager().persist(problemParameter);

	}

	/**
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IProblemParameterDAO#listProblemParameters()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemParameter> listProblemParameters() throws DAOException {
		return getEntityManager().createNamedQuery("ProblemParameter.list")
				.getResultList();
	}

}
