package it.gestionebiglietti.model.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.gestionebiglietti.model.Abbonamento;
import it.gestionebiglietti.model.Tessera;
import it.gestionemezzi.model.dao.GestioneMezziDAO;

public class AbbonamentoDAO {
	private static final String aziendaTrasporti = "BuildWeekBE1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(aziendaTrasporti);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	//SALVA ABBONAMENTO
	public static void salvaAbbonamento(String codice, Tessera tessera, LocalDate dataIni, LocalDate dataFine) {

		try {
			Abbonamento abbonamento = new Abbonamento();
			abbonamento.setCodUnivoco(codice);
			abbonamento.setTessera(tessera);
			abbonamento.setDataEmissione(dataIni);
			abbonamento.setDataScandenza(dataFine);

			t.begin();
			em.persist(abbonamento);
			t.commit();
		} catch (Exception e) {
			System.out.println("Errore nell'inserimento dell' abbonamento");
		}

	}
	
	public static void controlloCodiceAbbonamento(String codice, Tessera tessera, LocalDate dataIni, LocalDate dataFine) {

		Query q = em.createQuery("SELECT c.codUnivoco FROM OggettoDaVidimare c WHERE c.codUnivoco = :valore");
		q.setParameter("valore", codice);

		List<String> res = q.getResultList();
		
		if (res.isEmpty()) {
			salvaAbbonamento(codice, tessera, dataIni, dataFine);
			System.out.println(tessera.getUtente().getNome()+" "+tessera.getUtente().getCognome()+" il tuo"
					+ " codice abbonamento è "+codice+" SALVALO PER USI FUTURI");
		} else {
			System.out.println("ERRORE DEL SISTEMA");
		}

	}
	
	//CONTROLLA PRESENZA ABBONAMENTO NEL DB
	public static void controlloPossessoAbbonamento(Scanner scanner){
		System.out.println("");
		System.out.println("Inserisci il codice del tuo abbonamento");
		System.out.println("");
		String codice=scanner.nextLine();
		checkUtenteAbbonamento(codice, scanner);
		
	}
	
	public static void checkUtenteAbbonamento(String codice, Scanner scanner) {

		Query q = em.createQuery("SELECT a.codUnivoco FROM Abbonamento a WHERE a.codUnivoco = :valore");
		q.setParameter("valore", codice);

		List<String> res = q.getResultList();

		if (res.isEmpty()) {
			System.out.println("");
			System.out.println("Non hai un abbonamento, acquistalo!");
			System.out.println("");
			AziendaTrasportiDAO.funzionamento();
		} else {
			GestioneMezziDAO.selectTratta(codice);
		}

	}
	
}
