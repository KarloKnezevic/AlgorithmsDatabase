package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IProblemParamDefineDAO;
import hr.fer.zemris.algorithmsdatabase.model.ProblemParamDefine;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ProblemParamDefineDAOJPASqlImpl extends JPADAOBase implements
		IProblemParamDefineDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ProblemParamDefineDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IProblemParamDefineDAO#addProblemParamDefine(hr.fer.zemris.algorithmsdatabase.model.ProblemParamDefine)
	 */
	@Override
	public void addProblemParamDefine(ProblemParamDefine ppd)
			throws DAOException {
		getEntityManager().persist(ppd);

	}

	/**
	 * Method implementation with JPA.
	 * 
	 * @see hr.fer.zemris.algorithmsdatabase.dao.IProblemParamDefineDAO#listProblemParamDefined()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemParamDefine> listProblemParamDefined()
			throws DAOException {
		return getEntityManager().createNamedQuery("ProblemParamDefine.list")
				.getResultList();
	}

}
