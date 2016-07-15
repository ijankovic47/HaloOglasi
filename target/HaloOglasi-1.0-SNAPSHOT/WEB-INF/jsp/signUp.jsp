<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@include file="html/header.html" %>

<div class="row">
    <div class="col-md-12" style="height: 400px;">

        <form:form commandName="clanM" action="trySignUp" onsubmit="return validateForm()" name="signUp">
            ${lang.korisnickoIme}
            <form:input path="username" onchange="validateLength(this, 5, 20)"/>
            <p style="font-size: small; color: red; font-style: italic;"><form:errors path="username"/></p><br>
            
            Email:
            <form:input path="email" onchange="validateEmail(this)"/>
            <p style="font-size: small; color: red; font-style: italic;"><form:errors path="email"/></p><br>
            
            ${lang.sifra}
            <form:password path="password" onchange="validateLength(this, 5, 20)"/>
            <p style="font-size: small; color: red; font-style: italic;"><form:errors path="password"/></p><br>
            
            ${lang.telefon}
            <form:input path="telefon" onchange="validateLength(this, 7, 10)"/>
            <p style="font-size: small; color: red; font-style: italic;"><form:errors path="telefon"/></p><br>
            
            <input type="submit" value="${lang.potvrdi}"/>
        </form:form>
            
            <p>${signUp}</p>

        <a href="${pageContext.request.contextPath}/">${lang.nazad}</a>

    </div>
</div>

<%@include file="html/footer.html" %>

<script>
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
            
            function validateEmail(inputElement) {
                var inputText = inputElement.value;
                
                var regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                
                if (regularExpression.test(inputText)) {
                    inputElement.style = "border-color: none; color: black;";
                    
                    return true;
                } else {
                    inputElement.style = "border-color: red;";
                    
                    return false;
                }
            }
            
            function validateForm() {
                
                var usernameElement = document.forms["signUp"]["username"];
                if (!validateLength(usernameElement, 5, 20)) {
                    return false;
                }
                
                var emailElement = document.forms["signUp"]["email"];
                if (!validateEmail(emailElement)) {
                    return false;
                }
                
                 var passwordElement = document.forms["signUp"]["password"];
                if (!validateLength(passwordElement, 8, 20)) {
                    return false;
                }
                
                var nameElement = document.forms["signUp"]["telefon"];
                if (!validateLength(nameElement, 7, 10)) {
                    return false;
                }
                
                return true;
            }
        </script>