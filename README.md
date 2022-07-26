
# log4j-one

## Overview

**log4j-one** is a set of appenders and utilities for log4j. 

( where log4j 1 is your primary logging framework, i.e. where all your logging configuration is, and where all the appenders live ). 

## What's in the box ?

So amongst the gems in this little treasure chest are:
* **Log4jCliConfiguration** - a class to get your logging framework working in a reasonably simple manner within a CLI
* **MemoryAppender** - an Appender object which instead of writing to a file writes to a ring buffer of logging events. You can then dump that buffer onto a debug page in your webapp to save you having to find the logs on the container on the node on the cluster that's currently going doolally. 
* **LoggingOutputStream** - an OutputStream that takes  a logger object and cause bytes that are written to that outputStream to be logged. You can hook this up to the OutputStreams on a Docker container, say, and watch stdout and stderr get logged via your logging framework.

Also worth pointing out that these classes only really work with log4j 1, not log4j 2. 

So if you're on log4j 2, then why not take a mosy down to the randomnoun common project, which has basically the same things, but with annotations and complicated factory methods.

And if you're on log4j 1, then I commend your soul to the spirits of the ancients, and may I also interest you in the log4j-one-bridge project that will keep you there for the foreseeable future.

## How do I use it ? 

I wrote up a blog entry on this a while ago, I'll update that to point to this and then link this back to that and then link it to the three different repository managers I'll be uploading this to.


## Where can I get it ? 

Add this to your pom.xml, or pom.xml equivalent:
```
<dependency>
  <groupId>com.randomnoun.common</groupId>
  <artifactId>log4j-one</artifactId>
  <version>1.0.0</version>
</dependency>
```
Or from here on maven central, until such time that I create a release on github:  https://repo1.maven.org/maven2/com/randomnoun/common/log4j-one/0.0.4/

## Anything else up your sleeve ?

Well, if you're forced to use code that logs to log4j2 and you want all that redirected back into log4j 1, 
might I suggest you check out https://github.com/randomnoun/log4j-one-bridge

## Licensing

log4j-one is licensed under the BSD 2-clause license.
