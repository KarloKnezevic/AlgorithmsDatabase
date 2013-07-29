package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.Experiment;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IExperimentDAO {

	/**
	 * Experiment add to DAO.
	 * 
	 * @param experiment
	 *            experiment for storage
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addExperiment(Experiment experiment) throws DAOException;

	/**
	 * Method returns list of experiments. If none of experiment is stored,
	 * empty list is returned.
	 * 
	 * @return list of algorithms
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<Experiment> listExperiments() throws DAOException;

}
