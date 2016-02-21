<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <a class="btn btn-link btn-detail" style="display: block;text-align: center;">
        点击显示详细错误信息
    </a>
    <%--<a href="#" class="btn btn-link">&gt;&gt;报告给系统管理员</a>--%>
    <div class="prettyprint detail" style="display: none;width: 1210px;margin: 0 auto;padding-bottom: 30px;">
        ${stackTrace}
    </div>
</div>
<script type="text/javascript">
    $(".btn-detail").click(function() {
        var a = $(this);
        a.find("i").toggleClass("icon-collapse-alt").toggleClass("icon-expand-alt");
        $(".detail").toggle();
    });
</script>