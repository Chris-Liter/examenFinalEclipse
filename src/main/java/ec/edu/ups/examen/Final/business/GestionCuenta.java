package ec.edu.ups.examen.Final.business;

import ec.edu.ups.examen.Final.dao.CuentaDAO;
import ec.edu.ups.examen.Final.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCuenta {

	@Inject
	private CuentaDAO dao;
	
	public void crear(Cuenta cuenta) {
		dao.crear(cuenta);
	}
	
	public void transferir(Cuenta origen, Cuenta destino, double monto) {
		dao.transferir(origen, destino, monto);
	}
	
	public Cuenta getCuenta(String telefono, String operador) {
		return dao.getCuenta(telefono, operador);
	}
	public Cuenta getCue(String telefono) {
		return dao.getCue(telefono);
	}
	
	public Cuenta getCuentaPorCliente(int id) {
		return dao.getCuentaPorCliente(id);
	}
	
	
}
