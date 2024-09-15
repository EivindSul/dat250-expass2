<script>

  export let currentUser
  let username
  let password
  let email

  let feedback = ""


function createUser() {
  fetch("http://localhost:8080/api/users", {
    method: "POST",
    body:JSON.stringify({
      username: username,
      password: password,
      email: email
    }),
    headers: {
      "Content-Type": "application/json"
    }
    }).then((response) => {
      if (response.status === 201) {
        feedback = `User ${username} successfully created!` 
        console.log(feedback)
        currentUser = username;
        username = "";
        password = "";
        email = "";
      }
    }).catch((error) => {
      feedback = error.message;
      console.error(feedback);
    })
}
</script>

<h2>Create a user!</h2>

<input placeholder="Username" bind:value={username} />
<br>
<input placeholder="Password" type="password" bind:value={password} />
<br>
<input placeholder="Email address" type="email" bind:value={email} />
<br>
<button on:click={createUser}>Create user</button>
<p> {feedback} </p>


