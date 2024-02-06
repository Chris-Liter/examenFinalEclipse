package ec.edu.ups.examen.Final.business;

import ec.edu.ups.examen.Final.model.Cliente;
import ec.edu.ups.examen.Final.model.Cuenta;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private GestionCuenta ges;
	@Inject
	private GestionCliente ge;
	
	
	@PostConstruct
	public void init() {
		
		//Creacion de los clientes
		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		
		cliente.setDni("0302321013");
		cliente.setNombre("Jorge Lituma");
		
		cliente2.setDni("0305145872");
		cliente2.setNombre("Esteban Ochoa");
		
		cliente3.setDni("0301312523");
		cliente3.setNombre("Silvana Teran");
		
		cliente4.setDni("0306985661");
		cliente4.setNombre("Walter Regalado");
		
		ge.crear(cliente);
		ge.crear(cliente2);
		ge.crear(cliente3);
		ge.crear(cliente4);
		
		
		//Creacion de las cuentas
		Cuenta cuenta = new Cuenta();
		Cuenta cuenta2 = new Cuenta();
		Cuenta cuenta3 = new Cuenta();
		Cuenta cuenta4 = new Cuenta();
		
		cuenta.setId_cliente(1);
		cuenta.setMonto(5000);
		cuenta.setOperador("Tuenti");
		cuenta.setTelefono("0963623463");
		
		cuenta2.setId_cliente(2);
		cuenta2.setMonto(10.10);
		cuenta2.setOperador("Claro");
		cuenta2.setTelefono("0995980724");
		
		cuenta3.setId_cliente(3);
		cuenta3.setMonto(5);
		cuenta3.setOperador("Movistar");
		cuenta3.setTelefono("0995478412");
		
		cuenta4.setId_cliente(4);
		cuenta4.setMonto(30);
		cuenta4.setOperador("CNT");
		cuenta4.setTelefono("09962547815");
		
		ges.crear(cuenta);
		ges.crear(cuenta2);
		ges.crear(cuenta3);
		ges.crear(cuenta4);
		
	}
}
