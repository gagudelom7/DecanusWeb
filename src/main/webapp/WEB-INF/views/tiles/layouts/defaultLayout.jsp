<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <title><tiles:getAsString name="title" /></title> 
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value='/static/css/metro.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/metro-icons.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/metro-responsive.css' />"  rel="stylesheet"></link>
	<script src="<c:url value='/static/js/jquery-2.1.3.min.js' />"    type="text/javascript"></script>
	<script src="<c:url value='/static/js/metro.js' />"    type="text/javascript"></script>
	<script src="<c:url value='/static/js/jquery.dataTables.min.js'/>"    type="text/javascript"></script>
	<script src="<c:url value='/static/js/app.js'/>"    type="text/javascript"></script>
	<link rel='shortcut icon' type='image/x-icon' href='../favicon.ico' />
	  
	<!--<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link> -->
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<script>
        function pushMessage(t){
            var mes = 'Info|Implement independently';
            $.Notify({
                caption: mes.split("|")[0],
                content: mes.split("|")[1],
                type: t
            });
        }

        $(function(){
            $('.sidebar').on('click', 'li', function(){
                if (!$(this).hasClass('active')) {
                    $('.sidebar li').removeClass('active');
                    $(this).addClass('active');
                }
            })
        })
        
        
    </script>
    
<style type="text/css">

 #site-content2
    {
    width:100%;
    height: 75%;
    overflow-y:auto;
    position: relative;
    padding-bottom:5%;
    
    
    }

</style>


</head>
 
<body>
		<header id="header">
			<tiles:insertAttribute name="header" />
		</header>
	
		<section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section>
			
		<section id="site-content">
		<div id="site-content2" >
		<tiles:insertAttribute name="body" />
		</div>
			
		</section>
		
</body>
</html>