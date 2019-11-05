<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<div class="control-group">
    <label class="control-label" for="product">采购产品</label>

    <div class="controls">
        <s:textfield name="purchaseEntity.product" cssClass="input-xlarge" id="product"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="purchaseEntity.product" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="cooperation">合作公司</label>

    <div class="controls">
        <s:select list="cooperationEntityList" name="cooperation" listKey="id" listValue="name" id="cooperation"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="cooperation" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="user">采购员工</label>

    <div class="controls">
        <s:select list="userEntityList" name="user" listKey="userId" listValue="name" id="user"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="user" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="quantity">采购数量</label>

    <div class="controls">
        <s:textfield name="purchaseEntity.quantity" cssClass="input-xlarge" id="quantity"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="purchaseEntity.quantity" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="amount">采购金额</label>

    <div class="controls">
        <s:textfield name="purchaseEntity.amount" cssClass="input-xlarge" id="amount"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="purchaseEntity.amount" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="transport">运输方式</label>

    <div class="controls">
        <s:textfield name="purchaseEntity.transport" cssClass="input-xlarge" id="transport"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="purchaseEntity.transport" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="status">运输状态</label>

    <div class="controls">
        <s:textfield name="purchaseEntity.status" cssClass="input-xlarge" id="status"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="purchaseEntity.status" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>