package fr.diginamic.librairie;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestLibrairie {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("librairie");
		EntityManager em = entityManagerFactory.createEntityManager();

		Livre l = em.find(Livre.class, 1);
		if (l != null) {
			int lId = l.getId();
			String lTitre = l.getTitre();
			String lAuteur = l.getAuteur();
			System.out.println(lId + " " + lTitre + " " + lAuteur);
		}

		TypedQuery<Emprunt> query = em.createQuery("SELECT a FROM Emprunt a WHERE id=3", Emprunt.class);
		Emprunt emprunt = query.getResultList().get(0);
		Set<Livre> livres = emprunt.getLivres();

		for (Livre liv : livres) {
			System.out.println("\r"+liv.getTitre() + " " + liv.getAuteur()+"\r");
		}

		TypedQuery<Emprunt> queryClient = em.createQuery("SELECT a FROM Emprunt a WHERE a.client.id =1", Emprunt.class);
		Emprunt empruntClient = queryClient.getResultList().get(0);
		Set<Livre> livresClient = empruntClient.getLivres();
	
		for (Livre liv : livresClient) {
			System.out.println("\r"+liv.getTitre() + " " + liv.getAuteur());
		}

		em.close();
		entityManagerFactory.close();

	}

}
