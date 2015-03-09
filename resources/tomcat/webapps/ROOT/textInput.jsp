<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%
String studentNameInJSP=request.getParameter("studentName");
%>
<html>
<body>
Value of input text box in JSP : <%=studentNameInJSP%>

<jsp:include page="<%= "/dir/" + studentNameInJSP +"/html.jsp" %>" />
</body>
</html>