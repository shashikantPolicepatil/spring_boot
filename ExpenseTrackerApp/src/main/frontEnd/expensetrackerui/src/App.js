import './App.css';

import CategoryComp from './component/CategoryComp';
import AddExpense from './component/AddExpense';

import React, { Component } from 'react';

class App extends Component {
  render() {
    return (
      <div>
        
        <AddExpense/>
      </div>
    );
  }
}

export default App;