import axios from "axios";

const APP_BASE_URL="http://localhost:8081";
const ADD_CATEGORY="/category/addCategory";
const GET_CATEGORIES="/category/loadCategories";

const ADD_EXPENSE = "/expense/addExpense";

class HTTPServiceImpl {
   
    addCategory(category,headers){
        return axios.post(APP_BASE_URL+ADD_CATEGORY,category,{
            headers:headers,
        });
    }

    getCategoryList() {
        return axios.get(APP_BASE_URL+GET_CATEGORIES);
    }

    addExpense(expense,headers) {
        return axios.post(APP_BASE_URL+ADD_EXPENSE,expense,{
            headers:headers,
        });
    }
}

export default new HTTPServiceImpl();