package fr.diginamic.compta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

public class TestJpa {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Fournisseur f =em.find(Fournisseur.class, 4);
		if(f!=null){
			int fId = f.getId();
			String fNom = f.getNom();
<<<<<<< HEAD
			System.out.println(fId+ fNom);
=======
			System.out.println(fId+" "+fNom);
>>>>>>> TP 2
		}
		em.close();
		entityManagerFactory.close();
	}

}
