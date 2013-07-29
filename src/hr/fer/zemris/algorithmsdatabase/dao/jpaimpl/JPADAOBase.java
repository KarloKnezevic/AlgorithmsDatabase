package hr.fer.zemris.algorithmsdatabase.dao.jpaimpl;

import hr.fer.zemris.algorithmsdatabase.dao.IDAOOperations;

import javax.persistence.EntityManager;

/**
 * Osnovni razred iz kojeg su izvedeni svi ostali DAO objekti ovog paketa.
 * 
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 * 
 */
public class JPADAOBase {

	/** Referenca na {@linkplain DAOOperations} objekt */
	private final IDAOOperations daoOperations;

	/**
	 * Konstruktor.
	 * 
	 * @param daoOperations
	 *            referenca na objekt koji nudi pristup EntityManageru
	 */
	public JPADAOBase(IDAOOperations daoOperations) {
		this.daoOperations = daoOperations;
	}

	/**
	 * Metoda dohvaća aktivni EntityManager koji se koristi za obavljanje
	 * poslova perzistencije.
	 * 
	 * @return aktivni EntityManager
	 */
	public EntityManager getEntityManager() {
		return (EntityManager) daoOperations.getObject();
	}
}
