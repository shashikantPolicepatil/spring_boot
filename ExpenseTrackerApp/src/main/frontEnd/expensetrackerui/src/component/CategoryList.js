import React, { Component } from 'react';

class CategoryList extends Component {

    constructor(props) {
        super(props);
    }

    
    render() {
        const listDate =this.props.categoryList.map((category,i)=>{
            return <tr key={category.id}>
                 <td>{category.categoryDesc}</td>
                 <td><button onClick={()=>this.props.rowClicked(category.id)}>Edit</button></td>
            </tr>
     }) ;

   /*  const paginationData =  
         <p>{Array.from(Array(this.props.categoryList.pages), (e, i) => {
          return <a key={i+1} href={'#/category?page='+(i+1)}>{i+1}</a>
        })}</p>
      
*/

     const page = this.props.categoryList.page;
        return (
            <div>
                <p>{this.props.heading}</p>
                <table>
                    <tbody>
                        {listDate}
                    </tbody>
                </table>
               <p>
                   
               </p>
            </div>
        );
    }
}

export default CategoryList;