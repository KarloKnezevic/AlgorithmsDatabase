package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamNumeric;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IExpAlgParamNumericDAO {

	public void addExpAlgParamNumeric(ExpAlgParamNumeric eapn)
			throws DAOException;

	public List<ExpAlgParamNumeric> listExpAlgParamNumerics()
			throws DAOException;

}
