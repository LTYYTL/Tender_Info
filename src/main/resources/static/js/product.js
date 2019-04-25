//获得所有数据
function getAllProduct() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        table.render({
            elem: '#test'
            ,url:'/getAllProduct'
            ,cellMinWidth: 80
            ,toolbar: '#toolbarDemo'
            ,cols: [[
                {type: 'checkbox'}
                ,{field:'product_id', title:'物料编号', width:100}
                ,{field:'product_name', title:'物料名称', templet: '#usernameTpl'}
                ,{field:'product_type', title:'物料类型'}
                ,{field:'product_brand', title:'品牌'}
                ,{field:'product_price', title: '价格', minWidth:120}
                ,{field:'product_number', title:'数量'}
                ,{field:'unit', title:'单位'}
                ,{field:'product_supplierId', title:'供应商'}
                ,{field:'product_description', title:'描述'}
                ,{field:'product_state', title:'状态', width:85, templet: '#checkboxTpl'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
        });


        //监听锁定操作
        form.on('checkbox(lockDemo)', function(obj){
            layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });
    });

    //头工具栏事件
    // table.on('toolbar(test)', function(obj){
    //     var checkStatus = table.checkStatus(obj.config.id);
    //     switch(obj.event){
    //         case 'getCheckData':
    //             var data = checkStatus.data;
    //             layer.alert(JSON.stringify(data));
    //             break;
    //         case 'getCheckLength':
    //             var data = checkStatus.data;
    //             layer.msg('选中了：'+ data.length + ' 个');
    //             break;
    //         case 'isAll':
    //             layer.msg(checkStatus.isAll ? '全选': '未全选');
    //             break;
    //     };
    // });
}
$(document).ready(function(){
    console.log("ddd")
    getAllProduct();

})

//上传文件事件
function uploadEx() {
    console.log("ssss")
    $('#importFile').modal('')
    $('#importFile').modal('open')
}





