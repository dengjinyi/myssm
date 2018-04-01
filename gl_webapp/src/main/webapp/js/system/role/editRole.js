
$(function(){
	
	$("#saveBtn").click(function(){
		$("#editForm").bootstrapValidator('validate');//提交验证  
        if ($("#editForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码  
			$.ajax({
				url:basePath+"/role/save.do",
				type:"post",
				data:$("#editForm").serialize(),
				dataType:"json",
				success:function(data){
					if(data.statuCode == "200"){
						
						closeLayer();
					}
				}
			});
        }
	});
	
	$("#closeEditBtn").click(function(){
		closeLayer();
	});
	
	
	$("#editForm").bootstrapValidator({  
        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证  
        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的  
        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面  
        message: '通用的验证失败消息',//好像从来没出现过  
        feedbackIcons: {//根据验证结果显示的各种图标  
            valid: 'glyphicon glyphicon-ok',  
            invalid: 'glyphicon glyphicon-remove',  
            validating: 'glyphicon glyphicon-refresh'  
        },  
        fields: {  
        	name: {  
                validators: {  
                    notEmpty: {//检测非空,radio也可用  
                        message: '文本框必须输入'  
                    },  
                }  
            }
           
        }  
    });
});

function closeLayer(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

