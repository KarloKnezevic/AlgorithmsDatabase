package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.DAOException;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgParamDefineDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgParameterDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IAlgorithmDAO;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOFactory;
import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;
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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * <p>
 * Ovaj razred predstavlja implementaciju sloja za pohranu podataka u relacijsku
 * bazu podataka uporabom specifikacije JPA (Java Persistence API).
 * </p>
 * <p>
 * Razred kao implementacije odgovarajućih DAO sučelja stvara objekte iz paketa
 * {@linkplain hr.fer.zemris.adresar.dao.jpaimpl}; konkretno, radi se o
 * objektima: {@linkplain hr.fer.zemris.adresar.dao.jpaimpl.GradDAOJPAImpl} i
 * {@linkplain hr.fer.zemris.adresar.dao.jpaimpl.OsobaDAOJpaImpl}.
 * </p>
 * 
 * <p>
 * Odgovarajući EntityManager stvara se po potrebi (kada ga prvi puta zatreba
 * neka metode u DAO objektima), i povezuje u kontekst trenutne dretve. Sve
 * metode koje izvodi ista dretva imaju pristup do istog pohranjenog
 * EntityManager-a.
 * </p>
 * 
 * <p>
 * EntityManager se zatvara pozivom metode {@linkplain #release()}. Ukoliko
 * pozivatelj ne poziva ovu metodu, doći će do "curenja" veza prema bazi
 * podataka što će uzrokovati neispravan rad klijenta a potencijalno i zagušenje
 * samog DBMS-a (ovisno o maksimalnom konfiguriranom broju veza koje DBMS može
 * imati otvorene prema klijentima). Alternativo, EntityManager-om se može
 * upravljati odgovarajućim kroz odgovarajuće metode sučelja
 * {@linkplain DAOOperations}.
 * </p>
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class DAOFactoryJPAImpl implements IDAOFactory, IDAOOperations {
	/**
	 * Pomoćni razred čiji se primjerci vežu u kontekst dretve u korišteni
	 * {@linkplain ThreadLocal} objekt. Zaseban razred napravljen je stoga da se
	 * omogući kasnija eventualna pohrana dodatnih podataka.
	 * 
	 * @author marcupic
	 * 
	 */
	private static class ThreadData {
		/** EntityManager koji se koristi za rad s bazom podataka */
		private EntityManager entityManager;
		/** Transakcija */
		private EntityTransaction tx;

	}

	/**
	 * ThreadLocal za pohranu podataka o uspostavljenim vezama prema DBMS-u.
	 **/
	private final ThreadLocal<ThreadData> registry = new ThreadLocal<ThreadData>();

	// ==================================================================
	// Reference na sql objekte
	private final IAlgorithmDAO algorithm;

	private final IAlgParameterDAO algorithmParameter;

	private final IAlgParamDefineDAO algParamDefine;

	private final IExpAlgParamNumericDAO expAlgParamNumeric;

	private final IExpAlgParamStringDAO expAlgParamString;

	private final IExperimentDAO experiment;

	private final IExpProbParamNumericDAO expProbParamNumeric;

	private final IExpProbParamStringDAO expProbParamString;

	private final IProblemDAO problem;

	private final IProblemParamDefineDAO problemParamDefine;

	private final IProblemParameterDAO problemParameter;

	private final IResultDAO result;

	private final IRunDAO run;

	// ==================================================================
	/** EntityManagerFactory za stvaranje EntityManager objekata */
	private EntityManagerFactory emf;

	/**
	 * Konstruktor.
	 */
	public DAOFactoryJPAImpl() {
		startup();
		// ==================================================================
		// INSTANCIRATI OBJEKTE
		algorithm = new AlgorithmDAOJPASqlImpl(this);

		algorithmParameter = new AlgorithmParameterDAOJPASqlImpl(this);

		algParamDefine = new AlgorithmParameterDefineDAOJPASqlImpl(this);

		expAlgParamNumeric = new ExpAlgParamNumericDAOJPASqlImpl(this);

		expAlgParamString = new ExpAlgParamStringDAOJPASqlImpl(this);

		experiment = new ExperimentDAOJPASqlImpl(this);

		expProbParamNumeric = new ExpProbParamNumericDAOJPASqlImpl(this);

		expProbParamString = new ExpProbParamStringDAOJPASqlImpl(this);

		problem = new ProblemDAOJPASqlImpl(this);

		problemParamDefine = new ProblemParamDefineDAOJPASqlImpl(this);

		problemParameter = new ProblemParameterDAOJPASqlImpl(this);

		result = new ResultDAOJPASqlImpl(this);

		run = new RunDAOJPASqlImpl(this);
		// ==================================================================
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOOperations}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOOperations#beginTransaction()
	 */
	@Override
	public void beginTransaction() throws DAOException {
		try {
			getThreadData().tx.begin();
		} catch (final Exception ex) {
			throw new DAOException("Could not begin transaction.", ex);
		}
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOOperations}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOOperations#closeObject()
	 */
	@Override
	public void closeObject() throws DAOException {
		release();
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOOperations}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOOperations#commitTransaction()
	 */
	@Override
	public void commitTransaction() throws DAOException {
		try {
			getThreadData().tx.commit();
		} catch (final Exception ex) {
			throw new DAOException("Could not commit transaction.", ex);
		}
	}

	@Override
	public IAlgorithmDAO getAlgorithm() {
		return algorithm;
	}

	@Override
	public IAlgParameterDAO getAlgorithmParameter() {
		return algorithmParameter;
	}

	@Override
	public IAlgParamDefineDAO getAlgParamDefine() {
		return algParamDefine;
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOFactory}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOFactory#getDAOOperations()
	 */
	@Override
	public IDAOOperations getDAOOperations() {
		return this;
	}

	@Override
	public IExpAlgParamNumericDAO getExpAlgParamNumeric() {
		return expAlgParamNumeric;
	}

	@Override
	public IExpAlgParamStringDAO getExpAlgParamString() {
		return expAlgParamString;
	}

	@Override
	public IExperimentDAO getExperiment() {
		return experiment;
	}

	@Override
	public IExpProbParamNumericDAO getExpProbParamNumeric() {
		return expProbParamNumeric;
	}

	@Override
	public IExpProbParamStringDAO getExpProbParamString() {
		return expProbParamString;
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOOperations}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOOperations#getObject()
	 */
	@Override
	public Object getObject() throws DAOException {
		return getThreadData().entityManager;
	}

	@Override
	public IProblemDAO getProblem() {
		return problem;
	}

	@Override
	public IProblemParamDefineDAO getProblemParamDefine() {
		return problemParamDefine;
	}

	@Override
	public IProblemParameterDAO getProblemParameter() {
		return problemParameter;
	}

	@Override
	public IResultDAO getResult() {
		return result;
	}

	@Override
	public IRunDAO getRun() {
		return run;
	}

	/**
	 * Pomoćna metoda koja iz konteksta trenutne dretve dohvaća podatke o
	 * EntityManageru. Ako takvih podataka nema, metoda automatski stvara novi
	 * EntityManager, veže ga u kontekst trenutne dretve i vraća pomoćni razred
	 * koji čuva sve podatke.
	 * 
	 * @return primjerak razreda koji čuva podatke o trenutnom EntityManageru
	 */
	private ThreadData getThreadData() {
		ThreadData td = registry.get();
		if (td == null) {
			td = new ThreadData();
			td.entityManager = emf.createEntityManager();
			try {
				td.tx = td.entityManager.getTransaction();
			} catch (final RuntimeException ex) {
				throw new DAOException("Could not get transaction object.", ex);
			}
			registry.set(td);
		}
		return td;
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOFactory}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOFactory#initStorage()
	 */
	@Override
	public void initStorage() {
		// Ne radi nista... Kod JPA, tablice ce se
		// automatski stvoriti prilikom stvaranja
		// primjerka razreda EntityManagerFactory
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOFactory}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOFactory#release()
	 */
	@Override
	public void release() {
		final ThreadData td = registry.get();
		if (td != null) {
			try {
				// Zatvorimo transakciju
				if (td.tx.isActive()) {
					td.tx.commit();
				}
				// Zatvorimo entityManager
				if (td.entityManager.isOpen()) {
					td.entityManager.close();
				}
			} catch (final Exception ex) {
				try {
					if (td.tx.isActive()) {
						td.tx.rollback();
					}
				} catch (final Exception ignorable) {
				}
				throw new DAOException("Could not release DAO.", ex);
			} finally {
				registry.remove();
				// Ako je entityManager i dalje otvoren, to znaci da
				// smo ovdje dosli zbog iznimke kod commitanja;
				// pokusajmo samo nasilno zatvoriti entitymanager i
				// vratiti originalni exception
				try {
					if (td.entityManager.isOpen()) {
						td.entityManager.close();
					}
				} catch (final Exception ignorable) {
				}
			}
		}
	}

	/**
	 * Implementacija odgovarajuće metode sučelja {@linkplain DAOOperations}.
	 * 
	 * @see hr.fer.zemris.adresar.dao.DAOOperations#rollbackTransaction()
	 */
	@Override
	public void rollbackTransaction() throws DAOException {
		try {
			getThreadData().tx.rollback();
		} catch (final Exception ex) {
			throw new DAOException("Could not rollback transaction.", ex);
		}
	}

	@Override
	public void rollbackTransactionIfNeeded() throws DAOException {
		try {
			if (getThreadData().tx.isActive()) {
				getThreadData().tx.rollback();
			}
		} catch (final Exception ex) {
			throw new DAOException("Could not rollback transaction.", ex);
		}
	}

	/**
	 * Pomoćna metoda koja zatvara postojeći EntityManagerFactory. Korisno
	 * pozivati direktno kada je ovaj DAO ugrađen u web aplikaciju.
	 */
	public void shutdown() {
		try {
			if (emf != null) {
				emf.close();
			}
		} finally {
			emf = null;
		}
	}

	/**
	 * Pomoćna metoda koja stvara novi EntityManagerFactory. Korisno pozivati
	 * direktno kada je ovaj DAO ugrađen u web aplikaciju.
	 */
	public void startup() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("algorithmdb");
		}
	}

}
