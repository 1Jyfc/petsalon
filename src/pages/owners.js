import react,{Component} from 'react';
import display from '../assets/paw.png';
import {List,Avatar,Icon, Layout, Modal, Button, Form, Input} from 'antd';
import styles from './index.css';
import Link from 'umi/link';
import {connect} from 'dva';
import ButtonGroup from 'antd/lib/button/button-group';

const mapStateToProps = (state) =>{
  return {
    list_owner: state.list_owner
  }
}

const mapDispatchToProps = (dispatch) =>{
  return {
    // click: ()=>dispatch({type:"typecount/click",payload:{photo:"clothes"}}),
    fetch: ()=>dispatch({type:"list_owner/fetchData"}),
    deleteData: ({payload})=>dispatch({type:"list_owner/deleteData", payload:payload})
  }
}

@connect(mapStateToProps,mapDispatchToProps)
class ownerList extends Component{
  state={
    addVisible:false
  }
  showAddModel=()=>{
    this.setState({addVisible:true});
  }
  handleAddOk = (e) => {
    const { dispatch, form: { validateFields } } = this.props;

    validateFields((err, values) => {
    if (!err) {
      dispatch({
        type: "list_owner/addData",
        payload: values,
      });
      this.setState({ addVisible: false });
      console.log("OK!");
    }
    else{
      console.log("Error!");
    }
  });
  }
  handleDelete = (e) => {
    const { dispatch, form: { validateFields } } = this.props;

    validateFields((err, values) => {
    if (!err) {
      dispatch({
        type: "list_owner/addData",
        payload: values,
      });
      this.setState({ addVisible: false });
      console.log("OK!");
    }
    else{
      console.log("Error!");
    }
  });
  }
  handleAddCancel = (e) => {
    console.log(e);
    this.setState({
      addVisible: false,
    });
  }
  componentDidMount(){
    this.props.fetch();
  }
  render(){
    const { getFieldDecorator } = this.props.form;
    const data = this.props.list_owner.data===undefined?[]:this.props.list_owner.data;//incase data is not passed from backend
    const IconText = ({ type, text }) => (
      <span>
    <Icon type={type} style={{ marginRight: 8 }} />
        {text}
  </span>
    );
    return (
    <div className={styles.list}>
      <Layout itemLayout="vertical">
        <Button type="primary" onClick={this.showAddModel}>
          Add New ...
        </Button>
      </Layout>
      <Modal 
        title="新增用户" 
        visible={this.state.addVisible}
        onOk={this.handleAddOk}
        onCancel={this.handleAddCancel}>
        <Form>
            <Form.Item label="ID">
              {getFieldDecorator('id', {
                rules: [{ required: true }],
              })(
                <Input />
              )}
            </Form.Item>
            <Form.Item label="姓名">
              {getFieldDecorator('name', {
                rules: [{ required: true }],
              })(
                <Input />
              )}
            </Form.Item>
          </Form>
      </Modal>
      <List
        itemLayout="vertical"
        size="large"
        pagination={{
          onChange: (page) => {
            console.log(page);
          },
          pageSize: 3,
        }}
        dataSource={data}
        renderItem={item => (
          <List.Item
            key={item.name}
            actions={[<Button>宠物列表</Button>, <Button onClick={
              ()=> {
                this.props.deleteData({payload:item});
              }
            }>删除用户</Button>]}>
            <List.Item.Meta
              avatar={<Avatar src={display} />}
              title={item.name}
            />
            </List.Item>
        )}
      />
    </div>
    )
  }
}

//export default ownerList;
export default connect(mapStateToProps)(Form.create()(ownerList));
