import React, { useState } from 'react';
import Slider from 'react-slick';
import styled from "styled-components";
import { useNavigate } from 'react-router-dom';
import Register from './Register';
import { AppBar,Card } from '@material-ui/core';
import { ArrowLeftOutlined, ArrowRightOutlined } from "@mui/icons-material";
import { sliderItems } from "../data/data";

const Container = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  /* background-color: coral; */
  position: relative;
  overflow: hidden;
`;

const Arrow = styled.div`
  width: 50px;
  height: 50px;
  background-color: #5d7997;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 0;
  bottom: 0;
  margin: auto;
  cursor: pointer;
  opacity: 0.5;
  z-index: 2;
  left: ${(props) => props.direction === "left" && "10px"};
  right: ${(props) => props.direction === "right" && "10px"};
`;

const Wrapper = styled.div`
  height: 100%;
  display: flex;
  transition: all 1.5s ease;
  transform: translateX(${(props) => props.slideIndex * -100}vw);
`;

const Slide = styled.div`
  width: 70vw;
  height: 100vh;
  display: flex;
  align-items: left;
  background-color: #${(props) => props.bg};
`;

const ImgContainer = styled.div`
  height: 100%;
  flex: 1;
`;

const Image = styled.img`
  height: 80%;
  background-image: url('https://i.ibb.co/3fjhCLm/istockphoto-1415118219-1024x1024.jpg'); 
`;

const InfoContainer = styled.div`
  flex: 1;
  padding: 50px;
`;

const Title = styled.h1`
  font-size: 70px;

`;

const Desc = styled.p`

  margin: 0px 0px;
  font-size: 20px;
  font-weight: 500;
  letter-spacing: 2px;
`;




function LoginPage({ onLogin }) {
  const [email, setEmail] = useState('');
  const [slideIndex, setSlideIndex] = useState(0);
  const handleClick = (direction) => {
    if (direction === "left") {
      setSlideIndex(slideIndex > 0 ? slideIndex - 1 : 1);
    } else {
      setSlideIndex(slideIndex < 1 ? slideIndex + 1 : 0);
    }
  };
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

  const handleSliderLeft = ()=>{

  }
  const handleSliderRight = ()=>{
    
  }

  return (
    <div className="login-page">
           <AppBar />

         
          <div className="login-page">
      <div className='login-portion'>
        <h4>  </h4>
      <h2>Login</h2>
      <input
        type="text"
        placeholder="Enter your email"
        value={email}
        onChange={handleEmailChange}
      />
      <button onClick={handleLogin}>Login</button>
      
      
      <Register onLogin={handleRegister} />
      </div>
      {/* <div className="slider">
         
           <h1> This is existing feature</h1>
         
       </div> */}
      




       </div>

      <div className="slider-container">
      <Container>
      <Arrow direction="left" onClick={() =>  handleClick("left")}>
        <ArrowLeftOutlined />
      </Arrow>
      <Wrapper slideIndex={slideIndex}>
        {sliderItems.map((item) => (
          <Slide bg={item.bg} key={item.id}>
            {/* <ImgContainer>
              <Image src={item.img} />
            </ImgContainer> */}
            <InfoContainer>
              <Title>{item.title}</Title>
              <Desc>{item.desc}</Desc>
            </InfoContainer>
          </Slide>
        ))}
      </Wrapper>
      <Arrow direction="right" onClick={() => handleClick("right")}>
        <ArrowRightOutlined />
      </Arrow>
    </Container>

    </div>

    </div>
  );
}

export default LoginPage;
