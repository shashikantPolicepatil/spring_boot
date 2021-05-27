import React, { Component } from 'react';
import ReactApexChart from 'react-apexcharts'
import "./DashBoard.css";
import UtilityServiceImpl from '../service/UtilityServiceImpl';
import HttpServiceImpl from '../service/HTTPServiceImpl';

class DashBoardData extends Component {

    emptyOptions = {
        chart: {
          width: 380,
          type: 'pie',
        },
        labels: [],
      }

    constructor(){
        super();
        this.state={
            currentMonth:'',
            dashBoardData:'',
            series: [],
            options: this.emptyOptions,
            display:false
        }
        this.handleOnChange=this.handleOnChange.bind(this);
    }

    componentDidMount(){
        this.getDashBoardData(UtilityServiceImpl.getCurrentMonth())       
    }

    getDashBoardData(month) {
        debugger;
        let lbs = [];
        let series = this.state.series;
        let labels= this.state.options;
        HttpServiceImpl.getDashBoardData(month)
        .then((response)=>{
            debugger;
            response.data.labels.map((val,i)=>{lbs.push(val)});
            this.emptyOptions.labels=lbs;
            this.setState({dashBoardData:response.data,labels:response.data.labels,
                series:response.data.series,options:this.emptyOptions,display:response.data.display});
        })
        .catch((error)=>{
            console.log(error);
        });
        console.log(this.state.options);
    }

    handleOnChange(event) {
        console.log("on Change"+event.target.name+"/"+event.target.value);
        this.getDashBoardData(event.target.value);
    }
    render() {
        var months = ["All","January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
         "November", "December"];
         const monthsList = months.map((month,i)=>{
             return i===UtilityServiceImpl.getCurrentMonth()?
             <option value={i} key={i} selected>{month}</option>
             :<option value={i} key={i}>{month}</option>
         })
         let currentMonth = UtilityServiceImpl.getCurrentMonth();
         const {dashBoardData} = this.state;
         let liData=dashBoardData.amountByCate;
        const data =  liData?liData.map((cate,i)=>{
             return <ul key={i}><li key={i}>{cate.field}:{cate.value}</li>
             </ul>
         }):""
         debugger;
         console.log(this.state.series+"/"+this.state.options.labels);
         console.log(this.state.dashBoardData);
       
        return (
            <div className="dashboardContainer">
      <div className="nav">
                    
                        <p>Month:<select selected={currentMonth} name="month" onChange={this.handleOnChange}>
                            {monthsList}
                            </select>
                        </p>
                        
                        {this.state.display?
                        <div>
                        <table>
                        <thead>
                            <tr>
                                <th>
                                    Total Credits
                                </th>
                                <th>
                                    Total Debits
                                  </th>
                                <th>
                                    Balance
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{dashBoardData.creditAmount}</td>
                                <td>{dashBoardData.debitAmount}</td>
                                <td>{dashBoardData.balance}</td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <div className="expenseByCate">
                        Expense By Category
                        {data}
                    </div>
                    <div style={{position: 'fixed',left: '400px', top: '47%'}}>
                        Expense graph
                    <ReactApexChart options={this.state.options}
                    series={this.state.series} type="pie" width={380} />
                    </div>
                    </div>
                        
                        :'No data..'}
                        
                    </div>
            </div>
        );
    }
}

export default DashBoardData;