package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBanciaria;
import com.example.demo.modelo.TransferenciaPr;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;

@Service
public class TransferenciaGestorServiceImpl implements ITransferenciaGestorService {

	@Autowired
	ITransferenciaRepository transferenciaRepository;
	@Autowired
	ICuentaBancariaRepository cuentaBancariaRepository;

	@Override
	public void transferir(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		TransferenciaPr transferencia = new TransferenciaPr();
		transferencia.setFecha(LocalDateTime.of(2023, 01, 13, 0, 0));
		transferencia.setOrigen(numeroOrigen);
		transferencia.setDestino(numeroDestino);

		// Busco las cuentas
		CuentaBanciaria banciariaOrigen = this.cuentaBancariaRepository.buscar(numeroOrigen);
		CuentaBanciaria banciariaDestino = this.cuentaBancariaRepository.buscar(numeroDestino);

		// Calculo la comision
		BigDecimal comisi = null;
		comisi = banciariaOrigen.getSaldo().subtract(monto.multiply(new BigDecimal(0.05)));
		transferencia.setComision(comisi);

		// Ingreso el monto
		transferencia.setMonto(monto);

		// Opero el monto en las respectivas cuentas
		if (monto.compareTo(banciariaOrigen.getSaldo()) < 1) {
			banciariaOrigen.setSaldo(banciariaOrigen.getSaldo().subtract(monto));
			banciariaDestino.setSaldo(banciariaDestino.getSaldo().add(monto));

			// Actualizo las cuentas
			this.cuentaBancariaRepository.actuañizar(banciariaOrigen);
			this.cuentaBancariaRepository.actuañizar(banciariaDestino);

			// Ingreso la transferencia realizada

			this.transferenciaRepository.insertar(transferencia);

		} else {
			System.out.println("Saldo insuficiente en la cuenta para realizar la transferencia");
		}

	}

}
