<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<div>
    <ul class="breadcrumb">
        <li>
            <s:a class="brand" namespace="/common" action="index">主页</s:a>
            <span class="divider">/</span>
        </li>
        <li <s:if test="#session.loginuser['department']!='经理'&&#session.loginuser['department']!='人事部'"> style="display:none;" </s:if>>
            <s:a namespace="/common" action="userList">人事管理</s:a>
            <span class="divider">/</span>
        </li>
        <li>
            修改员工信息
        </li>
    </ul>
</div>
<script>
function pswdcfm()
{
	var pwd=document.getElementById("password").value;
	var pwdc=document.getElementById("passwordcfm").value;
	if(pwd!=pwdc){
	window.alert("两次密码不一致，请重新输入！");
	}
}
</script>
<div class="row-fluid sortable">
    <div class="box span12">
        <div class="box-header" data-original-title>
            <h3><i class="icon-user"></i><span class="break"></span>修改员工信息</h3>
        </div>
        <hr/>
        <div class="box-content">
            <s:form cssClass="form-horizontal" action="saveUser" namespace="/common">
                <fieldset>
                	<s:if test="#session.loginuser['userId']!=userEntity.userId">
                	 <s:hidden name="userEntity.userId"/>
                     <s:hidden name="userEntity.password"/>
                     <s:hidden name="userEntity.joinedDate"/>
                     <s:hidden name="userEntity.createdBy"/>
                     <s:hidden name="userEntity.createdTs"/>
                    <jsp:include page="form.jsp"/>
                	</s:if>
                	<s:if test="#session.loginuser['userId']==userEntity.userId&&#session.loginuser['department']=='人事部'">
                	 <s:hidden name="userEntity.userId"/>
                     <s:hidden name="userEntity.joinedDate"/>
                     <s:hidden name="userEntity.createdBy"/>
                     <s:hidden name="userEntity.createdTs"/>
                     <jsp:include page="form.jsp"/>
                     <div style="margin-left:18px;" >
                     <label class="control-label" for="password">修改密码&nbsp;&nbsp;&nbsp;&nbsp;</label>
                     <s:password name="userEntity.password" showPassword="true" cssClass="input-xlarge" id="password"/></p>
                      <label class="control-label" for="passwordcfm">确认密码：  </label>
                     <input type="password" class="input-xlarge" id="passwordcfm" onblur="pswdcfm();">
                     </div>
                	</s:if>
                    <s:if test="#session.loginuser['userId']==userEntity.userId&&#session.loginuser['department']!='人事部'">
                     <label class="control-label" for="password">修改密码：  </label>
                     <s:password name="userEntity.password" showPassword="true" cssClass="input-xlarge" id="password"/></p>
                     <label class="control-label" for="passwordcfm">确认密码：  </label>
                     <input type="password" class="input-xlarge" id="passwordcfm" onblur="pswdcfm();">
                     
                     <s:hidden name="userEntity.userId"/>
                     <s:hidden name="userEntity.username"/>
                     <s:hidden name="userEntity.name"/>
                     <s:hidden name="userEntity.sex"/>
                     <s:hidden name="userEntity.age"/>
                     <s:hidden name="userEntity.department"/>
                     <s:hidden name="userEntity.joinedDate"/>
                     <s:hidden name="userEntity.createdBy"/>
                     <s:hidden name="userEntity.createdTs"/>
                    </s:if>
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