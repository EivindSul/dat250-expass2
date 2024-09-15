<script>
  export let currentUser

  let polls = fetch("http://localhost:8080/api/polls").then((response) => {
  return response.json();
  })

  let feedback = ""

  function vote(pollid, option) {

    if (currentUser === "") {
      return
    }
  
    fetch(`http://localhost:8080/api/polls/${pollid}`, {
      method: "POST",
      body:JSON.stringify({
        user: currentUser,
        option: option
      }),
      headers: {
        "Content-Type": "application/json"
      }
      }).then((response) => {
        if (response.status === 201) {
          feedback = "Vote successfully submitted!" 
        }
      }).catch((error) => {
        feedback = error.message;
        console.log(option);
      })

}

</script>

<h1>Active polls</h1>

{#await polls}
<p>Waiting for polls...</p>

{:then polls}

{#each polls as poll}
  <div style="border: dotted 1px black; background: #eeeeee; padding: 10px; margin: 15px;">
    <h2>Poll #{poll.id}</h2>
    <h3>{poll.question}</h3>
    <p>Owner: {poll.owner}</p>
    <div>
    {#each poll.options as option}
      <button on:click={() => vote(poll.id, option.caption)}>{option.caption}</button>
      <p><b>Votes: {poll.votes.filter(vote => vote.option.caption == option.caption).length}</b></p>
      <br>
    {/each}
    </div>
  </div>
{/each}

{:catch error}
<p>Polls could not be fetched: {error}</p>
{/await}

