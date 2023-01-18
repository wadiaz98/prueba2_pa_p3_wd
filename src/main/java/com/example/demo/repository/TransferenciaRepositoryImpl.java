package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.TransferenciaPr;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(TransferenciaPr transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

	@Override
	public TransferenciaPr buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(TransferenciaPr.class, id);
	}

}
