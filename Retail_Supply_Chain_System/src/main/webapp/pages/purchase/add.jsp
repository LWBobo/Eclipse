<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<div>
    <ul class="breadcrumb">
        <li>
            <s:a class="brand" namespace="/common" action="index">主页</s:a>
            <span class="divider">/</span>
        </li>
        <li>
            <s:a namespace="/common" action="purchaseList">采购管理</s:a>
            <span class="divider">/</span>
        </li>
        <li>
            <s:a namespace="/common" action="addPurchase">添加采购信息</s:a>
        </li>
    </ul>
</div>

<div class="row-fluid sortable">
    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3><i class="icon-user"></i><span class="break"></span>添加采购信息</h3>
        </div>
        <hr/>
        <div class="box-content">
            <s:form cssClass="form-horizontal" action="savePurchase" namespace="/common">
                <fieldset>
                    <jsp:include page="form.jsp"/>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <button type="reset" class="btn">重置</button>
                    </div>
                </fieldset>
            </s:form>
        </div>
    </div>
    <!--/span-->
</div>
<!--/row-->