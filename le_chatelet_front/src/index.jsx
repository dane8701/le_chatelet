import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Home from './pages/Home';
import Authentification1 from './pages/Authentification1';
import Authentification2 from './pages/Authentification2';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { createGlobalStyle } from 'styled-components';
import Rejection from './pages/Rejection';

const GlobalStyle = createGlobalStyle`
    div {
        font-family: 'Trebuchet MS', Helvetica, sans-serif;
    }
`

ReactDOM.render(
  <React.StrictMode>
        <Router>
          <GlobalStyle />
          <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/country" element={<Rejection />}/>
            <Route path="/auth1" element={<Authentification1 />}/>
            <Route path="/auth2" element={<Authentification2 />}/>
          </Routes>
        </Router>
    </React.StrictMode>,
  document.getElementById('root')
);

