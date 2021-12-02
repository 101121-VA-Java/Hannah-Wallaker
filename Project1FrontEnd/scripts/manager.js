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


async function getAllPendingReimbursements(){
    console.log("at least we are in the function");
    let response = await fetch(`http://localhost:8080/pending/manager`, {method: 'get',
    headers : {'Authorization': sessionStorage.token},         
    });
    if (response.status === 201) {
        response = await response.json();
        console.log(response);
        // console.log(response.json());
        // alert("Retrieved Pending")
        let pending = document.getElementById("allPending");
        let result = "";
        for (let i = 0; i < response.length; i++) {
            const element = response[i];
            result += `<div>Reimbursement #: ${element.reId}</div>`;
            result += `<div>Amount Requested:  $ ${element.reAmount}</div>`;
            result += `<div>Creator: ${element.reCreatorUsername}</div>`;
            result += `<div>Description of Request: ${element.reDescription}</div>`;
            result += `<div>Status Identification: ${element.reStatusId}</div>`;

        }
        pending.innerHTML = result;
        }
        else {      
        alert(response.status);
        }
    }

    async function getAllResolvedReimbursements(){
        console.log("at least we are in the function");
        let response = await fetch(`http://localhost:8080/resolved/manager`, {method: 'get',
        headers : {'Authorization': sessionStorage.token},         
        });
        if (response.status === 201) {
            response = await response.json();
            console.log(response);
            // console.log(response.json());
            // alert("Retrieved Pending")
            let allResolved = document.getElementById("allResolved");
            let result = "";
            for (let i = 0; i < response.length; i++) {
                const element = response[i];
                result += `<div>Reimbursement #: ${element.reId}</div>`;
                result += `<div>Amount Requested:  $ ${element.reAmount}</div>`;
                result += `<div>Creator: ${element.reCreatorUsername}</div>`;
                result += `<div>Description of Request: ${element.reDescription}</div>`;
                result += `<div>Status Identification: ${element.reStatusId}</div>`;
    
            }
            allResolved.innerHTML = result;
            }
            else {      
            alert(response.status);
            }
        }




async function getAllEmployees(){
    console.log("at least we are in the function");
    let response = await fetch(`http://localhost:8080/employees/all`, {method: 'GET',
    headers : {'Authorization': sessionStorage.token},        
    });
    console.log(response);
    if (response.status === 201) {
        console.log("in if statement");
        response = await response.json();
        console.log(response);
        let employees = document.getElementById("employees");
        let result = "";
        for (let i = 0; i < response.length; i++) {
            const element = response[i];
            result += `<div>Company Email:  ${element.email}</div>`;
            result += `<div>First Name:  ${element.firstName}</div>`;
            result += `<div>Last Name:  ${element.lastName}</div>`;
            result += `<div>Username:  ${element.Username}</div>`;
        }

        employees.innerHTML = result;
        }
        else {      
        alert(response.status);
        }
    }