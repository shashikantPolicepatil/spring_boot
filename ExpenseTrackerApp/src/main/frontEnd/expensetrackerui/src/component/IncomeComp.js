import React, { Component } from 'react';
import AddIncome from './AddIncome';
import IncomeList from './IncomeList';
import HTTPServiceImpl from '../service/HTTPServiceImpl';

class IncomeComp extends Component {

    emptyIncome={
        id:"",
        credit:0,
        incomeDate:new Date().getDate,
        category:{
            id:"",
            categoryCode:"",
            categoryDesc:""
        }
    }

  constructor() {
        super();
        this.state={
            income:this.emptyIncome,
            categoryList:[],
            incomeList:[],
            statusMessage:''
        }
        this.handleCatChange = this.handleCatChange.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.addIncome = this.addIncome.bind(this);
    }

    componentDidMount() {
        HTTPServiceImpl.getCategoryList()
        .then((response)=>{
            this.setState({categoryList:response.data});
        })
        .catch((error)=>{
            throw new Error(error.message);
        });
        //income list
        this.getIncomeList();
    }

    handleChange(event) {
        let income = this.state.income;
        income[event.target.name]=event.target.value;
        this.setState({income:income});
    }

    handleCatChange(event) {
        var val = event.target.value;
        let income = this.state.income;
        let categoryList = this.state.categoryList;
        categoryList.filter((category)=>{
            if(category.id===parseInt(val)){
                console.log(category);
                income[event.target.name]=category;
            }
        })
        this.setState({income:income});
        console.log(this.state);
    }

    addIncome() {
        const income = {...this.state.income};
        const headers={"content-type":"application/json"}
        HTTPServiceImpl.addIncome(JSON.stringify(income),headers)
        .then((reponse)=>{
            console.log(reponse.data);
            this.setState({income:this.emptyIncome})
            this.getIncomeList();
        })
        .catch((error)=>{
            console.log(error);
        })
    }

    getIncomeList() {
        HTTPServiceImpl.getIncomeList()
        .then((response)=>{
            this.setState({incomeList:response.data});
            debugger;
            console.log(this.state.incomeList);
        }).catch((error)=>{
            this.setState({statusMessage:'Network error.Please try again later'});
        });
    }

    handleEdit=(id)=>{
        console.log('income id '+id);
    }

    handleDelete=(id)=>{
        HTTPServiceImpl.removeIncome(id)
        .then((response)=>{
            console.log(response);
            this.setState({statusMessage:'Removed Successfully'});
            this.getIncomeList();
        }).catch((error)=>{
            this.setState({statusMessage:'Unable to delete.Please try again.'});
        })
    }

   
    render() {
        return (
            <div>

                <IncomeList title={this.state.incomeList.length>0?'Amount credit details..':'No credit info.'}
                incomeList={this.state.incomeList}
                handleDelete={this.handleDelete}
                handleEdit={this.handleEdit}/>
                <p>{this.state.statusMessage}</p>

                 <AddIncome title='Add income'
                categoryList={this.state.categoryList}
                income={this.state.income}
                handleChange={this.handleChange}
                handleCatChange={this.handleCatChange}
                addIncome={this.addIncome}/>

               
            </div>
        );
    }
}

export default IncomeComp;