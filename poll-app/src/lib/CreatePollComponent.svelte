<script>
  export let currentUser

  let id = 0;
  let question = ""
  let options = ["yes", "no", "maybe"]
  let option1 = ""
  let option2 = ""

  let feedback = ""


  function createPoll() {

    if (currentUser === "") {
      return
    }

    fetch("http://localhost:8080/api/polls", {
      method: "POST",
      body:JSON.stringify({
        id: id,
        owner: currentUser,
        question: question,
        options: [option1, option2]
      }),
      headers: {
        "Content-Type": "application/json"
      }
      }).then((response) => {
        if (response.status === 201) {
          feedback = `Poll ${id} successfully created!` 
          console.log(feedback)
          question = ""
          option1 = ""
          option2 = ""
        }
      }).catch((error) => {
        feedback = error.message;
        console.error(feedback);
      })
  }
</script>

<h1>Create a poll</h1>
<div>
  <input placeholder="id" bind:value={id} />
  <br>
  <input placeholder="question" bind:value={question} />
  <br>
  <input placeholder="option1" bind:value={option1} />
  <br>
  <input placeholder="option2" bind:value={option2} />
  <br>
  <button on:click={createPoll}>Create poll</button>
  <p> {feedback} </p>
</div>

