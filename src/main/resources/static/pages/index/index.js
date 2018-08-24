"use strict";

var pageIndex = 1;
var pageSize = 8;

var totalPages = 0;
var totalRecords = 0;
$(function () {
    new Vue({
        el: '#app',
        data: {
            users: [],
            searchVal: '',
            totalPages: totalPages,
            totalRecords: totalRecords
        },
        created: function () {
            let rtnData = getUser();
            this.users = rtnData.list;
            this.totalPages = rtnData.totalPages;
            this.totalRecords = rtnData.totalRecords;
        },
        methods: {
            search: function (event) {
                let rtnData = getUser(this.searchVal);
                this.users = rtnData.list;
                this.totalPages = rtnData.totalPages;
                this.totalRecords = rtnData.totalRecords;
            },
            getUser:function (uid){
                let rtnData;
                let request = {
                    uid: uid,
                    pageIndex: pageIndex,
                    pageSize: pageSize
                }
                post(commonUrl + 'user/list', request, function (data) {
                    if (data.rtnCode == 'E000000') {
                        rtnData = data
                    } else {
                        rtnData = null;
                    }
                }, null, false);
                return rtnData;
            }
        }
    });
})
