I installed using docker.

`docker pull rabbitmq`

I then ran the container using:

`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management`
