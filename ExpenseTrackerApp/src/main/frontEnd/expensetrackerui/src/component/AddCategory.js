import React, { Component } from 'react';
import HTTPServiceImpl from '../service/HTTPServiceImpl';

class AddCategory extends Component {
    expenseCategory={
        id:"",
        categoryCode:"",
        categoryDesc:""
    }

    constructor() {
        super()
        this.state={
            expenseCategory:this.expenseCategory,
            buttonDisable:false,
            _clr:'white',
            returnMessage:'Successfully Added..'
        }
        this.addCategory = this.addCategory.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({_clr:'white'});
        let expenseCategory = {...this.state.expenseCategory}
        expenseCategory[event.target.name]=event.target.value;
        this.setState({expenseCategory});
    }

    addCategory(event) {
        this.setState({buttonDisable:true});
        console.log(this.state.expenseCategory);
        //Adding to db 
        const headers={"content-type":"application/json"};
        const expenseCategory={...this.state.expenseCategory};
        HTTPServiceImpl.addCategory(JSON.stringify(expenseCategory),headers)
        .then(()=>{
            this.setState({expenseCategory:this.expenseCategory,buttonDisable:false,_clr:'black'})
        })
        .catch((error)=>{
            console.log(error);
            this.setState({returnMessage:error.message,_clr:'red'})
        });
    }

    render() {
     //   const {expenseCategory, buttonDisable,_clr,returnMessage} = this.state;
     //console.log(this.props)
        return (
            <div>
                <p>
                    Category name:<input name="categoryDesc" onChange={this.props.handleChange}
                    value={this.props.expenseCategory.categoryDesc}
                    required></input>
                    
                    <button onClick={this.props.addCategory} disabled={this.props.buttonDisable}>
                        {this.props.buttonName}</button>
                </p>
                <p style={{color:this.props._clr}}>{this.props.returnMessage}</p>
            </div>
        );
    }
}

export default AddCategory;