package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamString;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IExpAlgParamStringDAO {

	public void addExpAlgParamString(ExpAlgParamString eaps)
			throws DAOException;

	public List<ExpAlgParamString> listExpAlgParamStrings() throws DAOException;

}
