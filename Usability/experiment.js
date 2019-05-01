// This is the results hash array
var results = {};

// This function should be called to open the next page in the experiment
// First parameter is the href of the next page
// The following parameters are strings of resultName:resultValue, 
// which will get added to the results array before being turned into
// a query street and added to the href 
function callNextPage()
{
	var pageHref;
		
	// If there is a href
	if (arguments.length > 0)
	{
		// Get the href from the arguments
		pageHref = arguments[0];
		
		// If there are more results
		if (arguments.length > 1)
		{
			// Add the results to the results array
			for (var i=1; i < arguments.length; i++)
			{
				var hash = arguments[i].split(":");
				//results.push(hash[1]);
				results[hash[0]] = hash[1];
			}
		}
		
		var n = 0;
		for (var _ in results) { n++; }
		
		// if we have results, append them to the href as the query string
		if (n > 0)
		{
			// Add ALL the results onto the href as a query string
			pageHref = pageHref + "?" + $.param( results );
		}
		// This loads the new page
		window.location.href = pageHref;	
	}
	// else do nothing
	else
	{
		console.log("'callNextPage' function called without any parameters");
	}
}

// This function should be called to populate the results array with any data sent via the query string
function getResults()
{
	var hash;
    var q = document.URL.split('?')[1];
    if(q != undefined)
    {
        q = q.split('&');
        for(var i = 0; i < q.length; i++)
        {
            hash = q[i].split('=');
            //results.push(hash[1]);
            results[hash[0]] = hash[1];
        }
	}
}
			var prices = $(".prices").attr("data_value");
			var i=0;
			
			function addcart () {
				i++;
				document.getElementById("prices").innerHTML="Total Price" + i* prices;
			}
function benchmarkDate()
{
	var start_date;
	var end_date;
	
	start_date=new Date(); // 1
	
	// 100
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 200
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 300
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 400
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 500
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 600
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 700
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 800
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 900
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	// 999
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date(); end_date=new Date();
	
	var diff = end_date.getTime() - start_date.getTime();
	
	//Debug line below
	//alert("start: " + start_date.getTime() + "\nend: " + end_date.getTime() + "\nDiff: " + diff)
	
	return diff;
}