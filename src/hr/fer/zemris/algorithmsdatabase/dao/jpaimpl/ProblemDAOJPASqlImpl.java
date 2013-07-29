package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IProblemDAO;
import hr.fer.zemris.algorithmsdatabase.model.Problem;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ProblemDAOJPASqlImpl extends JPADAOBase implements IProblemDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ProblemDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IProblemDAO#addProblem(hr.fer.zemris.algorithmsdatabase.model.Problem)
	 */
	@Override
	public void addProblem(Problem problem) throws DAOException {
		getEntityManager().persist(problem);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IProblemDAO#listProblems()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Problem> listProblems() throws DAOException {
		return getEntityManager().createNamedQuery("Problem.list")
				.getResultList();
	}

}
