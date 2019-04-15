<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Developer</title>
</head>
<body>

<h2>Enter review information</h2>
<form:form method="post" modelAttribute="review" action="new">
  <table>
    <tr>
      <td><form:label path="title">Title</form:label></td>
      <td><form:input path="title" name="title" id="title" class="form-control"/></td>
    </tr>
    <tr>
      <td><form:label path="text">Text</form:label></td>
      <td><form:input path="text" name="text" id="text" class="form-control" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <form:button id="add" name="add" class="btn btn-lg btn-primary btn-block btn-signin">Add</form:button>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>