package edu.cies.decanus.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.cies.decanus.config.AppConfigDB;
import edu.cies.decanus.config.EncryptAes;
import edu.cies.decanus.dto.UsuariosDto;
import edu.cies.decanus.negocio.UsuarioDao;

@Controller
@RequestMapping ("/usuario")
public class UsuarioController {
	
	
	@Autowired
	AppConfigDB db;
	
	@RequestMapping(value = { "/all"}, method = RequestMethod.GET)
	public ModelAndView usuarios(ModelAndView model) throws SQLException{
		List<UsuariosDto> usuarios=new ArrayList<UsuariosDto>();
		usuarios=new UsuarioDao().getListUsuario(db.getTemplate());		
		model.addObject("listUsuario", usuarios);
		model.setViewName("usuarios");
		return model; 
	}
	
	@RequestMapping(value = { "/crear"}, method = RequestMethod.GET)
	public ModelAndView usuarioCrear(ModelAndView model){
		model.setViewName("usuarioCrear");
		return model;	
		
	}
	
	@RequestMapping(value = { "/guardar"}, method = RequestMethod.POST)
	public ModelAndView guardarUsuario(HttpServletRequest request) throws Exception{
		
		UsuariosDto usuario = new UsuariosDto();
		usuario.setIdUsuario((String)request.getParameter("id"));
		usuario.setNombre1((String)request.getParameter("nombre1"));
		usuario.setNombre2((String)request.getParameter("nombre2"));
		usuario.setApellido1((String)request.getParameter("apellido1"));
		usuario.setApellidos2((String)request.getParameter("apellido2"));
		usuario.setTipoUsuario((String)request.getParameter("tipo"));
		usuario.setEstadoUsuario((String)request.getParameter("estado"));
		String fecha=(String)request.getParameter("fecha");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse(fecha);
		usuario.setFechaIngreso(inputDate);
		String pass=(String)request.getParameter("pass");
		String pass2=(String)request.getParameter("pass2");
		usuario.setPass(EncryptAes.encrypt(pass));
		String respuesta=new UsuarioDao().crearUsuario(db.getTemplate(), usuario);
		System.out.println(fecha);
		return new ModelAndView("redirect:/usuario/all");
		
	}
	
	
	@RequestMapping(value = { "/eliminar"}, method = RequestMethod.POST)
	private ModelAndView eliminarUsuario(HttpServletRequest request){
		String id = ((String)request.getParameter("id"));
		String respuesta=new UsuarioDao().eliminarUsuario(db.getTemplate(), id);
		return new ModelAndView("redirect:/usuario/all");
		
		
	}
	
	
	@RequestMapping(value = { "/modificar"}, method = RequestMethod.POST)
	private ModelAndView buscarUsuario(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String id = ((String)request.getParameter("id"));
		UsuariosDto usuario= new UsuariosDto();
		usuario = new UsuarioDao().getUsuario(db.getTemplate(), id);
		SimpleDateFormat dt1= new SimpleDateFormat("dd-MM-yyyy");
		usuario.setFechaIngresoS(dt1.format(usuario.getFechaIngreso()));
		model.addObject("usuario", usuario);
		model.setViewName("usuarioModificar");
		return model;
		
	}
	
	
	@RequestMapping(value = { "/modificar/ejecutar"}, method = RequestMethod.POST)
	public ModelAndView modificarUsuario(HttpServletRequest request) throws Exception{
		
		UsuariosDto usuario = new UsuariosDto();
		usuario.setIdUsuario((String)request.getParameter("id"));
		usuario.setNombre1((String)request.getParameter("nombre1"));
		usuario.setNombre2((String)request.getParameter("nombre2"));
		usuario.setApellido1((String)request.getParameter("apellido1"));
		usuario.setApellidos2((String)request.getParameter("apellidos2"));
		usuario.setTipoUsuario((String)request.getParameter("tipo"));
		usuario.setEstadoUsuario((String)request.getParameter("estado"));
		String fecha=(String)request.getParameter("fecha");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse(fecha);
		usuario.setFechaIngreso(inputDate);
		String pass=(String)request.getParameter("pass");
		String pass2=(String)request.getParameter("pass2");
		usuario.setPass(EncryptAes.encrypt(pass));
		String respuesta=new UsuarioDao().ModificarUsuario(db.getTemplate(), usuario, 1);

		System.out.println(fecha);
		return new ModelAndView("redirect:/usuario/all");
		
		
	}
	
}
