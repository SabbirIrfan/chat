import React from 'react';

import { useRef, useEffect } from 'react';

function ChatMessages({ messages,value }) {
  const chatContainerRef = useRef(null);

  useEffect(() => {
    // Scroll to the bottom of the chat container when messages change
    chatContainerRef.current.scrollTop = chatContainerRef.current.scrollHeight;
  }, [messages]);

  return (
    <div className="chat-messages" ref={chatContainerRef}>
      {messages.map((message, index) => (
        <div key={index} className={`message ${value}`}>
          <p className='message'>{message}</p>
        </div>
      ))}
    </div>
  );
}

export default ChatMessages;
