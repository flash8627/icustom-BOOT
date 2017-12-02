var HtmlAreaService = function() {
    var BASE = '../services/htmlarea/htmlAreaService';
    return {
    	findHtmlAreas: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaPage/20/1', function(object) {
                HtmlAreaView.renderHtmlAreaTable(object.result);
                callback();
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
        /*createHtmlArea: function(htmlArea) {
        	var lans = [htmlArea];
        	console.warn(lans);
            batchInsertHtmlArea(lans);
        },*/
        
        batchUpdateHtmlArea: function(items) {
            AjaxUtil.sendPostData(BASE + '/saveOrUpdate', items, function(htmlArea) {
            	var obj = htmlArea.obj;
            	HtmlAreaView.updateHtmlAreaRow(obj);
            });
        },
        deleteHtmlAreaRows: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
                HtmlAreaView.deleteHtmlAreaRows(items);
            });
        }
    }
}();