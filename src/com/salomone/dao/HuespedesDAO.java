package com.salomone.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.salomone.modelo.Huespedes;


public class HuespedesDAO {
private Connection connection;
	
	public HuespedesDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(Huespedes huesped) {
		try {
			String sql = "INSERT INTO huespedes (nombre, apellido, fechaN, nacionalidad, telefono, id_Reserva) VALUES (?, ?, ?, ?,?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, huesped.getNombre());
				pstm.setString(2, huesped.getApellido());
				pstm.setDate(3, huesped.getFechaN());
				pstm.setString(4, huesped.getNacionalidad());
				pstm.setString(5, huesped.getTelefono());
				pstm.setInt(6, huesped.getIdReserva());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						huesped.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Huespedes> listarHuespedes() {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fechaN, nacionalidad, telefono, id_Reserva FROM huespedes";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huespedes> buscarId(String id) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {

			String sql = "SELECT id, nombre, apellido, fechaN, nacionalidad, telefono, id_Reserva FROM huespedes WHERE id_Reserva = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huespedes> buscarApellido(String apellido) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {

			String sql = "SELECT id, nombre, apellido, fechaN, nacionalidad, telefono, id_Reserva FROM huespedes WHERE apellido = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, apellido);
				pstm.execute();

				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer id_Reserva, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?, fechaN = ?, nacionalidad = ?, telefono = ?, id_Reserva = ? WHERE id = ?")) {
			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setDate(3, fechaN);
			stm.setString(4, nacionalidad);
			stm.setString(5, telefono);
			stm.setInt(6, id_Reserva);
			stm.setInt(7, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void Eliminar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM huespedes WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultSetEnHuesped(List<Huespedes> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Huespedes huespedes = new Huespedes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(huespedes);
			}
		}				
	}
	
	
		
}

