import { Layout, Menu, Breadcrumb } from 'antd';
import {Link} from "umi";

const { Header, Content, Footer } = Layout;

function BasicLayout(props) {
  return (
    <Layout className="layout">
      <Header>
        <div className="logo" />
        <Menu
          theme="dark"
          mode="horizontal"
          // defaultSelectedKeys={['2']}
          style={{ lineHeight: '64px' }}
        >
          <Menu.Item key="1"><Link to="/owners">Owner</Link></Menu.Item>
          <Menu.Item key="2"><Link to="/pets">Pet</Link></Menu.Item>
          <Menu.Item key="3"><Link to="/services">Service</Link></Menu.Item>
        </Menu>
      </Header>
      <Content style={{ padding: '0 50px' }}>
        <div style={{ background: '#fff', padding: 24, minHeight: 800 }}>{props.children}</div>
      </Content>
    </Layout>
  );
}

export default BasicLayout;
