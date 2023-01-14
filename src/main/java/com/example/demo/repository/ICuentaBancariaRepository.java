package com.example.demo.repository;

import com.example.demo.modelo.CuentaBanciaria;

public interface ICuentaBancariaRepository {

	public void insertar(CuentaBanciaria cuentaBanciaria);

	public void actuañizar(CuentaBanciaria cuentaBanciaria);

	public CuentaBanciaria buscar(String numero);

	public void borrar(String numero);

}
