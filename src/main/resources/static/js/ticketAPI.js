let createTicket = () => {

    let ticket = {
        "name": document.getElementById('ticket-name').value,
        "periodOfValidity": document.getElementById('ticket-duration-time').value,
        "price": document.getElementById('ticket-price').value
    };

    fetch("/employee/ticket/create", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(ticket)
        }
    ).then(response => console.log(response))
}

let getTicketList = () => {
    return fetch('/employee/ticket/getAll', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
}


let printTicket = async () => {

    const ticketList = await getTicketList().then(r => r);

    let table = document.getElementById('ticket-table');

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
        del.innerHTML = ('<a class="btn-outline-danger"><span class="btn-outline-danger btn-client" data-feather="trash" data-toggle="modal" data-target="#delete-ticket-popup"></span></a>');
        edit.innerHTML = ('<a class="btn-outline-dark"><span class="btn-outline-secondary btn-client" data-feather="edit" data-toggle="modal" data-target="#edit-ticket-popup"></span></a>');
        row.append(id, name, price, del, edit);
        table.append(row);
    }
    feather.replace()
}

let ticketId;

$(document).ready(function () {
    $("#ticket-table").on('click', '.btn-client', function () {
        let currentRow = $(this).closest("tr");
        ticketId = currentRow.find("td:eq(0)").text();
    });
});

let deleteTicket = () => {
    fetch(`employee/ticket/${ticketId}/delete`, {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({})
        }
    ).then(r => console.log(r))
}

let editTicket = () => {
    let productName = document.getElementById('edit-ticket-name').value;
    let durationTime = document.getElementById('edit-duration-time').value;
    let productPrice = document.getElementById('edit-ticket-price').value;

    let editProduct = {
        "name": productName,
        "periodOfValidity": durationTime,
        "price": productPrice
    };

    fetch(`employee/ticket/${ticketId}/edit`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(editProduct)
        }
    ).then(response => console.log(response))
}

