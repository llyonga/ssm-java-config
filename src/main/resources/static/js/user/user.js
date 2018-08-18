$(function() {
    initTable();
});

function initTable() {
    var setting = {
        // search: true,//显示搜索框
        url: contextPath+'/user/getList',
        // expandAll: true,
        // expandColumn: "2",
        columns: [{
            field: 'op',
            title: '选择',
            align: 'center',
            valign: 'middle',
            radio: true
        }, {
            title: '序号',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'userId',
            title: '用户ID',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'username',
            title: '用户名',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'password',
            title: '密码',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'deptId',
            title: '部门ID',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'email',
            title: '邮箱',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'mobile',
            title: '电话',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
            valign: 'middle',
            sortable: true,
            // 格式化状态
            formatter: function statusFormatter(value, row, index) {
                if (value === 1) {
                    return '<span class="label label-success">正常</span>';
                } else {
                    return '<span class="label label-default">锁定</span>';
                }
            }
        }, {
            field: 'crateTime',
            title: '创建时间',
            align: 'center',
            valign: 'middle',
            sortable: true,
            //获取日期列的值进行转换
            formatter: function (value, row, index) {
                return timestampDateFormat(value);
            }
        }, {
            field: 'lastLoginTime',
            title: '登录时间',
            align: 'center',
            valign: 'middle',
            sortable: true,
            //获取日期列的值进行转换
            formatter: function (value, row, index) {
                return timestampDateFormat(value);
            }
        }, {
            field: 'ssex',
            title: '性别',
            align: 'center',
            valign: 'middle',
            sortable: true
        },{
            field: 'theme',
            title: '主题',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'avatar',
            title: '作者',
            align: 'center',
            valign: 'middle',
            sortable: true,
            formatter: function(value,row,index){
                var u = contextPath + "/static/assets/img/"+value;
                return '<img  src="'+u+'"  class="img-circle">';
            }
        }, {
            field: 'description',
            title: '描述',
            align: 'center',
            valign: 'middle',
            sortable: true
        }]
    };

    $B_table.initTable('table1', setting);
}


//查询
$(document).on('click', "#btn_search",function(){
    searchTable('table1','query_form');
});

//重置
$(document).on('click',"#btn_rest",function () {
    resetForm("query_form");
});

//修改
$(document).on('click',"#btn_edit",function () {
    var row = $("#table1").bootstrapTable('getSelections');
    console.log(row);
});


