"use strict";

$(function () {
    getUser();
})

function getUser() {
    var request = {
        uid:'1'
    }
    post(commonUrl + 'user/get', request, function (data) {
        if (data.rtnCode == 'E000000') {
            //success
            alert(JSON.stringify(data));
        } else {

        }
    }, null, false);
}