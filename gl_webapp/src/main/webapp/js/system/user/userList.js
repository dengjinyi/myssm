var zNodes = [
            { id: 1, pId: 0, name: "北京" },
            { id: 2, pId: -1, name: "天津" },
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
	
	initTable();
	
	$("#select").click(function(){
		refreshTable();
	});
	
	$("#addUser").click(function(){
		var url = basePath+"/user/edit.do";
		layer.open({
	      type: 2,
	      title: '新增用户',
	      maxmin: true,
	      shadeClose: true, //点击遮罩关闭层
	      area : ['850px' , '540px'],
	      content: url
	    });
		
		/*var url = basePath+"/user/edit.do";
		$("#userModalBody").load(url,{},function(){
			$('#status').chosen({
			  	no_results_text: 'Oops, nothing found!',
			  	width: '100%'
			});
			$('#userType').chosen({
			  	no_results_text: 'Oops, nothing found!',
			  	width: '100%'
			});
		});
		$("#userModal").modal("show");*/
		
	});
	
	$('#myTab a').click(function (e) {
		  $(this).tab('show');
	});
	
	$('.my_select_box').on('change', function(e, params) {
	
	});
	
	$("#select").click(function(){
		$("#myModal").modal("show");
	});
	
	$("#userName").focus(function(){
		if(!ztreeObj){
			InitialZtree();
		}
		showMenu();
	});
	
	$("#officeName").focus(function(){
		if(!ztreeObj){
			InitialZtree();
		}
		showMenu();
	});
	
	$("#saveUserBtn").click(function(){
		$("#editUserForm").submit();
	});
	
	$("#deleteUser").click(function(){
		
		if($table){
			var selections = $table.bootstrapTable('getSelections');
			var _array = new Array();
			if(selections && selections.length >0){
				for(var i = 0 ; i < selections.length ; i++){
					_array.push(selections[i].id);
				}
				deleteUser(_array.join(","));
			}
		}
	});
});

function deleteUser(ids){
	var url = basePath+"/user/deleteUser.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			ids:ids
		},
		dataType:"json",
		success:function(data){
			alert(data.statuCode);
			$table.bootstrapTable('refresh',{page:1,pageSize:10});
		}
	});
}

function editUser(id){
	var url = basePath+"/user/edit.do?id="+id;
	layer.open({
      type: 2,
      title: '新增用户',
      maxmin: true,
      shadeClose: true, //点击遮罩关闭层
      area : ['850px' , '540px'],
      content: url
    });
}

var ztreeObj;
function InitialZtree() {
	ztreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
}


var $table = null;
function initTable(){
	$table = $('#dataTable').bootstrapTable({
		url:basePath+'/user/ajaxList.do',
		cache:false,
		method:'post',
		dataType:'json',
		queryParams:{
			"page":1,
			"pageSize":10
		},
		toolbar:"#toolbar",
		sidePagination:'server',//server 或 client
		striped:true,
		pageNumber:1,
		pagination : true,//开启分页
		search:false,
		queryParams:queryParams,
		clickToSelect:true,
		singleSelect:false,
		pageSize : 10,//每页大小
        pageList : [10, 15, 20, 30],//可以选择每页大小
        columns:[
             {checkbox:true},
             {field:'id',title:'id',sortable:true,width:100,align: 'center',valign: 'middle',visible:false},    
             {field:'company',title:'公司名称',sortable:true,width:100,align: 'center',valign: 'middle'},    
             {field:'orgName',title:'部门',sortable:true,width:100,align: 'center',valign: 'middle'},    
             {field:'account',title:'用户帐号',sortable:true,width:100,align: 'center',valign: 'middle'},    
             {field:'name',title:'姓名',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'email',title:'email',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'phone',title:'联系电话',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'mobile',title:'手机',sortable:true,width:100,align: 'center',valign: 'middle'},
             {field:'events',title:'操作',sortable:false,width:100,align: 'center',valign: 'middle',formatter:function(value,row,index){
            	 return '<a href="'+basePath+'/user/edit.do?id='+row.id+'">修改</a>';
             }}
         ]
        
	});
}

function refreshTable(){
	var options = $table.bootstrapTable('getOptions');
	var solidParams = queryParams();
	$table.bootstrapTable('refresh',solidParams);
}

function queryParams(params){
	var name = $("#name").val();
	var orgId = $("#orgId").val();
	var company = $("#company").val();
	var account = $("#account").val();
	var queryParams = {
			page:1,
			pageSize:10,
			orgId:orgId,
			name:name,
			company:company,
			account:account
	};
    return queryParams;
}

function AutoMatch(txtObj) {
    if (txtObj.value.length > 0) {
        InitialZtree();
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        var nodeList = zTree.getNodesByParamFuzzy("name", txtObj.value);
        //将找到的nodelist节点更新至Ztree内
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        showMenu();
    } else {
        //隐藏树
        hideMenu();
        InitialZtree();                
    }              
}

//显示树
function showMenu() {
            var cityObj = $("#userName");
            var cityOffset = $("#userName").offset();
            $("#menuContent").css({ left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px" }).slideDown("fast");
}
       
//隐藏树
function hideMenu() {
            $("#menuContent").fadeOut("fast");
}

//点击某个节点 然后将该节点的名称赋值值文本框
function onClick(e, treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
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
            var cityObj = $("#userName");
            cityObj.attr("value", v);
            //隐藏zTree
            hideMenu();
            return false;
}