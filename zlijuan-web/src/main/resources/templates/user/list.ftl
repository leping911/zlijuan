<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Blake</title>
</head>
<body>
    <div>
        <div id="toolbar">
            <button class="btn btn-primary" id="user-add-btn"><i class="fa fa-plus"></i> 新增</button>
            <button class="btn btn-danger" id="user-delete-btn"><i class="fa fa-remove"></i> 删除</button>
        </div>
        <table id="user-list">
        </table>
    </div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="user-modal-add" tabindex="-1" role="dialog" aria-labelledby="user-modal-title" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="user-modal-title">
						新增
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="user-add-form" name="user-add-form">
						<input type="hidden" name="id"/>
						<div class="form-group">
							<label for="userCode" class="col-sm-3 control-label">员工号</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="userCode" placeholder="员工号"/>
							</div>
						</div>
						<div class="form-group">
							<label for="nickName" class="col-sm-3 control-label">姓名</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="nickName" placeholder="姓名"/>
							</div>
						</div>
						<div class="form-group">
							<label for="userName" class="col-sm-3 control-label">用户名</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="userName" placeholder="用户名"/>
							</div>
						</div>
						<div class="form-group">
							<label for="userPassword" class="col-sm-3 control-label">密码</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="密码"/>
							</div>
						</div>
						<div class="form-group">
							<label for="userPasswordComfirm" class="col-sm-3 control-label">确认密码</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" name="userPasswordComfirm" placeholder="确认密码"/>
							</div>
						</div>
						<div class="form-group">
							<label for="age" class="col-sm-3 control-label">年龄</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="age" placeholder="年龄"/>
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="col-sm-3 control-label">性别</label>
							<div class="col-sm-9">
								<label class="radio-inline">
									<input type="radio" name="gender" value="M"/> 男
								</label>
								<label class="radio-inline">
									<input type="radio" name="gender" value="F"/> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="telephone" class="col-sm-3 control-label">手机号码</label>
							<div class="col-sm-9">
								<input type="tel" class="form-control" name="telephone" placeholder="手机号码"/>
							</div>
						</div>
						<#if roleInfos??>
							<div class="form-group">
								<label for="roleInfosId" class="col-sm-3 control-label">角色</label>
								<div class="col-sm-9">
			                        <#list roleInfos as roleInfo>
			                        	<label class="checkbox-inline">
											<input type="checkbox" name="roleInfosId" value="${roleInfo.id!}"/> ${roleInfo.roleName!}
										</label>
			                        </#list>
								</div>
							</div>
						</#if>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭
					</button>
					<button type="button" class="btn btn-primary" id="user-add-form-submit">
						提交
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<script type="text/javascript" src="${basePath}/js/user/list.js"></script>
</body>

</html>