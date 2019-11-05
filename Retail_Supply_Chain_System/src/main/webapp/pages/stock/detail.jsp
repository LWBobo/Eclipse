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
            <s:a namespace="/common" action="stockList">库存管理</s:a>
            <span class="divider">/</span>
        </li>
        <li>
           库存信息
        </li>
    </ul>
</div>

<div class="row-fluid sortable">
    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3><i class="icon-user"></i><span class="break"></span>库存信息明细</h3>
        </div>
        <hr/>
        <div class="box-content">
            <table class="table table-striped">
                <tr>
                    <td>货物</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="stockEntity.product"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="stockEntity.quantity"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>存货位置</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="stockEntity.place"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>货物状态</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:property value="stockEntity.status"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>是否缺货</td>
                    <td>
                        <div class="slider sliderSimple">
                            <s:if test="stockEntity.quantity < stockEntity.danger">是</s:if>
                            <s:if test="stockEntity.quantity >= stockEntity.danger">否</s:if>
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