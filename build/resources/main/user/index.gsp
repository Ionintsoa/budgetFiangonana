<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="login"/>
    <title>Se connecter</title>
</head>
<body>
    <div class="splash-container">
        <div class="card">
            <%-- <div class="card-header text-center"><img class="logo-img" src="../assets/images/logo.png" alt="logo"><span class="splash-description">Please enter your user information.</span></div> --%>
            <div class="card-header text-center">
                <span>Logo</span>
                <span class="splash-description">Veuillez vous connecter.</span>
            </div>
            <div class="card-body">
                <form autocomplete="off">
                    <%-- <p>Don't worry, we'll send you an email to reset your password.</p> --%>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="email" name="email" required="" placeholder="Your Email" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="password" name="password" required="" placeholder="Your Password" autocomplete="off">
                    </div>
                    <div class="form-group pt-1"><a class="btn btn-block btn-primary btn-xl" href="../index.html">Se connecter</a></div>
                </form>
            </div>
            <div class="card-footer text-center">
                <span>Vous n'avez pas de compte? <a href="pages-sign-up.html">Réclamez</a></span>
            </div>
        </div>
    </div>
</body>
</html>