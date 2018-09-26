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
            <div>
                <p>Click <a href="/hello">here</a> to see a greeting.</p>
                <h2 className='test-ccs-class'>11Привет123!</h2>
                <form action="/logout" method="post">
                    <input type="submit" value="Sign Out"/>
                </form>
            </div>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('react'));

