<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="html/header.html" %>

<div class="row">
    <div class="col-md-12" style="height: 400px;">
        
        <form action="tryLogIn">
            Email:
            <input type="text" name="email"/>
            ${lang.sifra}
            <input type="password" name="password"/>
            <input type="submit" value="${lang.potvrdi}">
        </form>
        
        <a href="${pageContext.request.contextPath}/">${lang.nazad}</a>

 <%@include file="html/footer.html" %>