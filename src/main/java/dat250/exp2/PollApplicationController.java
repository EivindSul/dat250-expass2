package dat250.exp2;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/users")
	public ResponseEntity<User> getUser(@RequestBody User user) {
		repo.addUser(user);
		return ResponseEntity.created(URI.create("/users/" + user.getUsername())).body(user);
	}

	@GetMapping("/users/{username}")
	public ResponseEntity<User> postUser(@PathVariable String username) {
		return ResponseEntity.ok(repo.getUsers().get(username));
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}

