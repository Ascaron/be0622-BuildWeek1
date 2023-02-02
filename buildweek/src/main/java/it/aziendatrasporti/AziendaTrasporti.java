package it.aziendatrasporti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestionebiglietti.model.Abbonamento;
import it.gestionebiglietti.model.Biglietto;
import it.gestionebiglietti.model.DistributoreAutomatico;
import it.gestionebiglietti.model.RivenditoreFisico;
import it.gestionebiglietti.model.Tessera;
import it.gestionebiglietti.model.Utente;
import it.gestionebiglietti.model.dao.AbbonamentoDAO;
import it.gestionebiglietti.model.dao.AziendaTrasportiDAO;
import it.gestionebiglietti.model.dao.BiglietteriaDAO;
import it.gestionebiglietti.model.dao.BigliettoDAO;
import it.gestionebiglietti.model.dao.DistributoreAutomaticoDAO;
import it.gestionebiglietti.model.dao.RivenditoreFisicoDAO;

public class AziendaTrasporti {
	
	private static final String aziendaTrasporti = "BuildWeekBE1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(aziendaTrasporti);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {
		
		//ISTANZIO GLI OGGETTI
		/*Utente ut1=new Utente("Mario", "Rossi");
		BiglietteriaDAO.saveut(ut1);
		
		Tessera tes1=new Tessera();
		tes1.setNumTessera(111);
		tes1.setUtente(ut1);
		tes1.setDataInizio(LocalDate.of(2022, 11, 10));
		tes1.setDataFine(tes1.getDataInizio().plusYears(1));
		BiglietteriaDAO.savetes(tes1);*/
		
		//RivenditoreFisicoDAO.istanziaRivenditoreFisico();
		
		//DistributoreAutomaticoDAO.istanziaDistributori();

		/*Biglietto bo1=new Biglietto(UUID.randomUUID().toString(), rf1);
		BigliettoDAO.salvaBiglietto(bo1);
		
		Biglietto bo2=new Biglietto(UUID.randomUUID().toString(), rf1);
		BigliettoDAO.salvaBiglietto(bo2);
		
		Biglietto bo3=new Biglietto(UUID.randomUUID().toString(), da2);
		BigliettoDAO.salvaBiglietto(bo3);
		
		Biglietto bo4=new Biglietto(UUID.randomUUID().toString(), da2);
		BigliettoDAO.salvaBiglietto(bo4);
		
		Abbonamento ab1=new Abbonamento();
		ab1.setBiglietteria(rf1);
		ab1.setCodUnivoco(UUID.randomUUID().toString());
		ab1.setDataEmissione(LocalDate.of(2022, 01, 01));
		ab1.setDataScandenza(ab1.getDataEmissione().plusYears(1));
		ab1.setTessera(tes1);
		AbbonamentoDAO.salvaAbbonamento(ab1);
		
		Abbonamento ab2=new Abbonamento();
		ab2.setBiglietteria(da2);
		ab2.setCodUnivoco(UUID.randomUUID().toString());
		ab2.setDataEmissione(LocalDate.of(2023, 11, 11));
		ab2.setDataScandenza(ab1.getDataEmissione().plusYears(1));
		ab2.setTessera(tes1);
		AbbonamentoDAO.salvaAbbonamento(ab2);*/

		//PARTE DELLO SCANNER
		System.out.println("Buongiorno, benvenuto in Flixbus");
		AziendaTrasportiDAO.funzionamento();
	}

}
