<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- document body -->
<div class="container">
  <h1>${message}</h1>
</div>

<div class="container">
  <ul>
    <c:forEach items="${projects}" var="project" >
    <li>${project.codeName}</li>
    </c:forEach>
  </ul>
  <hr>
</div>
