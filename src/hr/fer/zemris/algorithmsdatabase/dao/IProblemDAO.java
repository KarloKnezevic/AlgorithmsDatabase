package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.Problem;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IProblemDAO {

	/**
	 * Problem add to DAO.
	 * 
	 * @param problem
	 *            problem for storage
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addProblem(Problem problem) throws DAOException;

	/**
	 * Method returns list of problems. If none of problems is stored, empty
	 * list is returned.
	 * 
	 * @return list of problems
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<Problem> listProblems() throws DAOException;

}
