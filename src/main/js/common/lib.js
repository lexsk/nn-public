import $ from "jquery";

export function beforeSendAjax(xhr) {
    let token = $('#_csrf').attr('content');
    let header = $('#_csrf_header').attr('content');
    xhr.setRequestHeader(header, token);
}