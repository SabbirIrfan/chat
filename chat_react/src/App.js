import React, { useState } from 'react';
import './App.css';
import LoginPage from './components/LoginPage';
import ChatPage from './components/ChatPage';

function App() {
  const [userEmail, setUserEmail] = useState('');

  const handleLogin = (email) => {
    setUserEmail(email);
  };

  return (
    <div className="App">
      {!userEmail ? (
        <LoginPage onLogin={handleLogin} />
      ) : (
        <ChatPage userEmail={userEmail} />
      )}
    </div>
  );
}

export default App;
