import request from '../util/request'

export default{
    namespace:'list_pet',
    state:{},
    reducers:{
        setData(state,{payload}){
            return { data: payload};
        },
        appendData(state,{payload}){
            let newData = state.data;
            newData = newData.concat(payload);
            return { data: newData};
        },
        consoleData(state,{payload}){
            console.log(payload);
            console.log(state.data);
        }
    },
    effects:{
        *fetchData({payload},{call,put}){
            const response = yield call(request,'/api/pets');
            yield put({type:'setData',payload:response});
        },
        *addData({payload},{call,put}) {
            const value={
                id:Number(payload.id),
                name:payload.name,
                type:payload.type,
                services:[]
            }
            const values = [value];
            const response = yield call(request,'/api/pets', {
                headers: {
                    'content-type': 'application/json',
                },
                method: 'POST',
                body: JSON.stringify(value),
            });
            yield put({type:'appendData',payload:value});
        },
        *deleteData({payload},{call,put}){
            yield call(request,'/api/pets/' + payload.id, {
                method: 'DELETE',
            });
            const responseRefresh = yield call(request,'/api/pets');
            yield put({type:'setData',payload:responseRefresh});
        }
    }
}

// function checkStatus(response) {
//     if (response.status >= 200 && response.status < 300) {
//       return response;
//     }
  
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
