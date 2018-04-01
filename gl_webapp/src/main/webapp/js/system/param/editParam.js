
$(function(){
	
		 $("#editForm").validate({
	        submitHandler:function(form){
	        	$(form).ajaxSubmit({
	        		dataType:"json",
	        		success:function(data){
	        			layer.alert(data.msg, {
	        				  skin: 'layui-layer-lan' //样式类名
	        				  ,closeBtn: 0
	        				}, function(){
	        					goBack();
	        				});
	        		}
	        	}); 
	        }    
		});
	
		 $("#backHome").click(function(){
			 goBack();
		 });
});


function goBack(){
	window.location.href = basePath+"/admin/param/list.do";
}

