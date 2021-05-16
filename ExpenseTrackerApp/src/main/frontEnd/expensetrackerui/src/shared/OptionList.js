import React, { Component } from 'react';
import HTTPServiceImpl from '../service/HTTPServiceImpl';

class OptionList extends Component {
    constructor() {
        super()
        this.state={
            categoryList:[]
        }
    }
    componentDidMount() {
        HTTPServiceImpl.getCategoryList()
        .then((response)=>{
            this.setState({categoryList:response.data});
        })
        .catch((error)=>{
            throw new Error(error.message);
        });
    }
    render() {
        const cateList =  this.state.categoryList.map((category,i)=>{
            return <option value={category.id}>{category.categoryDesc}</option>
         });
        return (
            <>
                {cateList}
            </>
        );
    }
}

export default OptionList;