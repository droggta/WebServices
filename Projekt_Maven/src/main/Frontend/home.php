<!DOCTYPE html>
<html lang="de">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet.css">
    <script type="text/javascript" src="resources/bootstrap/jquery/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
    <title>DHBWpal</title>

    <script type="text/javascript">
            function createAccount() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("POST", 'http://localhost:8080/soap/mainService', true);

                var sr =
                  '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap/">'+
                      '<soapenv:Header/>'+
                      '<soapenv:Body>'+
                        '<soap:getData>'+
                            '<callmethod>create</callmethod>'+
                            '<recievername>test</recievername>'+
                            '<sendername>test1</sendername>'+
                            '<amount>0</amount>'+
                            '<Campus>mos</Campus>'+
                            '<Wohnort>de</Wohnort>'+
                            '<iban>111111111111</iban>'+
                         '</soap:getData>'+
                      '</soapenv:Body>'+
                   '</soapenv:Envelope>';


                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4) {
                        if (xmlhttp.status == 200) {
                            alert(xmlhttp.responseText);
                        }
                    }
                }
                xmlhttp.setRequestHeader('Content-Type', 'text/xml;charset=UTF-8');
                xmlhttp.send(sr);
            }

             function sendMoney() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open('POST', 'http://localhost:8080/soap/mainService', true);

                var sr =
                    '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap/"/>'+
                        '<soapenv:Header/>'+
                            '<soapenv:Body>'+
                                '<soap:getData>'+
                                '<callmethod>transfer</callmethod>'+
                                '<recievername>'+ document.getElementById("sendReceiver").value+'</recievername>'+
                                '<sendername>'+ document.getElementById("sendSender").value+'</sendername>'+
                                '<amount>'+ document.getElementById("sendValue").value+'</amount>'+
                                '<Campus>?</Campus>'+
                                '<Wohnort>?</Wohnort>'+
                                '<iban>?</iban>'+
                            '</soap:getData>'+
                        '</soapenv:Body>'+
                    '</soapenv:Envelope>';

                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState == 4) {
                            if (xmlhttp.status == 200) {
                                alert(xmlhttp.responseText);
                                }
                            }
                        }
                        xmlhttp.setRequestHeader('Content-Type', 'text/xml');
                        xmlhttp.send(sr);
                    }

                    function loadAccount() {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.open('POST', 'http://localhost:8080/soap/mainService', true);

                        var sr =
                            '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap/"/>'+
                                '<soapenv:Header/>'+
                                    '<soapenv:Body>'+
                                        '<soap:getData>'+
                                            '<callmethod>filldepot</callmethod>'+
                                            '<recievername>'+ document.getElementById("loadAccountname").value+'</recievername>'+
                                            '<sendername>'+ document.getElementById("loadAccountname").value+'</sendername>'+
                                            '<amount>'+ document.getElementById("loadValue").value+'</amount>'+
                                            '<Campus>?</Campus>'+
                                            '<Wohnort>?</Wohnort>'+
                                            '<iban>?</iban>'+
                                        '</soap:getData>'+
                                    '</soapenv:Body>'+
                                '</soapenv:Envelope>';

                                xmlhttp.onreadystatechange = function () {
                                if (xmlhttp.readyState == 4) {
                                    if (xmlhttp.status == 200) {
                                        alert(xmlhttp.responseText);
                                        }
                                    }
                                }
                                xmlhttp.setRequestHeader('Content-Type', 'text/xml');
                                xmlhttp.send(sr);
                                }

        </script>


  </head>
  <body>

  <div class="page_header">
    <div class="page_header_title">
        <div class="page_header_title_icon_text"><a style="color: white; text-decoration: none;" class="headerRef" href="home.php">DHBWpal</a></div>
    </div>
    <a href="home.php?p=login" class="page_header_title_profile_btn_cont">
        <img src="resources/profile.png" alt="Profil-Symbol" class="page_header_title_icon">
    </a>
  </div>

  <?php
  if (isset($_GET['p'])) {
      switch($_GET['p']){
      case "create" :
               echo
                    '<div>
                        <div class="createHeader">Konto erstellen</div>
                    </div>
                    <div id="login_card" class="card">
                      <div class="card-body">
                          <h2>Persönliche Daten</h2>
                          <div class="actions">
                          <form>
                          <div class="createInputs">
                              <div class="createInput"><input id="createUsername" type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1"></div>
                              <div class="createInput"><input id="createCampus" type="text" class="form-control" placeholder="Campus" aria-label="Username" aria-describedby="basic-addon1"></div>
                              <div class="createInput"><input id="createCity" type="text" class="form-control" placeholder="Wohnort" aria-label="Username" aria-describedby="basic-addon1"></div>
                               <div class="createInput"><input id="createIban" type="text" class="form-control" min-length="12" max-length="12" placeholder="Iban" aria-label="Username" aria-describedby="basic-addon1"></div>
                              <div class="createBtn"><button type="button" class="btn btn-primary" onclick="createAccount()">Konto erstellen</button></div>
                              </div>
                          </form>
                          </div>
                        </div>
                   </div>';
                      break;
      case "load" :
         echo
              '<div>
              	    <div class="createHeader">Konto aufladen</div>
              </div>
              <div id="login_card" class="card">
                <div class="card-body">
                    <h2>Betrag eingeben</h2>
                    <div class="actions">
                    <form><div class="createInputs">
                    <div class="createInput"><input type="text" id="loadAccountname" class="form-control" placeholder="Accountname" aria-label="Betrag" aria-describedby="basic-addon1"></div>
                         <div class="createInput"><input type="text" id="loadValue" class="form-control" placeholder="Betrag" aria-label="Betrag" aria-describedby="basic-addon1"></div>
                        <div class="createBtn"><button type="button" onclick="loadAccount()" class="btn btn-primary">Konto aufladen</button></div>
                        </div>
                    </form>
                </div>
                </div>
                </div>';
                break;
      case "send" :
          echo
               '<div>
               	    <div class="createHeader">Geld versenden</div>
               </div>
               <div id="login_card" class="card">
                 <div class="card-body">
                     <h2>Überweisungsdaten eingeben</h2>
                     <div class="actions">
                    <form><div class="createInputs">
                    <div class="createInput"><input type="text" id="sendSender" class="form-control" placeholder="Accountname des Senders" aria-label="Sender" aria-describedby="basic-addon1"></div>
                        <div class="createInput"><input type="text" id="sendReceiver" class="form-control" placeholder="Accountname des Empfängers" aria-label="Empfänger" aria-describedby="basic-addon1"></div>
                        <div class="createInput"><input type="text" id="sendValue" class="form-control" placeholder="Betrag" aria-label="Betrag" aria-describedby="basic-addon1"></div>
                        <div class="createBtn"><button type="button" class="btn btn-primary" onclick="sendMoney()">Betrag versenden</button></div>
                        </div>
                    </form>
                 </div>
                 </div>
                 </div>';
                  break;

      }
  }
  else {
      echo
      '<div>
            <div class="headerLine1"><b>Herzlich Willkommen bei DHBWpal</b></div>
      	    <div class="headerLine2">Hier können Sie unkompliziert und simpel Geld an Ihre Kommilitonen senden</div>
      </div>
      <div id="login_card" class="card">
        <div class="card-body">
            <h2>Was möchten Sie tun?</h2>
            <div class="actions mainPageBtn">
             <form>
                <input type="hidden" name="p" value="create">
                <div class="aufladenBtn"><button type="submit" class="btn btn-primary">Konto erstellen</button></div>
             </form>
            <form>
                <input type="hidden" name="p" value="load">
                <div class="aufladenBtn"><button type="submit" class="btn btn-primary">Konto aufladen</button></div>
            </form>
            <form>
                <input type="hidden" name="p" value="send">
                <div class="aufladenBtn"><button type="submit" class="btn btn-primary">Geld versenden</button></div>
            </form>
        </div>
        </div>
        </div>';
  }
  ?>

  <div class="page_footer">
            <div class="footer_group">
                <div class="footer_category">
                    <h5><b>Über Uns</b></h5>
                    <ul class="footer_list">
                        <li><a href="home.php?p=privacy" class="footer_list_link">Datenschutz</a></li>
                        <li><a href="" class="footer_list_link">Pressemitteilungen</a></li>
                        <li><a href="home.php?p=impressum" class="footer_list_link">Impressum</a></li>
                    </ul>
                </div>
                <div class="footer_category">
                    <h5><b>Zahlungsmethoden</b></h5>
                    <ul class="footer_list">
                        <li><a href="" class="footer_list_link">Gutscheinkarten</a></li>
                        <li><a href="" class="footer_list_link">Bankeinzug</a></li>
                        <li><a href="" class="footer_list_link">Überweisung</a></li>
                    </ul>
                </div>
                <div class="footer_category">
                    <h5><b>Service</b></h5>
                    <ul class="footer_list">
                        <li><a href="home.php?p=contact" class="footer_list_link">Kundenservice</a></li>
                        <li><a href="home.php?p=contact" class="footer_list_link">Kontakt</a></li>
                        <li><a href="home.php?p=contact" class="footer_list_link">Elektrogeräterecycling</a></li>
                    </ul>
                </div>
            </div>
        </div>
  </body>
</html>