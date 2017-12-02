var HtmlAreaView = function() {
    var generateHtmlAreaTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('htmlArea_table_tr_template', item);
    };
    var insertHtmlAreaTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('htmlArea_modal_form_template', item);
    };
    return {
        renderHtmlAreaTable: function(items) {
            TemplateUtil.registerPartical('tr', 'htmlArea_table_tr_template');
            var html = TemplateUtil.renderHtml('htmlArea_table_template', {
                data: items
            });
            $('#htmlArea_list').html(html);
        },
        renderHtmlAreaModal: function(title, item) {
            var $modal = $('#htmlArea_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('htmlArea_modal_form_template', item);
            $modal.find('.modal-body').html(html);
        },
        
        insertHtmlAreaRow: function(item) {
            var html = insertHtmlAreaTableTrHtml(item);
            $('#htmlArea_table').find('tbody').prepend(html);
        },
        updateHtmlAreaRow: function(items) {
            for(var i=0;i<items.length;i++){
            	var item = items[i];
            	var html = generateHtmlAreaTableTrHtml(item);
            	$('#htmlArea_table').find('tbody').prepend(html);
            }
        },
        deleteHtmlAreaRows: function(items) {
            for(var nav in items){
            	$('#htmlArea_table').find('tbody').find('tr[data-id="' + items[nav].htmlAreaId + '"]').remove();
            }
        }
    };
}();