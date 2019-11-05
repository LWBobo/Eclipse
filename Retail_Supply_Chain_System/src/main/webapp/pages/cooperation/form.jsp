<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<div class="control-group">
    <label class="control-label" for="name">公司名称</label>

    <div class="controls">
        <s:textfield name="cooperationEntity.name" cssClass="input-xlarge" id="name"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="cooperationEntity.name" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="name">负责人</label>

    <div class="controls">
        <s:textfield name="cooperationEntity.personInCharge" cssClass="input-xlarge" id="personInCharge"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="cooperationEntity.personInCharge" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="telephone">电话</label>

    <div class="controls">
        <s:textfield name="cooperationEntity.telephone" cssClass="input-xlarge" id="telephone"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="cooperationEntity.sex" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="address">地址</label>

    <div class="controls">
        <s:textfield name="cooperationEntity.address" cssClass="input-xlarge" id="address"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="cooperationEntity.address" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>