import React from 'react';
import PropTypes from 'prop-types';

function Button({ text, onClick }) {
  return <button className="button inline" type="button" onClick={onClick}>{ text }</button>;
}

Button.propTypes = {
  text: PropTypes.string.isRequired,
  onClick: PropTypes.func,
};

Button.defaultProps = {
  onClick: () => { },
};

export default Button;
