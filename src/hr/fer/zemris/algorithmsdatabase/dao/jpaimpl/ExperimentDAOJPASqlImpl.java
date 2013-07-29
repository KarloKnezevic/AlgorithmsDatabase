package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IExperimentDAO;
import hr.fer.zemris.algorithmsdatabase.model.Experiment;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ExperimentDAOJPASqlImpl extends JPADAOBase implements
		IExperimentDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ExperimentDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IExperimentDAO#addExperiment(hr.fer.zemris.algorithmsdatabase.model.Experiment)
	 */
	@Override
	public void addExperiment(Experiment experiment) throws DAOException {
		getEntityManager().persist(experiment);

	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IExperimentDAO#listExperiments()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Experiment> listExperiments() throws DAOException {
		return getEntityManager().createNamedQuery("Experiment.list")
				.getResultList();
	}

}
