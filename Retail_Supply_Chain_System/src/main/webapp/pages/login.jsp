<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from wbpreview.com/previews/WB0016FX5/login.html by HTTrack Website Copier/3.x [XR&CO'2010], Thu, 16 May 2013 17:56:05 GMT -->
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>请先登录</title>
    <meta name="description" content="Optimus Dashboard Bootstrap Admin Template.">
    <meta name="author" content="Łukasz Holeczek">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link id="bootstrap-style" href="<s:url value="/static/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<s:url value="/static/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
    <link href="<s:url value="/static/css/style.css"/>" rel="stylesheet">
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
<div class="container-fluid">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <h2>百货中心供应链管理系统 - 登录</h2>

                <s:actionerror cssClass="alert alert-danger" cssStyle="list-style: none;"/>

                <s:form class="form-horizontal" action="logon" namespace="/common" method="post">
                    <fieldset>

                        <div class="input-prepend" title="Username">
                            <span class="add-on"><i class="icon-user"></i></span>
                            <input class="input-large span10" name="username" id="username" type="text" placeholder="用户名"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="Password">
                            <span class="add-on"><i class="icon-lock"></i></span>
                            <input class="input-large span10" name="password" id="password" type="password" placeholder="密码"/>
                        </div>
                        <div class="clearfix"></div>


                        <div class="btn-group button-login">
                            <button type="submit" class="btn btn-primary">登录</button>
                        </div>
                        <div class="clearfix"></div>
                </s:form>
            </div><!--/span-->
        </div><!--/row-->

    </div><!--/fluid-row-->

</div><!--/.fluid-container-->

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

<!-- Mirrored from wbpreview.com/previews/WB0016FX5/login.html by HTTrack Website Copier/3.x [XR&CO'2010], Thu, 16 May 2013 17:56:05 GMT -->
</html>

