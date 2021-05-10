import React, { Component } from 'react';

class CategoryList extends Component {

    render() {
        const listDate =this.props.categoryList.map((category,i)=>{
            return <tr key={category.id}>
                 <td>{category.categoryDesc}</td>
                 <td><button onClick={()=>this.props.rowClicked(category.id)}>Edit</button></td>
            </tr>
     }) ;
        return (
            <div>
                <p>{this.props.heading}</p>
                <table>
                    <tbody>
                        {listDate}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default CategoryList;