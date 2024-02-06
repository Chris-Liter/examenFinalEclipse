package ec.edu.ups.examen.Final.dao;

import ec.edu.ups.examen.Final.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class CuentaDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void crear(Cuenta cuenta) {
		em.persist(cuenta);
	}
	
	
	public Cuenta getCuenta(String telefono, String operador) {
		String jpql = "SELECT c FROM Cuenta c WHERE c.telefono = :telefono AND c.operador = :operador";
		TypedQuery<Cuenta> q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("telefono", telefono);
		q.setParameter("operador", operador);
		return q.getSingleResult();
	}
	

	public Cuenta getCue(String telefono) {
		String jpql = "SELECT c FROM Cuenta c WHERE c.telefono = :telefono";
		TypedQuery<Cuenta> q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("telefono", telefono);
		return q.getSingleResult();
	}
	
	
	public Cuenta getCuentaPorCliente(int id) {
		String jpql = "SELECT c FROM Cuenta c WHERE c.id_cliente = :id";
		TypedQuery<Cuenta> q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("id", id);
		return q.getSingleResult();
	}
	
	
	public void transferir(Cuenta origen, Cuenta destino, double monto) {
		if (origen.getMonto() >= monto) {
	        em.createQuery("UPDATE Cuenta c SET c.monto = c.monto - :monto WHERE c.id = :clienteOrigenId")
	                .setParameter("monto", monto)
	                .setParameter("clienteOrigenId", origen.getId())
	                .executeUpdate();

	        em.createQuery("UPDATE Cuenta c SET c.monto = c.monto + :monto WHERE c.id = :clienteDestinoId")
	                .setParameter("monto", monto)
	                .setParameter("clienteDestinoId", destino.getId())
	                .executeUpdate();
     } else {
	     throw new RuntimeException("Error: Saldo insuficiente para realizar la transferencia.");
            }
	}
	
}
