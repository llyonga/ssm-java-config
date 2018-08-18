
$(function() {
    var setting = {
        data : {
            key : {
                name: "menuName",
                url: "url"
            },
            simpleData : {
                enable: true,
                idKey: "menuId",
                pIdKey: "parentId",
                rootPId: 0
            }
        }
    };
    var treeNodes;
    $.ajax({
        type : "post",
        url : contextPath+'/menu/getList',
        success : function(data) {
            // window.toastr.info("获取数据成功！");
            console.log(data);
            treeNodes = data;
            $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            treeObj.expandAll(true);
        },
        error : function() {
            window.toastr.error("请求失败","",{"positionClass": "toast-top-center"});
        }
    });
});






// $(function() {
//     // initTable();
//
//     var setting = {	};
//
//     var zNodes =[
//         { name:"父节点1 - 展开", open:true,
//             children: [
//                 { name:"父节点11 - 折叠",
//                     children: [
//                         { name:"叶子节点111"},
//                         { name:"叶子节点112"},
//                         { name:"叶子节点113"},
//                         { name:"叶子节点114"}
//                     ]},
//                 { name:"父节点12 - 折叠",
//                     children: [
//                         { name:"叶子节点121"},
//                         { name:"叶子节点122"},
//                         { name:"叶子节点123"},
//                         { name:"叶子节点124"}
//                     ]},
//                 { name:"父节点13 - 没有子节点", isParent:true}
//             ]},
//         { name:"父节点2 - 折叠",
//             children: [
//                 { name:"父节点21 - 展开", open:true,
//                     children: [
//                         { name:"叶子节点211"},
//                         { name:"叶子节点212"},
//                         { name:"叶子节点213"},
//                         { name:"叶子节点214"}
//                     ]},
//                 { name:"父节点22 - 折叠",
//                     children: [
//                         { name:"叶子节点221"},
//                         { name:"叶子节点222"},
//                         { name:"叶子节点223"},
//                         { name:"叶子节点224"}
//                     ]},
//                 { name:"父节点23 - 折叠",
//                     children: [
//                         { name:"叶子节点231"},
//                         { name:"叶子节点232"},
//                         { name:"叶子节点233"},
//                         { name:"叶子节点234"}
//                     ]}
//             ]},
//         { name:"父节点3 - 没有子节点", isParent:true}
//
//     ];
//     $.fn.zTree.init($("#treeDemo"), setting, zNodes);
// });
//
// var $tb = $('#table1');
//
// function initTable() {
//     var setting = {
//         // search: true,//显示搜索框
//         url: contextPath+'/menu/getList',
//         height: 850,
//         striped: true,
//         sidePagination: 'server',
//         idField: 'id',
//         // expandAll: true,
//         // expandColumn: "1",
//         columns: [{
//             field: '',
//             checkbox: true
//         }, {
//             field: 'name',
//             title: '菜单名称',
//             align: 'center',
//             valign: 'middle',
//         }, {
//             field: 'status',
//             title: '状态',
//             sortable: true,
//             align: 'center',
//             formatter: function (value, row, index) {
//                 if (value === 1) {
//                     return '<span class="label label-success">正常</span>';
//                 } else {
//                     return '<span class="label label-default">锁定</span>';
//                 }
//             }
//         }, {
//             field: 'permissionValue',
//             title: '权限值',
//             sortable: true,
//             align: 'center',
//             valign: 'middle',
//         }],
//         treeShowField: 'name',
//         parentIdField: 'pid',
//         onLoadSuccess: function(data) {
//             console.log(data);
//             // jquery.treegrid.js
//             $tb.treegrid({
//                 // initialState: 'collapsed',
//                 treeColumn: 1,
//                 // expanderExpandedClass: 'glyphicon glyphicon-minus',
//                 // expanderCollapsedClass: 'glyphicon glyphicon-plus',
//                 onChange: function() {
//                     // $tb.bootstrapTable('resetWidth');
//                 }
//             });
//         }
//     };
//
//     $tb.bootstrapTable(setting);
//     // $B_table.initTable('table1', setting);
// }
//
//
// //查询
// $(document).on('click', "#btn_search",function(){
//     searchTable('table1','query_form');
// });
//
// //重置
// $(document).on('click',"#btn_rest",function () {
//     resetForm("query_form");
// });
//
// //修改
// $(document).on('click',"#btn_edit",function () {
//     var row = $("#table1").bootstrapTable('getSelections');
//     console.log(row);
// });
//
//
//
//
