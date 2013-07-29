package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IRunDAO;
import hr.fer.zemris.algorithmsdatabase.model.Run;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class RunDAOJPASqlImpl extends JPADAOBase implements IRunDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public RunDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IRunDAO#addRun(hr.fer.zemris.algorithmsdatabase.model.Run)
	 */
	@Override
	public void addRun(Run run) throws DAOException {
		getEntityManager().persist(run);

	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IRunDAO#listRuns()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Run> listRuns() throws DAOException {
		return getEntityManager().createNamedQuery("Run.list").getResultList();
	}

}
