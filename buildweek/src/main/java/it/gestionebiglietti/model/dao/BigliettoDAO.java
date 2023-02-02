package it.gestionebiglietti.model.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.gestionebiglietti.model.Biglietto;

public class BigliettoDAO {
	
	private static final String aziendaTrasporti = "BuildWeekBE1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(aziendaTrasporti);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void salvaBiglietto(String codice) {

		try {
			Biglietto biglietto=new Biglietto(codice);

			t.begin();
			em.persist(biglietto);
			t.commit();
			System.out.println("Il tuo codice biglietto è "+ codice+" SALVALO");

		} catch (Exception e) {
			System.out.println("Errore nell'inserimento del codice");
		}

	}
	
	public static void controlloCodiceBiglietto(String codice) {

		Query q = em.createQuery("SELECT c.codUnivoco FROM OggettoDaVidimare c WHERE c.codUnivoco = :valore");
		q.setParameter("valore", codice);

		List<String> res = q.getResultList();
		
		if (res.isEmpty()) {
			salvaBiglietto(codice);
		} else {
			System.out.println("ERRORE DEL SISTEMA");
		}

	}
	
	public static void checkUtenteBiglietto(String codice, Scanner scanner) {

		Query q = em.createQuery("SELECT b.codUnivoco FROM Biglietto b WHERE b.codUnivoco = :valore");
		q.setParameter("valore", codice);

		List<String> res = q.getResultList();

		if (res.isEmpty()) {
			System.out.println("");
			System.out.println("Non hai un biglietto, acquistalo!");
			System.out.println("");
			AziendaTrasportiDAO.funzionamento();
		} else {
			//AziendaTrasportiDAO.abbonamentoPerTratta(scanner);
			System.out.println("MOOOOOOOSECA");
			//SELEZIONA UNA TRATTA
		}

	}
	
}
