package hr.fer.zemris.algorithmsdatabase.service.impl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.DAOFactoryProvider;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgParamDefineDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgParameterDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgorithmDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IExpAlgParamNumericDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IExpAlgParamStringDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IExpProbParamNumericDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IExpProbParamStringDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IExperimentDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IProblemDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IProblemParamDefineDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IProblemParameterDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IResultDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IRunDAO;
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
import hr.fer.zemris.algorithmsdatabase.service.IAppService;

import java.util.List;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class AppServiceImpl implements IAppService {

	private IAlgorithmDAO algorithmDAO;

	private IProblemDAO problemDAO;

	private IAlgParameterDAO algorithmParameterDAO;

	private IProblemParameterDAO problemParameterDAO;

	private IAlgParamDefineDAO algParamDefineDAO;

	private IProblemParamDefineDAO problemParameterDefineDAO;

	private IExperimentDAO experimentDAO;

	private IRunDAO runDAO;

	private IResultDAO resultDAO;

	private IExpAlgParamNumericDAO expAlgParamNumericDAO;

	private IExpAlgParamStringDAO expAlgParamStringDAO;

	private IExpProbParamNumericDAO expProbParamNumericDAO;

	private IExpProbParamStringDAO expProbParamStringDAO;

	@Override
	public void addAlgorithm(Algorithm algorithm) throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			algorithmDAO.addAlgorithm(algorithm);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addAlgorithmParameter(AlgorithmParameter algorithmParameter)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			algorithmParameterDAO.addAlgorithmParameter(algorithmParameter);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addProblem(Problem problem) throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			problemDAO.addProblem(problem);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addProblemParameter(ProblemParameter problemParameter)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			problemParameterDAO.addProblemParameter(problemParameter);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addExperiment(Experiment experiment) throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			experimentDAO.addExperiment(experiment);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addAlgParamDefine(AlgParamDefine apd) throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			algParamDefineDAO.addAlgorithmParamDefine(apd);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addProblemParamDefine(ProblemParamDefine ppd)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			problemParameterDefineDAO.addProblemParamDefine(ppd);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addRun(Run run) throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			runDAO.addRun(run);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addResult(Result result) throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			resultDAO.addResult(result);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addExpAlgParamNumeric(ExpAlgParamNumeric eapn)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			expAlgParamNumericDAO.addExpAlgParamNumeric(eapn);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addExpAlgParamString(ExpAlgParamString eaps)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			expAlgParamStringDAO.addExpAlgParamString(eaps);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addExpProbParamNumeric(ExpProbParamNumeric eppn)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			expProbParamNumericDAO.addExpProbParamNumeric(eppn);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public void addExpProbParamString(ExpProbParamString epps)
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			expProbParamStringDAO.addExpProbParamString(epps);
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}

	}

	@Override
	public List<AlgorithmParameter> listAlgorithmParameters()
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<AlgorithmParameter> algorithmParameters = algorithmParameterDAO
					.listAlgorithmParameters();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return algorithmParameters;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<Algorithm> listAlgorithms() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<Algorithm> algorithms = algorithmDAO.listAlgorithms();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return algorithms;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<ProblemParameter> listProblemParameters() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<ProblemParameter> problemParameters = problemParameterDAO
					.listProblemParameters();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return problemParameters;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<Problem> listProblems() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<Problem> problems = problemDAO.listProblems();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return problems;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<AlgParamDefine> listAlgParamDefine() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<AlgParamDefine> algParams = algParamDefineDAO
					.listAlgorithmParamDefined();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return algParams;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<ProblemParamDefine> listProblemParamDefine()
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<ProblemParamDefine> probParams = problemParameterDefineDAO
					.listProblemParamDefined();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return probParams;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<Experiment> listExperiments() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<Experiment> experiments = experimentDAO
					.listExperiments();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return experiments;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<Run> listRuns() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<Run> runs = runDAO.listRuns();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return runs;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<Result> listResults() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<Result> results = resultDAO.listResults();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return results;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<ExpAlgParamNumeric> listExpAlgParamNumerics()
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<ExpAlgParamNumeric> eapns = expAlgParamNumericDAO
					.listExpAlgParamNumerics();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return eapns;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<ExpAlgParamString> listExpAlgParamStrings() throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<ExpAlgParamString> eapss = expAlgParamStringDAO
					.listExpAlgParamStrings();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return eapss;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<ExpProbParamNumeric> listExpProbParamNumerics()
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<ExpProbParamNumeric> eppns = expProbParamNumericDAO
					.listExpProbParamNumerics();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return eppns;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	@Override
	public List<ExpProbParamString> listExpProbParamStrings()
			throws DAOException {
		DAOFactoryProvider.getDAOFactory().getDAOOperations()
				.beginTransaction();
		try {
			final List<ExpProbParamString> eppss = expProbParamStringDAO
					.listExpProbParamStrings();
			DAOFactoryProvider.getDAOFactory().getDAOOperations()
					.commitTransaction();
			return eppss;
		} finally {
			DAOFactoryProvider.getDAOFactory().release();
		}
	}

	public void setIAlgorithmDAO(IAlgorithmDAO algorithmDAO) {
		this.algorithmDAO = algorithmDAO;
	}

	public void setIAlgParameterDAO(IAlgParameterDAO algorithmParameterDAO) {
		this.algorithmParameterDAO = algorithmParameterDAO;
	}

	public void setIProblemDAO(IProblemDAO problemDAO) {
		this.problemDAO = problemDAO;
	}

	public void setIProblemParameterDAO(IProblemParameterDAO problemParameterDAO) {
		this.problemParameterDAO = problemParameterDAO;
	}

	public void setIAlgParamDefineDAO(IAlgParamDefineDAO algParamDefineDAO) {
		this.algParamDefineDAO = algParamDefineDAO;
	}

	public void setIProblemParamDefineDAO(
			IProblemParamDefineDAO problemParameterDefineDAO) {
		this.problemParameterDefineDAO = problemParameterDefineDAO;
	}

	public void setIExperimentDAO(IExperimentDAO experimentDAO) {
		this.experimentDAO = experimentDAO;
	}

	public void setIRunDAO(IRunDAO runDAO) {
		this.runDAO = runDAO;
	}

	public void setIResultDAO(IResultDAO resultDAO) {
		this.resultDAO = resultDAO;
	}

	public void setIExpAlgParamNumericDAO(
			IExpAlgParamNumericDAO expAlgParamNumericDAO) {
		this.expAlgParamNumericDAO = expAlgParamNumericDAO;
	}

	public void setIExpAlgParamStringDAO(
			IExpAlgParamStringDAO expAlgParamStringDAO) {
		this.expAlgParamStringDAO = expAlgParamStringDAO;
	}

	public void setIExpProbParamNumericDAO(
			IExpProbParamNumericDAO expProbParamNumericDAO) {
		this.expProbParamNumericDAO = expProbParamNumericDAO;
	}

	public void setIExpProbParamStringDAO(
			IExpProbParamStringDAO expProbParamStringDAO) {
		this.expProbParamStringDAO = expProbParamStringDAO;
	}

}
