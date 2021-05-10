import React, { Component } from 'react';
import AddCategory from './AddCategory';
import CategoryList from './CategoryList';
import HTTPServiceImpl from '../service/HTTPServiceImpl';

class CategoryComp extends Component {

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
            returnMessage:'Successfully Added..',
            buttonName:'Add',
            categoryList:[]
           
        }
        this.addCategory = this.addCategory.bind(this);
        this.handleChange = this.handleChange.bind(this);
        //this.rowClicked = this.rowClicked.bind(this);
    }

    componentDidMount() {
        this.loadCategories();
    }

    loadCategories() {
        HTTPServiceImpl.getCategoryList()
            .then((reponse) => {
                console.log(reponse.data);
                this.setState({ categoryList: reponse.data });
            })
            .catch((error) => {
            });
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
            this.setState({expenseCategory:this.expenseCategory,
                buttonDisable:false,_clr:'black'});
            if(this.state.buttonName==='Save') {
                this.setState({buttonName:'Add',returnMessage:'Successfully updated'});
            } else {
                this.setState({returnMessage:'Successfully Added..'})
            }
            this.loadCategories();
        })
        .catch((error)=>{
            console.log(error);
            this.setState({returnMessage:error.message,_clr:'red'})
        });
    }

    rowClicked=(id)=> {
        console.log('rowClicked'+id);
        var categoryList = this.state.categoryList
        categoryList.filter((cat)=>{
            if(cat.id===id){
                this.setState({expenseCategory:cat,buttonName:'Save'});
            }
        });
    }
    render() {
        return (
            <div>
                <CategoryList categoryList={this.state.categoryList} 
                rowClicked={this.rowClicked}
                heading={this.state.categoryList.length>0?'List of Categories':'There is no categories..'}/>

                <AddCategory 
                handleChange={this.handleChange}
                addCategory={this.addCategory}
                expenseCategory={this.state.expenseCategory}
                _clr={this.state._clr}
                returnMessage={this.state.returnMessage}
                buttonDisable={this.state.buttonDisable}
                buttonName={this.state.buttonName}/>
            </div>
        );
    }
}

export default CategoryComp;