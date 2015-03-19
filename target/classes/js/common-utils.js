/**
 * 
 */

function clearChildSelect(childSelector) {
	$(childSelector).empty();
}

function loadCities(forElement, toElement) {
	
}
function loadDistrictsSelect(stateSelector, toElement) {
	
	if (jQuery(toElement).attr('data-loaded') == 'true') {
		
	} else if (jQuery(toElement).attr('data-loaded') == 'false') {
		
		var url = 'static/state/' + $(stateSelector).find(":selected").val() +'/districts'
		$.get(url, function(result) {
			var districts = ""; 
			
			$.each(result, function(key,val) {
				districts += '<option value="'+ val.ID + '">' + val.Name + '</option>';
			});
			
			$(toElement).html(districts);
			// localStorage.setItem("states", states);
			// jQuery(toElement).attr('data-loaded', 'true')
			// alert(states)
		});
		
	}
}

function loadStatesSelect(toElement) {
	// alert("Test");
	if (localStorage.states && jQuery(toElement).attr('data-loaded') == 'false') {
		$(toElement).empty();
		$(toElement).append(localStorage.states);
		jQuery(toElement).attr('data-loaded', 'true')
	} else if (jQuery(toElement).attr('data-loaded') == 'false') {
		var url = 'static/country/1/states'
		$.get(url, function(result) {
			var states = ""; 
			
			$.each(result, function(key,val) {
				states += '<option value="'+ val.ID + '">' + val.Name + '</option>';
			});
			
			$(toElement).html(states);
			localStorage.setItem("states", states);
			jQuery(toElement).attr('data-loaded', 'true')
			// alert(states)
		});
		
	}
}

function clearTextOnClick(obj) {
	if (obj.value === jQuery(obj).attr('data-constant')) {

		obj.value = '';
	}

}

function loadTextOnBlurIfEmpty(obj) {
	if (obj.value == '') {
		obj.value = jQuery(obj).attr('data-constant');
	}
}

/*******************************************************************************
 * url += createQueryParam("branchName", $(branchName).val()); url +=
 * createQueryParam("state", $(state).val()); url +=
 * createQueryParam("district", $(district).val()); url +=
 * createQueryParam("ifsc", $(ifsc).val());
 * 
 * Banks related functions
 */



function populateResult(bankId, elementId) {
	var url = 'banks/search/result/';
	var data = {
			BankId : bankId
		};
	$.post(url, data,  function(result) {
		loadSearchResult(result, elementId);
	});
}
function loadSearchResult(result, element) {
	$(element).empty();
	obj = $(element);
	$.each(result.results, function(i,item) {
		console.info(item);
		obj.append("<tr>");
		obj.append("<td><span>" + item.bankName+ "</span></td>");
		obj.append("<td><span>" + item.city+ "</span></td>");
		obj.append("<td><span>" + item.district+ "</span></td>");
		obj.append("<td><span>" + item.state+ "</span></td>");
		obj.append("<td><span>" + item.ifsc+ "</span></td>");
		obj.append("<td><span></span></td>");
		obj.append("</tr>");
	});
	
}
function filterBranch(elementId, bankId, branchName, district, state, ifsc) {

	var url = 'banks/search/filter/' + bankId;
	/*
	 * url += createQueryParam("branchName", $(branchName).val()); url +=
	 * createQueryParam("state", $(state).val()); url +=
	 * createQueryParam("district", $(district).val()); url +=
	 * createQueryParam("ifsc", $(ifsc).val());
	 */

	var data = {
		branchName : getValueFromElement($(branchName)),
		district : getValueFromElement($(district)),
		state : getValueFromElement($(state)),
		ifsc : getValueFromElement($(ifsc))
	};
	$.post(url, data, function(result) {
		loadSearchResult(result, elementId);
	});
}

function getValueFromElement(element) {
	if (element.val() === jQuery(element).attr('data-constant')) {
		return null;
	} else {
		return element.val();
	}
}
function createQueryParam(key, value) {
	return '&' + key + '=' + value
}
function doHttpPostAndAppend(url, data, contentType) {
	$.post(url, function(result) {
		$(elementId).html(result);
		return result;
	});
}

function doHttpGetAndAppendToElement(url, data, contentType, elementId) {
	var resultdata='';
	$.get(url, function(result) {
		$(elementId).html(result);		
	});
	return resultdata;
}
