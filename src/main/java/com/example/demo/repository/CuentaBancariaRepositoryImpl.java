package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CuentaBanciaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBanciaria cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBanciaria);
	}

	@Override
	public void actuañizar(CuentaBanciaria cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBanciaria);
	}

	@Override
	public CuentaBanciaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBanciaria.class, numero);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(numero));
	}

}
