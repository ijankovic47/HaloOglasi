<%@page import="ita.model.ClanM"%>
<%@page import="ita.model.StanM"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ita.servlet.ShowImage" %>

<%@include file="html/header.html" %>

<div class="row">
    <div class="col-md-12">
        
        <p style="float: right">${lang.ulogovanKao} ${clanM.username}(${clanM.email}) <a href="${pageContext.request.contextPath}/logOut">${lang.izlogujSe}</a></p>

        <c:choose>
            
            <c:when test="${clanM.stanovi.size()==0}">
                <h1 style="clear: both">${lang.nemaOglasa}</h1>
            </c:when>
                
            <c:otherwise>
                <h1 style="clear: both">${lang.vasiOglasi}</h1><br>
                
                <c:forEach items="${clanM.stanovi}" var="stanM" varStatus="i">
                    
                        <div class="row" style="clear: both;">
                            
                            <div class="col-md-3" style="float: left">
                                <c:if test="${stanM.slike.size()>0}">
                                    <img src="${pageContext.request.contextPath}/ShowImage?id=${stanM.slike[0].id}" alt="Something wrong !" class="img-thumbnail"/>
                                </c:if>
                            </div>
                            
                            <div class="col-md-9">
                                <h1> ${stanM.naslov} </h1>
                                <p>${lang.cena} ${stanM.cena} e</p>
                                <p>${stanM.adresa.naseljeM.opstina.ime}/${stanM.adresa.naseljeM.ime}/${stanM.adresa.ulicaM.ime}</p>
                                <p>${lang.validiran} ${stanM.validiran}</p>
                                
                                <form action="opsirnije">
                                    <input type="text" hidden value="${i.index}" name="index"/>
                                    <input type="submit" value="${lang.opsirnije}"/>
                                </form>
                                    
                                <form action="delete">
                                    <input type="text" value="${stanM.id}" hidden name="id"/>
                                    <input type="submit" value="${lang.obrisi}"/>
                                </form>
                                    
                                    <form action="edit">
                                        <input type="text" hidden value="${i.index}" name="index"/>
                                        <input type="submit" value="${lang.edituj}"/>
                                    </form>
                                    
                                <c:if test="${clanM.role=='admin' && stanM.validiran==false}">
                                    <form action="validate">
                                        <input type="text" value="${stanM.id}" hidden name="id"/>
                                        <input type="submit" value="${lang.validiraj}"/>
                                    </form>
                                </c:if>
                                    
                            </div>
                        </div><hr>
                    
                </c:forEach>
            </c:otherwise>
        </c:choose>
        
            <div style="float: right; margin-bottom: 70px;">
                <c:if test="${clanM.role=='user'}">
                    
                    <form action="dajOglas">
                        <input type="text" hidden value="${clanM.email}" name="email"/>
                        <input type="text" hidden value="${clanM.password}" name="password"/>
                        <input type="submit" value="${lang.noviOglas}"/>
                    </form>
                        
                </c:if>
            </div>

        <%@include file="html/footer.html" %>
