package fr.diginamic.compta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestJpa {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Fournisseur f =em.find(Fournisseur.class, 4);
		if(f!=null){
			int fId = f.getId();
			String fNom = f.getNom();
			System.out.println(fId+ fNom);
		}
		em.close();
		entityManagerFactory.close();
	}

}
