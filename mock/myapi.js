function getclickcount(req,res){
  console.log("succeeded");
  return res.json(["1","2","3"]);
}

const data = [
  {
    id: 'Ant Design Title 1',
    name: 'Ant Design, a design language for background applications, is refined by Ant UED Team'
  },
  {
    id: 'Ant Design Title 2',
    name: 'Ant Design, a design language for background applications, is refined by Ant UED Team'
  },
  {
    id: 'Ant Design Title 3',
    name: 'Ant Design, a design language for background applications, is refined by Ant UED Team'
  },
  {
    id: 'Ant Design Title 4',
    name: 'Ant Design, a design language for background applications, is refined by Ant UED Team'
  },
];

export default{
  'GET /api/get': getclickcount,
  'GET /api/fetch': data,
}
