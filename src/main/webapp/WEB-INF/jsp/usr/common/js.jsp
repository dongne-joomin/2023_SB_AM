<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	let mag = '${msg}'.trim();
	let isHistoryBack = '${isHistoryBack}';
	
	// falsy
	if(msg) {
		alert(msg);
	}
	
	if(isHistoryBack) {
		history.back();
	}
	
</script>