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
