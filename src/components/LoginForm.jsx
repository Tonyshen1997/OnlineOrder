import { LockOutlined, UserOutlined } from "@ant-design/icons";
import { Button, Form, Input, message } from "antd";
import PropTypes from "prop-types";
import React from "react";
import { login } from "../utils";

class LoginForm extends React.Component {
  state = {
    loading: false,
  };

  onFinish = (data) => {
    this.setState({
      loading: true,
    });

    login(data)
      .then(() => {
        message.success("Login Successful");
        this.props.onSuccess();
      })
      .catch((err) => {
        message.error(err.message);
      })
      .finally(() => {
        this.setState({
          loading: false,
        });
      });
  };

  render() {
    return (
      <Form
        onFinish={this.onFinish}
        style={{
          width: 300,
          margin: "auto",
        }}
      >
        <Form.Item
          name="username"
          rule={[{ requried: true, message: "Please input your Username!" }]}
        >
          <Input prefix={<UserOutlined />} placeholder="Username" />
        </Form.Item>
        <Form.Item
          name="password"
          rules={[{ required: true, message: "Please input your Password!" }]}
        >
          <Input.Password prefix={<LockOutlined />} placeholder="Password" />
        </Form.Item>

        <Form.Item>
          <Button type="primary" htmlType="submit" loading={this.state.loading}>
            Login
          </Button>
        </Form.Item>
      </Form>
    );
  }
}
LoginForm.propTypes = {
  onSuccess: propTypes.func,
};

export default LoginForm;
