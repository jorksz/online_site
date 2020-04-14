/**
 *
 * @param cellval
 * @returns {string}
 */

//时间戳转换函数
function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        //后面的时分秒：  + " " + hours + ":" + minutes + ":" + seconds
    }
}

//获取超链接中的参数
function getUrlParam(name) {

    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象

    var r = window.location.search.substr(1).match(reg);  //匹配目标参数

    if (r != null) return unescape(r[2]);

    return null; //返回参数值

}


//    显示分页
function commonPage(data,videoId,type) {
    var list = data.lists;
    $("#page").empty();
    if (list.length > 0) {

        var totalPage = data.totalPage;//总页数

        var currPage = data.currPage;//当前页数

        var totalCount = data.totalCount;//总记录数

        var pageSize = data.pageSize;//每页显示多少条
        var appendpage = '';

        if (totalPage > 0) {
            var front = currPage - 1;//上一页
            if (front <= 0) {
                front = 1;
            }
//            下一页
            var next = currPage + 1;
            if (next > totalPage) {
                next = totalPage;
            }

            //上一页样式代码
            if (currPage == 1) {
                appendpage += '<li class="paginate_button previous disabled" id="example2_previous"><a aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>';
            } else {
                appendpage += '<li class="paginate_button previous" id="example2_previous"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ (currPage - 1) + ')" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>';
            }


            //总页数小于6的中间页数的代码
            if (totalPage <= 6) {
                for (var i = 1; i <= totalPage; i++) {
                    if (i == currPage) {
                        appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                    } else {
                        appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                    }
                }
            }
            //总页数大于6的HTML
            else {
                //总页数与当前页数相差间隔大于等于6的HTML代码
                if (totalPage - currPage >= 6) {
                    for (var i = currPage; i <= currPage + 5; i++) {
                        //分页代码
                        if (i == currPage) {
                            appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                        } else {
                            appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                        }
                    }
                }
                else {
                    //相隔小于6的HTML，显示总页数之前的6个
                    for (var i = totalPage - 5; i <= totalPage; i++) {
                        if (i == currPage) {
                            appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                        } else {
                            appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                        }
                    }
                }

            }
            //后部分的代码
            if (currPage == totalPage) {
                appendpage += '<li class="paginate_button next" id="example2_next"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ currPage + ')" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>';
            } else {
                appendpage += '<li class="paginate_button next" id="example2_next"><a style="cursor: pointer" onclick="getVideoComment(' + videoId + ',' +type+','+ (currPage + 1) + ')" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>';
            }

            $("#page").empty();
            $("#page").append(appendpage);
        }


    }



}
//搜索视频结果分页
function commonPage1(data,sortId) {
    var list = data.lists;
    $("#page").empty();
    if (list.length > 0) {

        var totalPage = data.totalPage;//总页数

        var currPage = data.currPage;//当前页数

        var totalCount = data.totalCount;//总记录数

        var pageSize = data.pageSize;//每页显示多少条
        var appendpage = '';

        if (totalPage > 0) {
            var front = currPage - 1;//上一页
            if (front <= 0) {
                front = 1;
            }
//            下一页
            var next = currPage + 1;
            if (next > totalPage) {
                next = totalPage;
            }

            //上一页样式代码
            if (currPage == 1) {
                appendpage += '<li class="paginate_button previous disabled" id="example2_previous"><a aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>';
            } else {
                appendpage += '<li class="paginate_button previous" id="example2_previous"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ (currPage - 1) + ')" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>';
            }


            //总页数小于6的中间页数的代码
            if (totalPage <= 6) {
                for (var i = 1; i <= totalPage; i++) {
                    if (i == currPage) {
                        appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                    } else {
                        appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ i+ ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                    }
                }
            }
            //总页数大于6的HTML
            else {
                //总页数与当前页数相差间隔大于等于6的HTML代码
                if (totalPage - currPage >= 6) {
                    for (var i = currPage; i <= currPage + 5; i++) {
                        //分页代码
                        if (i == currPage) {
                            appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ i+ ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                        } else {
                            appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                        }
                    }
                }
                else {
                    //相隔小于6的HTML，显示总页数之前的6个
                    for (var i = totalPage - 5; i <= totalPage; i++) {
                        if (i == currPage) {
                            appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                        } else {
                            appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                        }
                    }
                }

            }
            //后部分的代码
            if (currPage == totalPage) {
                appendpage += '<li class="paginate_button next" id="example2_next"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ currPage + ')" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>';
            } else {
                appendpage += '<li class="paginate_button next" id="example2_next"><a style="cursor: pointer" onclick="getVideoByType(' + sortId + ','+ (currPage + 1) + ')    " aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>';
            }

            $("#page").empty();
            $("#page").append(appendpage);
        }


    }



}

function commonPage2(data,videoname) {
    var list = data.lists;
    $("#page").empty();
    if (list.length > 0) {

        var totalPage = data.totalPage;//总页数

        var currPage = data.currPage;//当前页数

        var totalCount = data.totalCount;//总记录数

        var pageSize = data.pageSize;//每页显示多少条
        var appendpage = '';

        if (totalPage > 0) {
            var front = currPage - 1;//上一页
            if (front <= 0) {
                front = 1;
            }
//            下一页
            var next = currPage + 1;
            if (next > totalPage) {
                next = totalPage;
            }

            //上一页样式代码
            if (currPage == 1) {
                appendpage += '<li class="paginate_button previous disabled" id="example2_previous"><a aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>';
            } else {
                appendpage += '<li class="paginate_button previous" id="example2_previous"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ (currPage - 1) + ')" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>';
            }


            //总页数小于6的中间页数的代码
            if (totalPage <= 6) {
                for (var i = 1; i <= totalPage; i++) {
                    if (i == currPage) {
                        appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                    } else {
                        appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ i+ ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                    }
                }
            }
            //总页数大于6的HTML
            else {
                //总页数与当前页数相差间隔大于等于6的HTML代码
                if (totalPage - currPage >= 6) {
                    for (var i = currPage; i <= currPage + 5; i++) {
                        //分页代码
                        if (i == currPage) {
                            appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoByName(' + videoname+ ','+ i+ ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                        } else {
                            appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                        }
                    }
                }
                else {
                    //相隔小于6的HTML，显示总页数之前的6个
                    for (var i = totalPage - 5; i <= totalPage; i++) {
                        if (i == currPage) {
                            appendpage += '<li class="paginate_button active"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';
                        } else {
                            appendpage += '<li class="paginate_button"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ i + ')" aria-controls="example2" data-dt-idx="1" tabindex="0">' + i + '</a></li>';

                        }
                    }
                }

            }
            //后部分的代码
            if (currPage == totalPage) {
                appendpage += '<li class="paginate_button next" id="example2_next"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ currPage + ')" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>';
            } else {
                appendpage += '<li class="paginate_button next" id="example2_next"><a style="cursor: pointer" onclick="getVideoByName(' + videoname + ','+ (currPage + 1) + ')    " aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>';
            }

            $("#page").empty();
            $("#page").append(appendpage);
        }


    }



}