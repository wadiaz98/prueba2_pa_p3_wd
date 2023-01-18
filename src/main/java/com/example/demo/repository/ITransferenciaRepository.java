package com.example.demo.repository;

import com.example.demo.modelo.TransferenciaPr;

public interface ITransferenciaRepository {

	public void insertar(TransferenciaPr transferencia);

	public TransferenciaPr buscar(Integer id);
}
