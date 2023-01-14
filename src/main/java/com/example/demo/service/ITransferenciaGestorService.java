package com.example.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaGestorService {

	public void transferir(String numeroOrigen, String numeroDestino, BigDecimal monto);
}
