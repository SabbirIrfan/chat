import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faHeart ,faCodeBranch} from '@fortawesome/free-solid-svg-icons';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="container">
        <p>&copy; 2023 ChatApp</p>
        <div className="social-icons">
          <a href="#">
            <FontAwesomeIcon icon={faEnvelope} /> Contact Us
          </a>
          <a href="#">
            <FontAwesomeIcon icon={faHeart} /> Made with Love
          </a>
          <a href="#">
          <FontAwesomeIcon icon={faCodeBranch} /> Career
          </a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
