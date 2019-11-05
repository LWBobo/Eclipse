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
            <s:a namespace="/common" action="cooList">合作公司管理</s:a>
        </li>
    </ul>
</div>

<div class="row-fluid sortable">

    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3>
                <i class="icon-user"></i>
                <span class="break"></span>
                合作公司管理
            </h3>
        </div>

        <div class="box-content">
            <s:actionmessage cssClass="alert alert-success" cssStyle="list-style: none;"/>
        </div>

        <div class="box-content">
            <div>
                <s:a namespace="/common" action="addCoo" cssClass="btn btn-primary">添加合作公司</s:a>
            </div>

            <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>公司名称</th>
                    <th>负责人</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>创建人</th>
                    <th>创建日期</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <s:iterator var="cooperation" value="cooperationEntityPaginationBean.items" status="status">
                    <tr>
                        <td>
                            <s:property value="#status.index + 1"/>
                        </td>
                        <td>
                            <s:property value="#cooperation.name"/>
                        </td>
                        <td>
                            <s:property value="#cooperation.personInCharge"/>
                        </td>
                        <td>
                            <s:property value="#cooperation.telephone"/>
                        </td>
                        <td>
                            <s:property value="#cooperation.address"/>
                        </td>
                        <td>
                            <s:property value="#cooperation.createdBy"/>
                        </td>
                        <td>
                            <s:property value="#cooperation.createdTs"/>
                        </td>

                        <td>
                            <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                <s:url namespace="/common" action="updateCoo" id="updateUrl">
                                    <s:param name="cooperationEntity.id" value="#cooperation.id"/>
                                </s:url>

                                <s:a href="%{updateUrl}" cssClass="btn btn-xs btn-info">
                                    更新
                                </s:a>

                                <s:url namespace="/common" action="deleteCoo" id="deleteUrl">
                                    <s:param name="cooperationEntity.id" value="#cooperation.id"/>
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
                        <s:if test="cooperationEntityPaginationBean.currentPage == 0">
                            <li class="prev disabled">
                                <a href="#"> << </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="cooList" id="prevUrl">
                                <s:param name="cooperationEntityPaginationBean.currentPage" value="0"/>
                                <s:param name="cooperationEntityPaginationBean.pageSize"
                                         value="cooperationEntityPaginationBean.pageSize"/>
                            </s:url>

                            <li class="prev">
                                <s:a href="%{prevUrl}">
                                    <<
                                </s:a>
                            </li>
                        </s:else>
                        <s:if test="cooperationEntityPaginationBean.currentPage == 0">
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="cooList" id="prevUrl2">
                                <s:param name="cooperationEntityPaginationBean.currentPage"
                                         value="cooperationEntityPaginationBean.currentPage - 1"/>
                                <s:param name="cooperationEntityPaginationBean.pageSize"
                                         value="cooperationEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{prevUrl2}">上一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="cooperationEntityPaginationBean.currentPage + 1 == cooperationEntityPaginationBean.totalPage || cooperationEntityPaginationBean.totalPage == 0">
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="cooList" id="nextUrl2">
                                <s:param name="cooperationEntityPaginationBean.currentPage"
                                         value="cooperationEntityPaginationBean.currentPage + 1"/>
                                <s:param name="cooperationEntityPaginationBean.pageSize"
                                         value="cooperationEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{nextUrl2}">下一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="cooperationEntityPaginationBean.currentPage + 1 == cooperationEntityPaginationBean.totalPage || cooperationEntityPaginationBean.totalPage == 0">
                            <li class="next disabled">
                                <a href="#">
                                    >>
                                </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="cooList" id="nextUrl">
                                <s:param name="cooperationEntityPaginationBean.currentPage"
                                         value="cooperationEntityPaginationBean.totalPage - 1"/>
                                <s:param name="cooperationEntityPaginationBean.pageSize"
                                         value="cooperationEntityPaginationBean.pageSize"/>
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