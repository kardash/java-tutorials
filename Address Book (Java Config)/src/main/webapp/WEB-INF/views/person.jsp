<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Person
</h1>
 
<c:url var="addAction" value="/person/add" ></c:url>
 
<form:form action="${addAction}" commandName="person">
<table>
    <c:if test="${!empty person.lastname}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td>
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="prefix">
                <spring:message text="Prefix"/>
            </form:label>
        </td>
        <td>
            <form:input path="prefix" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="firstname">
                <spring:message text="First Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstname" />
            <form:errors path="firstname" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="middlename">
                <spring:message text="Middle Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="middlename" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="lastname">
                <spring:message text="Last Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastname" />
            <form:errors path="lastname" cssClass="error"/>
        </td>
    </tr>
    <tr>
         <td>
          	<form:label path="gender">
                <spring:message text="Gender"/>
            </form:label>
         </td>
         <td><form:select path="gender" items="${genderList}" /></td>
     </tr>
    <tr>
        <td>
            <form:label path="suffix">
                <spring:message text="Suffix"/>
            </form:label>
        </td>
        <td>
            <form:input path="suffix" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="age">
                <spring:message text="Age"/>
            </form:label>
        </td>
        <td>
            <form:input path="age" />
            <form:errors path="age" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty person.lastname}">
                <input type="submit"
                    value="<spring:message text="Edit Person"/>" />
            </c:if>
            <c:if test="${empty person.lastname}">
                <input type="submit"
                    value="<spring:message text="Add Person"/>" />
            </c:if>
        </td>
    </tr>
</table> 
</form:form>
<br>
<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
    <table class="tg">
    <tr>
        <th width="80">Person ID</th>
        <th>Prefix</th>
        <th>First Name</th>
        <th>Middle Name</th>
        <th>Last Name</th>
        <th>Suffix</th>
        <th>Age</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
        <th width="60">Contacts</th>
    </tr>
    <c:forEach items="${listPersons}" var="person">
        <tr>
            <td>${person.id}</td>
             <td>${person.prefix}</td>
             <td>${person.firstname}</td>
             <td>${person.middlename}</td>
             <td>${person.lastname}</td>
             <td>${person.suffix}</td>
             <td>${person.age}</td>
             <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
             <td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
             <td><a href="<c:url value='/person/${person.id}/contacts' />" >Contacts</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
