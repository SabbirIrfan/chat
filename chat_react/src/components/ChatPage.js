import React, { useState,useEffect } from 'react';
import ChatMessages from './ChatMessages'; // Import the ChatMessages component
import { Sync } from '@material-ui/icons';

function ChatPage({ userEmail }) {
  const  [mainUser,setMainUser] = useState('');
  
  const [friends, setFriends] = useState([]);
  const [newFriend, setNewFriend] = useState('');
  const [messages, setMessages] = useState([]); // Add a state for messages
//   const [email,setEmail] = useState(userEmail);
  const [chatterName, setChatterName] = useState('');
  const [chatterEmail, setChatterEmail] = useState('');

  const [chatId,setChatId] = useState();


useEffect(()=>{
    console.log(userEmail);
    if(!userEmail) return;

    fetch(`http://localhost:8080/user/getAllFriend/${userEmail}`)
    .then(
      (response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json(); // Attempt to parse the response as JSON
      }
    )
    .then((result)=>{
        
      setFriends(result);
    }
  )
  fetch(`http://localhost:8080/user/email/${userEmail}`)
    .then(
      (response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json(); // Attempt to parse the response as JSON
      }
      )
    .then((result)=>{
        console.log(result);
      setMainUser(result);
    }
  )
  
  },[])
//   useEffect(()=>{

//     try {
//         handleShowMessage();
//     } catch (error) {
//         console.log(error);
//     }
        
  
//   },[])
  
  const  handleShowMessage = ( id) =>{
    console.log("fetched chat id? in show message")
    console.log(id)
    if(!id) {
        return;
    }
    try {
    
      fetch(`http://localhost:8080/message/getAllMessage/${id}`)
      .then(
        (response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json(); // Attempt to parse the response as JSON
        }
      )
      .then((result)=>{
          
           
          let msg =[];
  
          
          result.forEach(element => {
              msg.push(element.content);
          });
          console.log(msg);
          if(msg.length == 0) return;
          setMessages(msg);
      })  ;
    } catch (error) {
      console.log(error);
    }
    
    

  };
  const handleAddFriend = () => {
    
    fetch(`http://localhost:8080/user/addFriend/${userEmail}/${newFriend}`,{
      method:"PUT",
      headers:{"Content-Type":"application/json"},
      
      body:JSON.stringify()
      
    }).then(()=>{
      console.log("New friend added")
    })
    if (newFriend.trim() !== '') {
      setFriends([...friends, newFriend]);
      setNewFriend('');
    }
    setChatterName(newFriend);
    getChatId();
  };
  
//   const handleClick=(e)=>{
//     e.preventDefault()
//     const user = {newFriend}
//     fetch(`http://localhost:8080/user/addFriend/${userEmail}/${newFriendd}`,{
//       method:"POST",
//       headers:{"Content-Type":"application/json"},
//       body:JSON.stringify(user)

//   }).then(()=>{
//     console.log("New Student added")
//   })
// }

const getChatId = ()=>{
    console.log("fetching chat Id");
    
    console.log("chatter email is "+ chatterEmail+" userEmail is "+ userEmail);
    if(!chatterEmail || !userEmail) 
    {
        alert("no chat selected , try again");
        return;

    }
    try {
      fetch(`http://localhost:8080/message/getChatId/${userEmail}/${chatterEmail}`)
    .then(
      (response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json(); // Attempt to parse the response as JSON
      }
    )
    .then((result)=>{
        
      setChatId(result.id);
      console.log(chatId);


    });
    } catch (error) {
      console.log(error);
    }
    
    handleShowMessage(chatId);
    // console.log(list2);

}

const handleChatter =  (name)=>{

    setChatterName(name);
    console.log(chatterName);
    getChatId();
    

}

  const handleSendMessage = (text) => {
    if(!chatId) return;


    console.log(text);
    if(text === "") {
      try {
        fetch(`http://localhost:8080/message/addMessage`,{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(message)
        }).then(()=>{
        })  
      } catch (error) {
        console.log(error);
      }
      return;
    }
    getChatId();
    console.log(chatId);
    const currentLocalDateTime = new Date();
    let message ;
    try {
       message = {
        "chatId": `${chatId}`,
        "senderName" : `${mainUser.name}`,
        "content" : `${text}`
        
        }  
    } catch (error) {
      console.log("in send message");
    }
    
    try {
      fetch(`http://localhost:8080/message/addMessage`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(message)
      }).then(()=>{
      })  
    } catch (error) {
      console.log(error);
    }
    
    if (text.trim() !== '') {
    
      // Create a new message object and add it to the messages state
    
      setMessages([...messages, text]);
    }
  };


  const getChtterMail = (value) =>{
    console.log(value.type + "------- " + value)
    if(!value) {
      alert("please type the friend name properly and press enter twice");
      return;
    }
    try {
      fetch(`http://localhost:8080/user/name/${value}`)
    .then(
      (response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json(); // Attempt to parse the response as JSON
      }
    )
    .then((result) =>{
        console.log("chat email is fetching  ");
        console.log(result.email);
        setChatterEmail(result.email);
    })  
    } catch (error) {
      console.log(error);
    }
    
  }
  const handleSetChat = (value) =>{
    
    getChtterMail(value);

    // setChatterName(value);

    console.log("chatter email is "+ chatterEmail);
    getChatId();
  }



  return (
    <div className="chat-page">
     <div className="friend-list">
     <input
          id="set-chat"
          type="text"
          placeholder="Enter friend's name to chat with"
          onKeyPress={(e) => {
            if (e.key === 'Enter') {
              handleSetChat(e.target.value);
            }
          }}
          
        />
        
        <h2>Friend List</h2>
        <ul className="contact-list">
          {friends.map((friend, index) => (
            <li id={index}>
            <button className="friend-button" >{friend}</button>
            </li>
          ))}
        </ul>
        <input
          type="text"
          placeholder="Enter friend's name"
          value={newFriend}
          onChange={(e) => setNewFriend(e.target.value)}
        />
        <button onClick={handleAddFriend}>Add Friend</button>
      </div>
      <div className="chat-area">
        <h2>${chatterName}</h2>
        <ChatMessages messages={messages} /> {/* Add the ChatMessages component */}
        <div className="message-input">
          <input
            type="text"
            placeholder="Type your message"
            onKeyPress={(e) => {
              if (e.key === 'Enter') {
                handleSendMessage(e.target.value);
                e.target.value='';
               
              }
            }}
            
          />

          
        </div>
      </div>
    </div>
  );
}

export default ChatPage;
