package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.Result;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IResultDAO {

	/**
	 * Result add to DAO.
	 * 
	 * @param result
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addResult(Result result) throws DAOException;

	/**
	 * Method returns list of results. If none of results is stored, empty list
	 * is returned.
	 * 
	 * @return list of results
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<Result> listResults() throws DAOException;

}
