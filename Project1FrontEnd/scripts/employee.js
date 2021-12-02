


async function getPendingReimbursements(){
    console.log("at least we are in the function");
    let response = await fetch(`http://localhost:8080/pending/${sessionStorage.token.split(":")[0]}`, {method: 'get',
    headers : {'Authorization': sessionStorage.token},         
    });
    if (response.status === 201) {
        response = await response.json();
        console.log(response);
        // console.log(response.json());
        // alert("Retrieved Pending")
        let pending = document.getElementById("pending");
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


async function getResolvedReimbursements(){
    console.log("at least we are in the function");
    let response = await fetch(`http://localhost:8080/resolved/${sessionStorage.token.split(":")[0]}`, {method: 'get',
    headers : {'Authorization': sessionStorage.token},         
    });
    if (response.status === 201) {
        response = await response.json();
        console.log(response);
        // console.log(response.json());
        // alert("Retrieved Pending")
        let pending = document.getElementById("resolved");
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

    async function getAccountInfo(){
        console.log("at least we are in the function");
        let response = await fetch(`http://localhost:8080/account/${sessionStorage.token.split(":")[0]}`, {method: 'get',
        headers : {'Authorization': sessionStorage.token},         
        });
        if (response.status === 201) {
            response = await response.json();
            console.log(response);
            // console.log(response.json());
            // alert("Retrieved Pending")
            let account = document.getElementById("account");
            let result = "";
            for (let i = 0; i < response.length; i++) {
                const element = response[i];
                result += `<div>Company Email:  ${element.email}</div>`;
                result += `<div>First Name:  ${element.firstName}</div>`;
                result += `<div>Last Name:  ${element.lastName}</div>`;
                result += `<div>Username:  ${element.username}</div>`;
            }

            account.innerHTML = result;
            }
            else {      
            alert(response.status);
            }
        }

        async function updateAccountInfo(){
            console.log("at least we are in the function");
            let firstName = document.getElementById("first").value;
            let lastName = document.getElementById("last").value;
            let password = document.getElementById("user").value;
            let data = {firstName, lastName, password};

            let response = await fetch(`http://localhost:8080/account/${sessionStorage.token.split(":")[0]}`, {method: 'put',
            headers : {'Authorization': sessionStorage.token},
            body: JSON.stringify(data)
            });
            if (response.status === 201) {
                response = await response.json();
                console.log(response);
                // console.log(response.json());
                // alert("Retrieved Pending")
                let account = document.getElementById("account");
                let result = "";
                for (let i = 0; i < response.length; i++) {
                    const element = response[i];
                    result += `<div>Company Email:  ${element.email}</div>`;
                    result += `<div>First Name:  ${element.firstName}</div>`;
                    result += `<div>Last Name:  ${element.lastName}</div>`;
                    result += `<div>Username:  ${element.Username}</div>`;
                }
    
                account.innerHTML = result;
                }
                else {      
                // alert(response.status);
                }
            }

            async function submitReimbursement(){
                console.log("at least we are in the function");
                let reCreator = document.getElementById("ReCreator").value;
                let reAmount = document.getElementById("ReAmount");
                let reDescription = document.getElementById("ReDescription");
                let reStatusId = document.getElementById("ReStatus");
                let reTypeId = document.getElementById("ReType");
                let data = {reCreator, reAmount, reDescription, reStatusId, reTypeId};

                let response = await fetch(`http://localhost:8080/reimbursement/${sessionStorage.token.split(":")[0]}`, {method: 'post',
            headers : {'Authorization': sessionStorage.token},
            body: JSON.stringify(data)
            });

            if (response.status === 201) {
                response = await response.json();
                console.log(response);
                // console.log(response.json());
                // alert("Retrieved Pending")
                let account = document.getElementById("account");
                let result = "";
                for (let i = 0; i < response.length; i++) {
                    const element = response[i];
                    // result += `<div>Company Email:  ${element.email}</div>`;
                    // result += `<div>First Name:  ${element.firstName}</div>`;
                    // result += `<div>Last Name:  ${element.lastName}</div>`;
                    // result += `<div>Username:  ${element.Username}</div>`;
                }
    
                account.innerHTML = result;
                }
                else {      
                 alert(response.status);
                }
            
            }
            