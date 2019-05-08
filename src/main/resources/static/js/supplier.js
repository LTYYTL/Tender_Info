//获得所有数据
function getAllSupplier(ur) {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        table.render({
            elem: '#test'
            ,url:ur
            ,page: true
            ,toolbar: '#toolbarDemo'
            ,cols: [[
                {type: 'checkbox'}
                ,{field:'supplier_id', title:'供应商编号', width:100}
                ,{field:'supplier_name', title:'供应商名称', templet: '#usernameTpl'}
                ,{field:'type', title:'供应种类'}
                ,{field:'brand', title:'供应品牌'}
                ,{field:'supplier_iphone', title: '联系电话', minWidth:120}
                ,{field:'cooperation_type', title:'合作类型'}
                ,{field:'supplier_location', title:'行政地址'}
                ,{field:'description', title:'描述'}
                ,{field:'blacklist', title:'黑名单', width:85,templet: '#checkboxTpl'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,limit:5
            ,limits:[5,10,15,20]

        });


        //监听锁定操作
        form.on('checkbox(lockDemo)', function(obj){
            layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            console.log("supplier_id="+obj.data.supplier_id)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    deleteSupplier(obj.data.supplier_id)
                });
            } else if(obj.event === 'edit'){

                console.log("updateSupplier")
                $("#update_suppliers_id").val(obj.data.supplier_id)
                $("#update_supplier_id").val(obj.data.supplier_id)
                $("#update_supplier_name").val(obj.data.supplier_name)
                $("#update_supplier_location").val(obj.data.supplier_location)
                $("#update_type").val(obj.data.type)
                $("#update_brand").val(obj.data.brand)
                $("#update_description").val(obj.data.description)
                $("#update_cooperation_type").val(obj.data.cooperation_type)
                $("#update_supplier_iphone").val(obj.data.supplier_iphone)
                $("#update_blacklist").val(obj.data.blacklist)
                $('#updateSup').modal('')
                $('#updateSup').modal('open')

            }
        });
    });

}

$(document).ready(function(){
    console.log("ddd")
    getAllSupplier('/getAllSupplier');
    Materialize.updateTextFields();

})

//上传文件事件
function uploadEx() {
    console.log("ssss")
    $('#importFile').modal('')
    $('#importFile').modal('open')
}
//添加弹框
function addSupplier() {
    console.log("addSupplier")
    $('#addSup').modal('')
    $('#addSup').modal('open')
}
//搜索事件
function searchSupplier() {
    //获得搜索内容
    var searchText =  $("#searchText").val()
    //获得搜索种类
    var obj = $("#searchContant option:selected");
    var searchContant_val=obj.val();//获得选中的value
    //根据种类调用函数
    switch (searchContant_val){
        case 'searchId':
            console.log(searchContant_val);
            var ul = "/getSupplierById/"+ searchText
            console.log(ul)
            getAllSupplier(ul)
            break;
        case 'searchName':
            console.log(searchContant_val);
            var ul = "/getSupplierByName/"+ searchText
            console.log(ul)
            getAllSupplier(ul)
            break;
        case 'searchType':
            var ul = "/getSupplierByType/"+ searchText
            getAllSupplier(ul)
            break;
        case 'searchBrand':
            var ul = "/getSupplierByBrand/"+ searchText
            getAllSupplier(ul)
            break;
        case 'searchCooperation':
            var ul = "/getSupplierByCooperation/"+ searchText
            getAllSupplier(ul)
            break;
    }
}

function changeVl() {
    var obj = $("#searchContant option:selected");
    var searchContant_val=obj.val();
    switch (searchContant_val){
        case 'searchId':
            console.log(searchContant_val);
            break;
        case 'searchName':
            console.log(searchContant_val);
            break;
        case 'searchType':
            console.log(searchContant_val);

            break;
        case 'searchBrand':
            console.log(searchContant_val);
            break;
    }
}

//删除物料
function deleteSupplier(supplier_id) {
    $.ajax({
        url:"/deleteSupplier",
        data:{"supplier_id":supplier_id},
        success:function (data) {
            alert("删除成功！")
        },
        error:function (data) {
            console.log("error")
        }
    })
}



