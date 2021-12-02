let customizableFetch = (url, callback, optionalData=null) => {
    fetch(url, {
        headers: {
            Authorization: sessionStorage.token
        }
    })
    .then(res => res.json())
    .then(res => {
        callback(res, optionalData);
    })
    .catch(err => console.log(err.message))
}

let get = (resources, fn) => {
    customizableFetch(`http://localhost:8080/${resources}`, fn);
}

// search pending reimbursements

let showReimbursementsOfOneEmployee = () => {
    let searchId = document.getElementById('recreator').value;
    if(!searchId) return;
    customizableFetch(`http://localhost:8080/reimbursement/pending/man`, showReimbursements)
}


//search resolved reimbursements

let showReimbursementsOfOneEmployee = () => {
    let searchId = document.getElementById('recreator').value;
    if(!searchId) return;
    customizableFetch(`http://localhost:8080/reimbursement/resolved/man`, showReimbursements)
}