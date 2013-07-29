package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamString;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IExpProbParamStringDAO {

	public void addExpProbParamString(ExpProbParamString epps)
			throws DAOException;

	public List<ExpProbParamString> listExpProbParamStrings()
			throws DAOException;

}
