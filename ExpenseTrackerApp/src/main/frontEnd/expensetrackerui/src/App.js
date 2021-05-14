import './App.css';

import CategoryComp from './component/CategoryComp';
import AddExpense from './component/AddExpense';
import ExpenseComp from './component/ExpenseComp';
import Header from './component/Header';
import Footer from './component/Footer';
import Menu from './menu/Menu';

import React, { Component } from 'react';

class App extends Component {
  render() {
    return (
      <div>
        <Header/>
        <Menu/>
        <Footer/>
      </div>
    );
  }
}

export default App;