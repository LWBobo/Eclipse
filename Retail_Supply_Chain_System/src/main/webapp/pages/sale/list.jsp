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
            <s:a namespace="/common" action="saleList">销售管理</s:a>
        </li>
    </ul>
</div>

<div class="row-fluid sortable">

    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3>
                <i class="icon-user"></i>
                <span class="break"></span>
                销售管理
            </h3>
        </div>

        <div class="box-content">
            <s:actionmessage cssClass="alert alert-success" cssStyle="list-style: none;"/>
        </div>

        <div class="box-content">
            <div>
                <s:a namespace="/common" action="addSale" cssClass="btn btn-primary">添加销售记录</s:a>
            </div>

            <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>货品</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>销售员</th>
                    <th>销售时间</th>
                </tr>
                </thead>
                <tbody>

                <s:iterator var="sale" value="saleEntityPaginationBean.items" status="status">
                    <tr>
                        <td>
                            <s:property value="#status.index + 1"/>
                        </td>
                        <td>
                            <s:property value="#sale.stockEntity.product"/>
                        </td>
                        <td>
                            <s:property value="#sale.quantity"/>
                        </td>
                        <td>
                            <s:property value="#sale.amount"/>
                        </td>
                        <td>
                            <s:property value="#sale.userEntity.name"/>
                        </td>
                        <td>
                            <s:property value="#sale.createdTs"/>
                        </td>

                    </tr>
                </s:iterator>

                </tbody>
            </table>

            <div class="col-sm-6">
                <div class="pagination pull-right">
                    <ul>
                        <s:if test="saleEntityPaginationBean.currentPage == 0">
                            <li class="prev disabled">
                                <a href="#"> << </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="saleList" id="prevUrl">
                                <s:param name="saleEntityPaginationBean.currentPage" value="0"/>
                                <s:param name="saleEntityPaginationBean.pageSize"
                                         value="saleEntityPaginationBean.pageSize"/>
                            </s:url>

                            <li class="prev">
                                <s:a href="%{prevUrl}">
                                    <<
                                </s:a>
                            </li>
                        </s:else>
                        <s:if test="saleEntityPaginationBean.currentPage == 0">
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="saleList" id="prevUrl2">
                                <s:param name="saleEntityPaginationBean.currentPage"
                                         value="saleEntityPaginationBean.currentPage - 1"/>
                                <s:param name="saleEntityPaginationBean.pageSize"
                                         value="saleEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{prevUrl2}">上一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="saleEntityPaginationBean.currentPage + 1 == saleEntityPaginationBean.totalPage || saleEntityPaginationBean.totalPage == 0">
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="saleList" id="nextUrl2">
                                <s:param name="saleEntityPaginationBean.currentPage"
                                         value="saleEntityPaginationBean.currentPage + 1"/>
                                <s:param name="saleEntityPaginationBean.pageSize"
                                         value="saleEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{nextUrl2}">下一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="saleEntityPaginationBean.currentPage + 1 == saleEntityPaginationBean.totalPage || saleEntityPaginationBean.totalPage == 0">
                            <li class="next disabled">
                                <a href="#">
                                    >>
                                </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="saleList" id="nextUrl">
                                <s:param name="saleEntityPaginationBean.currentPage"
                                         value="saleEntityPaginationBean.totalPage - 1"/>
                                <s:param name="saleEntityPaginationBean.pageSize"
                                         value="saleEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li class="next">
                                <s:a href="%{nextUrl}">
                                    >>
                                </s:a>
                            </li>
                        </s:else>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--/span-->

</div>
<!--/row-->