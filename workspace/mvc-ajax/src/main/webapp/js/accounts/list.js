/*
 * In the first part, implement functionality to display accounts
 * that matched the search criteria. This time, via AJAX.
 * Please review the "AccountsController" and see that it is
 * ready to return JSON when needed.
 *
 * The high level steps you will need to perform are:
 * 1. Bind a "click" handler to the "searchButton". 
 * 2. Empty out the contents of the former table data.
 * 3. Iterate over the results data and display the desired content
 *    (you will need to write the HTML for each table row and the table cells).
 * 4. Show the HTML fragment that wraps the entire table.
 */

/*
 * After completing the first part, continue to the second part.
 * 
 * In the second part, implement account details functionality.
 * This time, not using @ResponseBody/HttpMessageConverter.
 * 
 * The high level steps you will need to perform are:
 * 1. Modify displayed account data to include a link for details.
 * 2. Modify Spring configuration to support the MappingJackson2JsonView (step 02).
 * 3. Implement a handler function to make AJAX request and display account details.
 * 
 * The processAjaxAccountDetails() function has already been provided for you.
 * It displays account details in a pop-up alert box.
 *
 */

function processAjaxAccountDetails(data) {
	$.getJSON(data, function(results) {
		var account = results.account;
		var s = "=== Account Details ===\n\n";
		s += "Account Number: " + account.number + "\n";
		s += "Account Name: " + account.name + "\n";
		s += "Date of birth: " + account.dateOfBirth + "\n";
		s += "Receive monthly email update? "
			+ (account.receivingMonthlyEmailUpdate ? "Yes" : "No") + "\n";
		alert(s);	
	} );
}
