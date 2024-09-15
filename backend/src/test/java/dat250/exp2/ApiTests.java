package dat250.exp2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest 
class ApiTests {

	private int port = 8080;

	String baseUrl = "http://127.0.0.1:" + port;

	RestClient restClient = RestClient.builder().
	baseUrl(baseUrl)
	.build();

	@Test
	void getUserTest() {
		ResponseEntity<String> result = restClient.get()
		.uri("/api/users/Eivind")
		.retrieve()
		.toEntity(String.class);

		System.out.println("Response status: " + result.getStatusCode()); 
		System.out.println("Response headers: " + result.getHeaders()); 
		System.out.println("Contents: " + result.getBody()); 

		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void getUsersTest() {
		ResponseEntity<String> result = restClient.get()
		.uri("/api/users")
		.retrieve()
		.toEntity(String.class);

		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void postUserTest() {

		User patrick = new User();
		patrick.setUsername("big_man_patrick");
		patrick.setPassword("patrick_da_goat123");
		patrick.setEmail("patrick@mail.com");


		ResponseEntity<String> resultPost = restClient.post()
		.uri("/api/users")
		.contentType(MediaType.APPLICATION_JSON)
		.body(patrick)
		.retrieve()
		.toEntity(String.class);

		assertThat(resultPost.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(resultPost.getBody()).contains("big_man_patrick");
		assertThat(resultPost.getBody()).contains("patrick_da_goat123");
		assertThat(resultPost.getBody()).contains("patrick@mail.com");

		ResponseEntity<User> resultGet = restClient.get()
		.uri("/api/users/big_man_patrick")
		.retrieve()
		.toEntity(User.class);

		assertThat(resultGet.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertThat(resultGet.getBody().getUsername()).contains("big_man_patrick");
		assertThat(resultGet.getBody().getPassword()).contains("patrick_da_goat123");
		assertThat(resultGet.getBody().getEmail()).contains("patrick@mail.com");
	}

	@Test
	void pollTest(){

		String poll = """
		{
		"id": 100,
		"owner": "Eivind",
		"question": "Will this test pass?",
		"options": ["yes", "no", "maybe"]
		}
		""";

		ResponseEntity<String> resultPostPoll = restClient.post()
		.uri("/api/polls")
		.contentType(MediaType.APPLICATION_JSON)
		.body(poll)
		.retrieve()
		.toEntity(String.class);

		assertThat(resultPostPoll.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		// FIXME: Get requests dont work here.

		// ResponseEntity<Poll> resultGetPoll = restClient.get()
		// .uri("/api/polls/100")
		// .retrieve()
		// .toEntity(Poll.class);

		// assertThat(resultGetPoll.getStatusCode()).isEqualTo(HttpStatus.OK);

		Vote vote = new Vote();
		vote.setUser("Eivind");
		vote.setPollId(100);
		vote.setOption(new VoteOption("yes"));

		ResponseEntity<Vote> resultPostVote = restClient.post()
		.uri("/api/polls/100")
		.contentType(MediaType.APPLICATION_JSON)
		.body(vote)
		.retrieve()
		.toEntity(Vote.class);

		assertThat(resultPostVote.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		// ResponseEntity<String> resultGetVotes = restClient.post()
		// .uri("/api/polls/100/votes")
		// .contentType(MediaType.APPLICATION_JSON)
		// .body(poll)
		// .retrieve()
		// .toEntity(String.class);

		// assertThat(resultGetVotes.getStatusCode()).isEqualTo(HttpStatus.OK);
		// assertThat(resultGetVotes.getBody()).contains("Eivind");
		// assertThat(resultGetVotes.getBody()).contains("probably not");

	}

}
