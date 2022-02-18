import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Home from './pages/Home';
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
          </Routes>
        </Router>
    </React.StrictMode>,
  document.getElementById('root')
);

