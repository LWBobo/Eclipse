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
        </li>
    </ul>
</div>

<div class="row-fluid sortable">

    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3>
                <i class="icon-user"></i>
                <span class="break"></span>
                采购管理
            </h3>
        </div>

        <div class="box-content">
            <s:actionmessage cssClass="alert alert-success" cssStyle="list-style: none;"/>
        </div>

        <div class="box-content">
            <div>
                <s:a namespace="/common" action="addPurchase" cssClass="btn btn-primary">添加采购信息</s:a>
            </div>

            <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>采购产品</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>运送方式</th>
                    <th>运送状态</th>
                    <th>采购公司</th>
                    <th>采购人</th>
                    <th>采购日期</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <s:iterator var="purchase" value="purchaseEntityPaginationBean.items" status="status">
                    <tr>
                        <td>
                            <s:property value="#status.index + 1"/>
                        </td>
                        <td>
                            <s:url namespace="/common" action="detailPurchase" id="detailUrl">
                                <s:param name="purchaseEntity.id" value="#purchase.id"/>
                            </s:url>

                            <s:a href="%{detailUrl}">
                                <s:property value="#purchase.product"/>
                            </s:a>
                        </td>
                        <td>
                            <s:property value="#purchase.quantity"/>
                        </td>
                        <td>
                            <s:property value="#purchase.amount"/>
                        </td>
                        <td>
                            <s:property value="#purchase.transport"/>
                        </td>
                        <td>
                            <s:property value="#purchase.status"/>
                        </td>
                        <td>
                            <s:property value="#purchase.cooperationEntity.name"/>
                        </td>
                        <td>
                            <s:property value="#purchase.userEntity.name"/>
                        </td>
                        <td>
                            <s:property value="#purchase.createdTs"/>
                        </td>

                        <td>
                            <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                <s:url namespace="/common" action="updatePurchase" id="updateUrl">
                                    <s:param name="purchaseEntity.id" value="#purchase.id"/>
                                </s:url>

                                <s:a href="%{updateUrl}" cssClass="btn btn-xs btn-info">
                                    更新
                                </s:a>

                                <s:url namespace="/common" action="deletePurchase" id="deleteUrl">
                                    <s:param name="purchaseEntity.id" value="#purchase.id"/>
                                </s:url>

                                <s:a action="%{deleteUrl}" cssClass="btn btn-xs btn-danger">
                                    删除
                                </s:a>
                            </div>
                        </td>
                    </tr>
                </s:iterator>

                </tbody>
            </table>

            <div class="col-sm-6">
                <div class="pagination pull-right">
                    <ul>
                        <s:if test="purchaseEntityPaginationBean.currentPage == 0">
                            <li class="prev disabled">
                                <a href="#"> << </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="purchaseList" id="prevUrl">
                                <s:param name="purchaseEntityPaginationBean.currentPage" value="0"/>
                                <s:param name="purchaseEntityPaginationBean.pageSize"
                                         value="purchaseEntityPaginationBean.pageSize"/>
                            </s:url>

                            <li class="prev">
                                <s:a href="%{prevUrl}">
                                    <<
                                </s:a>
                            </li>
                        </s:else>
                        <s:if test="purchaseEntityPaginationBean.currentPage == 0">
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="purchaseList" id="prevUrl2">
                                <s:param name="purchaseEntityPaginationBean.currentPage"
                                         value="purchaseEntityPaginationBean.currentPage - 1"/>
                                <s:param name="purchaseEntityPaginationBean.pageSize"
                                         value="purchaseEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{prevUrl2}">上一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="purchaseEntityPaginationBean.currentPage + 1 == purchaseEntityPaginationBean.totalPage || purchaseEntityPaginationBean.totalPage == 0">
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="purchaseList" id="nextUrl2">
                                <s:param name="purchaseEntityPaginationBean.currentPage"
                                         value="purchaseEntityPaginationBean.currentPage + 1"/>
                                <s:param name="purchaseEntityPaginationBean.pageSize"
                                         value="purchaseEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{nextUrl2}">下一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="purchaseEntityPaginationBean.currentPage + 1 == purchaseEntityPaginationBean.totalPage || purchaseEntityPaginationBean.totalPage == 0">
                            <li class="next disabled">
                                <a href="#">
                                    >>
                                </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="purchaseList" id="nextUrl">
                                <s:param name="purchaseEntityPaginationBean.currentPage"
                                         value="purchaseEntityPaginationBean.totalPage - 1"/>
                                <s:param name="purchaseEntityPaginationBean.pageSize"
                                         value="purchaseEntityPaginationBean.pageSize"/>
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