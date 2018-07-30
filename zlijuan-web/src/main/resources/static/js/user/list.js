$(function(){
	$('#user-list').bootstrapTable({
	    url: basePath + '/user/page',   //数据请求地址
	    pagination: true,  //是否分页
	    sidePagination: 'server', //服务器端分页
	    escape: true,  //是否转义数据
	    pageSize: 10,  //分页大小
	    queryParamsType: 'limit', //参数格式，发送标准的RESTFul类型的参数请求
	    dataField: 'content',
	    totalField: 'totalElements',
	    searchOnEnterKey: true,
	    idField: 'id',
	    sortName: 'userName',
	    sortOrder: 'asc',
	    toolbar: '#toolbar',
	    clickToSelect: true,
	    queryParams: function(params) {
	    	return params;
	    },
	    showExport: true,
	    exportDataType: 'all',
	    exportTypes: ['json', 'xml', 'csv', 'txt', 'sql', 'excel'],
	    columns: [{
	        width: '3%',
	        checkbox: true
	    }, {
	        field: 'userName',
	        title: '用户名',
	        width: '15%',
	        sortable: true
	    }, {
	        field: 'nickName',
	        title: '姓名',
	        width: '15%',
	        sortable: true
	    }, {
	        field: 'userCode',
	        title: '工号',
	        width: '10%',
	        sortable: true
	    }, {
	        field: 'gender',
	        title: '性别',
	        width: '7%',
	        sortable: true,
	        formatter: function(value, row, index) {
	        	return value == 'F' ? '女' : '男';
	        }
	    }, {
	        field: 'age',
	        title: '年龄',
	        width: '7%',
	        sortable: true
	    }, {
	        field: 'telephone',
	        title: '手机号码',
	        width: '20%',
	        sortable: true
	    }, {
			field: 'id',
			title: '操作',
	        width: '23%',
			halign: 'left',
			formatter:function (value, row, index, field){
				var button_detail = '<button class="button btn btn-sm" onclick="detailUserInfo(' + value + ')" style="margin-left:5px">查看</button>';
				var button_update = '<button class="button btn btn-sm" onclick="updateUserInfo(' + value + ')" style="margin-left:5px">修改</button>';
				var button_delete = '<button class="button btn btn-sm" onclick="deleteUserInfo(' + value + ')" style="margin-left:5px">删除</button>';
				var button = button_detail + button_update + button_delete;
				return button;
			}
		}]
	});
	
	// 在键盘按下并释放及提交后验证提交表单
	$('#user-add-form').validate({
		rules : {
			userCode: {
				required: true,
				minlength: 5,
				maxlength: 50
			},
			userName: {
				required: true,
				minlength: 5,
				maxlength: 50
			},
			userPassword: {
				required: true,
				minlength: 5,
				maxlength: 50
			},
			userPasswordComfirm: {
				required: true,
				minlength: 5,
				equalTo: '#userPassword'
			},
			nickName: {
				required: true,
				maxlength: 50
			},
			age: {
				digits: true,
				range:[0,255]
			}
		}
	});
	
	$('#user-add-form-submit').click(function(){
		if($('#user-add-form').valid()) {
			var userInfo = {};
			var id = $('input[name="id"]').val();
			if(id != null && id != '') {
				userInfo.id = id;
			}
			userInfo.userCode = $('input[name="userCode"]').val();
			userInfo.userName = $('input[name="userName"]').val();
			userInfo.userPassword = $('input[name="userPassword"]').val();
			userInfo.userPasswordComfirm = $('input[name="userPasswordComfirm"]').val();
			userInfo.nickName = $('input[name="nickName"]').val();
			userInfo.age = $('input[name="age"]').val();
			userInfo.gender = $('input[name="gender"]:checked').val();
			userInfo.telephone = $('input[name="telephone"]').val();
			
			userInfo.roleInfos = [];
			$('input[name="roleInfosId"]:checked').each(function(){
				var roleInfo = {};
				roleInfo.id = $(this).val();
				userInfo.roleInfos.push(roleInfo); 
			});
			
			$.ajax({
				url : basePath + '/user/save',
				data: JSON.stringify(userInfo),
				type : 'post',
				dataType : 'json',
				contentType : 'application/json',
				success : function(data) {
					if(data.success) {
						$('#user-modal-add').modal('hide');
						$('#user-list').bootstrapTable('refresh');
					} else {
						alert(data.msg);
					}
				}
			});
		}
	});
	
	$('#user-add-btn').click(function(){
		resetForm();
		$('#user-modal-add').modal('show');
	});
	
	$('#user-delete-btn').click(function(){
		var userInfos = [];
		$('input[name="btSelectItem"]:checked').each(function(){
			var userInfo = {};
			userInfo.id = $(this).val();
			userInfos.push(userInfo);
		});
		if(userInfos.length == 0) {
			alert('请选择需要删除的数据！')
		} else {
			if(confirm("确认删除？")){
				$.ajax({
					url : basePath + '/user/deleteByIds',
					data: JSON.stringify(userInfos),
					type : 'post',
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {
						if(data.success) {
							alert("删除成功");
							$('#user-list').bootstrapTable('refresh');
						} else {
							alert(data.msg);
						}
					}
				});
			}
		}
	})
});

function detailUserInfo(id) {
	resetForm();
	$.ajax({
		url : basePath + '/user/get',
		data: {
			id: id
		},
		type : 'get',
		dataType : 'json',
		success : function(data) {
			$('input[name="id"]').val(data.id);
			$('input[name="userCode"]').val(data.userCode);
			$('input[name="userName"]').val(data.userName);
			$('input[name="userPassword"]').parent().parent().hide();
			$('input[name="userPasswordComfirm"]').parent().parent().hide();
			$('input[name="nickName"]').val(data.nickName);
			$('input[name="age"]').val(data.age);
			$('input[name="gender"][value=' + data.gender + ']').attr('checked',true);
			data.roleInfos.forEach(function(val, index, arr){
				$('input[name="roleInfosId"][value=' + val.id + ']').attr('checked',true);
			})
			$('input[name="telephone"]').val(data.telephone);
			$('#user-add-form-submit').hide();
			$('#user-modal-add').modal('show');
		}
	});
}

function deleteUserInfo(id) {
	if(confirm("确认删除？")){
		$.ajax({
			url : basePath + '/user/delete',
			data: {
				id: id
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				if(data.success) {
					alert("删除成功");
					$('#user-list').bootstrapTable('refresh');
				} else {
					alert(data.msg);
				}
			}
		});
	}
}

function updateUserInfo(id) {
	resetForm();
	$.ajax({
		url : basePath + '/user/get',
		data: {
			id: id
		},
		type : 'get',
		dataType : 'json',
		success : function(data) {
			$('input[name="id"]').val(data.id);
			$('input[name="userCode"]').val(data.userCode);
			$('input[name="userName"]').val(data.userName);
			$('input[name="userPassword"]').parent().parent().hide();
			$('input[name="userPasswordComfirm"]').parent().parent().hide();
			$('input[name="nickName"]').val(data.nickName);
			$('input[name="age"]').val(data.age);
			$('input[name="gender"][value=' + data.gender + ']').attr('checked',true);
			data.roleInfos.forEach(function(val, index, arr){
				$('input[name="roleInfosId"][value=' + val.id + ']').attr('checked',true);
			})
			$('input[name="telephone"]').val(data.telephone);
			$('#user-modal-add').modal('show');
		}
	});
}

function resetForm() {
	document.getElementById("user-add-form").reset()
	$('input[name="id"]').val('');
	$('input[name="userCode"]').val('');
	$('input[name="userName"]').val('');
	$('input[name="userPassword"]').val('');
	$('input[name="userPasswordComfirm"]').val('');
	$('input[name="userPassword"]').parent().parent().show();
	$('input[name="userPasswordComfirm"]').parent().parent().show();
	$('input[name="nickName"]').val('');
	$('input[name="age"]').val('');
	$('input[name="gender"]').removeAttr('checked');
	$('input[name="roleInfosId"]').removeAttr('checked');
	$('input[name="telephone"]').val('');
	$('#user-add-form-submit').show();
}
