package edu.cies.decanus.negocio;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.cies.decanus.dto.MateriaDto;
import edu.cies.decanus.dto.MateriaMapper;

public class MateriaDao {
	
	
	public List<MateriaDto> getListMateria(JdbcTemplate jdbcTemplate){
		
		String sql ="select * from materias";
		
		List<MateriaDto> Lista=jdbcTemplate.query(sql, new MateriaMapper());
		
		return Lista;
		
	}
	
	public String crearMateria(JdbcTemplate jdbcTemplate, MateriaDto materia) {
	      String SQL = "INSERT INTO decanus.materias(nombre_materia, horas, profesor) VALUES(?, ?, ?)";
	     String respuesta="OK";
	      try {
	    	  jdbcTemplate.update( SQL, materia.getNombre(), materia.getHoras(), materia.getProfesor());
		} catch (Exception e) {
			respuesta="NOK";
		}
	      
	     
	      return respuesta;
	   }
	
	public String eliminarMateria(JdbcTemplate jdbcTemplate, int id){
		
		String SQL = "DELETE FROM  decanus.materias WHERE id_materia=?";
		String respuesta = "OK";
		try {
		
			jdbcTemplate.update(SQL, id);
			
		} catch (Exception e) {

			respuesta = "NOK";
			
		}
		
		return respuesta;
		
	}
	
	public String ModificarMateria (JdbcTemplate jdbcTemplate, MateriaDto materia){
		
		String sql= "UPDATE decanus.materias SET nombre_materia=?, horas=?, profesor=? WHERE id_materia=?";
		String respuesta = "OK";
		try {
			jdbcTemplate.update(sql,materia.getNombre(), materia.getHoras(),materia.getProfesor(),materia.getCodigo());
		} catch (Exception e) {
			respuesta = "NOK";
		}
		
		return respuesta;
	}
	
	
	

}
