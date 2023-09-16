package com.salomone.modelo;

import java.sql.Date;

public class Huespedes {
	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FechaN;
	private String Nacionalidad;
	private String Telefono;
	private Integer Id_Reserva;
	
	public Huespedes(String nombre, String apellido,  Date fechaN, String nacionalidad, String telefono,
			Integer id_Reserva) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		FechaN = fechaN;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		Id_Reserva = id_Reserva;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, Date fechaN, String nacionalidad,
			String telefono, Integer id_Reserva) {
		super();
		Id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaN = fechaN;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		Id_Reserva = id_Reserva;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public Date getFechaN() {
		return FechaN;
	}

	public void setFechaN(Date fechaN) {
		FechaN = fechaN;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public Integer getIdReserva() {
		return Id_Reserva;
	}

	public void setIdReserva(Integer id_Reserva) {
		Id_Reserva = id_Reserva;
	}
	
}
