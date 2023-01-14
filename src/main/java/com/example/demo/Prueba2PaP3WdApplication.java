package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.CuentaBanciaria;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.ITransferenciaGestorService;

@SpringBootApplication
public class Prueba2PaP3WdApplication implements CommandLineRunner {

	@Autowired
	private ICuentaBancariaService bancariaService;

	@Autowired
	private ITransferenciaGestorService gestorService;

	public static void main(String[] args) {
		SpringApplication.run(Prueba2PaP3WdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Opcion 1
		CuentaBanciaria bancariaOrigen = new CuentaBanciaria();
		bancariaOrigen.setNumero("0123456787");
		bancariaOrigen.setCedula("1725840538");
		bancariaOrigen.setTipo("A");
		bancariaOrigen.setSaldo(new BigDecimal(200));

		this.bancariaService.crear(bancariaOrigen);

		CuentaBanciaria bancariaDestino = new CuentaBanciaria();
		bancariaDestino.setNumero("9876543218");
		bancariaDestino.setCedula("1725840538");
		bancariaDestino.setTipo("C");
		bancariaDestino.setSaldo(new BigDecimal(100));

		this.bancariaService.crear(bancariaDestino);

		// Opcion 2
		this.gestorService.transferir("0123456789", "9876543210", new BigDecimal(100));

		// Opcion3
		this.bancariaService.buscar(bancariaOrigen.getNumero());
	}

}
