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
        </li>
    </ul>
</div>

<div class="row-fluid sortable">

    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3>
                <i class="icon-user"></i>
                <span class="break"></span>
                库存管理
            </h3>
        </div>

        <div class="box-content">
            <s:actionmessage cssClass="alert alert-success" cssStyle="list-style: none;"/>
        </div>

        <div class="box-content">
            <div>
                <s:a namespace="/common" action="addStock" cssClass="btn btn-primary">添加库存信息</s:a>
            </div>

            <table style="margin-top: 10px" class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>货品</th>
                    <th>数量</th>
                    <th>存放位置</th>
                    <th>存放位置</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
				<%int dannum=Integer.parseInt(request.getAttribute("dannum").toString()); %>
                <s:iterator var="stock" value="stockEntityPaginationBean.items" status="status">
                    <s:if test="#stock.quantity < #stock.danger"> <%dannum++;%></s:if>
                    <tr <s:if test="#stock.quantity < #stock.danger"> class="error" </s:if>>
                        <td>
                            <s:property value="#status.index + 1"/>
                        </td>
                        <td>
                            <s:url namespace="/common" action="detailStock" id="detailUrl">
                                <s:param name="stockEntity.id" value="#stock.id"/>
                            </s:url>

                            <s:a href="%{detailUrl}">
                                <s:property value="#stock.product"/>
                            </s:a>
                        </td>
                        <td>
                            <s:property value="#stock.quantity"/>
                        </td>
                        <td>
                            <s:property value="#stock.place"/>
                        </td>
                        <td>
                            <s:property value="#stock.status"/>
                        </td>

                        <td>
                            <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                <s:url namespace="/common" action="updateStock" id="updateUrl">
                                    <s:param name="stockEntity.id" value="#stock.id"/>
                                </s:url>

                                <s:a href="%{updateUrl}" cssClass="btn btn-xs btn-info">
                                    更新
                                </s:a>
                            </div>
                        </td>
                    </tr>
                </s:iterator>

                </tbody>
            </table>
			
			<% if(dannum>0){%>
			<input type="hidden" id="dannum" value="<%=dannum %>">
			<script>
				var i=document.getElementById("dannum").value;
				window.alert("请注意，您有"+i+"类货物库存不足！");
			</script>
			<% } %>
			
            <div class="col-sm-6">
                <div class="pagination pull-right">
                    <ul>
                        <s:if test="stockEntityPaginationBean.currentPage == 0">
                            <li class="prev disabled">
                                <a href="#"> << </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="stockList" id="prevUrl">
                                <s:param name="stockEntityPaginationBean.currentPage" value="0"/>
                                <s:param name="stockEntityPaginationBean.pageSize"
                                         value="stockEntityPaginationBean.pageSize"/>
                            </s:url>

                            <li class="prev">
                                <s:a href="%{prevUrl}">
                                    <<
                                </s:a>
                            </li>
                        </s:else>
                        <s:if test="stockEntityPaginationBean.currentPage == 0">
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="stockList" id="prevUrl2">
                                <s:param name="stockEntityPaginationBean.currentPage"
                                         value="stockEntityPaginationBean.currentPage - 1"/>
                                <s:param name="stockEntityPaginationBean.pageSize"
                                         value="stockEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{prevUrl2}">上一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="stockEntityPaginationBean.currentPage + 1 == stockEntityPaginationBean.totalPage || stockEntityPaginationBean.totalPage == 0">
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="stockList" id="nextUrl2">
                                <s:param name="stockEntityPaginationBean.currentPage"
                                         value="stockEntityPaginationBean.currentPage + 1"/>
                                <s:param name="stockEntityPaginationBean.pageSize"
                                         value="stockEntityPaginationBean.pageSize"/>
                            </s:url>
                            <li>
                                <s:a href="%{nextUrl2}">下一页</s:a>
                            </li>
                        </s:else>
                        <s:if test="stockEntityPaginationBean.currentPage + 1 == stockEntityPaginationBean.totalPage || stockEntityPaginationBean.totalPage == 0">
                            <li class="next disabled">
                                <a href="#">
                                    >>
                                </a>
                            </li>
                        </s:if>
                        <s:else>
                            <s:url namespace="/common" action="stockList" id="nextUrl">
                                <s:param name="stockEntityPaginationBean.currentPage"
                                         value="stockEntityPaginationBean.totalPage - 1"/>
                                <s:param name="stockEntityPaginationBean.pageSize"
                                         value="stockEntityPaginationBean.pageSize"/>
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