<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
    <title>E-resto</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-sixteen.css">
    <link rel="stylesheet" href="assets/css/owl.css">

  </head>

  <body>

 
   <%@include file="Include/Header.jsp" %>
    
        <div class="send-message">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div>
              <h2>Login cuisinier</h2>
            </div>
          </div>
          <div class="col-md-8" style="margin-top: 20px;">
            <div class="contact-form">
              <form id="contact" action="serveltLoginCuisiner" method="post">
                <div class="row">
                                      <div class="col-lg-8" >

                  <div class="col-lg-5 col-md-5 col-sm-5">
                    <fieldset>
                        <label>Nom</label>
                      <input name="name" type="text" class="form-control" id="name" placeholder="Nom" required="">
                    </fieldset>
                  </div>
                  <div class="col-lg-5 col-md-5 col-sm-5">
                    <fieldset>
                        <label>Mot de passe</label>
                      <input name="name" type="password" class="form-control" id="name" placeholder="*******" required="">
                    </fieldset>
                  </div>
                    <fieldset>
                      <button type="submit" id="form-submit" class="filled-button">Se connecter</button>
                    </fieldset>
                  </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    
   <%@include file="Include/Footer.jsp" %>

    
  </body>

</html>
