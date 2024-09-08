package dat250.exp2;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollApplicationController {

	private final PollRepository repo;

	public PollApplicationController(@Autowired DomainManager repo){
		this.repo = repo;
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	// USERS

	@GetMapping("/users")
	public ResponseEntity<Collection<User>> getUsers() {
		Collection<User> users = repo.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@PostMapping("/users")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		repo.addUser(user);
		return ResponseEntity.created(URI.create("/users/" + user.getUsername())).body(user);
	}

	@GetMapping("/users/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		return ResponseEntity.ok(repo.getUsers().get(username));
	}

	@DeleteMapping("/users/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable String username) {
		repo.removeUser(username);
		return ResponseEntity.ok().build();
	}
	
	// POLLS

	@GetMapping("/polls")
	public ResponseEntity<Collection<Poll>> getPolls() {
		Collection<Poll> polls = repo.getAllPolls();
		return ResponseEntity.ok(polls);
	}

	@PostMapping("/polls")
	public ResponseEntity<Poll> postPoll(@RequestBody Poll poll) {
		repo.addPoll(poll);
		return ResponseEntity.created(URI.create("/polls/" + poll.getId())).body(poll);
	}

	@GetMapping("/polls/{pollid}")
	public ResponseEntity<Poll> getPoll(@PathVariable Integer pollid) {
		return ResponseEntity.ok(repo.getPolls().get(pollid));
	}

	// VOTES

	@GetMapping("/polls/{pollId}/votes")
	public ResponseEntity<Collection<Vote>> getVotes(@PathVariable Integer pollId) {
		Collection<Vote> votes = repo.getVotes(pollId);
		return ResponseEntity.ok(votes);
	}

	@PostMapping("/polls/{pollId}")
	public ResponseEntity<Vote> postVote(@PathVariable Integer pollId, @RequestBody Vote vote) {
		repo.addVote(pollId, vote);
		return ResponseEntity.created(URI.create("/polls/" + pollId.toString() + "/" + vote.getUser())).body(vote);
	}


}

