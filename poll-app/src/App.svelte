<script>
  import CreatePollComponent from './lib/CreatePollComponent.svelte'
  import CreateUserComponent from './lib/CreateUserComponent.svelte'
  import VoteComponent from './lib/VoteComponent.svelte'

  let currentUser = ""
  let username = ""

  function logIn(username) {
    currentUser = username;
    username = ""
}
</script>

<main>
  <h1><u>Poll App</u></h1>

  <div>
    <h2>{currentUser === "" ? "Not logged in." : "Logged in as "} {currentUser}</h2>
    <h2>Log in:</h2>
    <input placeholder="Username" bind:value={username} />
    <button on:click={() => logIn(username)}>Log in</button>
    
  </div>

  <div>
    <CreateUserComponent currentUser={currentUser} />
  </div>

  <div>
    <CreatePollComponent currentUser={currentUser} />
  </div>
  
  <div>
    <VoteComponent currentUser={currentUser} />
  </div>

</main>
