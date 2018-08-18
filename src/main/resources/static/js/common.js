var $B_table = (function(){
    var bootstrapTable_default= {
        method: 'post',
        // contentType: "application/x-www-form-urlencoded",
        height: 850,//高度调整
        cache: false,
        sortable: true,
        striped: true, //是否显示行间隔色
        pagination: true,//是否分页
        sidePagination: 'server',
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 10,//单页记录数
        pageList: [5, 10, 20, 30],//分页步进值
        //默认是limit，对应的参数是limit和offset，如果需要pageNumber和pageSize，设为空
        queryParamsType: '',
        showRefresh: true,//刷新按钮
        showColumns: true,
        clickToSelect: true,//是否启用点击选中行
        buttonsAlign: 'right',//按钮对齐方式
        uniqueId: "ID",
        toolbarAlign: 'right',
        toolbar: '#toolbar',//指定工作栏
        cardView: false,
        detailView: false,
        smartDisplay: false,
        //显示导出插件
        showExport: true,
        exportDataType: 'all',
        exportTypes:[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],  //导出文件类型
        //请求服务数据时所传参数
        queryParams: function (params) {
            return {
                sortName: params.sortName,
                sortOrder: params.sortOrder,
                //页面大小
                pageSize : params.pageSize,
                //页码
                pageNumber : params.pageNumber
            };
        }
    };


    function _initTable(id,settings) {
        var params = $.extend({}, bootstrapTable_default, settings);
        if (typeof params.url === 'undefined') {
            throw '初始化表格失败，请配置url参数！';
        }
        if (typeof params.columns === 'undefined') {
            throw '初始化表格失败，请配置columns参数！';
        }
        $('#' + id).bootstrapTable(params);
        // $(window).resize(function () {
        //     $("#table1").bootstrapTable('resetView');
        // });
    }




    return {
        initTable: function (id, setting) {
            _initTable(id, setting);

            //添加table刷新按钮样式
            $("button[name='refresh']").removeClass("btn-default").addClass("btn-primary");

            $("table.table").on("click-row.bs.table",function(e,row,ele){
                $(".info").removeClass("info");
                $(ele).addClass("info");
            });
        }
    }
})();


//定义条件搜索
function searchTable(table_id,form_id) {
    //定义参数
    var search = {};
    //遍历form表单，封装参数json
    $.each($("#"+form_id).serializeArray(),function (i, field) {
        if (field.value != null && field.value != "" && field.value != undefined) {
            search[field.name]=field.value;
        }
    });
    $('#'+table_id).bootstrapTable("refresh",{query : search});
}

//重置表单
function resetForm(form_id) {
    $('#'+form_id).find('[name]').each(function () {
        $(this).val('');
    });
}


//转换table中日期格式(时间戳转换为yyyy-MM-dd HH:mm:ss格式)
function timestampDateFormat(val) {
    if (val == null || val == '' || val ==  undefined || val == 'null') {
        return "";
    }
    var date = new Date(val);
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
}

//实现面板图标切换
$(document).on('click',".my-lnr",function () {
    if ($(".my-lnr").hasClass("lnr-chevron-down")) {
        $(".my-lnr").removeClass("lnr-chevron-down");
    } else {
        $(".my-lnr").addClass("lnr-chevron-down");
    }
});

