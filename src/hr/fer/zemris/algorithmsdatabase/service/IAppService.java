package hr.fer.zemris.algorithmsdatabase.service;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.model.AlgParamDefine;
import hr.fer.zemris.algorithmsdatabase.model.Algorithm;
import hr.fer.zemris.algorithmsdatabase.model.AlgorithmParameter;
import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamNumeric;
import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamString;
import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamNumeric;
import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamString;
import hr.fer.zemris.algorithmsdatabase.model.Experiment;
import hr.fer.zemris.algorithmsdatabase.model.Problem;
import hr.fer.zemris.algorithmsdatabase.model.ProblemParamDefine;
import hr.fer.zemris.algorithmsdatabase.model.ProblemParameter;
import hr.fer.zemris.algorithmsdatabase.model.Result;
import hr.fer.zemris.algorithmsdatabase.model.Run;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IAppService {

	// algorithm
	public void addAlgorithm(Algorithm algorithm) throws DAOException;

	public List<Algorithm> listAlgorithms() throws DAOException;

	// algorithm parameter
	public void addAlgorithmParameter(AlgorithmParameter algorithmParameter)
			throws DAOException;

	public List<AlgorithmParameter> listAlgorithmParameters()
			throws DAOException;

	// problem
	public void addProblem(Problem problem) throws DAOException;

	public List<Problem> listProblems() throws DAOException;

	// problem parameter
	public void addProblemParameter(ProblemParameter problemParameter)
			throws DAOException;

	public List<ProblemParameter> listProblemParameters() throws DAOException;

	// algorithm parameters defined
	public void addAlgParamDefine(AlgParamDefine apd) throws DAOException;

	public List<AlgParamDefine> listAlgParamDefine() throws DAOException;

	// algorithm parameters defined
	public void addProblemParamDefine(ProblemParamDefine ppd)
			throws DAOException;

	public List<ProblemParamDefine> listProblemParamDefine()
			throws DAOException;

	// experiment
	public void addExperiment(Experiment experiment) throws DAOException;

	public List<Experiment> listExperiments() throws DAOException;

	// run
	public void addRun(Run run) throws DAOException;

	public List<Run> listRuns() throws DAOException;

	// result
	public void addResult(Result result) throws DAOException;

	public List<Result> listResults() throws DAOException;

	// experiment alg param numeric
	public void addExpAlgParamNumeric(ExpAlgParamNumeric eapn)
			throws DAOException;

	public List<ExpAlgParamNumeric> listExpAlgParamNumerics()
			throws DAOException;

	// experiment alg param string
	public void addExpAlgParamString(ExpAlgParamString eaps)
			throws DAOException;

	public List<ExpAlgParamString> listExpAlgParamStrings() throws DAOException;

	// experiment alg param numeric
	public void addExpProbParamNumeric(ExpProbParamNumeric eppn)
			throws DAOException;

	public List<ExpProbParamNumeric> listExpProbParamNumerics()
			throws DAOException;

	// experiment alg param string
	public void addExpProbParamString(ExpProbParamString epps)
			throws DAOException;

	public List<ExpProbParamString> listExpProbParamStrings()
			throws DAOException;

}
