const form = document.querySelector('#stock-form');
const jsonDisplay = document.getElementById('json-display');


form.addEventListener('submit', (event) => {
  event.preventDefault(); // Prevent default form submission behavior

  // Get form data
  const symbol = form.elements['symbol'].value;

  // Send AJAX request to server
  fetch(`http://localhost:8080/ticker/getIncomeStatement?symbol=${symbol}`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => response.json())
  .then(data => {
    // Update the page with the new data
    // For example, you could display the stock information in a table or chart
    console.log(JSON.stringify(data, null, 2));
  })
  .catch(error => console.error(error));
});


// form.addEventListener('submit', (event) => {
//   event.preventDefault(); // Prevent default form submission behavior

//   // Get form data
//   const symbol = form.elements['symbol'].value;

//   // Send AJAX request to server
//   fetch(`/ticker/getIncomeStatement?symbol=${symbol}`, {
//     method: 'GET',
//     headers: {
//       'Content-Type': 'application/json'
//     }
//   })
//   .then(response => response.json())
//   .then(data => {
//     // Update the page with the new data
//     // For example, you could display the stock information in a table or chart
//     console.log(data);
//   })
//   .catch(error => console.error(error));
// });


//form.addEventListener('submit', (event) => {
//    event.preventDefault(); // Prevent default form submission behavior
//
//    // Get form data
//    const symbol = form.elements['symbol'].value;
//
//    // Send AJAX request to server
//    fetch('/ticker/getIncomeStatement', {
//        method: 'GET',
//        headers: {
//        'Content-Type': 'application/json'
//        },
//        body: JSON.stringify({ symbol })
//    })
//    .then(response => response.json())
//    .then(data => {
//        // Update the page with the new data
//        // For example, you could display the stock information in a table or chart
//        console.log(data);
//    })
//    .catch(error => console.error(error));
//});
