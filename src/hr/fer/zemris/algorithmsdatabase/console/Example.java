package hr.fer.zemris.algorithmsdatabase.console;

import hr.fer.zemris.algorithmsdatabase.dao.DAOFactoryProvider;
import hr.fer.zemris.algorithmsdatabase.model.AlgParamDefine;
import hr.fer.zemris.algorithmsdatabase.model.Algorithm;
import hr.fer.zemris.algorithmsdatabase.model.AlgorithmParameter;
import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamNumeric;
import hr.fer.zemris.algorithmsdatabase.model.ExpAlgParamString;
import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamNumeric;
import hr.fer.zemris.algorithmsdatabase.model.ExpProbParamString;
import hr.fer.zemris.algorithmsdatabase.model.Experiment;
import hr.fer.zemris.algorithmsdatabase.model.ParameterType;
import hr.fer.zemris.algorithmsdatabase.model.Problem;
import hr.fer.zemris.algorithmsdatabase.model.ProblemParamDefine;
import hr.fer.zemris.algorithmsdatabase.model.ProblemParameter;
import hr.fer.zemris.algorithmsdatabase.model.Result;
import hr.fer.zemris.algorithmsdatabase.model.Run;
import hr.fer.zemris.algorithmsdatabase.service.ServiceFactory;

import java.util.List;
import java.util.Random;

/**
 * Example.
 * 
 * Primjer programskog korištenja baze podataka. Koriste se metode koje servis
 * nudi. Ukoliko se žele implementirati dodatne metode, potrebno ih je
 * implementirati u servisu, evenutalno korigirati model te u DAO sloju
 * implementirati potrebne operacije. Implementirana je baza podataka koja
 * koristi JPA specifikaciju uz Hibernate.
 * 
 * Cilj je bazu podataka koristiti kao import JAR biblioteke. U DAO sloju, u
 * servise provideru, implementirano je spajanje na konkretnu bazu podataka, s
 * konkretnim korisničkim imenom i lozinkom.
 * 
 * UPOZORENJE: potrebno kod modela utvrditi eksplicitnu vezu. Trentno nijedna
 * veza nije uspostavljena i sve se zasad radi programski. To je plan za buduće
 * projekte.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class Example {

	/**
	 * Primjer pisanja i uporabe metoda definiranih servisom.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DAOFactoryProvider.getDAOFactory().initStorage();

		dodajAlgoritam();

		listajAlgoritme();

		dodajProblem();

		listajProblem();

		dodajAlgParametar();

		listajAlgParametre();

		dodajProbParametar();

		listajProbParametre();

		dodajAlgDefinedParametar();

		listajAlgDefinedParametre();

		dodajProbDefinedParametar();

		listajProbDefinedParametre();

		dodajExperiment();

		listajEksperimente();

		dodajRun();

		listajRunove();

		dodajResult();

		listajResultse();

		dodajEapn();

		listajEapn();

		dodajEapss();

		listajEapss();

		dodajEppn();

		listajEppn();

		dodajEpps();

		listajEpps();
	}

	private static void listajEpps() {
		final List<ExpProbParamString> res = ServiceFactory.getAppService()
				.listExpProbParamStrings();
		for (final ExpProbParamString r : res) {
			System.out.println(r.toString());
		}

	}

	private static void dodajEpps() {
		final List<Experiment> experiments = ServiceFactory.getAppService()
				.listExperiments();
		final List<ProblemParameter> pparams = ServiceFactory.getAppService()
				.listProblemParameters();
		for (final Experiment ex : experiments) {
			for (final ProblemParameter pp : pparams) {
				final ExpProbParamString epps = new ExpProbParamString();
				epps.setExpId(ex.getId());
				epps.setProbParamId(pp.getId());
				epps.setValue("s vrijednost");
				ServiceFactory.getAppService().addExpProbParamString(epps);
			}
		}
	}

	private static void listajEppn() {
		final List<ExpProbParamNumeric> res = ServiceFactory.getAppService()
				.listExpProbParamNumerics();
		for (final ExpProbParamNumeric r : res) {
			System.out.println(r.toString());
		}

	}

	private static void dodajEppn() {
		final List<Experiment> experiments = ServiceFactory.getAppService()
				.listExperiments();
		final List<ProblemParameter> pparams = ServiceFactory.getAppService()
				.listProblemParameters();
		final Random rand = new Random();
		for (final Experiment ex : experiments) {
			for (final ProblemParameter pp : pparams) {
				final ExpProbParamNumeric eppn = new ExpProbParamNumeric();
				eppn.setExpId(ex.getId());
				eppn.setProbParamId(pp.getId());
				eppn.setValue(rand.nextDouble());
				ServiceFactory.getAppService().addExpProbParamNumeric(eppn);

			}
		}

	}

	private static void listajEapss() {
		final List<ExpAlgParamString> res = ServiceFactory.getAppService()
				.listExpAlgParamStrings();
		for (final ExpAlgParamString r : res) {
			System.out.println(r.toString());
		}

	}

	private static void dodajEapss() {
		final List<AlgorithmParameter> aparams = ServiceFactory.getAppService()
				.listAlgorithmParameters();
		final List<Experiment> experiments = ServiceFactory.getAppService()
				.listExperiments();
		for (final AlgorithmParameter ap : aparams) {
			for (final Experiment ex : experiments) {
				final ExpAlgParamString eaps = new ExpAlgParamString();
				eaps.setAlgParamId(ap.getId());
				eaps.setExpId(ex.getId());
				eaps.setValue("s vrijednost");
				ServiceFactory.getAppService().addExpAlgParamString(eaps);
			}
		}
	}

	private static void listajEapn() {
		final List<ExpAlgParamNumeric> res = ServiceFactory.getAppService()
				.listExpAlgParamNumerics();
		for (final ExpAlgParamNumeric r : res) {
			System.out.println(r.toString());
		}

	}

	private static void dodajEapn() {
		final List<AlgorithmParameter> aparams = ServiceFactory.getAppService()
				.listAlgorithmParameters();
		final List<Experiment> experiments = ServiceFactory.getAppService()
				.listExperiments();
		final Random rand = new Random();

		for (final AlgorithmParameter ap : aparams) {
			for (final Experiment ex : experiments) {
				final ExpAlgParamNumeric eapn = new ExpAlgParamNumeric();
				eapn.setAlgParamId(ap.getId());
				eapn.setExpId(ex.getId());
				eapn.setValue(rand.nextDouble());
				ServiceFactory.getAppService().addExpAlgParamNumeric(eapn);
			}
		}

	}

	private static void listajResultse() {
		final List<Result> res = ServiceFactory.getAppService().listResults();
		for (final Result r : res) {
			System.out.println(r.toString());
		}

	}

	private static void dodajResult() {
		final int brojTestova = 100;
		final Random rand = new Random();
		final List<Run> runs = ServiceFactory.getAppService().listRuns();
		for (final Run r : runs) {
			for (int i = 0; i < brojTestova; i++) {
				final Result result = new Result();
				result.setRunId(r.getId());
				result.setAvg(rand.nextDouble());
				result.setEvaluations((i + 1) * 10);
				result.setMax(rand.nextDouble());
				result.setMin(rand.nextDouble());
				result.setStdev(rand.nextDouble());
				ServiceFactory.getAppService().addResult(result);

			}
		}

	}

	private static void listajRunove() {
		final List<Run> runs = ServiceFactory.getAppService().listRuns();
		for (final Run r : runs) {
			System.out.println(r.toString());
		}

	}

	private static void dodajRun() {
		final List<Experiment> experiments = ServiceFactory.getAppService()
				.listExperiments();
		for (final Experiment e : experiments) {
			final Run run = new Run();
			run.setExpId(e.getId());
			ServiceFactory.getAppService().addRun(run);
		}

	}

	private static void listajEksperimente() {
		final List<Experiment> experiments = ServiceFactory.getAppService()
				.listExperiments();
		for (final Experiment ex : experiments) {
			System.out.println(ex.toString());
		}

	}

	private static void dodajExperiment() {
		final List<Algorithm> algorithms = ServiceFactory.getAppService()
				.listAlgorithms();
		final List<Problem> problems = ServiceFactory.getAppService()
				.listProblems();
		for (final Algorithm a : algorithms) {
			for (final Problem p : problems) {
				final Experiment experiment = new Experiment();
				experiment.setAlgId(a.getId());
				experiment.setProbId(p.getId());
				ServiceFactory.getAppService().addExperiment(experiment);
			}
		}

	}

	private static void listajProbDefinedParametre() {
		final List<ProblemParamDefine> ppds = ServiceFactory.getAppService()
				.listProblemParamDefine();
		for (final ProblemParamDefine ppd : ppds) {
			System.out.println(ppd.toString());
		}

	}

	private static void dodajProbDefinedParametar() {
		final List<Problem> problems = ServiceFactory.getAppService()
				.listProblems();
		final List<ProblemParameter> pparams = ServiceFactory.getAppService()
				.listProblemParameters();
		for (final Problem p : problems) {
			for (final ProblemParameter pp : pparams) {
				final ProblemParamDefine ppd = new ProblemParamDefine();
				ppd.setProbId(p.getId());
				ppd.setProbParId(pp.getId());
				ServiceFactory.getAppService().addProblemParamDefine(ppd);
			}
		}

	}

	private static void listajAlgDefinedParametre() {
		final List<AlgParamDefine> apds = ServiceFactory.getAppService()
				.listAlgParamDefine();
		for (final AlgParamDefine apd : apds) {
			System.out.println(apd.toString());
		}

	}

	private static void dodajAlgDefinedParametar() {
		final List<Algorithm> algorithms = ServiceFactory.getAppService()
				.listAlgorithms();
		final List<AlgorithmParameter> aparams = ServiceFactory.getAppService()
				.listAlgorithmParameters();

		for (final Algorithm a : algorithms) {
			for (final AlgorithmParameter ap : aparams) {
				final AlgParamDefine apd = new AlgParamDefine();
				apd.setAlgId(a.getId());
				apd.setAlgParId(ap.getId());
				ServiceFactory.getAppService().addAlgParamDefine(apd);
			}
		}

	}

	private static void dodajAlgoritam() {
		final Algorithm algorithm = new Algorithm();
		algorithm.setName("ALGORITAM X");
		algorithm.setDescription("Opis algoritma X");
		ServiceFactory.getAppService().addAlgorithm(algorithm);
	}

	private static void dodajAlgParametar() {
		final AlgorithmParameter aparam = new AlgorithmParameter();
		aparam.setName("PARAM XN");
		aparam.setType(ParameterType.NUMERIC);
		ServiceFactory.getAppService().addAlgorithmParameter(aparam);

	}

	private static void dodajProblem() {
		final Problem problem = new Problem();
		problem.setName("PROBLEM X");
		problem.setDescription("Opis problema X");
		ServiceFactory.getAppService().addProblem(problem);

	}

	private static void dodajProbParametar() {
		final ProblemParameter pparam = new ProblemParameter();
		pparam.setName("PARAM XS");
		pparam.setType(ParameterType.STRING);
		ServiceFactory.getAppService().addProblemParameter(pparam);

	}

	private static void listajAlgoritme() {
		final List<Algorithm> algorithms = ServiceFactory.getAppService()
				.listAlgorithms();
		for (final Algorithm a : algorithms) {
			System.out.println(a.toString());
		}

	}

	private static void listajAlgParametre() {
		final List<AlgorithmParameter> aparams = ServiceFactory.getAppService()
				.listAlgorithmParameters();
		for (final AlgorithmParameter ap : aparams) {
			System.out.println(ap.toString());
		}

	}

	private static void listajProblem() {
		final List<Problem> problems = ServiceFactory.getAppService()
				.listProblems();
		for (final Problem p : problems) {
			System.out.println(p.toString());
		}

	}

	private static void listajProbParametre() {
		final List<ProblemParameter> pparams = ServiceFactory.getAppService()
				.listProblemParameters();
		for (final ProblemParameter pp : pparams) {
			System.out.println(pp.toString());
		}

	}

}
