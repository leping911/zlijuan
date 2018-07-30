<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <!-- Bootstrap Core CSS -->
    <link href="${basePath}/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Bootstrap table css -->
    <link href="${basePath}/lib/bootstrap-table-dist/bootstrap-table.min.css" rel="stylesheet"/>

    <!-- MetisMenu CSS -->
    <link href="${basePath}/lib/metisMenu/metisMenu.min.css" rel="stylesheet"/>

    <!-- Custom CSS -->
    <link href="${basePath}/css/base.css" rel="stylesheet"/>

    <!-- Custom Fonts -->
    <link href="${basePath}/lib/Font-Awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="${basePath}/lib/html5shiv.min.js"></script>
    <script src="${basePath}/lib/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    	var basePath = '${basePath}';
    </script>

    <sitemesh:write property='head' />
</head>
<body>
    <div class="container-fluid">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">Blake</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> 首页</a>
                        </li>
                        <#if functionInfos??>
	                        <#list functionInfos as functionInfo>
	                        	<li>
	                            	<a href="#"><i class="fa ${functionInfo.functionIcons} fa-fw"></i> ${functionInfo.functionName}<span class="fa arrow"></span></a>
	                            	<#if functionInfo.childFunctionInfos??>
		                            	<#list functionInfo.childFunctionInfos>
		                            		<ul class="nav nav-second-level">
		                            			<#items as childFunctionInfo>
		                            				<li>
					                                    <a href="${basePath}${childFunctionInfo.functionUrl}">${childFunctionInfo.functionName}</a>
					                                </li>
		                            			</#items>
		                            		</ul>
		                            	</#list>
	                            	</#if>
	                            </li>
	                        </#list>
                        </#if>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- jQuery -->
        <script src="${basePath}/lib/jquery-3.2.1.min.js"></script>
        
        <!-- jQuery validate -->
        <script src="${basePath}/lib/jquery-validation-1.17.0/dist/jquery.validate.min.js"></script>
        <script src="${basePath}/lib/jquery-validation-1.17.0/dist/localization/messages_zh.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${basePath}/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <!-- Bootstrap table js -->
        <script src="${basePath}/lib/bootstrap-table-dist/bootstrap-table.min.js"></script>

        <script src="${basePath}/lib/bootstrap-table-dist/extensions/export/bootstrap-table-export.min.js"></script>

        <!-- Bootstrap table local CN js -->
        <script src="${basePath}/lib/bootstrap-table-dist/locale/bootstrap-table-zh-CN.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="${basePath}/lib/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${basePath}/js/base.js"></script>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="page-header breadcrumb" contenteditable="true">
                        <li><a href="#">主页</a> <span class="divider">/</span></li>
                        <li><a href="#">类目</a> <span class="divider">/</span></li>
                        <li class="active">主题</li>
                    </ul>
                </div>
                <!-- /.col-lg-12 -->
            </div>
        	<sitemesh:write property='body'/>
        </div>
        <!-- /#page-wrapper -->
    </div>
</body>
</html>
