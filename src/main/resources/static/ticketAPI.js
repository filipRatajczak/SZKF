const ticketList = [];

let createTicket = () => {

    let ticketName = document.getElementById('ticketName').value;
    let time = document.getElementById('time').value;
    let price = document.getElementById('price').value;

    let ticket = {
        "name": ticketName,
        "periodOfValidity": time,
        "price": price
    };

    fetch("/employee/create-ticket", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(ticket)
        }
    ).then(response => response.json())
        .catch((error) => {
            console.log(error)
        });
}

let getTicketList = () => {
    return fetch('/employee/get-all', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            ticketList.push(...r);
        })
}

getTicketList();

let printTicket = () => {

    let table = document.getElementById('table');

    for (let i = 0; i < ticketList.length; i++) {
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let name = document.createElement('td');
        let price = document.createElement('td');
        let del = document.createElement('td');
        let edit = document.createElement('td');
        id.innerText = ticketList[i].id;
        name.innerText = ticketList[i].name;
        price.innerText = ticketList[i].price;
        del.innerHTML = ('<a class="btn-outline-danger" href="#popup1"><span data-feather="trash"></span></a>');
        edit.innerHTML = ('<a class="btn-outline-dark" href="#"><span data-feather="edit"></span></a>');
        row.append(id);
        row.append(name);
        row.append(price);
        row.append(del);
        row.append(edit);
        table.append(row);
        feather.replace()
    }
}

