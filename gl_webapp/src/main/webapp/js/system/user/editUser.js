var zNodes = [
            { id: 0, pId:-1, name: "中国" },
            { id: 1, pId: 0, name: "北京" },
            { id: 2, pId: 0, name: "天津" },
            { id: 3, pId: 0, name: "上海" },
            { id: 6, pId: 0, name: "重庆" },
            { id: 4, pId: 0, name: "河北省", open: true },
            { id: 41, pId: 4, name: "石家庄" },
            { id: 42, pId: 4, name: "保定" },
            { id: 43, pId: 4, name: "邯郸" },
            { id: 44, pId: 4, name: "承德" },
            { id: 5, pId: 0, name: "广东省", open: true },
            { id: 51, pId: 5, name: "广州" },
            { id: 52, pId: 5, name: "深圳" },
            { id: 53, pId: 5, name: "东莞" },
            { id: 54, pId: 5, name: "佛山" },
            { id: 6, pId: 0, name: "福建省", open: true },
            { id: 61, pId: 6, name: "福州" },
            { id: 62, pId: 6, name: "厦门" },
            { id: 63, pId: 6, name: "泉州" },
            { id: 64, pId: 6, name: "三明" }
         ];

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
            onClick: onClick
        }
};

$(function(){
	//状态下拉框
	$('#status').chosen({
	  	no_results_text: 'Oops, nothing found!',
	  	width: '80px'
	});
	
	//用户类型
	$('#userType').chosen({
	  	no_results_text: 'Oops, nothing found!',
	  	width: '250px'
	});
	$('#company').chosen({
		no_results_text: 'Oops, nothing found!',
		width: '250px'
	});
	
	$("#orgButton").click(function(){
		if(!ztreeObj){
			InitialZtree();
		}
		showMenu();
	});
	
	$("#saveUserBtn").click(function(){
		$("#editUserForm").bootstrapValidator('validate');//提交验证  
        if ($("#editUserForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码  
			$.ajax({
				url:basePath+"/user/saveUser.do",
				type:"post",
				data:$("#editUserForm").serialize(),
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
	
	
	$("#editUserForm").bootstrapValidator({  
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
            account: {  
            	validators: {  
            		notEmpty: {//检测非空,radio也可用  
            			message: '文本框必须输入'  
            		},  
            	}  
            },  
            password: {  
            	validators: {  
            		notEmpty: {//检测非空,radio也可用  
            			message: '文本框必须输入'  
            		},  
            	}  
            },
            rpassword: {  
            	validators: { 
            		equalTo: "#password"  
            	}
            },
        }  
    });
	
	InitialZtree();
});

var ztreeObj;
function InitialZtree() {
	ztreeObj = $.fn.zTree.init($("#orgTree"), setting, zNodes);
	ztreeObj.expandAll(true); 
}

function showCompany(){
	layer.open({
	      type: 1,
	      title: '新增用户',
	      //maxmin: true,
	      shadeClose: true, //点击遮罩关闭层
	      area : ['350px' , '450px'],
	      content: $("#treeContent"),
	      btn: ['确定', '关闭'],
	      yes: function(index, layero){
	    	  var zTree = $.fn.zTree.getZTreeObj("orgTree");
	    	    //获得选中的节点
	    	  var nodes = zTree.getSelectedNodes();
	    	  var v ="";
	    	  for (var i = 0, l = nodes.length; i < l; i++) {
	    	        v += nodes[i].name;
	    	   }
	    	  $("#officeName").val(v);
	    	  layer.closeAll();
    	  },cancel: function(index, layero){
    		  
    	  }
	 });
}

function closeLayer(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

       
//点击某个节点 然后将该节点的名称赋值值文本框
function onClick(e, treeId, treeNode) {
   /* var zTree = $.fn.zTree.getZTreeObj("orgTree");
    //获得选中的节点
    var nodes = zTree.getSelectedNodes(),
    v = "";
    //根据id排序
    nodes.sort(function compare(a, b) { return a.id - b.id; });
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i].name + ",";
    }
    //将选中节点的名称显示在文本框内
    if (v.length > 0) v = v.substring(0, v.length - 1);
    var cityObj = $("#officeName");
    cityObj.attr("value", v);
    //隐藏zTree
    hideMenu();*/
    return false;
}