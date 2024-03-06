package edu.cies.decanus.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MateriaMapper implements RowMapper<MateriaDto> {

	@Override
	public MateriaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MateriaDto materia = new MateriaDto();
		
		materia.setCodigo(rs.getInt("id_materia"));
		materia.setNombre(rs.getString("nombre_materia"));
		materia.setHoras(rs.getInt("horas"));
		materia.setProfesor(rs.getString("profesor"));
		
		return materia;
	}

}
