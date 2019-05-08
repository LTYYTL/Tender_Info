//获得所有数据
function getAllExpert(ur) {
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
                ,{field:'expert_id', title:'专家编号', width:100}
                ,{field:'expert_name', title:'专家姓名', templet: '#usernameTpl'}
                ,{field:'expert_age', title:'年龄'}
                ,{field:'expert_sex', title:'性别'}
                ,{field:'expert_iphone', title:'手机号'}
                ,{field:'expert_profession', title:'专业'}
                ,{field:'expert_level', title: '级别', minWidth:120}
                ,{field:'expert_price', title:'费用'}
                ,{field:'expert_info', title:'专家信息'}
                ,{field:'expert_state', title:'状态', width:85,templet: '#checkboxTpl'}
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
            console.log("expert_id="+obj.data.expert_id)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    deleteExpert(obj.data.expert_id)
                });
            } else if(obj.event === 'edit'){

                console.log("updateExpert")
                $("#update_experts_id").val(obj.data.expert_id)
                $("#update_expert_id").val(obj.data.expert_id)
                $("#update_expert_name").val(obj.data.expert_name)
                $("#update_expert_profession").val(obj.data.expert_profession)
                $("#update_expert_age").val(obj.data.expert_age)
                $("#update_expert_level").val(obj.data.expert_level)
                $("#update_expert_price").val(obj.data.expert_price)
                $("#update_expert_info").val(obj.data.expert_info)
                $("#update_expert_sex").val(obj.data.expert_sex)
                $("#update_expert_iphone").val(obj.data.expert_iphone)
                $("#update_expert_state").val(obj.data.expert_state)
                $('#updateExp').modal('')
                $('#updateExp').modal('open')

            }
        });
    });

}

$(document).ready(function(){
    console.log("ddd")
    getAllExpert('/getAllExpert');
    Materialize.updateTextFields();

})

//上传文件事件
function uploadEx() {
    console.log("ssss")
    $('#importFile').modal('')
    $('#importFile').modal('open')
}
//添加弹框
function addExpert() {
    console.log("addExpert")
    $('#addExp').modal('')
    $('#addExp').modal('open')
}
//搜索事件
function searchExpert() {
    //获得搜索内容
    var searchText =  $("#searchText").val()
    //获得搜索种类
    var obj = $("#searchContant option:selected");
    var searchContant_val=obj.val();//获得选中的value
    //根据种类调用函数
    switch (searchContant_val){
        case 'searchId':
            console.log(searchContant_val);
            var ul = "/getExpertById/"+ searchText
            console.log(ul)
            getAllExpert(ul)
            break;
        case 'searchName':
            console.log(searchContant_val);
            var ul = "/getExpertByName/"+ searchText
            console.log(ul)
            getAllExpert(ul)
            break;
        case 'searchProfession':
            var ul = "/getExpertByProfession/"+ searchText
            getAllExpert(ul)
            break;
        case 'searchLevel':
            var ul = "/getExpertByLevel/"+ searchText
            getAllExpert(ul)
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
        case 'searchProfession':
            console.log(searchContant_val);

            break;
        case 'searchLevel':
            console.log(searchContant_val);
            break;
    }
}

//删除物料
function deleteExpert(expert_id) {
    $.ajax({
        url:"/deleteExpert",
        data:{"expert_id":expert_id},
        success:function (data) {
            alert("删除成功！")
        },
        error:function (data) {
            console.log("error")
        }
    })
}



