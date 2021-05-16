import React, { Component } from 'react';
import OptionList from '../shared/OptionList';

class AddIncome extends Component {
    render() {
        return (
            <div>
                
                <p>{this.props.title}</p>
                <table>
                    <tbody>
                        <tr>
                            <td>Category:</td>
                            <td><select onChange={this.props.handleCatChange}
                             value={this.props.income.category.id}
                                        name="category" >
                                            <OptionList/>
                                            </select>
                                            </td>
                        </tr>
                        <tr>
                            <td>Date:</td>
                            <td><input name="incomeDate" type="date" value={this.props.income.incomeDate}
                            onChange={this.props.handleChange}></input></td>
                        </tr>
                        <tr>
                            <td>Amount:</td>
                            <td><input name="credit" type="number" value={this.props.income.amount}
                             onChange={this.props.handleChange}></input></td>
                        </tr>
                    </tbody>
                </table>
                <button onClick={this.props.addIncome}>Save</button>
            </div>
        );
    }
}

export default AddIncome;