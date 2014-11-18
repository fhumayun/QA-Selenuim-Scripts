chrome.extension.sendMessage({}, function(response) {
	var readyStateCheckInterval = setInterval(function() {
	if (document.readyState === "complete") {
		clearInterval(readyStateCheckInterval);
		var nodes = document.querySelectorAll('*');
		hic_number = 0;
		for (var i = 0,len = nodes.length; i < len; i++) {
		  if (!nodes[i].id) {
		    nodes[i].id = 'hic_' + hic_number;
		    hic_number++;
		  }
		}
		// ----------------------------------------------------------
		// This part of the script triggers when page is done loading
		console.log('Total HiConversion QA Tags Inserted:' + i);
		// ----------------------------------------------------------

		}
	}, 10);
});