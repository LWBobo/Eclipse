<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<div class="control-group">
    <label class="control-label" for="username">用户名</label>

    <div class="controls">
        <s:textfield name="userEntity.username" cssClass="input-xlarge" id="username"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="userEntity.username" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="name">姓名</label>

    <div class="controls">
        <s:textfield name="userEntity.name" cssClass="input-xlarge" id="name"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="userEntity.name" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="sex">性别</label>

    <div class="controls">
        <s:select list="#{'0': '男', '1': '女'}" name="userEntity.sex" cssClass="input-xlarge" id="sex"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="userEntity.sex" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="age">年龄</label>

    <div class="controls">
        <s:textfield name="userEntity.age" cssClass="input-xlarge" id="age"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="userEntity.age" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="age">部门</label>

    <div class="controls">
    	<s:select list="#{'人事部': '人事部','采购部':'采购部', '物资部': '物资部','销售部':'销售部'}" name="userEntity.department" cssClass="input-xlarge" id="department"/>
        <!--<s:textfield name="userEntity.department" cssClass="input-xlarge" id="department"/>-->
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="userEntity.department" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>