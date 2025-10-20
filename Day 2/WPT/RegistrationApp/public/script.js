function validateForm() {
    let valid = true;
  
    // Clear previous error messages
    document.querySelectorAll(".error").forEach((el) => el.textContent = "");
  
    // Get input values
    const firstName = document.getElementById("firstName").value.trim();
    const lastName = document.getElementById("lastName").value.trim();
    const email = document.getElementById("email").value.trim();
    const userId = document.getElementById("userId").value.trim();
    const password = document.getElementById("password").value.trim();
    const confirmPassword = document.getElementById("confirmPassword").value.trim();
  
    // Validation checks
    if (firstName === "") {
      document.getElementById("firstNameError").textContent = "First name is required";
      valid = false;
    }
  
    if (lastName === "") {
      document.getElementById("lastNameError").textContent = "Last name is required";
      valid = false;
    }
  
    if (email === "") {
      document.getElementById("emailError").textContent = "Email is required";
      valid = false;
    } else {
      const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
      if (!email.match(emailPattern)) {
        document.getElementById("emailError").textContent = "Invalid email format";
        valid = false;
      }
    }
  
    if (userId === "") {
      document.getElementById("userIdError").textContent = "User ID is required";
      valid = false;
    }
  
    if (password === "") {
      document.getElementById("passwordError").textContent = "Password is required";
      valid = false;
    }
  
    if (confirmPassword === "") {
      document.getElementById("confirmPasswordError").textContent = "Confirm your password";
      valid = false;
    } else if (password !== confirmPassword) {
      document.getElementById("confirmPasswordError").textContent = "Passwords do not match";
      valid = false;
    }
  
    return valid; // Prevents form submission if false
  }
  