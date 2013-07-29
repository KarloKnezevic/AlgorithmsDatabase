package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamNumeric;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IExpProbParamNumericDAO {

	public void addExpProbParamNumeric(ExpProbParamNumeric eppn)
			throws DAOException;

	public List<ExpProbParamNumeric> listExpProbParamNumerics()
			throws DAOException;

}
