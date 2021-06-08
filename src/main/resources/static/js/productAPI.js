let createProduct = () => {

    let product = {
        "productName": document.getElementById('product-name').value,
        "price": document.getElementById('product-price').value
    };

    fetch("/employee/product/create", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(product)
        }
    ).then(response => console.log(response))
}

let getProductList = () => {
    return fetch('/employee/product/getAll', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
}


let printProducts = async () => {
    const productList = await getProductList().then(r => r);

    let table = document.getElementById('product-table');

    for (let i = 0; i < productList.length; i++) {
        let row = document.createElement('tr');
        let id = document.createElement('td');
        let name = document.createElement('td');
        let price = document.createElement('td');
        let del = document.createElement('td');
        let edit = document.createElement('td');
        id.innerText = productList[i].id;
        name.innerText = productList[i].productName;
        price.innerText = productList[i].price;
        del.innerHTML = ('<a class="btn-outline-danger"><span class="btn-outline-danger btn-client" data-feather="trash" data-toggle="modal" data-target="#delete-product-popup"></span></a>');
        edit.innerHTML = ('<a class="btn-outline-dark"><span class="btn-outline-secondary btn-client" data-feather="edit" data-toggle="modal" data-target="#edit-product-popup"></span></a>');
        row.append(id, name, price, del, edit);
        table.append(row);
    }
    feather.replace()
}

let productUserId;

$(document).ready(function () {
    $("#product-table").on('click', '.btn-client', function () {
        let currentRow = $(this).closest("tr");
        productUserId = currentRow.find("td:eq(0)").text();
    });
});

let deleteProduct = () => {
    fetch(`employee/product/${productUserId}/delete`, {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({})
        }
    ).then(r => console.log(r))
}

let editProduct = () => {
    let productName = document.getElementById('edit-product-name').value;
    let productPrice = document.getElementById('edit-product-price').value;

    let editProduct = {
        "productName": productName,
        "price": productPrice,
    };

    fetch(`employee/product/${productUserId}/edit`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(editProduct)
        }
    ).then(response => console.log(response))
}

let buyProduct = () => {

    let productName = document.getElementById('find-products').value;
    let product = {
        "productName": productName
    };

    fetch(`employee/product/${userId}/buy`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(product)
        }
    ).then(response => console.log(response))


}