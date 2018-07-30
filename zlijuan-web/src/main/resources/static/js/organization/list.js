$(function(){
	var id = '';
	$('#organization-list').bootstrapTable({
	    url: basePath + '/organization/page',   //数据请求地址
	    pagination: true,  //是否分页
	    sidePagination: 'server', //服务器端分页
	    escape: true,  //是否转义数据
	    pageSize: 10,  //分页大小
	    queryParamsType: 'limit', //参数格式，发送标准的RESTFul类型的参数请求
	    dataField: 'content',
	    totalField: 'totalElements',
	    searchOnEnterKey: true,
	    idField: 'id',
	    sortName: 'id',
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
	        checkbox: true
	    }, {
	        field: 'orgUnitCode',
	        title: '机构编号',
	        sortable: true
	    }, {
	        field: 'orgUnitName',
	        title: '机构名称',
	        sortable: true
	    }, {
	        field: 'orgUnitType',
	        title: '机构类型',
	        sortable: true,
	        formatter: function(value, row, index) {
	        	var orgUnitType;
	        	switch(value) {
		        	case 'NATION':
		        		orgUnitType = '国家';
		        		break;
	        		case 'PROVINCE':
	        			orgUnitType = '省份';
	        			break;
	        		case 'CITY':
	        			orgUnitType = '市';
	        			break;
	        		case 'COUNTY':
	        			orgUnitType = '区、县';
	        			break;
	        		default:
	        			orgUnitType = '其他';
	        	}
	        	return orgUnitType;
	        }
	    }],
	    /*treeShowField : 'orgUnitCode',
		parentIdField : 'orgUnitParentId',*/
		onLoadSuccess : function(data) {
			/* $table.treegrid({
				initialState: 'collapsed',
				treeColumn : 1,
				// expanderExpandedClass: 'glyphicon glyphicon-minus',
				// expanderCollapsedClass: 'glyphicon glyphicon-plus',
				onChange : function() {
					$table.bootstrapTable('resetWidth');
				}
			}); */
		}
	});
	
	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {
		async: {
			enable: true,
			url: basePath + "/tree/findByParentOrganizationInfo",
			autoParam: ["id"]
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: zTreeOnClick
		}
	};
	
	function zTreeOnClick(event, treeId, treeNode) {
		$('input[name="orgUnitParentId"]').val(treeNode.id);
		$('#organization-list').bootstrapTable('refresh',{
			query: {
				id: treeNode.id
			}
		});
	};
	
	$.getJSON(basePath + "/tree/findByParentOrganizationInfo", function(result) {
		zTreeObj = $.fn.zTree.init($("#organizationInfo-tree"), setting, result);
	});
	
	
	
	// 在键盘按下并释放及提交后验证提交表单
	$('#organization-add-form').validate({
		rules : {
			orgUnitCode: {
				required: true,
				minlength: 5,
				maxlength: 50
			},
			orgUnitName: {
				required: true,
				minlength: 5,
				maxlength: 50
			},
			orgUnitType: {
				required: true
			}
		}
	});
	
	$('#organization-add-form-submit').click(function(){
		if($('#organization-add-form').valid()) {
			var organizationInfo = {};
			var id = $('input[name="id"]').val();
			if(id != null && id != '') {
				organizationInfo.id = id;
			}
			organizationInfo.orgUnitCode = $('input[name="orgUnitCode"]').val();
			organizationInfo.orgUnitName = $('input[name="orgUnitName"]').val();
			organizationInfo.orgUnitType = $('input[name="orgUnitType"]:checked').val();
			organizationInfo.parentOrganizationInfo = {};
			organizationInfo.parentOrganizationInfo.id = $('input[name="orgUnitParentId"]').val();
			
			
			$.ajax({
				url : basePath + '/organization/save',
				data: JSON.stringify(organizationInfo),
				type : 'post',
				dataType : 'json',
				contentType : 'application/json',
				success : function(data) {
					if(data.success) {
						$('#organization-modal-add').modal('hide');
						$('#organization-list').bootstrapTable('refresh');
					} else {
						alert(data.msg);
					}
				}
			});
		}
	});
	
	$('#organization-add-btn').click(function(){
		resetForm();
		$('#organization-modal-add').modal('show');
	});
	
	$('#organization-delete-btn').click(function(){
		var organizationInfos = [];
		$('input[name="btSelectItem"]:checked').each(function(){
			var organizationInfo = {};
			organizationInfo.id = $(this).val();
			organizationInfos.push(userInfo);
		});
		if(organizationInfos.length == 0) {
			alert('请选择需要删除的数据！')
		} else {
			if(confirm("确认删除？")){
				$.ajax({
					url : basePath + '/organization/deleteByIds',
					data: JSON.stringify(organizationInfos),
					type : 'post',
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {
						if(data.success) {
							alert("删除成功");
							$('#organization-list').bootstrapTable('refresh');
						} else {
							alert(data.msg);
						}
					}
				});
			}
		}
	})
});


function detailOrganizationInfo(id) {
	resetForm();
	$.ajax({
		url : basePath + '/organization/get',
		data: {
			id: id
		},
		type : 'get',
		dataType : 'json',
		success : function(data) {
			$('input[name="id"]').val(data.id);
			$('input[name="orgUnitCode"]').val(data.orgUnitCode);
			$('input[name="orgUnitName"]').val(data.orgUnitName);
			$('input[name="orgUnitParentId"]').val(data.parentOrganizationInfo.id);
			$('input[name="orgUnitType"][value=' + data.orgUnitType + ']').attr('checked',true);
			$('#organization-add-form-submit').hide();
			$('#organization-modal-add').modal('show');
		}
	});
}

function deleteOrganizationInfo(id) {
	if(confirm("确认删除？")){
		$.ajax({
			url : basePath + '/organization/delete',
			data: {
				id: id
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				if(data.success) {
					alert("删除成功");
					$('#organization-list').bootstrapTable('refresh');
				} else {
					alert(data.msg);
				}
			}
		});
	}
}

function updateOrganizationInfo(id) {
	resetForm();
	$.ajax({
		url : basePath + '/organization/get',
		data: {
			id: id
		},
		type : 'get',
		dataType : 'json',
		success : function(data) {
			$('input[name="id"]').val(data.id);
			$('input[name="orgUnitCode"]').val(data.orgUnitCode);
			$('input[name="orgUnitName"]').val(data.orgUnitName);
			$('input[name="orgUnitParentId"]').val(data.parentOrganizationInfo.id);
			$('input[name="orgUnitType"][value=' + data.orgUnitType + ']').attr('checked',true);
			$('#organization-modal-add').modal('show');
		}
	});
}

function resetForm() {
	document.getElementById("organization-add-form").reset()
	$('input[name="id"]').val('');
	$('input[name="orgUnitCode"]').val('');
	$('input[name="orgUnitName"]').val('');
	$('input[name="orgUnitType"]').removeAttr('checked');
	$('#user-add-form-submit').show();
}