package jdc.controller;

import java.sql.Connection;

import jdbc.connectionFactory.ConnectionFactory;
import jdbc.dao.ReservasDAO;
import jdbc.model.Reserva;

public class ReservasController {
	private ReservasDAO reservaDAO;
	 
	 public ReservasController() {
			Connection connection = new ConnectionFactory().recuperarConexao();
			this.reservaDAO = new ReservasDAO(connection);
		}
	 
		public void salvar(Reserva reserva) {
			this.reservaDAO.salvar(reserva);
		}
}
