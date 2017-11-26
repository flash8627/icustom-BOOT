var HtmlAreaService = function() {
    var BASE = '../services/nav';
    return {
    	findHtmlAreas: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaList', function(navigationList) {
                HtmlAreaView.renderHtmlAreaTable(navigationList);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlAreaList/'+itemId, function(navigationList) {
                HtmlAreaView.renderHtmlAreaTable(navigationList);
                callback();
            });
        },
        findHtmlAreaById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findHtmlArea/' + itemId, function(navigation) {
                var title = 'Edit HtmlArea';
                HtmlAreaView.renderHtmlAreaModal(title, navigation);
            });
        },/*
        findHtmlAreasByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/navigations', {
                itemName: name
            }, function(navigationList) {
                HtmlAreaView.renderHtmlAreaTable(navigationList);
            });
        },*/
        createHtmlArea: function(navigation) {
            AjaxUtil.sendPostData(BASE + '/insert', navigation, function(navigation) {
                HtmlAreaView.insertHtmlAreaRow(navigation.obj);
            });
        },
        batchInsertHtmlArea: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                HtmlAreaView.insertHtmlAreaRows(items);
            });
        },
        updateHtmlArea: function(navigation) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', navigation, function(navigation) {
                HtmlAreaView.updateHtmlAreaRow(navigation.obj);
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