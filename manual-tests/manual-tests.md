I'll just copy the sequence of tests from the example.


# Create a new user
Body file: make-user.json
```json
{
    "username" : "vinnys",
    "password" : "vinnys123",
    "email" : "vinnysmail.com"
}
```

## Using httpie
http :8080/users < make-user.json

# List all users (-> shows the newly created user)

## Using httpie
http :8080/users 

# Create another user

Body file: make-user-2.json
```json
{
    "username" : "hannah",
    "password" : "hannah123",
    "email" : "hannah@mail.com"
}
```

## Using httpie
http :8080/users < make-user-2.json

# List all users again (-> shows two users)

## Using httpie
http :8080/users 

# User 1 creates a new poll

Body file: make-poll.json
```json
{
    "id": 1,
    "owner": "vinnys",
    "maxVotes": 1,
    "question": "Is spring fun to work in?",
    "options": ["yes", "no", "maybe"],
    "private": false,
    "publishedAt": "2024-09-09T12:00:00+02:00",
    "validUntil": "2024-09-12T12:00:00+02:00"
}
```

## Using httpie
http :8080/polls < make-poll.json

# List polls (-> shows the new poll)

## Using httpie
http :8080/polls

# User 2 votes on the poll
```json
{
    "user": "vinnys",
    "option": "yes",
    "publishedAt": "2024-09-09T13:00:00+02:00",
}
```

## Using httpie
http :8080/polls/1 < vote-poll-1.json

# User 2 changes his vote
```json
{
    "user": "vinnys",
    "option": "yes",
    "publishedAt": "2024-09-09T14:00:00+02:00",
}
```

## Using httpie
http :8080/polls/1 < vote-change-poll-1.json

# List votes (-> shows the most recent vote for User 2)

## Using httpie
http :8080/polls/1

# Delete the one poll

## Using httpie
http DELETE :8080/polls/1

# List votes (-> empty)

