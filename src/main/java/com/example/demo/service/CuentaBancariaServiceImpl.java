package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBanciaria;
import com.example.demo.repository.ICuentaBancariaRepository;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public void crear(CuentaBanciaria cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.insertar(cuentaBanciaria);
	}

	@Override
	public void modificar(CuentaBanciaria cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.actuañizar(cuentaBanciaria);
	}

	@Override
	public CuentaBanciaria buscar(String numero) {
		// TODO Auto-generated method stub
		CuentaBanciaria bancaria = this.iCuentaBancariaRepository.buscar(numero);
		System.out.println("El saldo de la cuenta es: " + bancaria.getSaldo());
		return bancaria;

	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.borrar(numero);
	}

}
