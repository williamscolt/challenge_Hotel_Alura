package com.salomone.controller;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.salomone.dao.HuespedesDAO;
import com.salomone.factory.ConnectionFactory;
import com.salomone.modelo.Huespedes;


public class HuespedesController {
	 private HuespedesDAO huespedDAO;
	 
	 public HuespedesController() {
			Connection connection = new ConnectionFactory().recuperarConexion();
			this.huespedDAO = new HuespedesDAO(connection);
		}
	 
		public void guardar(Huespedes huespedes) {
			this.huespedDAO.guardar(huespedes);
		}
		public List<Huespedes> listarHuespedes() {
			return this.huespedDAO.listarHuespedes();
		}
		
		public List<Huespedes> listarHuespedesId(String id) {
			return this.huespedDAO.buscarId(id);
		}
		
		public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer id_Reserva, Integer id) {
			this.huespedDAO.Actualizar(nombre, apellido, fechaN, nacionalidad, telefono, id_Reserva, id);
		}
		
		public void Eliminar(Integer id) {
			this.huespedDAO.Eliminar(id);
		}
}
