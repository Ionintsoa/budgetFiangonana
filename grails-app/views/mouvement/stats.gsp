<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Liste des mouvements</title>
</head>
<body>
    <div class="dashboard-ecommerce">
        <div class="container-fluid dashboard-content ">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="page-header">
                        <h2 class="pageheader-title">Statistique des mouvements </h2>
                        <div class="page-breadcrumb">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">E-Commerce Dashboard Template</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="card">
                        <h5 class="card-header">Statistique des mouvements</h5>
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <g:form class="needs-validation search-filter" controller="mouvement" action="stats">
                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2">
                                    <label>Filtres</label>
                                </div>
                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2">
                                    <%-- <label for="typeMouvement">Type du mouvement</label> --%>
                                    <select class="form-control" id="typeMouvement" name="typeMouvement">
                                        <g:each status="i" in="${types}" var="it">
                                            <g:if test="${filter.typeMouvement == i-1}">
                                                <option value="${i-1}" selected>${it}</option>
                                            </g:if>
                                            <g:else>
                                                <option value="${i-1}">${it}</option>
                                            </g:else>
                                        </g:each>
                                    </select>
                                </div>
                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2">
                                    <%-- <label for="month">Mois</label> --%>
                                    <select class="form-control" id="month" name="month">
                                        <g:each status="i" in="${months}" var="it">
                                            <g:if test="${filter.month == i-1}">
                                                <option value="${i-1}" selected>${it}</option>
                                            </g:if>
                                            <g:else>
                                                <option value="${i-1}">${it}</option>
                                            </g:else>
                                        </g:each>
                                    </select>
                                </div>
                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2">
                                    <%-- <label for="year">Année</label> --%>
                                    <input type="text" class="form-control" id="year" name="year" placeholder="2019" value="${filter.year}">
                                </div>
                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2">
                                    <button class="btn btn-primary" type="submit">Afficher</button>
                                </div>
                            </g:form>
                        </div>
                        
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Caisse</th>
                                        <th scope="col">Montant</th>
                                        <th scope="col">Mois</th>
                                        <th scope="col">Année</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <g:each in="${mouvements}">
                                        <tr class="table-secondary">
                                            <td>${it.caisse.label}</td>
                                            <td>${it.montant} Ar</td>
                                            <td>${it.getMonth(it.month)}</td>
                                            <td>${it.year}</td>
                                        </tr>
                                    </g:each>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>