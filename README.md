# dat250-expass2

Experiment assignment 2 in DAT250

**Work in progress!**

# Technical obstacles

## sdkman is not for fish
I use fish as my shell, but sdkman is a bash script.  There are ways to use
sdk for fish, namely reitzig/sdkman-for-fish on github, but I figured it is
better to make a simple solution than to reconfigure my entire development
environment for this one tool.

In order to install java tools, I go into bash and use sdk normally.
```
bash

# Then:

sdkman install whatever

# Then I exit back into fish:

exit
```

However, I want to use fish as my normal userspace shell,
so I have to add the sdkman paths to my $PATH.

I do this every time I launch my shell:
```
set PATH /home/eivind/.sdkman/candidates/gradle/current/bin/ $PATH
set PATH /home/eivind/.sdkman/candidates/java/current/bin/ $PATH
```
The main difficulty here was that I thought I should add the -x flag to
the command, which indicates export. This did not work, and I have no idea
why. My guess is that PATH already exists, so exporting it again does not
work, and is also not neccessary.

# Known issues

