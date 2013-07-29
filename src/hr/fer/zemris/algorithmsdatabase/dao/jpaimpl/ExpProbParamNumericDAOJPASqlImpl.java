package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IExpProbParamNumericDAO;
import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamNumeric;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ExpProbParamNumericDAOJPASqlImpl extends JPADAOBase implements
		IExpProbParamNumericDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ExpProbParamNumericDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	@Override
	public void addExpProbParamNumeric(ExpProbParamNumeric eppn)
			throws DAOException {
		getEntityManager().persist(eppn);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProbParamNumeric> listExpProbParamNumerics()
			throws DAOException {
		return getEntityManager().createNamedQuery("ExpProbParamNumeric.list")
				.getResultList();
	}

}
