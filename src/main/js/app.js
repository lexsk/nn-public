'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

    render() {
        return (
            <h2 className='test-ccs-class'>11Привет123!</h2>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('react'));

