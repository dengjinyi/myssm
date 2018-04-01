<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var basePath = "${basePath}";
</script>

<c:set var="fullPath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<c:set var="cssPath" value="${pageContext.request.contextPath}/css"/>  


<link href="${basePath}/common/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
<link href="${basePath}/common/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${basePath}/common/bootstrap/table/bootstrap-table.min.css" rel="stylesheet"/>
<link href="${basePath}/common/common.css" rel="stylesheet"/>
<script src="${basePath}/common/jquery/jquery.js"></script>
<script src="${basePath}/common/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/common/bootstrap/table/bootstrap-table.min.js"></script>
<script src="${basePath}/common/bootstrap/table/bootstrap-table-zh-CN.min.js"></script>

<link href="${basePath}/common/jquery/chosen/chosen.min.css" rel="stylesheet"/>
<script src="${basePath}/common/jquery/chosen/chosen.jquery.min.js"></script>
<script src="${basePath}/common/layer/layer.js"></script>
