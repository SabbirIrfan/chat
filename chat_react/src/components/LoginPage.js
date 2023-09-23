import React, { useState } from 'react';

function LoginPage({ onLogin }) {
  const [email, setEmail] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleLogin = () => {
    // Basic validation (you can enhance it)
    if (email.trim() !== '') {
      onLogin(email);
    }
  };

  return (
    <div className="login-page">
      <h2>Login</h2>
      <input
        type="text"
        placeholder="Enter your email"
        value={email}
        onChange={handleEmailChange}
      />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default LoginPage;
