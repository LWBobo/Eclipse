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
            采购信息明细
        </li>
    </ul>
</div>

<div class="row-fluid sortable">
    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3><i class="icon-user"></i><span class="break"></span>采购信息明细</h3>
        </div>
        <hr/>
        <div class="box-content">
            <table class="table table-striped">
                <tr>
                    <td>采购产品</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.product"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>采购公司</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.cooperationEntity.name"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>采购员工</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.userEntity.name"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>采购数量</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.quantity"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>采购金额</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.amount"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>运输方式</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.transport"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>运输状态</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="purchaseEntity.status"/>
                        </div>
                    </td>
                </tr>
            </table>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary" onclick="window.print();">打印</button>
            </div>
        </div>
    </div>
    <!--/span-->
</div>
<!--/row-->