'use strict';

import $ from "jquery";

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

    constructor(props) {
        super(props);
        $.ajax({
            type: 'POST',
            url: 'test',
            data: 'test_id=123',
            success: function (response) {
                console.log(response);
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

    render() {
        return (
            <h2 className='test-ccs-class'>11Привет123!</h2>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('react'));

