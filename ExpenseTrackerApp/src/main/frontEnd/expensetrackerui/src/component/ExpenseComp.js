import React, { Component } from 'react';
import HTTPServiceImpl from '../service/HTTPServiceImpl';
import AddExpense from './AddExpense';
import ExpenseList from './ExpenseList';

class ExpenseComp extends Component {
    emptyExpense={
        id:"",
        amount:0,
        expenseDate:new Date().getDate,
        expenseMonth:'',
        category:{
            id:"",
            categoryCode:"",
            categoryDesc:""
        }
    }

  constructor() {
        super();
        this.state={
            expense:this.emptyExpense,
            categoryList:[],
            expenseList:[],
            statusMessage:''
        }
        this.handleCatChange = this.handleCatChange.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.addExpense = this.addExpense.bind(this);
    }

    componentDidMount() {
        HTTPServiceImpl.getCategoryList()
        .then((response)=>{
            this.setState({categoryList:response.data});
        })
        .catch((error)=>{
            throw new Error(error.message);
        });

        //Expense list
        this.getExpenseList();
    }

    getExpenseList() {
        HTTPServiceImpl.getExpenseList()
            .then((response) => {
                console.log(response.data);
                this.setState({ expenseList: response.data });
            })
            .catch((error) => {
                throw new Error(error.message);
            });
    }

    handleChange(event) {
        //debugger;
        let expense = this.state.expense;
        expense[event.target.name]=event.target.value;
        this.setState({expense:expense});
    }
    handleCatChange(event) {
        var val = event.target.value;
        let expense = this.state.expense;
        let categoryList = this.state.categoryList;
        categoryList.filter((category)=>{
            if(category.id===parseInt(val)){
                console.log(category);
                expense[event.target.name]=category;
            }
        })
        this.setState({expense:expense});
        console.log(this.state);
    }

    addExpense() {
        const expense = {...this.state.expense};
        const headers={"content-type":"application/json"}
        HTTPServiceImpl.addExpense(JSON.stringify(expense),headers)
        .then((reponse)=>{
            console.log(reponse.data);
            this.setState({expense:this.emptyExpense})
            this.getExpenseList();
        })
        .catch((error)=>{
            console.log(error);
        })
    }
    
    handleEdit=(id)=>{
        console.log('expense id'+id);
        var expenseList = this.state.expenseList;
        debugger;
        expenseList.filter((expense)=>{
            if(expense.id===id)
            this.setState({expense:expense});
        })

    }

    handleDelete=(id)=>{
        HTTPServiceImpl.removeExpense(id)
        .then((response)=>{
            console.log(response);
            this.setState({statusMessage:'Removed Successfully'});
            this.getExpenseList();
        }).catch((error)=>{
            this.setState({statusMessage:'Unable to delete.Please try again.'});
        })
    }
    render() {
      
        return (
            <div className="transactions transactions-expense">
                <ExpenseList title= {this.state.expenseList.length>0?'Expense List' : 'No data'}
                expenseList={this.state.expenseList}
                handleEdit={this.handleEdit} handleDelete={this.handleDelete}
                statusMessage={this.state.statusMessage}/>

                <AddExpense title='Add expense'
                categoryList={this.state.categoryList}
                expense={this.state.expense}
                handleChange={this.handleChange}
                handleCatChange={this.handleCatChange}
        addExpense={this.addExpense}></AddExpense>

                
            </div>
        );
    }
}

export default ExpenseComp;