
class UtilityServiceImpl  {
    
    getCurrentDate() {
       return new Date();
    }

    getCurrentMonth() {
        var d = this.getCurrentDate(); 
        var month = d.getMonth()+1;
        return month;
    }
}

export default new  UtilityServiceImpl();