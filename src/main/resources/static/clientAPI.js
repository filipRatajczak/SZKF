const clientList = [];

let createClient = () => {

    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let birthdate = document.getElementById('birthdate').value;

    let client = {
        "birthday": birthdate.toString(),
        "firstName": firstname,
        "secondName": lastname,
        "email": email,
        "wallet": 0,
        "subscriptionValidity": null,
        "trainer": null
    };

    fetch("/employee/client/create", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(client)
        }
    ).then(response => response.json())
        .catch((error) => {
            console.log(error)
        });
}

let getClientList = () => {
    return fetch('employee/client/getAll', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            clientList.push(...r);
        })
}
getClientList();

let printClients = () => {

    let table = document.getElementById('print-client-table');

    for (let i = 0; i < clientList.length; i++) {
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let firstName = document.createElement('td');
        let lastName = document.createElement('td');
        let del = document.createElement('td');
        let edit = document.createElement('td');
        id.innerText = clientList[i].id;
        firstName.innerText = clientList[i].firstName;
        lastName.innerText = clientList[i].secondName;
        del.innerHTML = ('<a class="btn-outline-danger" href="#popup1"><span data-feather="trash"></span></a>');
        edit.innerHTML = ('<a class="btn-outline-dark" href="#"><span data-feather="edit"></span></a>');
        row.append(id);
        row.append(firstName);
        row.append(lastName);
        row.append(del);
        row.append(edit);
        table.append(row);
        feather.replace()
    }
}



