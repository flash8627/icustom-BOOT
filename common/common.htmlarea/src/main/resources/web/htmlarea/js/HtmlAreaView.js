var HtmlAreaView = function() {
    var generateHtmlAreaTableTrHtml = function(htmlarea) {
        return TemplateUtil.renderHtml('htmlarea_table_tr_template', htmlarea);
    };
    return {
        renderHtmlAreaTable: function(htmlareaList) {
        	console.warn('htmlareaList1?',htmlareaList);
            TemplateUtil.registerPartical('tr', 'htmlarea_table_tr_template');
            var html = TemplateUtil.renderHtml('htmlarea_table_template', {
                data: htmlareaList
            });

        	console.warn('html?',html);
            $('#htmlarea_list').html(html);
        },
        renderHtmlAreaModal: function(title, htmlarea) {
            var $modal = $('#htmlarea_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('htmlarea_modal_form_template', htmlarea);
            $modal.find('.modal-body').html(html);
        },
        insertHtmlAreaRow: function(htmlarea) {
            var html = generateHtmlAreaTableTrHtml(htmlarea);
            $('#htmlarea_table').find('tbody').prepend(html);
        },
        updateHtmlAreaRow: function(htmlarea) {
        	console.warn(htmlarea);
            var html = generateHtmlAreaTableTrHtml(htmlarea);
            $('#htmlarea_table').find('tbody').find('tr[data-id="' + htmlarea.htmlAreaId + '"]').replaceWith(html);
        },
        deleteHtmlAreaRow: function(htmlAreaId) {
            $('#htmlarea_table').find('tbody').find('tr[data-id="' + htmlAreaId + '"]').remove();
        },
        deleteHtmlAreaRows: function(items) {
            for(var nav in items){
            	$('#htmlarea_table').find('tbody').find('tr[data-id="' + nav.htmlAreaId + '"]').remove();
            }
        }
    };
}();