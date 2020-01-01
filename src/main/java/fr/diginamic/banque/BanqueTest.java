package fr.diginamic.banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.Client;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;
import fr.diginamic.banque.entites.Virement;

public class BanqueTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction(); 
		transaction.begin();

		Banque bank = new Banque();
		bank.setNom("New Bank");
		
		//clients
		Client clientA = new Client();
		clientA.setAdresse(new Adresse(2, "rue de la Loge", 34000,  "Montpellier"));
		clientA.setNom("Holmes");
		clientA.setPrenom("Jack");
		clientA.setDateNaissance(LocalDate.of(1981, 1, 25));
		clientA.setBanque(bank);
		bank.addClient(clientA);
		
		Client clientB = new Client();
		clientB.setAdresse(new Adresse(376, "avenue de Castelnau", 34000,  "Montpellier"));
		clientB.setNom("Vernon");
		clientB.setPrenom("Sophie");
		clientB.setDateNaissance(LocalDate.of(1985, 3, 28));
		clientB.setBanque(bank);
		bank.addClient(clientB);
		
		Client clientC = new Client();
		clientC.setAdresse(new Adresse(45, "rue du Triolet", 34000,  "Montpellier"));
		clientC.setNom("Kleber");
		clientC.setPrenom("Gustav");
		clientC.setDateNaissance(LocalDate.of(1973, 7, 19));
		clientC.setBanque(bank);
		bank.addClient(clientC);
		
		em.persist(bank);
		em.persist(clientA);
		em.persist(clientB);
		em.persist(clientC);
		
		Set<Client> clientsAb = new HashSet<>();
		clientsAb.add(clientA);
		clientsAb.add(clientB);
		//comptes
		Compte compteAb = new Compte();
		compteAb.setNumero(923097);
		compteAb.setSolde(1500.0);
		compteAb.setClients(clientsAb);
		
		AssuranceVie cAv = new AssuranceVie(LocalDate.of(2030, 8, 1), 3.0);
		cAv.setNumero(123443);
		cAv.setSolde(300.);
		cAv.setTaux(3.5);
		em.persist(cAv);
		
		Compte cLa = new LivretA(0.75);
		cLa.setNumero(124356);
		cLa.setSolde(1015.0);
		em.persist(cLa);
	
		Set<Compte> comptesC = clientC.getComptes();
		comptesC.add(cAv);
		comptesC.add(cLa);
		Set<Compte> comptesA = clientA.getComptes();
		comptesA.add(compteAb);
		Set<Compte> comptesB = clientB.getComptes();
		comptesB.add(compteAb);
		//operations
		Virement virement = new Virement(clientA.getNom()+" "+clientA.getPrenom());
		virement.setMotif("Voyage");
		virement.setMontant(140.0);
		virement.setDate(LocalDate.of(2019, 12, 15));
		virement.setCompte(compteAb);
		em.persist(virement);

		Operation opDebit = new Operation();
		opDebit.setDate(LocalDate.of(2019, 10, 8));
		opDebit.setMontant(278.45);
		opDebit.setMotif("Remboursement");
		opDebit.setCompte(compteAb);
		em.persist(opDebit);
		
		Operation opCredit = new Operation();
		opCredit.setDate(LocalDate.of(2019, 10, 15));
		opCredit.setMontant(-150.10);
		opCredit.setMotif("Veterinaire");
		opCredit.setCompte(compteAb);
		em.persist(opCredit);
		
		transaction.commit();
				
		em.close();
		entityManagerFactory.close();
	}

}
