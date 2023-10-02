import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';import './App.css';
import LoginPage from './components/LoginPage';
import ChatPage from './components/ChatPage';

function App() {
  const [userEmail, setUserEmail] = useState('');

  const handleLogin = (email) => {
    setUserEmail(email);
  };

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/"  element={<LoginPage onLogin={handleLogin} />} />
          <Route path="/chat" element={ <ChatPage userEmail={userEmail} />} />
        </Routes>
      </Router>
      </div>
    );
  //   <div className="App">
  //     {!userEmail ? (
  //       <LoginPage onLogin={handleLogin} />
  //     ) : (
  //       <ChatPage userEmail={userEmail} />
  //     )}
  //   </div>
  // );
}

export default App;
