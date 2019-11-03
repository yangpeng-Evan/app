function levelOne(data,form,$) {
        //1. 获取当前选中的值.
        var id = data.value;

        var content = "<option value=''>请选择二级分类</option>";
        //2. 非空判断.
        if(id == null || id == ""){
            $("#levelTwo").html(content);
            $("#levelThree").html("<option value=''>请选择三级分类</option>");
            form.render('select');
            return;
        }

        //3. 发送ajax请求,并获取当前分类对应的二级分类.
        $.getJSON(
            baseUrl + "dev/app/category-by-parent-id",
            {parentId: id},
            function(result){
                if(result.code == 0){
                    //1. 获取json
                    var jsonArray = result.data;
                    //2. 手动封装成<option value=""></option>
                    for(var i = 0;i < jsonArray.length ;i++){
                        content += "<option value='"+ jsonArray[i].id +"'>"+jsonArray[i].categoryName+"</option>";
                    }
                    //3. 插入到二级分类中.
                    $("#levelTwo").html(content);
                    $("#levelThree").html("<option value=''>请选择三级分类</option>");
                    //4. 更新渲染
                    form.render('select');
                }else{
                    layer.msg(result.msg);
                }
            }
        );
}

function levelTwo(data,form,$) {
        //1. 获取当前选中的值.
        var id = data.value;

        var content = "<option value=''>请选择三级分类</option>";
        //2. 非空判断.
        if(id == null || id == ""){

            $("#levelThree").html(content);
            form.render('select');
            return;
        }

        //3. 发送ajax请求,并获取当前分类对应的三级分类.
        $.getJSON(
            baseUrl + "dev/app/category-by-parent-id",
            {parentId: id},
            function(result){
                if(result.code == 0){
                    //1. 获取json
                    var jsonArray = result.data;
                    //2. 手动封装成<option value=""></option>
                    for(var i = 0;i < jsonArray.length ;i++){
                        content += "<option value='"+ jsonArray[i].id +"'>"+jsonArray[i].categoryName+"</option>";
                    }
                    //3. 插入到三级分类中.
                    $("#levelThree").html(content);
                    //4. 更新渲染
                    form.render('select');
                }else{
                    layer.msg(result.msg);
                }
            }
        );
}