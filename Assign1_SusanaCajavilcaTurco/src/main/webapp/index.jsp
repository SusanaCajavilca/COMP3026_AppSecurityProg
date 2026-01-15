<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<script>
function validateForm() {
    const languages = document.getElementsByName("language");
    let checked = false;

    for (let i = 0; i < languages.length; i++) {
        if (languages[i].checked) {
            checked = true;
            break;
        }
    }

    document.getElementById("langError").style.display =
        checked ? "none" : "inline";

    return checked;
}
/* Defines a client-side validation function that runs before the form is submitted.
   Gets all checkbox inputs related to the Language field.
   Keeps track of whether at least one checkbox is selected.
   Loops through the checkboxes and checks if any one of them is selected.
   Returns true if validation succeeds (form can submit), or false if it fails.
*/

</script>

<head>
<meta charset="UTF-8">
<title>USER REGISTRATION</title>

<style>
   .error {
        color: red;
        font-size: 12px;
    }
    table {
        width: 80%;
    }
    td {
        padding: 6px;
    }
</style>
</head>
<body>
<div align="center">
    <h1>User Registration Page</h1>

   
    <form action="<%=request.getContextPath()%>/UserServlet"
          method="post"
          onsubmit="return validateForm();">
     <!-- Submits the form data to UserServlet using HTTP POST.
          Calls validateForm() before submission.
          If validateForm() returns false, the form submission is stopped.
          Ensures at least one Language checkbox is selected before sending data to the server. -->    
        <table>
            <!-- User Id -->
            <tr>
                <td>User Id</td>
                <td>
                    <input type="text" name="userId" required minlength="5" maxlength="12" />
                   <span class="error">* Required (5–12 characters)</span>
                </td>
            </tr>

            <!-- Password -->
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" required minlength="7" maxlength="12" />
                    <span class="error">* Required (7–12 characters)</span>
                </td>
            </tr>

            <!-- Name -->
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" required pattern="[A-Za-z ]+" />
                    <span class="error">* Alphabet characters only</span>
                </td>
            </tr>

            <!-- Address -->
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" maxlength="30" />
                    <span class="error"> Optional, Max 30 characters</span>
                </td>
            </tr>

            <!-- Country -->
            <tr>
                <td>Country</td>
                <td>
                    <select name="country" required>
                        <option value="">--Select Country--</option>
                        <option value="Canada">Canada</option>
                        <option value="USA">USA</option>
                        <option value="France">France</option>
                        <option value="Spain">Spain</option>
                        <option value="Colombia">Colombia</option>
                    </select>
                    <span class="error">* Required</span>
                </td>
            </tr>

            <!-- Zip Code -->
            <tr>
                <td>Zip Code</td>
                <td>
                    <input type="text" name="zipCode" required pattern="[0-9]{6}" maxlength="6"/>
                    <span class="error">* 6 digit numeric</span>
                </td>
            </tr>

            <!-- Email -->
            <tr>
                <td>Email</td>
                <td>
                    <input type="email" name="email" required />
                    <span class="error">* Valid email required</span>
                </td>
            </tr>

            <!-- Sex -->
            <tr>
                <td>Sex</td>
                <td>
                    <input type="radio" name="sex" value="Male" required /> Male
                    <input type="radio" name="sex" value="Female" /> Female
                    <span class="error">* Required</span>
                </td>
            </tr>

			<!-- Language -->
			<!--HTML does not support required directly on checkbox groups
			    Strategy is JavaScript validation for the checkbox group
			    Form will NOT submit if no checkbox is selected -->
			<tr>
			    <td>Language</td>
			    <td>
			        <input type="checkbox" name="language" value="English" /> English
			        <input type="checkbox" name="language" value="Non-English" /> Non-English
			        <span class="error" id="langError">* Check at least one box</span>
			    </td>
			</tr>

            <!-- About -->
            <tr>
                <td>About</td>
                <td>
                    <textarea name="about" rows="3" cols="30" maxlength="50"></textarea>
                    <span class="error"> Optional, Max 50 characters</span>
                </td>
            </tr>
        </table>

        <br/>
        <input type="submit" value="Submit" />

    </form>
</div>
</body>
</html>