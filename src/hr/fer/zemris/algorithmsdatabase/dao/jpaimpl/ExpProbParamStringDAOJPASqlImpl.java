package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IExpProbParamStringDAO;
import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamString;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ExpProbParamStringDAOJPASqlImpl extends JPADAOBase implements
		IExpProbParamStringDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ExpProbParamStringDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	@Override
	public void addExpProbParamString(ExpProbParamString epps)
			throws DAOException {
		getEntityManager().persist(epps);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProbParamString> listExpProbParamStrings()
			throws DAOException {
		return getEntityManager().createNamedQuery("ExpProbParamString.list")
				.getResultList();
	}

}
