var setting = {
        view: {
            selectedMulti: false //是否允许多选
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            //zTree节点的点击事件
            onClick: zTreeOnClick
        }
};

//点击某个节点 然后将该节点的名称赋值值文本框
function zTreeOnClick(event, treeId, treeNode) {
    $("#parentName").val(treeNode.name);
	$("#pId").val(treeNode.id);
    //隐藏zTree
    hideMenu();
    event.preventDefault();
    return false;
}

//显示树
function showMenu() {
	var obj = $("#parentName");
	var offset = $("#parentName").offset();
	$("#menuTreeDiv").css({ left: offset.left + "px", top: offset.top + obj.outerHeight() + "px" }).slideDown("fast");
}
       
 //隐藏树
function hideMenu() {
   $("#menuTreeDiv").fadeOut("fast");
}

var ztreeObj;
function InitialZtree() {
	var url = basePath+"/menu/menuTree.do";
	$.ajax({
		url:url,
		type:"post",
		data:{},
		dataType:"json",
		success:function(data){
			ztreeObj = $.fn.zTree.init($("#menuTree"), setting, data);
			 var nodes = ztreeObj.getNodes();
            for (var i = 0; i < nodes.length; i++) { //设置节点展开
            	ztreeObj.expandNode(nodes[i], true, false, true);
            }
		}
	});
	
}


$(function(){
	InitialZtree();
	
	$("#menuTreeBtn").click(function(){
		showMenu();
	});
	
	$("#saveBtn").click(function(){
		$("#editForm").bootstrapValidator('validate');//提交验证  
        if ($("#editForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码  
			$.ajax({
				url:basePath+"/menu/save.do",
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
            },  
            parentId: {  
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

