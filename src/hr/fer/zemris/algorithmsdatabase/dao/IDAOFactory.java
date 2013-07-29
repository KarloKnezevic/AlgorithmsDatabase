package hr.fer.zemris.algorithmsdatabase.dao;

/**
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public interface IDAOFactory {

	public IAlgorithmDAO getAlgorithm();

	public IAlgParameterDAO getAlgorithmParameter();

	public IAlgParamDefineDAO getAlgParamDefine();

	IDAOOperations getDAOOperations();

	public IExpAlgParamNumericDAO getExpAlgParamNumeric();

	public IExpAlgParamStringDAO getExpAlgParamString();

	public IExperimentDAO getExperiment();

	public IExpProbParamNumericDAO getExpProbParamNumeric();

	public IExpProbParamStringDAO getExpProbParamString();

	public IProblemDAO getProblem();

	public IProblemParamDefineDAO getProblemParamDefine();

	public IProblemParameterDAO getProblemParameter();

	public IResultDAO getResult();

	public IRunDAO getRun();

	/**
	 * Metoda provjerava je li spremnik podataka inicijaliziran i ako nije,
	 * inicijalizira ga.
	 */
	public void initStorage();

	/**
	 * Metoda oslobađa korišteni objekt koji se je koristio za komunikaciju sa
	 * spremnikom. Dužnost je svake implementacije sloja usluge koja koristi
	 * usluge ovog sloja da nakon uporabe DAO objekata pozove ovu metodu. U
	 * suprotnom, moguća je pojava "curenja" veza prema bazi podataka i slični
	 * problemi.
	 */
	public void release();

}
