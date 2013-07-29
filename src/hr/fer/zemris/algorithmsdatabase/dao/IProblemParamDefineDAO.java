package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.ProblemParamDefine;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IProblemParamDefineDAO {

	/**
	 * ProblemParamDefine add to DAO.
	 * 
	 * @param apd
	 *            ProblemParamDefine for storage
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addProblemParamDefine(ProblemParamDefine ppd)
			throws DAOException;

	/**
	 * Method returns list of problem parameters defines. If none of parameters
	 * is stored, empty list is returned.
	 * 
	 * @return list of problems-parameters conections
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<ProblemParamDefine> listProblemParamDefined()
			throws DAOException;

}
