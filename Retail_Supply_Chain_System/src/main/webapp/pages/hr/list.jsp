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
            <s:a namespace="/common" action="userList">人事管理</s:a>
        </li>
    </ul>
</div>

<div class="row-fluid sortable">

    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3><i class="icon-user"></i><span class="break"></span>人事管理</h3>
        </div>

        <div class="box-content">
            <s:actionmessage cssClass="alert alert-success" cssStyle="list-style: none;"/>
        </div>

        <div class="box-content">
            <div>
                <s:a namespace="/common" action="addUser" cssClass="btn btn-primary">添加员工信息</s:a>
            </div>

            <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>部门</th>
                    <th>入职日期</th>
                    <th>创建人</th>
                    <th>创建日期</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <s:iterator var="user" value="userEntityPaginationBean.items" status="status">
                    <tr>
                        <td>
                            <s:property value="#status.index + 1"/>
                        </td>
                        <td>
                            <s:property value="#user.name"/>
                        </td>
                        <td>
                            <s:if test="#user.sex == \"0\"">
                                男
                            </s:if>
                            <s:else>
                                女
                            </s:else>
                        </td>
                        <td>
                            <s:property value="#user.age"/>
                        </td>
                        <td>
                            <s:property value="#user.department"/>
                        </td>
                        <td>
                            <s:property value="#user.joinedDate"/>
                        </td>
                        <td>
                            <s:property value="#user.createdBy"/>
                        </td>
                        <td>
                            <s:property value="#user.createdTs"/>
                        </td>

                        <td>
                            <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                <s:url namespace="/common" action="updateUser" id="updateUrl">
                                    <s:param name="userEntity.userId" value="#user.userId"/>
                                </s:url>

                                <s:a href="%{updateUrl}" cssClass="btn btn-xs btn-info" >
                                    更新
                                </s:a>

                                <s:url namespace="/common" action="deleteUser" id="deleteUrl">
                                    <s:param name="userEntity.userId" value="#user.userId"/>
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
                        <s:if test="userEntityPaginationBean.currentPage == 0">
                            <li class="prev disabled">
                                <a href="#"> << </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/salon" action="userList" id="prevUrl">
                                <s:param name="userEntityPaginationBean.currentPage" value="0"/>
                                <s:param name="userEntityPaginationBean.pageSize"
                                         value="userEntityPaginationBean.pageSize"/>
                            </s:url>

                            <li class="prev">
                                <s:a href="%{prevUrl}">
                                    <<
                                </s:a>
                            </li>
                        </s:else>
                        <s:if test="userEntityPaginationBean.currentPage == 0">
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="userList" id="prevUrl2">
                                <s:param name="userEntityPaginationBean.currentPage"
                                         value="userEntityPaginationBean.currentPage - 1"/>
                                <s:param name="userEntityPaginationBean.pageSize"
                                         value="userEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{prevUrl2}">上一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="userEntityPaginationBean.currentPage + 1 == userEntityPaginationBean.totalPage || userEntityPaginationBean.totalPage == 0">
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="userList" id="nextUrl2">
                                <s:param name="userEntityPaginationBean.currentPage"
                                         value="userEntityPaginationBean.currentPage + 1"/>
                                <s:param name="userEntityPaginationBean.pageSize"
                                         value="userEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{nextUrl2}">下一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="userEntityPaginationBean.currentPage + 1 == userEntityPaginationBean.totalPage || userEntityPaginationBean.totalPage == 0">
                            <li class="next disabled">
                                <a href="#">
                                    >>
                                </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="userList" id="nextUrl">
                                <s:param name="userEntityPaginationBean.currentPage"
                                         value="userEntityPaginationBean.totalPage - 1"/>
                                <s:param name="userEntityPaginationBean.pageSize"
                                         value="userEntityPaginationBean.pageSize"/>
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