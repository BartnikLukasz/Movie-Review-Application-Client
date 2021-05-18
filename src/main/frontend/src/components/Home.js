import logo from '../logo.svg';
import '../css/app.css';
import axios from "axios";
import React, {useState, useEffect, Component} from "react";
import Header from './Header.js';

const UserProfiles = () =>{

    const [userProfiles, setUserProfiles] = useState([]);
  
    const fetchUserProfiles = () => {
      axios.get("http://localhost:8080/users").then(res => {
        console.log(res);
        setUserProfiles(res.data);
      });
    };
  
    useEffect(() => {
      fetchUserProfiles();
    }, []);
  
    return userProfiles.map((userProfile, index) => {
      return (
        <div key={index}>
          <p>{userProfile.username}</p>
          <p>{userProfile.id}</p>
        </div>
      )
    });
  
  };

  class Home extends Component{
      render(){
          return(
            <div className="main">
            <UserProfiles />
          </div>
          )
      }
  }

  export default Home;