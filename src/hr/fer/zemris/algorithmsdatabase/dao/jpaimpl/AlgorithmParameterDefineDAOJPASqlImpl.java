package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgParamDefineDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.model.AlgParamDefine;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class AlgorithmParameterDefineDAOJPASqlImpl extends JPADAOBase implements
		IAlgParamDefineDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public AlgorithmParameterDefineDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IAlgParamDefineDAO#addAlgorithmParamDefine(hr.fer.zemris.algorithmsdatabase.model.AlgParamDefine)
	 */
	@Override
	public void addAlgorithmParamDefine(AlgParamDefine apd) throws DAOException {
		getEntityManager().persist(apd);

	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IAlgParamDefineDAO#listAlgorithmParamDefined()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AlgParamDefine> listAlgorithmParamDefined() throws DAOException {
		return getEntityManager().createNamedQuery("AlgParamDefine.list")
				.getResultList();
	}

}
