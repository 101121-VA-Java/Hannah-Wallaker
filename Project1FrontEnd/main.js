console.log('Hoping to see what I am working on connect to something visual!');

function loginSystem(){
    
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status === 201){
                console.log('User Successfully logged in');
            } else{
                console.log('Login error');
            }
        }
    }
    xhr.open("GET", "http://localhost:8080/users");
    let requestBody = JSON.stringify(u);
    xhr.send(requestBody);
}