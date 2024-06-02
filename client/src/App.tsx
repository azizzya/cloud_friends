import React from 'react';
import { Outlet } from 'react-router';
import './global.scss'

function App() {
  return (
    <div className="App">
      <Outlet />
    </div>
  );
}

export default App;
