<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<input type="hidden" name="page_courante" value="${pageContext.request.servletPath}"/>
<input type="hidden" name="recherche" value="${pageContext.request.getParameter("recherche")}"/>
<input type="hidden" name="code_postal" value="${requestScope.code_postal}"/>
<input type="hidden" name="idCinema" value="${requestScope.cinema.id}"/>
<input type="hidden" name="idFilm" value="${requestScope.film.id}"/>
