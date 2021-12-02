async function getRequestData(r_url) {
    try {
    let response = await fetch(r_url, {method: 'get',
    headers : {'authToken': AuthToken},        
    });
    if (response.status === 200) {
        let jsontext = await response.json();    
        return jsontext;
        }
        else {      
        var titleName = document.getElementById('errorMsg'); 
        titleName.innerText  = response.status;
        }
    }
    catch (err) {
        var titleName = document.getElementById('errorMsg'); 
        titleName.innerText  = "500";
    };


};

function viewTable(table, jsontext){
    for (let i = 0; i < jsontext.length +1 ; i++) {
        var row = table.insertRow(0);        
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        if (i === jsontext.length) {                    
            cell1.innerHTML = "reid";  
            cell2.innerHTML = "recreator";  
            cell3.innerHTML = "reamount"; 
            cell4.innerHTML = "redescription"; 
            cell5.innerHTML = "restatus"; 
            cell6.innerHTML = "retype"; 
            }
        else {
            cell1.innerHTML = jsontext[i].reid;
            cell2.innerHTML = jsontext[i].recreator;  
            cell3.innerHTML = jsontext[i].reamount; 
            cell4.innerHTML = jsontext[i].redescription;
            cell5.innerHTML = jsontext[i].status.status;
            cell6.innerHTML = jsontext[i].type.type;
        }

    }
}

//accountInfo
const divAccount = document.getElementById('accountInfo');
if (divAccount != null){
    accountInfo();
    const btn = document.getElementById('updateUserInfoBtn');    
    btn.addEventListener("click", updateUserInfo);
};

async function accountInfo(){
    var jsontext = await getRequestData("http://localhost/account");
    
    
    var titleName = document.getElementById('emailTitle'); 
    titleName.innerText  = jsontext.email;

    var username = document.getElementById('username'); 
    var password = document.getElementById('password');      
    var firstname = document.getElementById('firstname');
    var lastname = document.getElementById('lastname');
    var email = document.getElementById('email');

    username.value = jsontext.username;
    password.value = jsontext.password;
    firstname.value = jsontext.firstname;
    lastname.value = jsontext.lastname;
    email.value = jsontext.email;
    

};

async function updateUserInfo() {
    var username = document.getElementById('username'); 
    var password = document.getElementById('password');      
    var firstname = document.getElementById('firstname');
    var lastname = document.getElementById('lastname');
    var email = document.getElementById('email');
    
    
    try {
        let requestBody = `{"username" : "${username}" , "password" : "${password}"
        , "firstname" : "${firstName}", "lastname" : "${lastname}"
        , "email" : "${email}"}  `;
        let response = await fetch("http://localhost/account", {method: 'put',
        headers : {'authToken': AuthToken},   
        body : requestBody       
        });
        if (response.status === 200) {
            alert("Information Updated");
            }
            else {      
            alert(response.status);
            }
        }
        catch (err) {
            alert("500");
        };
}



//submit Reimbursement
const btn = document.getElementById('submitreimb');
if (btn != null){
btn.addEventListener("click", submitReimb);
};


//pending
const divPending = document.getElementById('pendingList');
if (divPending != null){
    viewPending();
};



//resolved
const divResolved = document.getElementById('resolvedList');
if (divResolved != null ){
    viewResolved();
};

function getPendingReimbursements(){
    let response = await fetch("http://localhost/reimbursement", {method: 'get',
    headers : {'authToken': AuthToken},   
    body : requestBody       
    });
    if (response.status === 200) {
        alert("Retrieved Pending")
        }
        else {      
        alert(response.status);
        }
    }
    catch (err) {
        alert("500");
    };
}

