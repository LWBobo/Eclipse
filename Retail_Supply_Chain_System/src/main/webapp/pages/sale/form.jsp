<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="utf-8" %>

<div class="control-group">
    <label class="control-label" for="stock">货物</label>

    <div class="controls">
        <s:select list="stockEntityList" name="stock" listKey="id" listValue="product" id="stock"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="stock" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="quantity">数量</label>

    <div class="controls">
        <s:textfield name="saleEntity.quantity" cssClass="input-xlarge" id="quantity"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="saleEntity.quantity" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="amount">总价</label>

    <div class="controls">
        <s:textfield name="saleEntity.amount" cssClass="input-xlarge" id="amount"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="saleEntity.amount" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="user">销售人员</label>

    <div class="controls">
        <s:select list="userEntityList" name="user" listKey="userId" listValue="name" id="user"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="user" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>