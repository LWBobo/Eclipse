<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="utf-8" %>

<div class="control-group">
    <label class="control-label" for="product">货物</label>

    <div class="controls">
        <s:textfield name="stockEntity.product" cssClass="input-xlarge" id="product"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="stockEntity.product" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="quantity">数量</label>

    <div class="controls">
        <s:textfield name="stockEntity.quantity" cssClass="input-xlarge" id="quantity"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="stockEntity.quantity" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="place">存放位置</label>

    <div class="controls">
        <s:textfield name="stockEntity.place" cssClass="input-xlarge" id="place"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="stockEntity.place" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="danger">库存预警</label>

    <div class="controls">
        <s:textfield name="stockEntity.danger" cssClass="input-xlarge" id="danger"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="stockEntity.danger" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="status">货物状态</label>

    <div class="controls">
        <s:select list="#{'完好': '完好', '受潮': '受潮', '破损': '破损'}" name="stockEntity.status" cssClass="input-xlarge" id="status"/>
        <span class="help-inline col-xs-12 col-sm-7">
            <span class="middle text-danger">
                <s:fielderror fieldName="stockEntity.status" cssClass="list-unstyled"/>
            </span>
        </span>
    </div>
</div>