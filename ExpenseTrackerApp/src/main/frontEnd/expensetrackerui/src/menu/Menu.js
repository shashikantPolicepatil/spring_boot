import "./Menu.css";
import React, { Component,lazy,Suspense } from 'react';
import {HashRouter,Route} from 'react-router-dom';
//import CategoryComp from '../component/CategoryComp';
//import ExpenseComp from '../component/ExpenseComp';
//import Home from '../component/Home';

const Home = lazy(()=> import('../component/Home'));
const CategoryComp = lazy(()=> import('../component/CategoryComp'));
const ExpenseComp = lazy(()=> import('../component/ExpenseComp'));
const IncomeComp = lazy(()=> import('../component/IncomeComp'));

class Menu extends Component {
    render() {
        return (
            <div className="menu"> 
            <div id="menu-items">
                <a href="#/home">Home</a>
                <a href="#/category">Category</a>
                <a href="#/expense">Expense</a>
                <a href="#/income">Income</a>
            </div>
            <Suspense fallback="Loading...">
            <HashRouter>
                <div>
                    <Route path="/" exact component={Home}/>
                    <Route path="/home" exact component={Home}/>
                    <Route path="/category" exact component={CategoryComp}/>
                    <Route path="/expense" exact component={ExpenseComp}/>
                    <Route path="/income" exact component={IncomeComp}/>
                </div>
            </HashRouter> 
            </Suspense>               
            </div>
        );
    }
}

export default Menu;