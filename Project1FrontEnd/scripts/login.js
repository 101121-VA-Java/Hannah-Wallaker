document.getElementById("submitButtom").addEventListener('click', loginsystem);

let api = "http://localhost:8080/auth";

function loginsystem(){
    document.getElementById("error-div").innerHTML = "";

    let username = document.getElementById("username").value;
    let pasword = document.getElementById("password").value;

    let xhr = new XMLHttpRequest();

    xhr.open("POST", "http://localhost:8080/auth");

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let authToken = xhr.getResponseHeader("Authorization");
            sessionStorage.setItem("token", authToken);
            window.location.href="../index.html";
        
        }else if(xhr.readyState === 4){
            document.getElementById("error-div").innerHTML = "Sorry, there is an error with your login";
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `username=${username}&password=${password}`;

    xhr.send(requestBody);
}