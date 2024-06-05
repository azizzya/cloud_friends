import React from 'react';
import { Outlet } from 'react-router';
import './global.scss'
import Navbar from './Components/Navbar/Navbar';

function App() {
  return (
    <div className="App">
      <Outlet />
      <Navbar />
    </div>
  );
}

export default App;
