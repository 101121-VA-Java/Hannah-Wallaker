
//submit reimb
document.getElementById("submitreimb").addEventListener("click", submitReimb);
let api = "http://localhost:8080";

function submitReimb(){
    let recreator = document.getElementById("recreator").value;
    let reamount = document.getElementById("reamount").value;
    let redescription = document.getElementById("redescription").value;
    let restatus = document.getElementById("restatus").value;
    let retype = document.getElementById("retype").value;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", `${api}/reimbursement`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("success");
        } else if (xhr.readyState === 4){
            document.getElementById("error").innerHTML = xhr.response;
           }  
           
           xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

           let requestBody = `recreator=${recreator}&reamount=${reamount}&redescription=${redescription}&restatus=${restatus}&retype=${retype}`;
   
           xhr.send(requestBody);

}

}

// view pending reimb
const divPending = document.getElementById('pendingList');
if (divPending != null){
divPending.innerHTML = "<h1> testing </h1>";
};


  //view resolved requests
const divResolved = document.getElementById('viewResolved');
if (divResolved != null ){
divResolved.innerHTML = "<h1> testing </h1>";
};

 //view account info
const divAccount = document.getElementById('accountInfo');
if (divAccount != null){
    divAccount.innerHTML = "<h1> testing </h1>";
};

let u_username = AuthToken.split(':')[0];
getRequestData("http://localhost/reimbursement/pending/u_username");