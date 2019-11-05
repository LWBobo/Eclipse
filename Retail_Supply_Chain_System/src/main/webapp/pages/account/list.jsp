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
            <s:a namespace="/common" action="accountList">数据统计</s:a>
        </li>
    </ul>
</div>

<div class="row-fluid sortable">

    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3>
                <i class="icon-user"></i>
                <span class="break"></span>
                数据统计
            </h3>
        </div>

        <div class="box-content">
            <div class="span4">
                <h5>最佳销售TOP 10</h5>
                <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>Rank</th>
                        <th>姓名</th>
                        <th>销售金额</th>
                    </tr>
                    </thead>
                    <tbody>

                    <s:iterator var="item" value="top10BestSales" status="status">
                        <tr>
                            <td>
                                <s:property value="#status.index + 1"/>
                            </td>
                            <td>
                                <s:property value="#item[0]"/>
                            </td>
                            <td>
                                <s:property value="#item[1]"/>
                            </td>
                        </tr>
                    </s:iterator>

                    </tbody>
                </table>
            </div>
            <div class="span4">
                <h5>最佳采购TOP 10</h5>

                <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>Rank</th>
                        <th>姓名</th>
                        <th>采购金额</th>
                    </tr>
                    </thead>
                    <tbody>

                    <s:iterator var="item" value="top10BestPurchases" status="status">
                        <tr>
                            <td>
                                <s:property value="#status.index + 1"/>
                            </td>
                            <td>
                                <s:property value="#item[0]"/>
                            </td>
                            <td>
                                <s:property value="#item[1]"/>
                            </td>
                        </tr>
                    </s:iterator>

                    </tbody>
                </table>
            </div>
            <div class="span4">
                <h5>最佳产品TOP 10</h5>

                <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                    <tr>
                        <th>Rank</th>
                        <th>产品</th>
                        <th>销售总量</th>
                    </tr>
                    </thead>
                    <tbody>

                    <s:iterator var="item" value="top10BestProducts" status="status">
                        <tr>
                            <td>
                                <s:property value="#status.index + 1"/>
                            </td>
                            <td>
                                <s:property value="#item[0]"/>
                            </td>
                            <td>
                                <s:property value="#item[1]"/>
                            </td>
                        </tr>
                    </s:iterator>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--/span-->

</div>
<!--/row-->