import logo from '../logo.svg';
import '../css/app.css';
import axios from "axios";
import React, {useState, useEffect} from "react";
import Header from './Header.js';
import Home from './Home.js';
import RegistrationForm from './RegistrationForm';
import LoginForm from './LoginForm';
import { BrowserRouter, Route, Switch } from 'react-router-dom';



function App() {
  return (
    <div className="App">
      <Header />
      <BrowserRouter>
        <Switch>
          <Route path="/register">
            <RegistrationForm />
          </Route>
          <Route path="/home">
            <Home />
          </Route>
          <Route path="/login">
            <LoginForm />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
