/**
 * 
 */

function eliminarRecurso(id, url){

	var f = document.createElement("form");
	f.setAttribute('method',"post");
	f.setAttribute('name', 'forma')
	f.setAttribute('action',url);
	
	var i = document.createElement("input");
	i.setAttribute('type',"text");
	i.setAttribute('name',"id");
	i.setAttribute('value', id);
	f.appendChild(i);
	document.getElementsByTagName('body')[0].appendChild(f);
	document.forma.submit();
}



function modificarRecurso(id, url){
	
	var f = document.createElement("form");
	f.setAttribute('method',"post");
	f.setAttribute('name', 'forma')
	f.setAttribute('action',url);
	
	var i = document.createElement("input");
	i.setAttribute('type',"text");
	i.setAttribute('name',"id");
	i.setAttribute('value', id);
	f.appendChild(i);
	document.getElementsByTagName('body')[0].appendChild(f);
	document.forma.submit();
}










