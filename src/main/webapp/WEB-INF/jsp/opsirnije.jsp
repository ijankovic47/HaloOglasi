<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="ita.servlet.ShowImage" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="html/header.html" %>

<div class="row"  style="height: 400px">
    <div class="col-md-4">

        <c:forEach items="${stanM.slike}" var="slika">
            <img class="mySlides w3-animate-top" src="${pageContext.request.contextPath}/ShowImage?id=${slika.id}" style="width:100%">
        </c:forEach>

    </div>
    <div class="col-md-4">

        <h1>${stanM.naslov}</h1>
        <p>${stanM.adresa.naseljeM.opstina.ime}/${stanM.adresa.naseljeM.ime}/${stanM.adresa.ulicaM.ime}</p>
        <p>${lang.cena} ${stanM.cena} e</p>
        <p>${lang.kvadratura} ${stanM.kvadratura} m<sup>2</sup></p>
        <p>${lang.brojSoba} ${stanM.brojSoba}</p>
        <p>${lang.grejanje} ${stanM.grejanje}</p>
    </div>

    <div class="col-md-4">
        <p>${lang.nacinPlacanja} ${stanM.nacinPlacanja}</p>
        <p>${lang.namestenost} ${stanM.namestenost}</p>
        <p>${lang.sprat} ${stanM.sprat}</p>
        <p>${lang.telefon} ${stanM.clan.telefon}</p>
        <p>Email: ${stanM.clan.email}</p>
        <ul>
            <c:if test="${stanM.depozit}">
                <li>${lang.depozit}</li>
                </c:if>
                <c:if test="${stanM.internet}">
                <li>Internet</li>
                </c:if>
                <c:if test="${stanM.klima}">
                <li>${lang.klima}</li>
                </c:if>
                <c:if test="${stanM.kablovska}">
                <li>${lang.kablovska}</li>
                </c:if>
                <c:if test="${stanM.telefon}">
                <li>${lang.telefon}</li>
                </c:if>
                <c:if test="${stanM.terasa}">
                <li>${lang.terasa}</li>
                </c:if>
        </ul>

    </div>
</div>

<div class="row" style="margin-bottom: 60px;">
    <div class="col-md-8" style="overflow: hidden;">
        ${stanM.mapa}
    </div>

    <div class="col-md-4">
        <p>${stanM.opis}</p>
    </div>

</div>
<c:choose>

    <c:when test="${clanM!=null}">
        <a href="${pageContext.request.contextPath}/tryLogIn?email=${clanM.email}&password=${clanM.password}">${lang.nazad}</a>
    </c:when>

    <c:otherwise>
        <a href="${pageContext.request.contextPath}/goBack">Back</a>
    </c:otherwise>

</c:choose>

<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {
            myIndex = 1
        }
        x[myIndex - 1].style.display = "block";
        setTimeout(carousel, 5000);
    }
</script>

<%@include file="html/footer.html" %>

