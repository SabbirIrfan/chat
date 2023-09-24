import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Register from './Register';


function LoginPage({ onLogin }) {
  const [email, setEmail] = useState('');

  const Navigate = useNavigate();


  const handleEmailChange = (e) => {
    setEmail(e.target.value);

  };

  const handleLogin = () => {
    // Basic validation (you can enhance it)
    if (email.trim() !== '') {
      onLogin(email);
    }
    Navigate('/chat');

  };
  const handleRegister = () => {
    // Basic validation (you can enhance it)
    if (email.trim() !== '') {
      onLogin(email);
      alert("Please log in now with your email");
    }
  };


  return (
    <div className="login-page">
      <div>
      <h2>Login</h2>
      <input
        type="text"
        placeholder="Enter your email"
        value={email}
        onChange={handleEmailChange}
      />
      <button onClick={handleLogin}>Login</button>
      </div>
      <div>
      <Register onLogin={handleRegister} />
      </div>
    </div>
  );
}

export default LoginPage;
