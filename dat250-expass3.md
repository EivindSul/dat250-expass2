# DAT250 Expass3

## Technical issues

It was hard to reload components without the website twitching and scrolling back up.
I have not worked with frontend before, so I am sure there exists a nice solution for this,
but I did not find one for now.

## Links to experiments 1 and 2:
- [Expass1](https://github.com/EivindSul/dat250-expass1)
- [Expass2 report](https://github.com/EivindSul/dat250-expass2/blob/main/dat250-expass2.md)
(Expass 2 also exists as a tag in this repo.) 

## Pending issues

The automatic gradle.build.kts did not work as intended, and did not run npm run build.
I just built the project and moved the build files manually instead.

I did a bad job when designing my API, so making a nice user interface was not really possible without
rewriting a lot of my earlier code.
I decided to let it stay like it is, but this means that you have to input an id when 
creating a poll, which is awkward.

The user is not really logged in, the username is just stored as a variable.
It is cleared upon refresh.

All components require the website to be refreshed to be updated.


