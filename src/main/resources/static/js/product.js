//获得所有数据
function getAllProduct(ur) {
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
                ,{field:'product_id', title:'物料编号', width:100}
                ,{field:'product_name', title:'物料名称', templet: '#usernameTpl'}
                ,{field:'product_type', title:'物料类型'}
                ,{field:'product_brand', title:'品牌'}
                ,{field:'product_price', title: '物料单价', minWidth:120}
                ,{field:'product_number', title:'数量'}
                ,{field:'unit', title:'计量单位'}
                ,{field:'product_supplierId', title:'供应商'}
                ,{field:'product_description', title:'描述'}
                ,{field:'product_state', title:'状态', width:85,templet: '#checkboxTpl'}
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
            console.log("product_id="+obj.data.product_id)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    deleteProduct(obj.data.product_id)
                });
            } else if(obj.event === 'edit'){

                console.log("updateProduct")
                $("#update_products_id").val(obj.data.product_id)
                $("#update_product_id").val(obj.data.product_id)
                $("#update_product_name").val(obj.data.product_name)
                $("#update_product_type").val(obj.data.product_type)
                $("#update_product_brand").val(obj.data.product_brand)
                $("#update_product_price").val(obj.data.product_price)
                $("#update_product_number").val(obj.data.product_number)
                $("#update_unit").val(obj.data.unit)
                $("#update_product_description").val(obj.data.product_description)
                $("#update_product_state").val(obj.data.product_state)
                $("#update_product_supplierId").val(obj.data.product_supplierId)
                $('#updatePro').modal('')
                $('#updatePro').modal('open')

            }
        });
    });

}

$(document).ready(function(){
    console.log("ddd")
    getAllProduct('/getAllProduct');
    Materialize.updateTextFields();

})

//上传文件事件
function uploadEx() {
    console.log("ssss")
    $('#importFile').modal('')
    $('#importFile').modal('open')
}
//添加弹框
function addProduct() {
    console.log("addProduct")
    $('#addPro').modal('')
    $('#addPro').modal('open')
}
//搜索事件
function searchProduct() {
   //获得搜索内容
    var searchText =  $("#searchText").val()
   //获得搜索种类
    var obj = $("#searchContant option:selected");
    var searchContant_val=obj.val();//获得选中的value
    //根据种类调用函数
    switch (searchContant_val){
        case 'searchId':
            console.log(searchContant_val);
            var ul = "/getProductById/"+ searchText
            console.log(ul)
            getAllProduct(ul)
            break;
        case 'searchName':
            console.log(searchContant_val);
            var ul = "/getProductByName/"+ searchText
            console.log(ul)
            getAllProduct(ul)
            break;
        case 'searchType':
            var ul = "/getProductByType/"+ searchText
            getAllProduct(ul)
            break;
        case 'searchBrand':
            var ul = "/getProductByBrand/"+ searchText
            getAllProduct(ul)
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
function deleteProduct(product_id) {
    $.ajax({
        url:"/deleteProduct",
        data:{"product_id":product_id},
        success:function (data) {
            alert("删除成功！")
        },
        error:function (data) {
            console.log("error")
        }
    })
}



