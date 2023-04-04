// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;


import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [symbol, setSymbol] = useState('');
  const [response, setResponse] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const result = await axios.get(`http://localhost:8080/ticker/getIncomeStatement?symbol=${symbol}`);
      setResponse(JSON.stringify(result.data));
    } catch (error) {
      setResponse(JSON.stringify(error));
    }
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <input type="text" value={symbol} onChange={(e) => setSymbol(e.target.value)} placeholder="Enter stock symbol" />
        <button type="submit">Submit</button>
      </form>
      <pre>{response}</pre>
    </div>
  );
}

export default App;
