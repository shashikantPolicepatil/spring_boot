import axios from "axios";

const APP_BASE_URL="http://localhost:8081";
const ADD_CATEGORY="/category/addCategory";
const GET_CATEGORIES="/category/loadCategories";

const ADD_EXPENSE = "/expense/addExpense";
const GET_EXPENSES = "/expense/loadAllExpense";
const DEL_EXPENSE = "/expense/remove/"

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

    removeExpense(id) {
        return axios.delete(APP_BASE_URL+DEL_EXPENSE+id);
    }

    getExpenseList() {
        return axios.get(APP_BASE_URL+GET_EXPENSES);
    }
}

export default new HTTPServiceImpl();