<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="ita.servlet.ShowImage" %>

<%@include file="html/header.html" %>

<div class="row">
    <div class="col-md-12">

        <c:choose>

            <c:when test="${stanovi.size()==0}">
                <h1>${lang.nemaOglasa2}</h1>
            </c:when>

            <c:otherwise>
                <h1>${lang.vasiOglasi2}</h1><br>
                <c:forEach items="${stanovi}" var="stanM" varStatus="i">

                    <div class="row" style="clear: both;">
                        <div class="col-md-4" style="float: left">

                            <c:if test="${stanM.slike.size()>0}">
                                <img src="${pageContext.request.contextPath}/ShowImage?id=${stanM.slike[0].id}" alt="Something wrong!" class="img-thumbnail"/>
                            </c:if>

                        </div>

                        <div class="col-md-8">

                            <h1> ${stanM.naslov} </h1>
                            <p>${lang.cena} ${stanM.cena} e</p>
                            <p>${stanM.adresa.naseljeM.opstina.ime}/${stanM.adresa.naseljeM.ime}/${stanM.adresa.ulicaM.ime}</p>

                            <form action="opsirnije2">
                                <input type="text" hidden value="${i.index}" name="index"/>
                                <input type="submit" value="${lang.opsirnije}"/>
                            </form>
                        </div>
                    </div><hr>

                </c:forEach>
            </c:otherwise>
        </c:choose>

        <a href="${pageContext.request.contextPath}/">${lang.nazad}</a>

        <%@include file="html/footer.html" %>
