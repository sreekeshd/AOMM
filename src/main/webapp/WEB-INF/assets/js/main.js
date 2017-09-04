/**
 * 
 */
    $('.saleStockNavBar li a').click(function(e) {
        $('.saleStockNavBar li.active').removeClass('active');
        var $parent = $(this).parent();
        $parent.addClass('active');
        e.preventDefault();
        loadInnerTab($parent.text().toLowerCase());
    });

    loadInnerTab=function( tabName ){
    	$.ajax({
    		type: 'GET',
    		url: tabName,
    		success: function(response) {
    			updatePage( response, tabName );
    		}
    	});
    }
    updatePage = function( response, tabName ){
    	var panelWrapper = $('.panel-wrapper'); 
    	panelWrapper.empty();
    	panelWrapper.html(response);
    	loadTable( tabName )
    }
    
    loadTable = function( tabName ){
    	switch(tabName){
    		case 'stock':
//    			loadStockTable();
    			break;
    		case 'sale':
//    			loadSaleTable();
    			break;
    		default:
    			console.log('WRONG TAB NAME');
    	}
    }
    
    $('#add_stock').click(function(e) {
    	debugger;
        $("#stockModal").modal();
    });
    	
	loadStockTable = function(){
		var oTable = $('#stockTable').DataTable({
			'ajax': "/getStocks",
			'serverSide': true,
//			"responsive": true,
			"bDestroy": true,
//    			"order": [[ 13, "asc" ],[ 1, "asc" ]],
//    			"bAutoWidth": false,
			"language": {
				"zeroRecords": "No data to display"
			},
//    			"oLanguage": {
//    				"sProcessing": self.rootParent.common.setLoader()
//    			},
			"processing": true,
			"sScrollX": '100%',
//    			"fnRowCallback" : function(nRow, aData,
//    					iDisplayIndex, iDisplayIndexFull) {
//    				if (!aData.notified) {
//    					$('td', nRow).css('background', '#CC9999');
//    					notificationData.push(aData.id);
//    				}
//    				self.rootParent.common.renderCountdown(
//    						nRow.lastChild);
//    			},
			"fnDrawCallback": function(settings, ajax) {
			},
			"aoColumns": [{
				data: 'id',
				"title": "<input type='checkbox' name='offer-id-title' class='select_all_check'>",
				"bSortable": false,
				"render": function(data) {
					return "<input class='offer_checkbox' type='checkbox' name='offer-id' value='" + data + "'>"
				}
			}, {
				data: 'id',
				sClass: 'align-center'
			}, {
				data: 'id',
				sClass: 'align-center'
			}, {
				data: 'id',
				sClass: 'align-center'
			}, {
				data: 'id',
				sClass: 'align-center'
			}, {
				data: 'id',
				sClass: 'align-center'
			}, {
				data: 'id',
				sClass: 'align-right'
			},{
				
				data: 'id',
				sClass: 'align-center'
			}, 
			{
				data: 'id',
				sClass: 'align-right',
			
			}],
			"fnCreatedRow" : function(nRow, aData, iDataIndex) {
				$(nRow)[0].id = iDataIndex;
			}
		});
	};
