package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.ProblemParameter;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IProblemParameterDAO {

	/**
	 * Problem parameter add to DAO.
	 * 
	 * @param problemParameter
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addProblemParameter(ProblemParameter problemParameter)
			throws DAOException;

	/**
	 * Method returns list of problem parameters. If none of algorithms is
	 * stored, empty list is returned.
	 * 
	 * @return list of problem parameters.
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<ProblemParameter> listProblemParameters() throws DAOException;

}
