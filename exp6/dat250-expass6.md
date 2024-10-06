# Technical problems
None really.
I just had to learn a bit about how to specify classpath for `javac` and `java`,
but it was not too difficult.

# Code for experiments 1-4

## Experiment 1

I installed using docker.

`docker pull rabbitmq`

I then ran the container using:

`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management`

## Experiment 2

[Recv.java](./task2/Recv.java)

[Send.java](./task2/Send.java)

I compiled the classes using:
```bash
javac -cp lib/amqp-client-5.22.0.jar task2/Send.java task2/Recv.java -d target
```

I ran them using:
```bash
java -cp target:lib/amqp-client-5.22.0.jar:lib/slf4j-api-1.7.36.jar:lib/slf4j-simple-1.7.36.jar Recv

java -cp target:lib/amqp-client-5.22.0.jar:lib/slf4j-api-1.7.36.jar:lib/slf4j-simple-1.7.36.jar Send "hei!"
```

One could also set a variable for the class path, which is what I did from here on out.
```fish
set CP target:lib/amqp-client-5.22.0.jar:lib/slf4j-api-1.7.36.jar:lib/slf4j-simple-1.7.36.jar

javac -cp $CP task2/Send.java task2/Recv.java -d target

java -cp $CP Recv
java -cp $CP Send "Hei!"
```

## Experiment 3

[Worker.java](./task3/Worker.java)

[AddTask.java](./task3/AddTask.java)

I compiled the classes using:
```bash
set CP target:lib/amqp-client-5.22.0.jar:lib/slf4j-api-1.7.36.jar:lib/slf4j-simple-1.7.36.jar

javac -cp $CP task3/Worker.java task3/AddTask.java -d target
```

I ran them using:
```bash
java -cp $CP Worker

java -cp $CP AddTask "Helloooo..."
```

## Experiment 4

[EmitLog.java](./task4/EmitLog.java)

[ReceiveLogs.java](./task4/ReceiveLogs.java)

I compiled the classes using:
```bash
set CP target:lib/amqp-client-5.22.0.jar:lib/slf4j-api-1.7.36.jar:lib/slf4j-simple-1.7.36.jar

javac -cp $CP task4/EmitLog.java task4/ReceiveLogs.java -d target
```

I ran them using:
```bash
java -cp $CP ReceiveLogs

java -cp $CP EmitLog
```

# Pending issues
Nothing in particular, things worked as expected.
