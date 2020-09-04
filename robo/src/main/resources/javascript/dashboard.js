

fetch('http://localhost:8080/api/repos')
  .then(response => response.json()).then(data => updateRepoList(data));
  // .then(data => console.log(data));


function updateRepoList(data) {
  data.forEach(repo => {
    // console.log(repo);
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var button = document.createElement("BUTTON");
    td1.innerHTML = repo["owner"];
    td2.innerHTML = repo["url"];
    td3.innerHTML = "not cloned";
    td3.setAttribute("id", repo["id"]);
    button.innerHTML = "Start";
    button.onclick = function() {startClone(repo)}
    // button.classList.add("btn btn-sm btn-outline-secondary");
    button.className = "btn btn-sm btn-outline-secondary"
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(button);
    document.getElementById("dashboard_tbody").appendChild(tr);
  });
}

function startClone(repo){
  console.log("starting clone here" + repo["url"]);
  let status = document.getElementById(repo["id"]);
  status.innerHTML = "Starting"
  fetch('http://localhost:8080/api/clone?' + 'url=' + repo["url"])
  .then(response => response.json()).then(function(response) {
    if(response["statusCode"] == "1"){
      status.innerHTML = "Finished"
    } else {
      status.innerHTML = "Error"
    }
    showDashboardAlert(response["command"]);
    console.log(response)
  });
}

function hideDashboardAlert(){
  let alert = document.getElementById("dashboard_alerts");
  alert.classList.remove("show");
  alert.classList.add("hide");
}

function showDashboardAlert(message){
  let alert = document.getElementById("dashboard_alerts");
  alert.classList.remove("hide");
  alert.classList.add("show");
  let alertText = document.getElementById("dashboard_alert_text");
  alertText.innerHTML = message;
}


fetch('http://localhost:8080/api/projects')
  .then(response => response.json())
  .then(data => updateClients(data));
  // .then(data => console.log(data));


function updateClients(data) {
  data.forEach(repo => {
    // console.log(repo);
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td")
    var button = document.createElement("BUTTON");
    td1.innerHTML = repo["name"];
    td2.innerHTML = "not running";
    td2.setAttribute("id", repo["name"]);
    button.innerHTML = "run";
    button.onclick = function() {startImage(repo)}
    // button.classList.add("btn btn-sm btn-outline-secondary");
    button.className = "btn btn-sm btn-outline-secondary"
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(button);
    document.getElementById("clients_tbody").appendChild(tr);
  });
}

function startImage(repo){
  console.log("starting clone here" + repo["name"]);
  let status = document.getElementById(repo["name"]);
  status.innerHTML = "Starting"
  fetch('http://localhost:8080/api/build?' + 'project=' + repo["name"])
  .then(response => response.json()).then(function(response) {
    if(response["statusCode"] == "1"){
      status.innerHTML = "Running"
    } else {
      status.innerHTML = "Error"
    }
    showDashboardAlert(response["command"]);
    console.log(response)
  });
}