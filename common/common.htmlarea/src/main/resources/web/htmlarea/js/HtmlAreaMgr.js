$.extend($.fn.validatebox.defaults.rules, {
	equaldDate : {
		validator : function(value, param) {
			var d1 = $(param[0]).datetimebox('getValue'); //获取开始时间
			return value >= d1; //有效范围为大于开始时间的日期
		},
		message : '结束日期不能早于开始日期!'
	}
})
var validateRemoveBtn = function(){
	var checkNum = $('input:checkbox[name=htmlAreaId]:checked').length;
	if(checkNum>0){
		$(".optionbtn").removeClass("l-btn-disabled");
	}else{
		$(".optionbtn").addClass("l-btn-disabled");
	}
}

/**取编辑form表单的值*/
/*getSearchFormValue=function(){
	var htmlObj = {};
	htmlObj.name = $('#search_html_area #name').val();
	htmlObj.title = $('#search_html_area #title').val();
	htmlObj.mappingUrl = $('#search_html_area #mappingUrl').val();
	htmlObj.content = $('textarea[name="searchHtmlAreaContent"]').val();
	htmlObj.description = $('#search_html_area textarea[name="description"]').val();
	programFilterEnable = $('#search_html_area input[name="programFilterEnable"]').val();
	htmlObj.programFilterEnable = programFilterEnable==1?true:false;
	htmlObj.category = $('#search_html_area input[name="category"]').val();
	var createdToDate = $('#search_html_area input[name="createdToDate"]').val();
	//console.info('createToDate 1',createToDate);
	htmlObj.createdToDate = createdToDate;
	var createFromDate = $('#search_html_area input[name="createFromDate"]').val();
	//console.info('createFromDate 2',createFromDate);
	htmlObj.createFromDate = createFromDate;
	htmlObj.htmlAreaId = $('#search_html_area #htmlAreaId').val();
	return htmlObj;	
}*/

/**设置编辑form表单的值*/
/*setSearchFormValue=function(htmlObj){

	$('#htmlarea_modal #name').val(htmlObj.name);
	$('textarea[name="searchHtmlAreaContent"]').val(htmlObj.content);
	$('#htmlarea_modal #title').val(htmlObj.title);
	$('#htmlarea_modal #mappingUrl').val(htmlObj.mappingUrl);
	$('#htmlarea_modal textarea[name="description"]').val(htmlObj.description);
	$('#htmlarea_modal input[name="programFilterEnable"]').val(htmlObj.programFilterEnable);
	$('#htmlarea_modal input[name="category"]').val(htmlObj.category);
	$('#htmlarea_modal #validToDate').val(htmlObj.validToDate);
	$('#htmlarea_modal #validFromDate').val(htmlObj.validFromDate);
	$('#htmlarea_modal #htmlAreaId').val(htmlObj.htmlAreaId);
}*/

/**取编辑form表单的值*/
getEditorFormValue=function(){
	var htmlObj = {};
	htmlObj.name = $('#htmlarea_modal #name').val();
	htmlObj.title = $('#htmlarea_modal #title').val();
	htmlObj.mappingUrl = $('#htmlarea_modal #mappingUrl').val();
	htmlObj.content = $('textarea[name="textareaContent"]').val();
	htmlObj.description = $('#htmlarea_modal textarea[name="description"]').val();
	programFilterEnable = $('#htmlarea_modal input[name="programFilterEnable"]').val();
	htmlObj.programFilterEnable = programFilterEnable==1?true:false;
	htmlObj.category = $('#htmlarea_modal input[name="category"]').val();
	var validFromDate = $('#htmlarea_modal input[name="validFromDate"]').val();
	//console.info('createToDate 1',createToDate);
	htmlObj.validFromDate = validFromDate;
	var validToDate = $('#htmlarea_modal input[name="validToDate"]').val();
	//console.info('createFromDate 2',createFromDate);
	htmlObj.validToDate = validToDate;
	htmlObj.htmlAreaId = $('#htmlarea_modal #htmlAreaId').val();
	return htmlObj;	
}

/**设置编辑form表单的值*/
setEditorFormValue=function(htmlObj){
	console.warn("titletitle",htmlObj);
}

KindEditor.ready(function(K) {
	var editor = K.create('textarea[name="content1"]', {
		cssPath : 'kindeditor/plugins/code/prettify.css',
		uploadJson : 'kindeditor/asp/upload_json.asp',
		fileManagerJson : 'kindeditor/asp/file_manager_json.asp',
		allowFileManager : true,
		afterBlur : function() {
			this.sync();
		}
	});
	prettyPrint();
	$("#content").change(function() {
		$.post("as.asp", {
			act : "getcontent",
			id : $(this).val()
		}, function(data) {
			editor.html(data);
		});
	});
});

var editor = null;
/**
 * 渲染编辑窗口和填充表单
 */
renderHtmlAreaModal=function(title,htmlObj){
	
	$('#htmlarea_modal .modal-title').text(title);
	$('#htmlarea_modal #name').val(htmlObj.name);
	
	editor.html(htmlObj.content);
	$('#htmlarea_modal #title').val(htmlObj.title);
	$('#htmlarea_modal #mappingUrl').val(htmlObj.mappingUrl);
	$('#htmlarea_modal textarea[name="description"]').val(htmlObj.description);
	$('#htmlarea_modal input[name="programFilterEnable"]').val(htmlObj.programFilterEnable);
	$('#htmlarea_modal input[name="category"]').val(htmlObj.category);
	$('#htmlarea_modal #validToDate').val(htmlObj.validToDate);
	$('#htmlarea_modal #validFromDate').val(htmlObj.validFromDate);
	$('#htmlarea_modal #htmlAreaId').val(htmlObj.htmlAreaId);
	$('#htmlarea_modal').modal('show');
}

$(function() {
	
	// 显示所有产品
	//$('body').hide(); // 隐藏界面
	HtmlAreaService.findHtmlAreas(function() {
		$('body').show(); // 显示界面
	});
	
	editor = KindEditor.create('textarea[name="textareaContent"]', {
		resizeType : 1,
		afterCreate : function() {
			this.sync();
		},
		//下面这行代码就是关键的所在，当失去焦点时执行 this.sync();  
		afterBlur : function() {
			this.sync();
		}
	});
	
	// 点击 Create 按钮，弹出创建产品对话框
	$('#htmlarea_create').on('click', function() {
		//改为直接赋值var form = $('#editor_html_area').clone();
		var htmlArea = {
			htmlAreaId : 0,
			name : '',
			title : '',
			mappingUrl : '',
			content : '',
			category : '',
			description : '',
			secondLevelType : '',
			thirdLevelType : '',
			validToDate : '',
			validFromDate : '',
			programFilterEnable : ''
		};
		var title = 'Create HtmlArea';
		renderHtmlAreaModal(title,htmlArea);

	});
	
	/**修改
	*/
	$(document).on('click', '.htmlarea_edit', function() {
    	var $tr = $(this).closest('tr');
    	var itemId = $tr.data('id');
    	var htmlAreaObj = HtmlAreaService.findHtmlAreaByItem(itemId);

		renderHtmlAreaModal("Editor HtmlArea",htmlAreaObj);
		
    });
	
	// 点击对话框中的 Save 按钮，创建或更新产品
	$('#htmlarea_modal_submit').on('click', function() {
		var idNode = $('#htmlAreaId');
		var mappingUrlNode = $('#mappingUrl');
		var id = $(idNode).val();
		
		var htmlArea = getEditorFormValue();
		if(htmlArea.htmlAreaId!=0){
			console.warn('submit',mappingUrlNode);
			$('#htmlArea_table').find('tbody').find('tr[data-id="' + htmlArea.htmlAreaId + '"]').remove();
		}
		$(".actionbtn").toggleClass("l-btn-disabled");
		HtmlAreaService.batchUpdateHtmlArea(htmlArea);
		$('#htmlarea_modal').modal('toggle');

	});
	
	// 点击 Delete 按钮，删除产品
	$(document).on('click','#htmlArea_remove',function() {
		var chkValues =[];
		$('input[name="htmlAreaId"]:checked').each(function(){
			var item = {htmlAreaId:$(this).val()}
			chkValues.push(item);
		});
		if(chkValues.length<1){
			//直接返回
			return;
		}
		
		if (confirm('Do you want to delete this htmlArea?')) {
			HtmlAreaService.deleteHtmlAreaRows(chkValues);
		}
		return false;
	});
	
	/*// 根据关键字查询产品
	$('#htmlarea_search_search').on('submit', function() {
		var keyword = $('htmlArea_search_form #keyword').val().trim();
		return false;
	});
	
	// 根据关键字查询产品
	$('#htmlarea_search_reset').on('submit', function() {
		var keyword = $('htmlArea_search_form #keyword').val().trim();
		return false;
	});*/

});
