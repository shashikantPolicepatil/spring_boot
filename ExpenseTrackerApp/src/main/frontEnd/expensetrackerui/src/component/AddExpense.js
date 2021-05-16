import React, { Component } from 'react';
import HTTPServiceImpl from '../service/HTTPServiceImpl';
import CategoryList from './CategoryList';

class AddExpense extends Component {
    
    render() {
      //  const{categoryList} = this.props.categoryList.cateList;
       const catList =  this.props.categoryList.map((category,i)=>{
           return <option value={category.id}>{category.categoryDesc}</option>
        })
        return (
            <div>
                <p>{this.props.title}</p>
                <table>
                    <tbody>
                        <tr>
                            <td>Category:</td>
                            <td><select onChange={this.props.handleCatChange}
                             value={this.props.expense.category.id}
                                        name="category" >{catList}</select></td>
                        </tr>
                        <tr>
                            <td>Date:</td>
                            <td><input name="expenseDate" type="date" value={this.props.expense.expenseDate}
                            onChange={this.props.handleChange}></input></td>
                        </tr>
                        <tr>
                            <td>Amount:</td>
                            <td><input name="amount" type="number" value={this.props.expense.amount}
                             onChange={this.props.handleChange}></input></td>
                        </tr>
                    </tbody>
                </table>
                <button onClick={this.props.addExpense}>Save</button>
            </div>
        );
    }
}

export default AddExpense;