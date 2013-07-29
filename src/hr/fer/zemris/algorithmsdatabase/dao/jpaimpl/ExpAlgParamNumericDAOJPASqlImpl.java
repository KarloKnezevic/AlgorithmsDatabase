package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IExpAlgParamNumericDAO;
import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamNumeric;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ExpAlgParamNumericDAOJPASqlImpl extends JPADAOBase implements
		IExpAlgParamNumericDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ExpAlgParamNumericDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	@Override
	public void addExpAlgParamNumeric(ExpAlgParamNumeric eapn)
			throws DAOException {
		getEntityManager().persist(eapn);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpAlgParamNumeric> listExpAlgParamNumerics()
			throws DAOException {
		return getEntityManager().createNamedQuery("ExpAlgParamNumeric.list")
				.getResultList();
	}

}
