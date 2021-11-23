let token = sessionStorage.getItem("token");
if(!token){
    window.location.href = "views/loginsystem.html"
}

document.getElementById('logout-button').addEventListener('click', logout);

function logout(){
    sessionStorage.clear();
    window.location.href = "views/loginsystem.html";
}