<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Blake</title>
</head>
<body>
    <div>
        <div id="toolbar">
            <button class="btn btn-primary" id="index-add-btn" data-toggle="modal" data-target="#index-modal-add"><i class="fa fa-plus"></i> 新增</button>
            <button class="btn btn-warning" id="index-update-btn"><i class="fa fa-pencil"></i> 修改</button>
            <button class="btn btn-danger" id="index-delete-btn"><i class="fa fa-remove"></i> 删除</button>
        </div>
        <table id="index-user-list">
        </table>
    </div>
    <script>
    	$(function(){
    		$('#index-user-list').bootstrapTable({
    		    url: '${basePath}/role/page',   //数据请求地址
    		    pagination: true,  //是否分页
    		    sidePagination: 'server', //服务器端分页
    		    escape: true,  //是否转义数据
    		    pageSize: 10,  //分页大小
    		    queryParamsType: 'limit', //参数格式，发送标准的RESTFul类型的参数请求
    		    dataField: 'content',
    		    totalField: 'totalElements',
    		    searchOnEnterKey: true,
    		    idField: 'id',
    		    sortName: 'roleName',
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
    		        field: 'id',
    		        title: 'id',
    		        checkbox: true
    		    }, {
    		        field: 'roleName',
    		        title: '角色名称',
    		        sortable: true
    		    }, {
    		        field: 'roleType',
    		        title: '角色类型',
    		        sortable: true,
    		        formatter: function(value, row, index) {
    		        	return value == 'SYSTEM' ? '系统角色' : '普通角色';
    		        }
    		    }, {
    		        field: 'roleDesc',
    		        title: '描述',
    		        sortable: true
    		    }]
    		});
    	})
    </script>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="index-modal-add" tabindex="-1" role="dialog" aria-labelledby="index-modal-title" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="index-modal-title">
						新增
					</h4>
				</div>
				<div class="modal-body">
					按下 ESC 按钮退出。
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭
					</button>
					<button type="button" class="btn btn-primary">
						提交
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>

</html>