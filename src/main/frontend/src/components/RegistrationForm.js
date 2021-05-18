import React, { Component, setState, redirectToHome, useState} from "react";
import axios from "axios";

class RegistrationForm extends Component{
    constructor(props){
        super(props);
        this.state = {
            username : "",
            password : "",
            confirmPassword: ""
        }
    }

handleChange = (e) => {
        const {id , value} = e.target   
        this.setState(prevState => ({
            ...prevState,
            [id] : value
        }))
    }

handleSubmit = (e) => {
    e.preventDefault();
    if(this.state.password === this.state.confirmPassword){
        this.sendData();
    } else{
        console.log("Passwords need to match!");
    }
}

sendData = () => {
    if(this.state.username.length && this.state.password.length) {
        const payload={
            "username":this.state.username,
            "password":this.state.password,
        }
        axios.post("http://localhost:8080/register", payload)
            .then(function (response) {
                if(response.status === 200){
                    setState(prevState => ({
                        ...prevState,
                        'successMessage' : 'Registration successful. Redirecting to home page..'
                    }))
                    redirectToHome();
                } else{
                    console.log("Error ocurred");
                }
            })
            .catch(function (error) {
                console.log(error);
            });    
    } else {
        console.log('Please enter valid username and password')    
    }
}

    render(){
        return(
            <div className="card col-16 col-lg-4 login-card mt-2 hv-center">
            <form onSubmit={this.handleSubmit}>
                <div className="form-group text-left">
                <label htmlFor="username">Username</label>
                <input type="text" 
                       className="form-control" 
                       id="username" 
                       aria-describedby="usernameHelp" 
                       placeholder="Enter username"
                       value={this.state.username}
                       onChange={this.handleChange}
                />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="password">Password</label>
                    <input type="password" 
                        className="form-control" 
                        id="password" 
                        placeholder="Password"
                        value={this.state.password}
                       onChange={this.handleChange}
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="password">Confirm Password</label>
                    <input type="password" 
                        className="form-control" 
                        id="confirmPassword" 
                        placeholder="Confirm Password"
                        value={this.state.confirmPassword}
                       onChange={this.handleChange}
                    />
                </div>
                <button 
                    type="submit" 
                    className="btn btn-primary"
                >
                    Register
                </button>
            </form>
        </div>
        )
    }
}

export default RegistrationForm;