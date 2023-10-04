import React from 'react';

const Friend = ({ friend, onSelect }) => {
  return (
    <button className='friends' onClick={() => onSelect(friend)}>
      {friend}
    </button>
  );
};

export default Friend;
