<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="vendor/bootstrap/css/bootstrap.min.css"/>
    <asset:stylesheet src="vendor/bootstrap/css/style.css"/>
    <asset:stylesheet src="libs/css/style.css"/>
    <asset:stylesheet src="vendor/fonts/fontawesome/css/fontawesome-all.css"/>
    <asset:stylesheet src="vendor/charts/chartist-bundle/chartist.css"/>
    <asset:stylesheet src="vendor/charts/morris-bundle/morris.css"/>
    <asset:stylesheet src="vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css"/>
    <asset:stylesheet src="vendor/charts/c3charts/c3.css"/>
    <asset:stylesheet src="vendor/fonts/flag-icon-css/flag-icon.min.css"/>

    <g:layoutHead/>
</head>

<body>
    <div class="dashboard-main-wrapper">
        <div class="">
            <g:layoutBody/>
        </div>
    </div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
