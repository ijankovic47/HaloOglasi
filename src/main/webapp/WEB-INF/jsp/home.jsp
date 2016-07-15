<%@page import="ita.model.OpstinaM"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ita.servlet.Localization" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="html/header.html" %>

<div class="row">
    <div class="col-md-12" style="height: 400px;">

        <a href="${pageContext.request.contextPath}/signUp" style="float: right">${lang.prijaviSe}</a><p style="float: right">/</p> 
        <a href="${pageContext.request.contextPath}/logIn" style="float: right">${lang.ulogujSe}</a><br>
        
        <a href="${pageContext.request.contextPath}/Localization?lang=srb" style="float: right">srb</a><p style="float: right">/</p> 
        <a href="${pageContext.request.contextPath}/Localization?lang=eng" style="float: right">eng</a><br>

        <h1>${lang.h1}</h1>

        <form action="${pageContext.request.contextPath}/loadForm2">

            <select name="opstina">
                <option value="-1">Opstina?</option>
                <c:forEach items="${opstine}" var="opstina" varStatus="i">
                    <c:choose>
                        <c:when test="${i.index==id}">
                            <option value="${i.index}" selected>${opstina.ime}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${i.index}">${opstina.ime}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>

            <input type="submit" value="${lang.potvrdi}"/>

        </form>

        <c:if test="${id>-1}">
            <form action="search">
                <select name="naselje">
                    <option value="0">Naselje?</option>
                    <c:forEach items="${naselja}" var="naselje">
                        <option value="${naselje.naseljeId}">${naselje.ime}</option>
                    </c:forEach>
                </select>

                ${lang.cenaDo}
                <input type="number" max="500" min="0" name="cena"> e

                ${lang.kvadraturaOd}
                <input type="number" max="500" min="0" name="kvadratura"> m2

                <select name="brSoba">
                    <option value="0">Broj soba?</option>
                    <option value="0.5">0.5</option>    
                    <option value="1">1</option>  
                    <option value="1.5">1.5</option> 
                    <option value="2">2</option> 
                    <option value="2.5">2.5</option> 
                    <option value="3">3</option>  
                    <option value="3.5">3.5</option>
                    <option value="4">4</option>  
                    <option value="4.5">4.5</option>
                    <option value="5">5</option>  
                    <option value="6">5+</option>  
                </select>

                <input type="submit" value="${lang.potvrdi}"/>
            </form>

        </c:if>
    </div>
</div>

<%@include file="html/footer.html" %>
