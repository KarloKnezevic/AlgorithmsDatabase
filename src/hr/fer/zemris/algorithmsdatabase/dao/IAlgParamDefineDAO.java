package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.AlgParamDefine;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IAlgParamDefineDAO {

	/**
	 * AlgParamDefine add to DAO.
	 * 
	 * @param apd
	 *            AlgParamDefine for storage
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public void addAlgorithmParamDefine(AlgParamDefine apd) throws DAOException;

	/**
	 * Method returns list of algorithm parameters defines. If none of
	 * parameters is stored, empty list is returned.
	 * 
	 * @return list of algorithms-parameters conections
	 * @throws DAOException
	 *             exception in DAO case error
	 */
	public List<AlgParamDefine> listAlgorithmParamDefined() throws DAOException;

}
