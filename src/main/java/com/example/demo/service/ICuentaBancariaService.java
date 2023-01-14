package com.example.demo.service;

import com.example.demo.modelo.CuentaBanciaria;

public interface ICuentaBancariaService {

	public void crear(CuentaBanciaria cuentaBanciaria);

	public void modificar(CuentaBanciaria cuentaBanciaria);

	public CuentaBanciaria buscar(String numero);

	public void borrar(String numero);
	

}
