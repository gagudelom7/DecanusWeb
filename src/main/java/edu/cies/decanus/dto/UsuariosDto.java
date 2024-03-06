package edu.cies.decanus.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuariosDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUsuario;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellidos2;
	private String tipoUsuario;
	private String estadoUsuario;
	private Date fechaIngreso;
	private String fechaIngresoS;
	public String getFechaIngresoS() {
		return fechaIngresoS;
	}
	public void setFechaIngresoS(String fechaIngresoS) {
		this.fechaIngresoS = fechaIngresoS;
	}
	private String pass;
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellidos2() {
		return apellidos2;
	}
	public void setApellidos2(String apellidos2) {
		this.apellidos2 = apellidos2;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
