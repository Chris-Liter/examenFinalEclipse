package ec.edu.ups.examen.Final.dao;

import java.util.List;

import ec.edu.ups.examen.Final.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void crear(Cliente cliente) {
		em.persist(cliente);
	}
	
	public Cliente getCliente(String dni) {
		String jpql = "SELECT c FROM Cliente c WHERE c.dni = :dni";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("dni", dni);
		return q.getSingleResult();
	}
	
	public List<Cliente> getAll(){
	    String jpql = "SELECT c FROM Cliente c WHERE c.dni <> :dni";
	    TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
	    q.setParameter("dni", "0302321013");
	    return q.getResultList();
	}

	
	public Cliente getJefe() {
		String jpql = "SELECT c FROM Cliente c WHERE c.dni = '0302321013'";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		return q.getSingleResult();
	}
	
}
