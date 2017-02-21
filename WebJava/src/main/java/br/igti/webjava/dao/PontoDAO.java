package br.igti.webjava.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.igti.webjava.entity.Ponto;
import br.igti.webjava.jpa.JPAUtil;

public class PontoDAO implements IWebJavaDAO<Ponto, Integer> {
	
	private EntityManager entityManager = JPAUtil.getInstance().getEntityManager();
	
	public void save(Ponto entity) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void update(Ponto entity) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void delete(Integer id) {

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(Ponto.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();			
	}

	public Ponto findById(Integer id) {
		
		return entityManager.find(Ponto.class, id);
	}
	
	
	public List<Ponto> findByName(String name) {
		TypedQuery<Ponto> query = entityManager
				.createQuery("from Ponto c where c.nome like :name", Ponto.class);		
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Ponto> findAll() {
		
		return entityManager.createQuery("from Ponto").getResultList();
	}
	
	public Ponto findByDia(Integer idFuncionario) {
		TypedQuery<Ponto> query = entityManager
				.createQuery("from Ponto c where c.funcionario.id = :idFuncionario and c.data = :data ", Ponto.class);		
		query.setParameter("idFuncionario", idFuncionario);
		query.setParameter("data", LocalDate.now());
		try{
		return query.getSingleResult();
		}catch(Exception w){
			return null;
		} 
	}

	

}
