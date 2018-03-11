<!DOCTYPE html>
<html>
<head>
	<title>后台管理</title>
    <#include "../common_header.ftl"/>
	
</head>
<body style="zoom: 1;">
	<div class="b-container">
		<#include "../top_menu.ftl"/>
        <#include "../quick_menu.ftl"/>
		<div id="wrap">
            <div class="outer with-side with-transition" style="min-height: 600px;">
                <#include "left_menu.ftl"/>

                <div id="admin_right">
                			<div class="content_box" style="border:none">
                			<div class="position"><span>会员</span><span>&gt;</span><span>会员管理</span><span>&gt;</span><span>会员列表</span></div>
                			<div class="operating">
                				<div class="search f_l">
                					<form  action="" method="get">
                						电话
                						<input class="small" name="phone" type="text" value="${(param.phone)!}"/>
                						昵称
                						<input class="small" name="nickName" type="text" value="${param.nickName?default("")}"/>

                						<button class="btn" type="submit"><span class="sch">搜 索</span></button>
                					</form>
                				</div>
                			</div>
                        <div class="content" style="min-height: 200px;">
                            <table class="list_table" style="font-size:13px;">
                                <thead>
                                    <tr style="height:30px;">
                                        <th width="140px">id</th>
                                        <th width="159px">电话</th>
                                        <th width="200px">微信id</th>
                                        <th width="200px">个人设置是否显示</th>
                                        <th width="150px">昵称</th>

                                        <th width="180px">是否审核</th>

                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <#list memberList as user>
                                    <tr>
                                        <td>${(user.id)!}</td>

                                        <td>${user.phone}</td>
                                        <td>${(user.weixin)!}</td>
                                        <td>${user.selfShow?default("")}<#if user.selfShow?default(0) = 1>  显示<#else> 不显示  </#if> </td>
                                        <td>${user.nickName}</td>

                                        <td>${user.isCheck?default("")}<#if user.isCheck?default(0) = 1>  已审核 <#else> 未审核  </#if>  </td>

                                        <td>

                                            <#if user.isCheck?default(0) = 1>
                                                <a href="javascript:void(0)" onclick="activation(${user.id?c})">取消审核</a>
                                            <#else>
                                                <a href="javascript:void(0)" onclick="setUserBlock(${user.id?c})">审核用户</a>
                                            </#if>

                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>


                	${pageDiv}
                </div>
            </div>
        </div>

		


		</div>

	</div>

	<script type="text/javascript">
		//DOM加载完毕执行
		$(document).ready(function(){
			$("#left_menu_welcome").addClass("selected");
			$("#status_select").val("${param.status?default("")}");
			$("#role_select").val("${param.roleId?default("")}");

		});
	</script>
<script type="text/javascript" charset="UTF-8" src="/cms/script/user.js"></script>


<div style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255);"></div></body></html>