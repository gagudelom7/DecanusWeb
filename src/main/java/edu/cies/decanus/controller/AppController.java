package edu.cies.decanus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.cies.decanus.config.AppConfigDB;
import edu.cies.decanus.dto.MateriaDto;
import edu.cies.decanus.negocio.MateriaDao;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	AppConfigDB db;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}
	
	
	
	@RequestMapping(value = { "/noticias"}, method = RequestMethod.GET)
	public ModelAndView noticias(ModelAndView model){
	model.setViewName("noticias");
		return model; 
	}

	@RequestMapping(value = { "/contactenos"}, method = RequestMethod.GET)
	public ModelAndView contactenos(ModelAndView model){
	model.setViewName("contactenos");
		return model; 
	}
	
	@RequestMapping(value = { "/actividades"}, method = RequestMethod.GET)
	public ModelAndView actividades(ModelAndView model){
	model.setViewName("actividades");
		return model; 
	}
	
	@RequestMapping(value = { "/materias","/materias/{id}"}, method = RequestMethod.GET)
	public ModelAndView materias(ModelAndView model,@PathVariable Optional<String> id){
	List<MateriaDto> lista=new ArrayList<MateriaDto>();	
	MateriaDto materia=new MateriaDto();
	lista= new MateriaDao().getListMateria(db.getTemplate());
	String url="/DecanusWeb/materias/crear";
	String accion="Crear";
	if (id.isPresent()){
		
		int idMateria=Integer.parseInt((String)id.get());
		for(MateriaDto in : lista){
			if(in.getCodigo()==idMateria){
				
				materia.setCodigo(in.getCodigo());
				materia.setNombre(in.getNombre());
				materia.setHoras(in.getHoras());
				materia.setProfesor(in.getProfesor());
				url="/DecanusWeb/materias/modificar";
				accion="Modificar";
				break;
			}
			
			
		}
		
		
	}else{
		
		materia.setCodigo(0);
		materia.setNombre("");
		materia.setHoras(1);
		materia.setProfesor("");
		
	}
	model.addObject("accion", accion);
	model.addObject("url", url);
	model.addObject("materia", materia);
	model.addObject("listMateria", lista);
	model.setViewName("materias");
	return model; 
	}
	
	@RequestMapping(value = {"/materias/crear"}, method = RequestMethod.POST)
	public ModelAndView crearMateria(HttpServletRequest request){
		MateriaDto materia=new MateriaDto();
		int horas=Integer.parseInt((String)request.getParameter("horas"));
		materia.setHoras(horas);
		materia.setNombre(request.getParameter("nombre"));
		materia.setProfesor(request.getParameter("profesor"));
		String respuesta=new MateriaDao().crearMateria(db.getTemplate(), materia);
		return new ModelAndView("redirect:/materias");
	
		
	}
	
	@RequestMapping(value = {"/materias/eliminar/{id}"}, method = RequestMethod.GET)
	public ModelAndView eliminarMateria(@PathVariable("id") String id){

		int idMateria=Integer.parseInt(id);
		
		String respuesta=new MateriaDao().eliminarMateria(db.getTemplate(), idMateria);
		return new ModelAndView("redirect:/materias");
		
	}
	
	@RequestMapping(value = {"/materias/modificar"}, method = RequestMethod.POST)
	public ModelAndView modificarMateria(HttpServletRequest request){
		MateriaDto materia=new MateriaDto();
		int horas=Integer.parseInt((String)request.getParameter("horas"));
		int codigo=Integer.parseInt(request.getParameter("codigo"));
		materia.setCodigo(codigo);
		materia.setHoras(horas);
		materia.setNombre(request.getParameter("nombre"));
		materia.setProfesor(request.getParameter("profesor"));
		String respuesta=new MateriaDao().ModificarMateria(db.getTemplate(), materia);
		return new ModelAndView("redirect:/materias");
		
	}
	
	
	@RequestMapping(value = { "/notas"}, method = RequestMethod.GET)
	public ModelAndView notas(ModelAndView model){
	model.setViewName("notas");
		return model; 
	}
	
	
	
}



		