var HtmlAreaService = function() {
    var BASE = '../services/htmlarea/htmlAreaService';
    return {
    	findHtmlAreas: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaPage/20/1', function(object) {
            	console.warn('回来了吗？',object.result);
                HtmlAreaView.renderHtmlAreaTable(object.result);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaList/'+itemId, function(HtmlAreaList) {
                HtmlAreaView.renderHtmlAreaTable(HtmlAreaList);
                callback();
            });
        },
        findHtmlAreaById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlArea/' + itemId, function(HtmlArea) {
                var title = 'Edit HtmlArea';
                HtmlAreaView.renderHtmlAreaModal(title, HtmlArea);
            });
        },/*
        findHtmlAreasByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/HtmlAreas', {
                itemName: name
            }, function(HtmlAreaList) {
                HtmlAreaView.renderHtmlAreaTable(HtmlAreaList);
            });
        },*/
        createHtmlArea: function(HtmlArea) {
            AjaxUtil.sendPostData(BASE + '/saveOrUpdate', HtmlArea, function(HtmlArea) {
                HtmlAreaView.insertHtmlAreaRow(HtmlArea.data);
            });
        },
        batchInsertHtmlArea: function(items) {
            AjaxUtil.sendPostData(BASE + '/saveOrUpdate', items, function(items) {
                HtmlAreaView.insertHtmlAreaRows(items);
            });
        },
        updateHtmlArea: function(HtmlArea) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', HtmlArea, function(HtmlArea) {
                HtmlAreaView.updateHtmlAreaRow(HtmlArea.data);
            });
        },
        deleteHtmlAreaById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                HtmlAreaView.deleteHtmlAreaRow(id);
            });
        },
        deleteHtmlAreaRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                HtmlAreaView.deleteHtmlAreaRows(items);
            });
        }
    }
}();