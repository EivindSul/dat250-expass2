package dat250.exp2;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PollApplicationController {

	private final DomainManager repo;

	public PollApplicationController(@Autowired DomainManager repo){
		this.repo = repo;
	}

	@GetMapping("/users")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		return ResponseEntity.ok(repo.getUsers().get(username));
	}

	@PostMapping("/users")
	public ResponseEntity<User> hello(@RequestBody User user) {
		repo.addUser(user);
		return ResponseEntity.created(URI.create("/" + user.username)).body(user);
	}

}

