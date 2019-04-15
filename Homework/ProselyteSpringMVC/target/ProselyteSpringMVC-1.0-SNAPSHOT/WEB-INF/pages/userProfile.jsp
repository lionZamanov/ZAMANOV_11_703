<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<v:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/Books.ico" />">

    <title>Мой профиль</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/album.css" />" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="${contextPath}/">Book Trade</a>
    <input class="form-control form-control-dark w-100 search" type="text" id="search" placeholder="Search"
           aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${contextPath}/review/new">
                            <span data-feather="home"></span>
                            Добавить рецензию <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Мои рецензии(${user.getUserName()})</h1>
            </div>

            <div class="album py-5 bg-light">
                <div class="container">
                    <div class="row books">
                        <v:forEach items="${user.getReviews()}" var="review">
                            <div class="col-md-3">
                                <div class="card mb-4 shadow-sm">
                                    <div class="card-body">
                                        <p class="h3">${review.getTitle()}</p>
                                        <p class="h4">${review.getText()}</p>
                                    </div>
                                </div>
                            </div>
                        </v:forEach>
                    </div>
                </div>
            </div>

        </main>
    </div>
</div>


<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>

<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>

</body>
</html>
