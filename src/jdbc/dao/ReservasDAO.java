package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.model.Reserva;

public class ReservasDAO {
	private Connection connection;
 
 	public ReservasDAO(Connection connection) {
		this.connection = connection;
	}
 	
 	public void salvar(Reserva reservas) {
 		try {
			String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setDate(1, reservas.getDataEntrada());
				pstm.setDate(2, reservas.getDataSaida());
				pstm.setString(3, reservas.getValor());
				pstm.setString(4, reservas.getFormaPagamento());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reservas.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}	
}
