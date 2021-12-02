const btn = document.getElementById('submitBtn');

btn.addEventListener("click", auth);

async function auth() {
let username = document.getElementById("username").value;
let password = document.getElementById("password").value;     
       let requestBody = `{"username" : "${username}" , "password" : "${password}"}`; 

       let response = await fetch('http://localhost:8080/auth', {method: 'post',
    //    headers : {'Content-Type': 'application/json'},  
        headers : {'Content-Type' : 'application/x-www-form-urlencoded'},       
       body : requestBody         
       });

       let responsetext = await response.text();
       if(response.status != 200){       
       alert(responsetext);
       }
       else if(response.status === 200) {
           console.log(response.headers);
           console.log(response);
          let authToken = response.headers.get('Authorization');
          sessionStorage.setItem("token", authToken);
          if (authToken.split(":")[1] === "1") {
            window.location.replace("../views/employees.html");
          } else{
          window.location.replace("../views/managers.html");
          }
        // if (responsetext == 1){        
        //     let authToken = response.headers.get('Authorization');
        // }
        // else {
            
        //     window.location.replace("views/manager.html");
        // }
       }


}



// document.getElementById("logout").addEventListener('click', LogOut);

// function LogOut(){
//     sessionStorage.clear();
//     window.location.href = "views/index.html";
// }