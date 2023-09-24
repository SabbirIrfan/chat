import React from 'react';

function ChatMessages({ messages,value }) {
  return (
    <div className="chat-messages">
      {messages.map((message, index) => (
        <div key={index} className={`message ${value}`}>
          <p className='message'>{message}</p>
        </div>
      ))}
    </div>
  );
}

export default ChatMessages;
