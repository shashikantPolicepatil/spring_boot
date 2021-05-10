import React, { Component } from 'react';
import HTTPServiceImpl from '../service/HTTPServiceImpl';
import CategoryList from './CategoryList';

class AddExpense extends Component {
    expense={
        id:"",
        amount:0,
        expenseDate:null,
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
            expense:this.expense,
            categoryList:[]
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
        })
        .catch((error)=>{
            console.log(error);
        })
    }
    
    render() {
        const{categoryList} = this.state;
       const catList =  categoryList.map((category,i)=>{
           return <option value={category.id}>{category.categoryDesc}</option>
        })
        return (
            <div>
                <p>Add expense</p>
                <table>
                    <tbody>
                        <tr>
                            <td>Category:</td>
                            <td><select onChange={this.handleCatChange}
                                        name="category" >{catList}</select></td>
                        </tr>
                        <tr>
                            <td>Date:</td>
                            <td><input name="expenseDate" type="date" onChange={this.handleChange}></input></td>
                        </tr>
                        <tr>
                            <td>Amount:</td>
                            <td><input name="amount" type="number" onChange={this.handleChange}></input></td>
                        </tr>
                    </tbody>
                </table>
                <button onClick={this.addExpense}>Save</button>
            </div>
        );
    }
}

export default AddExpense;