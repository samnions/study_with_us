function getPage(totalCount,currPage){  

$.jqPaginator('#pagination', {
        totalPages: totalCount,
        visiblePages: 10,
        currentPage: currPage,
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
        	console.info(type);
        	if(type!='init'){
        		$("#currPage").val(num);
        		document.forms[0].submit();
        	}
        }
        
    });
}