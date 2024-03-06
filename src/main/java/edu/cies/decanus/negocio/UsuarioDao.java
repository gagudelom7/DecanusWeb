package edu.cies.decanus.negocio;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.cies.decanus.dto.UsuariosDto;
import edu.cies.decanus.dto.UsuarioMapper;

public class UsuarioDao {

public List<UsuariosDto> getListUsuario(JdbcTemplate jdbcTemplate){
		
		String sql ="select * from usuarios";
		
		List<UsuariosDto> Lista=jdbcTemplate.query(sql, new UsuarioMapper() );
		
		return Lista;
		
	}

	public String crearUsuario(JdbcTemplate jdbcTemplate, UsuariosDto usuario) {
	      String SQL = "INSERT INTO decanus.usuarios(id_usuario, nombre1_usuario, nombre2_usuario, apellido1_usuario, apellido2_usuario, tipo_usuario, estado_usuario, fecha_ingreso, pass) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	     String respuesta="OK";
	      try {
	    	  jdbcTemplate.update( SQL, usuario.getIdUsuario(), usuario.getNombre1(), usuario.getNombre2(), usuario.getApellido1(), usuario.getApellidos2(), usuario.getTipoUsuario(),usuario.getEstadoUsuario(),usuario.getFechaIngreso(),usuario.getPass());
		} catch (Exception e) {
			respuesta="NOK";
		}
	      
	     
	      return respuesta;
	}

	
	


	
	public String eliminarUsuario(JdbcTemplate jdbcTemplate, String id){
		
		String SQL = "DELETE FROM  decanus.usuarios WHERE id_usuario=?";
		

		String respuesta = "OK";
		try {
		
			jdbcTemplate.update(SQL, id);
			
		} catch (Exception e) {

			respuesta = "NOK";
			
		}
		
		return respuesta;
	}
	
	public UsuariosDto getUsuario(JdbcTemplate jdbcTemplate, String id){
		String sql ="select * from usuarios WHERE id_usuario=?";
		UsuariosDto usuario = new UsuariosDto();
		try {
			
		usuario= (UsuariosDto)jdbcTemplate.queryForObject(sql, new Object[]{id}, new UsuarioMapper());
			
		} catch (Exception e) {
				usuario=null;
			
		}
		
		return usuario;
	}
	
	
	public String ModificarUsuario (JdbcTemplate jdbcTemplate, UsuariosDto usuario, int opcion){
		String sql="";
		String respuesta = "OK";
		try {
			
		
		if(opcion==1){
			
			sql= "UPDATE decanus.usuarios SET nombre1_usuario=?, nombre2_usuario=?, apellido1_usuario=?, apellido2_usuario=?, tipo_usuario=?, estado_usuario=?, fecha_ingreso=?, pass=?"+
					"WHERE id_usuario=?;";
			
			jdbcTemplate.update(sql,usuario.getNombre1(), usuario.getNombre2(),usuario.getApellido1(),usuario.getApellidos2(), 
					usuario.getTipoUsuario(), usuario.getEstadoUsuario(), usuario.getFechaIngreso(), usuario.getPass(), usuario.getIdUsuario());
			
		}else{
			
		
			sql= "UPDATE decanus.usuarios SET nombre1_usuario=?, nombre2_usuario=?, apellido1_usuario=?, apellido2_usuario=?, tipo_usuario=?, estado_usuario=?, fecha_ingreso=?"+
					"WHERE id_usuario=?;";
			
			
			jdbcTemplate.update(sql,usuario.getNombre1(), usuario.getNombre2(),usuario.getApellido1(),usuario.getApellidos2(), 
					usuario.getTipoUsuario(), usuario.getEstadoUsuario(), usuario.getFechaIngreso(),  usuario.getIdUsuario());
			
		}
		
		} catch (Exception e) {
			respuesta = "NOK";
		}
		
		
		return respuesta;
	}
	
	
	}
	

