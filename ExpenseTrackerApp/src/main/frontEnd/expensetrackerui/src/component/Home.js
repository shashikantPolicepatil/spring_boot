import React, { Component } from 'react';
import DashBoardData from './DashBoardData';

class Home extends Component {
    constructor() {
        super();
        this.state={
            dashBoardData:null
        }
    }

    componentDidMount() {
    }

    getDashBoardData(month) {
        
    }
    render() {
        return (
            <div>
                <p>Welcome .. Please navigate through link..</p>
                <DashBoardData/>
            </div>
        );
    }
}

export default Home;