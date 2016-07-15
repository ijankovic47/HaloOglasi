<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ita.model.OpstinaM"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@include file="html/header.html" %>

<div class="row" style="height: 400px;">
    <div class="col-md-12">

        <form action="dajOglas2">

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


            <form:form commandName="stanM" action="dajOglas" enctype="multipart/form-data" name="dajOglas" onsubmit="return validateForm()">

                <form:select path="adresa.naseljeM.ime" id="naselje" onchange="checkSelect(this)">
                    <form:options items="${naselja}" itemValue="ime" itemLabel="ime"/>
                </form:select>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('adresa.naseljeM.ime')}">
                        <p style="color: red;">Niste odabrali naselje !</p>
                    </c:if>
                </c:forEach><br>

                ${lang.naslov}
                <form:input path="naslov" onchange="validateLength(this, 5, 30)"/>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('naslov')}">
                        <p style="color: red;">Naslov mora da bude izmedju 5 i 30 karaktera !</p>
                    </c:if>
                </c:forEach><br>
                ${lang.cena}
                <form:input path="cena" onchange="checkNumber(this,1)"/>

                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('cena')}">
                        <p style="color: red;">Cena mora biti ceo broj !</p>
                    </c:if>
                </c:forEach><br>

                ${lang.ulicaIbroj}
                <form:input path="adresa.ulicaM.ime" onchange="validateLength(this, 5, 30)"/><br>

                ${lang.kvadratura}
                <form:input path="kvadratura" onchange="checkNumber(this,1)"/><br>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('kvadratura')}">
                        <p style="color: red;">Kvadratura mora biti ceo broj!</p>
                    </c:if>
                </c:forEach><br>

                <form:select path="brojSoba" onchange="checkSelect(this)" id="brojSoba">
                    <form:options items="${brojSoba}"/>
                </form:select>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('brojSoba')}">
                        <p style="color: red;">Niste odabrali broj soba !</p>
                    </c:if>
                </c:forEach><br>

                <form:select path="namestenost" onchange="checkSelect(this)" id="namestenost">
                    <form:options items="${namestenost}"/>
                </form:select><br>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('namestenost')}">
                        <p style="color: red;">Niste odabrali namestenost !</p>
                    </c:if>
                </c:forEach><br>

                <form:select path="nacinPlacanja" onchange="checkSelect(this)" id="nacinPlacanja">
                    <form:options items="${nacinPlacanja}"/>
                </form:select><br>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('nacinPlacanja')}">
                        <p style="color: red;">Niste odabrali nacin placanja !</p>
                    </c:if>
                </c:forEach><br>

                <form:select path="grejanje" onchange="checkSelect(this)" id="grejanje">
                    <form:options items="${grejanje}"/>
                </form:select>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('grejanje')}">
                        <p style="color: red;">Niste odabrali vrstu grejanja !</p>
                    </c:if>
                </c:forEach><br>

                ${lang.sprat}
                <form:input path="sprat" onchange="checkNumber(this,0)"/><br>
                <c:forEach items="${errors}" var="error">
                    <c:if  test="${error.getField().equals('sprat')}">
                        <p style="color: red;">Sprat mora biti ceo broj !</p>
                    </c:if>
                </c:forEach><br>

                ${lang.opis}
                <form:input path="opis"/>

                ${lang.dodatno}<br>

                <form:checkbox path="depozit"/>${lang.depozit}
                <form:checkbox path="terasa"/>${lang.terasa}
                <form:checkbox path="internet"/>Internet
                <form:checkbox path="klima"/>${lang.klima}
                <form:checkbox path="telefon"/>${lang.telefon}
                <form:checkbox path="kablovska"/>${lang.kablovska}<br>

                ${lang.linkMapa}
                <form:input path="mapa"/>


                <input type="file" name="file"/>
                <input type="file" name="file"/>
                <input type="file" name="file"/>
                <input type="file" name="file"/>

                <input type="text" hidden value="${stanM.id}" name="id"/>

                <input type="submit" value="${lang.potvrdi}"/>

            </form:form>
        </c:if>

        <a href="${pageContext.request.contextPath}/tryLogIn?email=${clanM.email}&password=${clanM.password}">${lang.nazad}</a>

        <script>
            function checkSelect(inputElement) {
                
                var x = inputElement.selectedIndex;
                if(document.getElementsByTagName("option")[x].value==-1){
                   inputElement.style = "color: red;";
                   return false;
                }      
                else{
                    inputElement.style = "border-color: none;";
                    return true;
                }
            }
            function validateLength(inputElement, min, max) {
                
                var inputText = inputElement.value;
                if (inputText.length < min || inputText.length > max) {
                    inputElement.style = "border-color: red;";
                    return false;
                } else {
                    inputElement.style = "border-color: none;";
                    return true;
                }
            }
            function checkNumber(inputElement, min){
                
                var x=inputElement.value;
                if(isNaN(x)||x<min){
                    inputElement.style="border-color: red;";
                    return false;
                }
                else{
                    inputElement.style = "border-color: none;";
                    return true;
                }
            }
            function validateForm() {
                
                var select = document.forms["dajOglas"]["naselje"];
                if(!checkSelect(select)){
                    return false;
                }
                var naslov=document.forms["dajOglas"]["naslov"];
                if(!validateLength(naslov,5,30)){
                    return false;
                }
                 var cena=document.forms["dajOglas"]["cena"];
                if(!checkNumber(cena,1)){
                    return false;
                }
                var naslov=document.forms["dajOglas"]["adresa.ulicaM.ime"];
                if(!validateLength(naslov,5,30)){
                    return false;
                }
                var kvadratura=document.forms["dajOglas"]["kvadratura"];
                if(!checkNumber(kvadratura,1)){
                    return false;
                }
                var select = document.forms["dajOglas"]["brojSoba"];
                if(!checkSelect(select)){
                    return false;
                }
                var select = document.forms["dajOglas"]["namestenost"];
                if(!checkSelect(select)){
                    return false;
                }
                var select = document.forms["dajOglas"]["nacinPlacanja"];
                if(!checkSelect(select)){
                    return false;
                }
                var select = document.forms["dajOglas"]["grejanje"];
                if(!checkSelect(select)){
                    return false;
                }
                var sprat=document.forms["dajOglas"]["sprat"];
                if(!checkNumber(sprat,0)){
                    return false;
                }
                return true;
            }
        </script>

        <%@include file="html/footer.html" %>


