'use strict';

import $ from "jquery";
import {beforeSendAjax} from "./common/lib";
import {HOST} from "./common/const";
import {hot} from 'react-hot-loader/root'

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

    constructor(props) {
        super(props);
        $.ajax({
            type: 'POST',
            url: 'test',
            data: 'test_id=123',
            beforeSend: beforeSendAjax,
            success: function (response) {
                console.log(response);
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

    logout() {
        $.ajax({
            type: 'POST',
            url: 'logout',
            beforeSend: beforeSendAjax,
            success: function () {
                window.location = 'http://' + HOST + '/login?logout';
            }
        });
    };

    render() {
        return (
            <div>
                <h2 className='test-ccs-class'>Привет {getLogin()}!</h2>

                <input type="submit" value="Sign Out" onClick={this.logout}/>

            </div>
        )
    }
}

const App1 = new App();

ReactDOM.render(hot(App1), document.getElementById('react'));

