import React, { Component } from 'react';

class ExpenseList extends Component {
    render() {
        const expenseListData=this.props.expenseList.map((expense,i)=>{
            return <tr key={i}>
                <td>{expense.category.categoryDesc}</td>
                <td>{expense.expenseDate}</td>
                <td>{expense.amount}</td>
                <td><button onClick={()=>this.props.handleEdit(expense.id)}>Edit</button></td>
                <td><button onClick={()=>this.props.handleDelete(expense.id)}>Remove</button></td>
            </tr>
        })
        const thead = <thead>
            <tr>
                <th>Category</th>
                <th>Spent Date</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>
        </thead>;
        return (
            <div>
                <p>{this.props.title}</p>
                <table>
                    {this.props.expenseList.length>0?thead:''}
                    <tbody>
                        {expenseListData}
                    </tbody>
                </table>
                <p style={{'font-weight':'bold'}}>{this.props.statusMessage}</p>
            </div>
        );
    }
}

export default ExpenseList;