package dat250.exp2;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PollApplicationController {

	private final PollRepository repo;

	public PollApplicationController(@Autowired DomainManager repo){
		this.repo = repo;
	}

	// USERS

	@GetMapping("/api/users")
	public ResponseEntity<Collection<User>> getUsers() {
		Collection<User> users = repo.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@PostMapping("/api/users")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		repo.addUser(user);
		return ResponseEntity.created(URI.create("/users/" + user.getUsername())).body(user);
	}

	@GetMapping("/api/users/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		return ResponseEntity.ok(repo.getUsers().get(username));
	}

	@DeleteMapping("/api/users/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable String username) {
		repo.removeUser(username);
		return ResponseEntity.ok().build();
	}
	
	// POLLS

	@GetMapping("/api/polls")
	public ResponseEntity<Collection<Poll>> getPolls() {
		Collection<Poll> polls = repo.getAllPolls();
		return ResponseEntity.ok(polls);
	}

	@PostMapping("/api/polls")
	public ResponseEntity<Poll> postPoll(@RequestBody Poll poll) {
		repo.addPoll(poll);
		return ResponseEntity.created(URI.create("/polls/" + poll.getId())).body(poll);
	}

	@GetMapping("/api/polls/{pollid}")
	public ResponseEntity<Poll> getPoll(@PathVariable Integer pollid) {
		return ResponseEntity.ok(repo.getPolls().get(pollid));
	}

	// VOTES

	@GetMapping("/api/polls/{pollId}/votes")
	public ResponseEntity<Collection<Vote>> getVotes(@PathVariable Integer pollId) {
		Collection<Vote> votes = repo.getVotes(pollId);
		return ResponseEntity.ok(votes);
	}

	@CrossOrigin
	@PostMapping("/api/polls/{pollId}")
	public ResponseEntity<?> postVote(@PathVariable Integer pollId, @RequestBody Vote vote) {
		vote.setPollId(pollId);
		if ( repo.addVote(vote) ) {
			return ResponseEntity.created(URI.create("/polls/" + pollId.toString() + "/" + vote.getUser())).body(vote);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body("Poll is inactive, the time in the vote is outside the specified timeframe in poll.");
		}
	}


}

