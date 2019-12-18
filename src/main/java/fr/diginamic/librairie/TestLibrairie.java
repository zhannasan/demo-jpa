package fr.diginamic.librairie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestLibrairie {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("librairie");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Livre l =em.find(Livre.class, 1);
		if(l!=null){
			int lId = l.getId();
			String lTitre = l.getTitre();
			String lAuteur = l.getAuteur();
			System.out.println(lId+" "+lTitre+" "+lAuteur);
		}
		em.close();
		entityManagerFactory.close();

	}

}
