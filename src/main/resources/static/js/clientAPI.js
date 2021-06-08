let createClient = () => {

    let client = {
        "birthday": document.getElementById('client-birthdate').value.toString(),
        "firstName": document.getElementById('client-firstname').value,
        "secondName": document.getElementById('client-lastname').value,
        "email": document.getElementById('client-email').value,
        "wallet": 0,
        "subscriptionValidity": null,
        "trainer": null
    };

    fetch("/employee/client/create", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(client)
        }
    ).then(response => console.log(response));
}

let getClientList = () => {
    return fetch('employee/client/getAll', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
}

let printClients = async () => {

    let clientList = await getClientList().then(r => r);

    let table = document.getElementById('client-table');

    for (let i = 0; i < clientList.length; i++) {
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let firstName = document.createElement('td');
        let lastName = document.createElement('td');
        let email = document.createElement('td');
        let birthDate = document.createElement('td');
        let wallet = document.createElement('td');
        let addFunds = document.createElement('td');
        let buyTicket = document.createElement('td');
        let buyProduct = document.createElement('td');
        let ticketValidity = document.createElement('td');
        let enter = document.createElement('td');
        let del = document.createElement('td');
        let edit = document.createElement('td');

        id.innerText = clientList[i].id;
        firstName.innerText = clientList[i].firstName;
        lastName.innerText = clientList[i].secondName;
        email.innerHTML = clientList[i].email;
        birthDate.innerHTML = clientList[i].birthday;
        wallet.innerHTML = clientList[i].wallet;
        addFunds.innerHTML = ('<a class="btn-outline-info" data-toggle="modal" data-target="#add-funds-popup"><span data-feather="dollar-sign" class="btn-outline-info btn-client"></span></a>')
        buyTicket.innerHTML = ('<a class="btn-outline-info" data-toggle="modal" data-target="#buy-ticket-popup"><span data-feather="credit-card" class="btn-outline-info btn-client"></span></a>')
        buyProduct.innerHTML = ('<a class="btn-outline-info" data-toggle="modal" data-target="#buy-product-popup"><span data-feather="shopping-bag" class="btn-outline-info btn-client"></span></a>')
        ticketValidity.innerHTML = clientList[i].subscriptionValidity;
        enter.innerHTML = ('<a class="btn-outline-success"><span data-feather="log-in" class="btn-outline-success btn-client" data-toggle="modal" data-target="#client-enter-popup"></span></a>')
        del.innerHTML = ('<a class="btn-outline-danger"><span data-feather="trash" class="btn-outline-danger btn-client" data-toggle="modal" data-target="#delete-client-popup"></span></a>');
        edit.innerHTML = ('<a class="btn-outline-dark" data-toggle="modal" data-target="#edit-client-popup"><span data-feather="edit" class="btn-outline-secondary btn-client"></span></a>');
        row.append(id, firstName, lastName, email, birthDate, wallet, addFunds, buyTicket, buyProduct, ticketValidity, enter, del, edit);
        table.append(row);
    }
    feather.replace()
}

let userId;

$(document).ready(function () {
    $("#client-table").on('click', '.btn-client', function () {
        let currentRow = $(this).closest("tr");
        userId = currentRow.find("td:eq(0)").text();
    });
});

let addFunds = () => {
    let funds = {
        "wallet": document.getElementById('value').value
    };

    fetch(`employee/users/${userId}/funds`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(funds)
    })
}

let addTicket = () => {
    let ticket = {
        "name": document.getElementById('find-tickets').value
    };

    fetch(`employee/users/${userId}/ticket`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(ticket)
        }
    ).then(r => r.json())
        .catch(e => console.log(e))
}

let enter = () => {

    if (userId === undefined) {
        console.log("id is undefined")
    } else {
        fetch(`employee/entrances/${userId}/enter`, {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({})
            }
        )
    }
}

let deleteClient = () => {

    fetch(`employee/client/delete/${userId}`, {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({})
        }
    )
}

let editClient = () => {
    let firstName = document.getElementById('edit-first-name').value;
    let secondName = document.getElementById('edit-last-name').value;
    let email = document.getElementById('edit-email').value;
    let editClient = {
        "firstName": firstName,
        "secondName": secondName,
        "email": email
    };

    fetch(`employee/client/edit/${userId}`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(editClient)
        }
    )
}

//////////////////////////ACTIVE-CLIENTS-API/////////////////////////////////////////

let activeClientList = []

let activeUserId;

$(document).ready(function () {
    $("#active-client-table").on('click', '.btn-client', function () {
        let currentRow = $(this).closest("tr");
        activeUserId = currentRow.find("td:eq(0)").text();
    });
});

let getActiveClientList = () => {
    return fetch('employee/client/getAll/active', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            activeClientList.push(...r);
        })
}
getActiveClientList()


let printActiveClients = async () => {

    let table = document.getElementById('active-client-table');

    for (let i = 0; i < activeClientList.length; i++) {
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let firstName = document.createElement('td');
        let lastName = document.createElement('td');
        let email = document.createElement('td');
        let wallet = document.createElement('td');
        let ticketValidity = document.createElement('td');
        let exit = document.createElement('td');

        id.innerText = activeClientList[i].id;
        firstName.innerText = activeClientList[i].firstName;
        lastName.innerText = activeClientList[i].secondName;
        email.innerHTML = activeClientList[i].email;
        wallet.innerHTML = activeClientList[i].wallet;
        ticketValidity.innerHTML = activeClientList[i].subscriptionValidity;
        exit.innerHTML = ('<a class="btn-outline-success"><span data-feather="log-in" class="btn-outline-danger btn-client" data-toggle="modal" data-target="#leave-client-popup"></span></a>')
        row.append(id);
        row.append(firstName);
        row.append(lastName);
        row.append(email);
        row.append(wallet);
        row.append(ticketValidity);
        row.append(exit);
        table.append(row);
        feather.replace()
    }
}

let leave = () => {

    fetch(`employee/entrances/${activeUserId}/leave`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({})
        }
    ).then(r => console.log(r))

}







