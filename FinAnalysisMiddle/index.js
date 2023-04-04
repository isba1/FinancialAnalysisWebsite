const express = require('express');
const httpProxy = require('http-proxy');

const apiProxy = httpProxy.createProxyServer();
const app = express();

const backendPort = 8080; // Replace with the port number of your backend server

app.all('/api/*', (req, res) => {
  apiProxy.web(req, res, { target: `http://localhost:${backendPort}` });
});

app.get('/getJsonData', (req, res) => {
  apiProxy.web(req, res, { target: `http://localhost:${backendPort}/getData` });
});

app.listen(3000, () => {
  console.log(`Server listening on port 3000`);
});
