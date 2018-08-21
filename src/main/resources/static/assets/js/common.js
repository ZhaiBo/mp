var commonUrl = "http://localhost:8080/";

function post(requestUrl, request,succCallback, errCallback, asy) {
    let data = JSON.stringify(request);
    if(requestUrl.indexOf('http') > -1 || requestUrl.indexOf('https') > -1) {
        requestUrl = requestUrl;
    } else {
        requestUrl = url + requestUrl;
    }

    console.log("data:" + data);
    if(succCallback == null) {
        succCallback = function(data, status) {
            console.log(data);
        }
    }
    if(errCallback == null) {
        errCallback = function(xhr, type, exception) {
            alert("超时");
            return;
        }
    }
    if(asy == null || asy == "") {
        asy = false;
    } else {
        asy = asy;
    }
    $.ajax({
        url: requestUrl,
        type: 'POST',
        contentType: 'application/json;charset=utf-8',
        data: data,
        async: asy,
        dataType: 'json',
        timeout: 6000 * 10,
        crossDomain: true,
        success: succCallback,
        error: errCallback
    });
}