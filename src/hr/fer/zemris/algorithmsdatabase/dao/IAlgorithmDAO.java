package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.Algorithm;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IAlgorithmDAO {

	/**
	 * Algorithm add to DAO.
	 * 
	 * @param algorithm
	 *            algorithm for storage
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addAlgorithm(Algorithm algorithm) throws DAOException;

	/**
	 * Method returns list of algorithms. If none of algorithms is stored, empty
	 * list is returned.
	 * 
	 * @return list of algorithms
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<Algorithm> listAlgorithms() throws DAOException;

}
