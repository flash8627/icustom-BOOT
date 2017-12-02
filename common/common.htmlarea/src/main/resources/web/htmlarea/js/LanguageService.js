var HtmlAreaService = function() {
    var BASE = '../services/htmlarea/htmlAreaService';
    return {
    	findHtmlAreas: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaPage/20/1', function(object) {
                HtmlAreaView.renderHtmlAreaTable(object.result);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaList/'+itemId, function(list) {
                HtmlAreaView.renderHtmlAreaTable(list);
                callback();
            });
        },
        findHtmlAreaById: function(itemId) {
        	//查询后直接填充到页面
            AjaxUtil.sendGetRequest(BASE + '/findItem/' + itemId, function(htmlArea) {
                var title = 'Edit HtmlArea';
                HtmlAreaView.renderHtmlAreaModal(title, htmlArea);
            });
        },
        findHtmlAreaByItem: function(itemId) {
        	var result = {};
        	//返回查询值,需要发同步请求吗？
            AjaxUtil.sendGetAsyncRequest(BASE + '/findByHtmlArea/' + itemId, function(htmlArea) {
            	result = htmlArea;
            	return result;
            });
            return result;
        },
        createHtmlArea: function(htmlArea) {
        	var lans = [htmlArea];
        	console.warn(lans);
            batchInsertHtmlArea(lans);
        },
        batchInsertHtmlArea: function(items,callback) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(object) {
            	console.warn(object);
                HtmlAreaView.insertHtmlAreaRows(object.data,callback);
            });
        },
        batchUpdateHtmlArea: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(htmlArea) {
                HtmlAreaView.updateHtmlAreaRow(htmlArea);
            });
        },
        deleteHtmlAreaById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                HtmlAreaView.deleteHtmlAreaRow(id);
            });
        },
        deleteHtmlAreaRows: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
                HtmlAreaView.deleteHtmlAreaRows(items);
            });
        }
    }
}();