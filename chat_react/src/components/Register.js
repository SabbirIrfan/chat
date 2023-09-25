import React, { useState } from 'react';

function Register({ onLogin }) {
  const [email, setEmail] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };
  const handleFirstNameChange = (e)=>{
    setFirstName(e.target.value);

  }
  const handleLastNameChange = (e)=>{
    setLastName(e.target.value);
    
  }
  const handleRegister = () => {
    // Basic validation (you can enhance it)
    if (email.trim() !== '') {
      onLogin(email);
      alert("Please Log in now with your Email");
    }
    const newUser = {
        "email": `${email}`,
        "name": `${firstName}`,
        "lastName": `${lastName}`
    }
    fetch(`http://localhost:8080/auth/register`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(newUser)

    }).then(()=>{
    console.log("New Student added")
    })
    }

  

  return (
    <div >
      <h2>Register</h2>
     
      <input
        type="text"
        placeholder="First Name"
        value={firstName}
        onChange={handleFirstNameChange}
      />
       <input
        type="text"
        placeholder="Last Name"
        value={lastName}
        onChange={handleLastNameChange}
      />
       <input
        type="text"
        placeholder="Enter your email"
        value={email}
        onChange={handleEmailChange}
      />
      <button onClick={handleRegister}>SignUp</button>
    </div>
  );
}

export default Register;
