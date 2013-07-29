package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
import hr.fer.zemris.algorithmsdatabase.dao.IExpAlgParamStringDAO;
import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamString;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ExpAlgParamStringDAOJPASqlImpl extends JPADAOBase implements
		IExpAlgParamStringDAO {

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup vezi prema DBMS-u
	 */
	public ExpAlgParamStringDAOJPASqlImpl(IDAOOperations daoOperations) {
		super(daoOperations);
	}

	@Override
	public void addExpAlgParamString(ExpAlgParamString eaps)
			throws DAOException {
		getEntityManager().persist(eaps);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpAlgParamString> listExpAlgParamStrings() throws DAOException {
		return getEntityManager().createNamedQuery("ExpAlgParamString.list")
				.getResultList();
	}

}
