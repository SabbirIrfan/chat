import React from 'react';

function ChatMessages({ messages }) {
  return (
    <div className="chat-messages">
      {messages.map((message, index) => (
        <div key={index} className={`message ${message.type}`}>
          <p>{message}</p>
        </div>
      ))}
    </div>
  );
}

export default ChatMessages;
