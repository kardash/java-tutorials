<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Contacts Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
   Person: ${contact.getPerson().getFirstname()} ${contact.getPerson().getLastname()}
</h1>
 
<c:url var="addAction" value="/person/add-contact" ></c:url>
 
<form:form action="${addAction}" commandName="contact">
<c:if test="${!empty contact.id}"> <form:hidden path="id" /></c:if>
<form:hidden path="person_id" />
<table>
    <tr>
        <td>
            <form:label path="email">
                <spring:message text="Email"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="mobile_no">
                <spring:message text="Mobile No."/>
            </form:label>
        </td>
        <td>
            <form:input path="mobile_no" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="phone_no">
                <spring:message text="Phone No."/>
            </form:label>
        </td>
        <td>
            <form:input path="phone_no" />
        </td>
    </tr>
    <tr>
         <td>
          	<form:label path="primary">
                <spring:message text="Primary"/>
            </form:label>
         </td>
         <td><form:select path="primary" items="${primaryList}" /></td>
     </tr>
     
    <tr>
        <td colspan="2">
        	<c:if test="${!empty contact.id}">
        	
            <input type="submit"
                    value="<spring:message text="Edit Contact"/>" />
            </c:if>
            
            <c:if test="${empty contact.id}">
        	
            <input type="submit"
                    value="<spring:message text="Add Contact"/>" />
            </c:if>
        </td>
    </tr>
</table> 
</form:form>
<br>
<h3>Contacts List</h3>
<c:if test="${!empty listContacts}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th>E-mail</th>
        <th>Mobile</th>
        <th>Phone</th>
        <th>Primary</th>
       
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listContacts}" var="contact">
        <tr>
            <td>${contact.id}</td>
             <td>${contact.email}</td>
             <td>${contact.mobile_no}</td>
             <td>${contact.phone_no}</td>
             <td>${contact.primary}</td>
             <td><a href="<c:url value='/contact/edit/${contact.id}' />" >Edit</a></td>
             <td><a href="<c:url value='/contact/remove/${contact.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
