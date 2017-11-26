var HtmlAreaView = function() {
    var generateHtmlAreaTableTrHtml = function(navigation) {
        return TemplateUtil.renderHtml('htmlarea_table_tr_template', navigation);
    };
    return {
        renderHtmlAreaTable: function(navigationList) {
            TemplateUtil.registerPartical('tr', 'htmlarea_table_tr_template');
            var html = TemplateUtil.renderHtml('htmlarea_table_template', {
                data: navigationList
            });
            $('#htmlarea_list').html(html);
        },
        renderHtmlAreaModal: function(title, navigation) {
            var $modal = $('#htmlarea_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('htmlarea_modal_form_template', navigation);
            $modal.find('.modal-body').html(html);
        },
        insertHtmlAreaRow: function(navigation) {
            var html = generateHtmlAreaTableTrHtml(navigation);
            $('#htmlarea_table').find('tbody').prepend(html);
        },
        updateHtmlAreaRow: function(navigation) {
        	console.warn(navigation);
            var html = generateHtmlAreaTableTrHtml(navigation);
            $('#htmlarea_table').find('tbody').find('tr[data-id="' + navigation.itemId + '"]').replaceWith(html);
        },
        deleteHtmlAreaRow: function(itemId) {
            $('#htmlarea_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteHtmlAreaRows: function(items) {
            for(var nav in items){
            	$('#htmlarea_table').find('tbody').find('tr[data-id="' + nav.itemId + '"]').remove();
            }
        }
    };
}();