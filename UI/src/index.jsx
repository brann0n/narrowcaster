import React from 'react';
// import ReactDOM from 'react-dom';
import ReactDOM from 'react-dom/client';
import './index.css';
import VigmoRouter from './VigmoRouter';
import { HashRouter } from 'react-router-dom';

const RootComponent = () => (
  <HashRouter hashType='hashbang'>
       <VigmoRouter />
  </HashRouter>
)

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<RootComponent />);


// ReactDOM.render(
//   <HashRouter hashType='hashbang'>
//     <VigmoRouter />
//   </HashRouter>,
//   document.getElementById('root')
// );
