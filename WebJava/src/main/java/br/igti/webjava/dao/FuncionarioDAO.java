package br.igti.webjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.igti.webjava.entity.Funcionario;
import br.igti.webjava.jpa.JPAUtil;

public class FuncionarioDAO implements IWebJavaDAO<Funcionario, Integer> {
	
	private EntityManager entityManager = JPAUtil.getInstance().getEntityManager();
	
	public void save(Funcionario entity) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void update(Funcionario entity) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void delete(Integer id) {

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(Funcionario.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();			
	}

	public Funcionario findById(Integer id) {
		
		return entityManager.find(Funcionario.class, id);
	}
	

	public List<Funcionario> findByName(String name) {
		TypedQuery<Funcionario> query = entityManager
				.createQuery("from Funcionario c where c.nome like :name", Funcionario.class);		
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() {
		
		return entityManager.createQuery("from Funcionario").getResultList();
	}
	
	public Funcionario findByLogin(String login, String senha) {
		
		TypedQuery<Funcionario> query = entityManager
				.createQuery("from Funcionario c where c.login = :login and c.senha = :senha", Funcionario.class);		
		query.setParameter("login", login);
		query.setParameter("senha", senha);		
	
		return query.getSingleResult();
	}
}
