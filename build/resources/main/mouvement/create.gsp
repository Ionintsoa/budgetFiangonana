<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <asset:stylesheet src="vendor/fonts/circular-std/style.css" />
    <title>Saisie mouvement</title>
</head>
<body>
    <div class="container-fluid dashboard-content ">
        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="page-header">
                    <h2 class="pageheader-title">Saisie mouvement </h2>
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
            <!-- ============================================================== -->
            <!-- validation form -->
            <!-- ============================================================== -->
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="card">
                    <div class="card-body">
                        <g:form class="needs-validation" controller="mouvement" action="${pageContent.formAction}">
                            <div class="row">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                    <div class="form-group">
                                        <label for="caisse">Caisse</label>
                                        <select class="form-control" id="caisse" name="caisse">
                                            <g:each in="${caisses}">
                                                <g:if test="${mouvement.caisse != null && mouvement.caisse.id == it.id}">
                                                    <option value="${it.id}" selected>${it.label}</option>
                                                </g:if>
                                                <g:else>
                                                    <option value="${it.id}">${it.label}</option>
                                                </g:else>
                                            </g:each>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                    <div class="form-group">
                                        <label for="typeMouvement">Mouvement</label>
                                        <select class="form-control" id="typeMouvement" name="typeMouvement">
                                            <g:if test="${mouvement.typeMouvement == 0}">
                                                <option value="0" selected>Entrée</option>
                                                <option value="1">Sortie</option>
                                            </g:if>
                                            <g:else>
                                                <option value="0">Entrée</option>
                                                <option value="1" selected>Sortie</option>
                                            </g:else>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                    <label for="date">Date</label>
                                    <input type="date" class="form-control" id="date" name="date" value="${mouvement.getStringDate()}">
                                    <div class="valid-feedback">
                                        Looks good!
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                    <label for="motif">Motif</label>
                                    <input type="text" class="form-control" id="motif" name="motif" placeholder="Motif" value="${mouvement.motif}">
                                    <div class="valid-feedback">
                                        Looks good!
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                    <label for="montant">Montant</label>
                                    <input type="text" class="form-control" id="montant" name="montant" placeholder="30 000" value="${mouvement.getStringMontant()}">
                                    <g:hasErrors bean="${mouvement}" field="montant">
                                        <div class="invalid-input">
                                            <g:fieldError bean="${mouvement}" field="montant"/>
                                        </div>
                                    </g:hasErrors>
                                    <%-- <g:hasErrors bean="${mouvement}">
                                        <ul>
                                            <g:eachError var="err" bean="${mouvement}">
                                                <li><g:message error="${err}" /></li>
                                            </g:eachError>
                                        </ul>
                                    </g:hasErrors> --%>
                                    <%-- <div class="valid-feedback">
                                        Looks good!
                                    </div> --%>
                                </div>
                            </div>
                            <br>
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                <button class="btn btn-primary" type="submit">${pageContent.btnSaveText}</button>
                                <g:if test="${pageContent.showCancelBtn}">
                                    <button class="btn btn-danger" type="button">Annuler</button>
                                </g:if>
                                
                            </div>
                        </g:form>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- end validation form -->
            <!-- ============================================================== -->
        </div>
    </div>
</body>
</html>