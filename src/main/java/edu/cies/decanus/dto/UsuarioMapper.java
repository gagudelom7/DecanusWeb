package edu.cies.decanus.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioMapper implements RowMapper<UsuariosDto> {

	@Override
	public UsuariosDto mapRow(ResultSet rs, int arg1) throws SQLException {
		UsuariosDto usuario= new UsuariosDto();
		usuario.setIdUsuario(rs.getString("id_usuario"));
		usuario.setNombre1(rs.getString("nombre1_usuario"));
		usuario.setNombre2(rs.getString("nombre2_usuario"));
		usuario.setApellido1(rs.getString("apellido1_usuario"));
		usuario.setApellidos2(rs.getString("apellido2_usuario"));
		usuario.setTipoUsuario(rs.getString("tipo_usuario"));
		usuario.setEstadoUsuario(rs.getString("estado_usuario"));
		usuario.setFechaIngreso(rs.getDate("fecha_ingreso"));
		return usuario;
	}

}
