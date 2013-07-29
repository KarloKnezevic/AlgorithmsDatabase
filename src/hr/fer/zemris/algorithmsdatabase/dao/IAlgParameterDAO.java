package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.AlgorithmParameter;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IAlgParameterDAO {

	/**
	 * Algorithm parameter add to DAO.
	 * 
	 * @param algorithmParameter
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addAlgorithmParameter(AlgorithmParameter algorithmParameter)
			throws DAOException;

	/**
	 * Method returns list of algorithm parameters. If none of algorithms is
	 * stored, empty list is returned.
	 * 
	 * @return list of algorithm parameters.
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<AlgorithmParameter> listAlgorithmParameters()
			throws DAOException;

}
