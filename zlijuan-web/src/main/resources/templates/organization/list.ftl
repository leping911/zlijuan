<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<link rel="stylesheet" href="${basePath}/lib/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <title>Blake</title>
</head>
<body>
	<div class="row">
		<div class="col-md-4">
			<ul id="organizationInfo-tree" class="ztree"></ul>
		</div>
		<div class="col-md-8">
		    <div>
		        <div id="toolbar">
		            <button class="btn btn-primary" id="organization-add-btn"><i class="fa fa-plus"></i> 新增</button>
		            <button class="btn btn-danger" id="organization-delete-btn"><i class="fa fa-remove"></i> 删除</button>
		        </div>
		        <table id="organization-list">
		        </table>
		    </div>
	    </div>
    </div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="organization-modal-add" tabindex="-1" role="dialog" aria-labelledby="organization-modal-title" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="organization-modal-title">
						新增
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="organization-add-form" name="organization-add-form">
						<input type="hidden" name="id" />
						<input type="hidden" name="orgUnitParentId" value="1" />
						<div class="form-group">
							<label for="orgUnitCode" class="col-sm-3 control-label">机构编号</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="orgUnitCode" placeholder="机构编号"/>
							</div>
						</div>
						<div class="form-group">
							<label for="orgUnitName" class="col-sm-3 control-label">机构名称</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="orgUnitName" placeholder="机构名称"/>
							</div>
						</div>
						<div class="form-group">
							<label for="orgUnitType" class="col-sm-3 control-label">机构类型</label>
							<div class="col-sm-9">
								<label class="radio-inline">
									<input type="radio" name="orgUnitType" value="PROVINCE"/> 省
								</label>
								<label class="radio-inline">
									<input type="radio" name="orgUnitType" value="CITY"/> 市
								</label>
								<label class="radio-inline">
									<input type="radio" name="orgUnitType" value="COUNTY"/> 县、区
								</label>
							</div>
						</div>
					</form>
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
	
	<script type="text/javascript" src="${basePath}/lib/zTree_v3/js/jquery.ztree.core.min.js"></script>
	<script type="text/javascript" src="${basePath}/js/organization/list.js"></script>
</body>

</html>