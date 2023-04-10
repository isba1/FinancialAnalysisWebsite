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
  const [stockData, setStockData] = useState({});

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/ticker/getInfo?symbol=${symbol}`);
      setStockData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const renderStockData = () => {
    if (Object.keys(stockData).length === 0) {
      return null;
    }

    return (
      <div>
        <h2>{stockData.symbol}</h2>
        <table>
          <tbody>
            {Object.entries(stockData).map(([key, value]) => (
              <tr key={key}>
                <td style={{ fontWeight: 'bold', fontSize: 'larger' }}>{key}</td>
                <td>{value}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <input type="text" value={symbol} onChange={(e) => setSymbol(e.target.value)} placeholder="Enter stock symbol" />
        <button type="submit">Submit</button>
      </form>
      {renderStockData()}
    </div>
  );
}
//   const [symbol, setSymbol] = useState('');
//   const [response, setData] = useState([]);

//   const handleSubmit = async (event) => {
//     event.preventDefault();

//     try {
//       const result = await axios.get(`http://localhost:8080/ticker/getInfo?symbol=${symbol}`);
//       setData(result.data);
//     } catch (error) {
//       console.error(error);
//     }
//   };

//   return (
//     <div className="App">
//       <form onSubmit={handleSubmit}>
//         <input type="text" value={symbol} onChange={(e) => setSymbol(e.target.value)} placeholder="Enter stock symbol" />
//         <button type="submit">Submit</button>
//       </form>
//       {/* <pre>{response}</pre> */}
//       {/* <div>
//       {response.data.map(item => (
//         <div key={item.id}>
//           <h2>{item.title}</h2>
//           <p>{item.description}</p>
//         </div>
//       ))}
//       </div> */}
//       <div>
//         {Array.isArray(response)
//           ? response.map((item) => (
//               <div key={item.id}>
//                 <h2>{item.title}</h2>
//                 <p>{item.description}</p>
//               </div>
//             ))
//           : Object.values(response).map((item) => (
//               <div key={item.id}>
//                 <h2>{item.title}</h2>
//                 <p>{item.description}</p>
//               </div>
//             ))}
//       </div>
//     </div>
//   );
// }

export default App;
