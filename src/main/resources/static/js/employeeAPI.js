let createEmployee = async () => {
    let employee = {
        "name": document.getElementById('employee-username').value,
        "pass": document.getElementById('employee-password').value,
        "role": document.getElementById('employee-role').value
    };
    fetch("/admin/employee/create", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(employee)
        }
    ).then(response => console.log(response));
}

let getEmployeeList = async () => {
    return fetch('/admin/employee/getAll', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
}

let printEmployees = async () => {

    const employeeList = await getEmployeeList().then(r => r);

    let table = document.getElementById('employee-table');

    for (let i = 0; i < employeeList.length; i++) {
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let username = document.createElement('td');
        let role = document.createElement('td');
        let del = document.createElement('td');
        let edit = document.createElement('td');
        id = employeeList[i].id;
        username.innerText = employeeList[i].name;
        role.innerText = employeeList[i].role;
        del.innerHTML = ('<a class="btn-outline-danger"><span class="btn-outline-danger btn-client" data-toggle="modal" data-target="#delete-employee-popup" data-feather="trash"></span></a>');
        edit.innerHTML = ('<a class="btn-outline-secondary"><span class="btn-outline-secondary btn-client" data-toggle="modal" data-target="#edit-employee-popup" data-feather="edit"></span></a>');
        row.append(id, username, role, del, edit);
        table.append(row);
    }
    feather.replace();
}

let employeeId;

$(document).ready(function () {
    $("#employee-table").on('click', '.btn-client', function () {
        let currentRow = $(this).closest("tr");
        employeeId = currentRow.find("td:eq(0)").text();
    });
});

let deleteEmployee = () => {
    fetch(`/admin/employee/${employeeId}/delete`, {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({})
    })
}

let editEmployee = () => {

    let employee = {
        "name": document.getElementById('edit-employee-name').value,
        "role": document.getElementById('edit-employee-role').value,
        "pass": document.getElementById('edit-employee-password').value
    };

    fetch(`/admin/employee/${employeeId}/edit`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(employee)
    })
}




