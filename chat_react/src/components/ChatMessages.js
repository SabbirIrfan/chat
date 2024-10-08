import React from 'react';

import { useRef, useEffect } from 'react';

function ChatMessages({ messages, userName }) {
  const chatContainerRef = useRef(null);

  useEffect(() => {
    chatContainerRef.current.scrollTop = chatContainerRef.current.scrollHeight;
  }, [messages]);

  return (
    <div className="chat-messages" ref={chatContainerRef}>
      {messages.map((message, index) => (
        <div key={index} >
          {userName === message.senderName ? (
       <p className='message-i'>{message.content} </p>
      ) : (
        <p className='message-u'>{message.content} </p>
      )}
         
          
        </div>
      ))}
    </div>
  );
}

export default ChatMessages;
