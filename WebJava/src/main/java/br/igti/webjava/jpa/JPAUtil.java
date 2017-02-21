package  br.igti.webjava.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    
    private static JPAUtil me;
    private EntityManagerFactory emf;
    
    
    private JPAUtil(){
        emf = Persistence.createEntityManagerFactory("JPAUtil");
    }

    public static JPAUtil getInstance() {
        if (me == null) {
            me = new JPAUtil();
        }
        return me;
    }

    public EntityManager getEntityManager() {
        EntityManager toReturn = emf.createEntityManager();        
        return toReturn;
    }

   

}
