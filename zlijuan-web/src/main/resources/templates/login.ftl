<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Bootstrap Core CSS -->
	<link href="${basePath}/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- Custom Fonts -->
	<link href="${basePath}/lib/Font-Awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
    	<script src="${basePath}/lib/html5shiv.min.js"></script>
    	<script src="${basePath}/lib/respond.min.js"></script>
    <![endif]-->

	<title>zlijuan</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 100px">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">登陆</h3>
					</div>
					<div class="panel-body">
						<form method="post" name="login-form" id="login-form">
							<fieldset>
								<div class="form-group">
									<label for="userPassword" class="form-label">用户名：</label>
									<input class="form-control" placeholder="用户名" name="userName" type="text" autofocus/>
								</div>
								<div class="form-group">
									<label for="userPassword" class="form-label">密码：</label>
									<input class="form-control" placeholder="密码" name="userPassword" type="password"/>
								</div>
								<!-- <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">记住密码
                                    </label>
                                </div> -->
								<!-- Change this to a button or input when using this as a form -->
								<input class="btn btn-lg btn-success btn-block" type="submit" value="登陆" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="${basePath}/lib/jquery-3.2.1.min.js"></script>
	
    <!-- jQuery validate -->
    <script src="${basePath}/lib/jquery-validation-1.17.0/dist/jquery.validate.min.js"></script>
    <script src="${basePath}/lib/jquery-validation-1.17.0/dist/localization/messages_zh.min.js"></script>


	<!-- Bootstrap Core JavaScript -->
	<script src="${basePath}/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$(function() {
			// 在键盘按下并释放及提交后验证提交表单
			$('#login-form').validate({
				rules : {
					userName : 'required',
					userPassword : {
						required : true
					}
				},
				messages : {
					userName : '请输入用户名',
					userPassword : {
						required : '请输入密码'
					}
				}
			})
		});
	</script>
</body>
</html>