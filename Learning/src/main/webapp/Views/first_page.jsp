<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
First page
    <a href="<%= request.getContextPath() %>/second_page">
        <button type="button">Go to Second Page</button>
    </a>

    <!-- Standard form submission -->
    <form id="First_page">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" required /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age" id="age" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Submit</button>
                </td>
            </tr>
        </table>
    </form>

    <script>
        $(document).ready(function() {
            // Form submission handler
            $("#First_page").on("submit", function(e) {
                e.preventDefault(); // Prevent the default form submission

                // Get form values
                var name = $("#name").val();
                var age = $("#age").val();

                // Create the payload (data to send)
                var payload = {
                    name: name,
                    age: age
                };

                console.log("Submitting data:", payload);

                // Send the AJAX POST request
                $.ajax({
                    url: "<%= request.getContextPath() %>/learning_post",  // Your server endpoint
                    type: "POST",
                    contentType: "application/json",  // Send as JSON
                    data: JSON.stringify(payload),   // Send the payload as JSON string
                    success: function(response) {
                        console.log("Response:", response);
                        if (response.result === "success") {
                            alert("Data submitted successfully!");
                            // Optionally, reset the form fields after successful submission
                            $("#First_page")[0].reset();
                        } else {
                            alert("Failed to submit: " + response.message); // Handle failure
                        }
                    },
                    error: function(xhr, status, error) {
                        alert("Error: " + xhr.responseText); // Handle error in the request
                    }
                });
            });
        });
    </script>
</body>
</html>
