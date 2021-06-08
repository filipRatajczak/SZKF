let chartData = []

let getTicketMonth = async () => {
    return fetch('/employee/payments/tickets/month', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            chartData = []
            chartData.push(...r);
        })
}

let getTicketQuarter = async () => {
    return fetch('/employee/payments/tickets/quarter', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            chartData = []
            chartData.push(...r);
        })
}

let getTicketYear = async () => {
    return fetch('/employee/payments/tickets/year', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            chartData = []
            chartData.push(...r);
        })
}

let getProductMonth = async () => {
    return fetch('/employee/payments/products/month', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            chartData = []
            chartData.push(...r);
        })
}

let getProductQuarter = async () => {
    return fetch('/employee/payments/products/quarter', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            chartData = []
            chartData.push(...r);
        })
}

let getProductYear = async () => {
    return fetch('/employee/payments/products/year', {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(response => response.json())
        .then(r => {
            chartData = []
            chartData.push(...r);
        })
}