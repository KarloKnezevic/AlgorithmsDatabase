package hr.fer.zemris.algorithmsdatabase.service;

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
import hr.fer.zemris.algorithmsdatabase.util.BeanUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Razred koji snosi odgovornost za odabir implementacije sloja usluge, i nudi
 * odabranu implementaciju kroz svoje metode.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class ServiceFactory {

	/** Referenca na odabranu implementaciju sloja usluge */
	private static IAppService appService;

	static {
		// Potraži datoteku service.properties i učitaj je
		final InputStream is = ServiceFactory.class.getClassLoader()
				.getResourceAsStream("service.properties");
		if (is == null) {
			throw new RuntimeException("Could not open service.properties");
		}
		final Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (final IOException ex) {
			throw new RuntimeException("Could not read service.properties", ex);
		} finally {
			try {
				is.close();
			} catch (final Exception ignorable) {
			}
		}
		final String className = prop.getProperty("className", "");
		if (className.isEmpty()) {
			throw new RuntimeException(
					"service.properties does not specify needed className property.");
		}

		// Stvori sloj usluge i pozovi one settere koje ima
		try {
			appService = (IAppService) ServiceFactory.class.getClassLoader()
					.loadClass(className).newInstance();
		} catch (final Exception ex) {
			throw new RuntimeException("Could not instantiate " + className
					+ ".", ex);
		}

		try {
			BeanUtil.setPropertyIfPresent(appService, IAlgorithmDAO.class,
					DAOFactoryProvider.getDAOFactory().getAlgorithm());
			BeanUtil.setPropertyIfPresent(appService, IProblemDAO.class,
					DAOFactoryProvider.getDAOFactory().getProblem());
			BeanUtil.setPropertyIfPresent(appService, IAlgParameterDAO.class,
					DAOFactoryProvider.getDAOFactory().getAlgorithmParameter());
			BeanUtil.setPropertyIfPresent(appService,
					IProblemParameterDAO.class, DAOFactoryProvider
							.getDAOFactory().getProblemParameter());
			BeanUtil.setPropertyIfPresent(appService, IAlgParamDefineDAO.class,
					DAOFactoryProvider.getDAOFactory().getAlgParamDefine());
			BeanUtil.setPropertyIfPresent(appService,
					IProblemParamDefineDAO.class, DAOFactoryProvider
							.getDAOFactory().getProblemParamDefine());
			BeanUtil.setPropertyIfPresent(appService, IExperimentDAO.class,
					DAOFactoryProvider.getDAOFactory().getExperiment());
			BeanUtil.setPropertyIfPresent(appService, IRunDAO.class,
					DAOFactoryProvider.getDAOFactory().getRun());
			BeanUtil.setPropertyIfPresent(appService, IResultDAO.class,
					DAOFactoryProvider.getDAOFactory().getResult());
			BeanUtil.setPropertyIfPresent(appService,
					IExpAlgParamNumericDAO.class, DAOFactoryProvider
							.getDAOFactory().getExpAlgParamNumeric());
			BeanUtil.setPropertyIfPresent(appService,
					IExpAlgParamStringDAO.class, DAOFactoryProvider
							.getDAOFactory().getExpAlgParamString());
			BeanUtil.setPropertyIfPresent(appService,
					IExpProbParamNumericDAO.class, DAOFactoryProvider
							.getDAOFactory().getExpProbParamNumeric());
			BeanUtil.setPropertyIfPresent(appService,
					IExpProbParamStringDAO.class, DAOFactoryProvider
							.getDAOFactory().getExpProbParamString());
		} catch (final Exception ex) {
			throw new RuntimeException("Could not call setters on " + className
					+ ".", ex);
		}
	}

	/**
	 * Metoda za dohvat sloja usluge. Ova je metode thread-safe i može se zvati
	 * iz više dretvi konkurentno.
	 * 
	 * @return implementaciju sloja usluge
	 */
	public static IAppService getAppService() {
		return appService;
	}

}
