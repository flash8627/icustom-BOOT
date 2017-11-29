var LookupItemService = function() {
    var BASE = '../services/lookup/lookupItemService';
    return {
    	initLookupItems: function(lookup,callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupItems/'+lookup.classId, function(resp) {
            	LookupItemView.addTabPanel(lookup,resp.data);
                callback();
            });
        },
    	findLookupItems: function(lookup,callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupItems/'+lookup.classId, function(resp) {
            	LookupItemView.addTabPanel(lookup,resp.data);
                callback();
            });
        },
        findLookupItemById: function(itemId) {
        	var item = {};
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(lookupItem) {
            	item = lookupItem;
                return item;
            });
            return item;
        },
        batchInsertLookupItem: function(classCode,items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(obj) {
            	var lookupItems = obj.data;
            	for(var i=0;i<lookupItems.length;i++){
            		//插入行
            		LookupItemView.insertLookupItemRow(lookup.classCode,lookupItems[i]);
            	}
            });
        },
        batchUpdateLookupItem: function(classCode,items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(lookupItems) {
            	var objs = lookupItems.data;
            	for(var i=0;i<objs.length;i++){
            		//插入行
            		LookupItemView.insertLookupItemRow(lookup.classCode,objs[i]);
            	}
            });
        },
        batchRemoveLookupItem: function(classCode,items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
            	LookupItemView.deleteLookupItemRow(classCode,items);
            });
        }
    }
}();