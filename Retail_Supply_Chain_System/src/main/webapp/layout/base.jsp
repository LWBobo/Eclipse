<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from wbpreview.com/previews/WB0016FX5/ by HTTrack Website Copier/3.x [XR&CO'2010], Thu, 16 May 2013 12:40:45 GMT -->
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>百货中心供应链管理系统</title>
    <meta name="description" content="Optimus Dashboard Bootstrap Admin Template.">
    <meta name="author" content="Łukasz Holeczek">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link id="bootstrap-style" href="<s:url value="/static/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<s:url value="/static/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
    <link id="base-style-responsive" href="<s:url value="/static/css/style-responsive.css"/>" rel="stylesheet">
    <!-- end: CSS -->

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- end: Favicon -->

</head>

<body>
<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse"
               data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <s:a cssClass="brand" namespace="/common" action="index">
                <span>百货中心供应链管理系统</span>
            </s:a>
           <p class="pull-right">  欢迎您 <%session.getAttribute("loginuser");%>${loginuser.name }，
			<s:a namespace="/common" action="logout">
                <span >注销</span>
            </s:a>
            |
            <s:a namespace="/common" action="updateUser.action?userEntity.userId=%{#session.loginuser['userId']}">
                <span >修改密码</span>
            </s:a>
            <!--<s:property value="#session.user['admin']"></s:property>-->
		</p>
        </div>
    </div>
</div>
<div id="under-header"></div>
<!-- start: Header -->

<div class="container-fluid" style="height:530px;">

        <!-- start: Main Menu -->
        <div class="span2 main-menu-span">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li class="nav-header hidden-tablet">您的操作：</li>
                    <li>
                        <s:a class="brand" namespace="/common" action="index">
                            <i class="icon-home"></i>
                            <span class="hidden-tablet"> 首页</span>
                        </s:a>
                    </li>
                    <li <s:if test="#session.loginuser['department']!='经理'&&#session.loginuser['department']!='人事部'"> style="display:none;" </s:if>>
                        <s:a namespace="/common" action="userList">
                            <i class="icon-eye-open"></i>
                            <span class="hidden-tablet">人事管理</span>
                        </s:a>
                    </li>
                    <li <s:if test="#session.loginuser['department']!='经理'&&#session.loginuser['department']!='采购部'"> style="display:none;" </s:if>>
                        <s:a namespace="/common" action="cooList">
                            <i class="icon-edit"></i>
                            <span class="hidden-tablet">合作公司管理</span>
                        </s:a>
                    </li>
                    <li <s:if test="#session.loginuser['department']!='经理'&&#session.loginuser['department']!='采购部'"> style="display:none;" </s:if>>
                        <s:a namespace="/common" action="purchaseList">
                            <i class="icon-list-alt"></i>
                            <span class="hidden-tablet">采购管理</span>
                        </s:a>
                    </li>
                    <li <s:if test="#session.loginuser['department']!='经理'&&#session.loginuser['department']!='物资部'"> style="display:none;" </s:if>>
                        <s:a namespace="/common" action="stockList">
                            <i class="icon-font"></i>
                            <span class="hidden-tablet">库存管理</span>
                        </s:a>
                    </li>
                    <li <s:if test="#session.loginuser['department']!='经理'&&#session.loginuser['department']!='销售部'"> style="display:none;" </s:if>>
                        <s:a namespace="/common" action="saleList">
                            <i class="icon-picture"></i>
                            <span class="hidden-tablet">销售管理</span>
                        </s:a>
                    </li>
                    <li>
                        <s:a namespace="/common" action="accountList">
                            <i class="icon-align-justify"></i>
                            <span class="hidden-tablet">数据统计</span>
                        </s:a>
                    </li>
                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <!-- end: Main Menu -->

        <div id="content" class="span10">
            <!-- start: Content -->
            <tiles:insertAttribute name="body"/>
            <!-- end: Content -->
        </div>
        <!--/#content.span10-->
    </div>
    <!--/fluid-row-->

    <div class="clearfix"></div>
    <hr>

    <footer>
        <p align="center">&copy; 百货中心供应链管理系统 2014</p>

    </footer>

</div>
<!--/.fluid-container-->

<!-- start: JavaScript-->
<script src="<s:url value="/static/js/jquery-1.9.1.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery-migrate-1.0.0.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery-ui-1.10.0.custom.min.js"/>"></script>
<script src="<s:url value="/static/js/bootstrap.js"/>"></script>
<script src="<s:url value="/static/js/jquery.cookie.js"/>"></script>
<script src="<s:url value="/static/js/fullcalendar.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.dataTables.min.js"/>"></script>
<script src="<s:url value="/static/js/excanvas.js"/>"></script>
<script src="<s:url value="/static/js/jquery.flot.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.flot.pie.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.flot.stack.js"/>"></script>
<script src="<s:url value="/static/js/jquery.flot.resize.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.chosen.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.uniform.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.cleditor.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.noty.js"/>"></script>
<script src="<s:url value="/static/js/jquery.elfinder.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.raty.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.iphone.toggle.js"/>"></script>
<script src="<s:url value="/static/js/jquery.uploadify-3.1.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.gritter.min.js"/>"></script>
<script src="<s:url value="/static/js/jquery.imagesloaded.js"/>"></script>
<script src="<s:url value="/static/js/jquery.masonry.min.js"/>"></script>
<script src="<s:url value="/static/js/custom.js"/>"></script>

<!-- end: JavaScript-->

</body>

<!-- Mirrored from wbpreview.com/previews/WB0016FX5/ by HTTrack Website Copier/3.x [XR&CO'2010], Thu, 16 May 2013 12:41:02 GMT -->
</html>