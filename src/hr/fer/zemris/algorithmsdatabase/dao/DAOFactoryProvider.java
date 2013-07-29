package hr.fer.zemris.algorithmsdatabase.dao;

import hr.fer.zemris.algorithmsdatabase.dao.jpaimpl.DAOFactoryJPAImpl;

/**
 * Razred u čijoj je nadležnosti odabir implementacije sloja za perzistenciju
 * podataka (DAO layer). Konkretno, ovaj razred odabire koja će se
 * implementacija sučelja koristiti u aplikaciji, stvara je i nudi ostatku
 * aplikacije na uporabu kroz statičku metodu.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class DAOFactoryProvider {

	/**
	 * Referenca na odabranu implementaciju sloja za perzistenciju
	 */
	private static final IDAOFactory daoFactory;

	// Statički inicijalizator - tu se obavlja biranje
	static {
		daoFactory = new DAOFactoryJPAImpl();
	}

	/**
	 * Metoda dohvaća implementaciju sloja za perzistenciju podataka.
	 * 
	 * @return referencu na {@linkplain IDAOFactory} koji se koristi
	 */
	public static IDAOFactory getDAOFactory() {
		return daoFactory;
	}

}
