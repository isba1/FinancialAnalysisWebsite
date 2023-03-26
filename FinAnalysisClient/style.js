const form = document.querySelector('#stock-form');

form.addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent default form submission behavior

    // Get form data
    const symbol = form.elements['symbol'].value;

    // Send AJAX request to server
    fetch('/ticker/getInfo', {
        method: 'GET',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({ symbol })
    })
    .then(response => response.json())
    .then(data => {
        // Update the page with the new data
        // For example, you could display the stock information in a table or chart
        console.log(data);
    })
    .catch(error => console.error(error));
});