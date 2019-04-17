import request from '../util/request'

export default{
    namespace:'list_owner',
    state:{},
    reducers:{
        setData(state,{payload}){
            return { data: payload};
        },
        appendData(state,{payload}){
            const newData = state.data;
            newData.concat(payload);
            return { data: newData};
        }
    },
    effects:{
        *fetchData({payload},{call,put}){
            const response = yield call(request,'/api/owners');
            yield put({type:'setData',payload:response})
        }
    }
}

// function checkStatus(response) {
//     if (response.status >= 200 && response.status < 300) {
//       return response;
//     }
//
//     const error = new Error(response.statusText);
//     error.response = response;
//     throw error;
//   }
// async function request(url, options) {
//   const response = await fetch(url, options);
//   checkStatus(response);
//   debugger
//   return await response.json();
// }
