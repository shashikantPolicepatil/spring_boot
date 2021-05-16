import React, { Component } from 'react';

class IncomeList extends Component {
    
    render() {
        debugger;
        const incomeListData=this.props.incomeList.map((income,i)=>{
            return <tr key={i}>
                <td>{income.category.categoryDesc}</td>
                <td>{income.incomeDate}</td>
                <td>{income.credit}</td>
                <td><button onClick={()=>this.props.handleEdit(income.id)}>Edit</button></td>
                <td><button onClick={()=>this.props.handleDelete(income.id)}>Remove</button></td>
            </tr>
        })

        const tHead = <thead>
        <tr>
            <th>Source</th>
            <th>Date</th>
            <th>Credited Amount</th>
            <th>Action</th>
        </tr>
    </thead>
        return (
            <div>
                <p>{this.props.title}</p>
                <table>
                    {this.props.incomeList.length>0?tHead:''}
                    <tbody>{incomeListData}</tbody>
                </table>
            </div>
        );
    }
}

export default IncomeList;