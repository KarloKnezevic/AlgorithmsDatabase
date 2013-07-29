package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.Run;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IRunDAO {

	/**
	 * Run add to DAO.
	 * 
	 * @param run
	 *            run for storage
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addRun(Run run) throws DAOException;

	/**
	 * Method returns list of runs. If none of runs is stored, empty list is
	 * returned.
	 * 
	 * @return list of runs
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<Run> listRuns() throws DAOException;

}
