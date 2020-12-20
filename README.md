
# log4j-one

## Background and opinionated rant

Well, everyone who uses log4j now realises the folly of their ways and think they need to add a couple of seconds to their startup time whilst their logging framework initialises, and who amongst us can honestly say that they don't want to spend time understanding arbitrary changes to configuration APIs and file formats ? 

And it's a doozy of a configuration API, let me tell you. If you haven't created a factory for the builder for the builder for the configuration object, (that can't be composed of any object other than Strings, mind you) that calls the factory of the builder of the builder of the logger appender then you haven't lived.

So anyway, minor rant aside, everyone now uses log4j2, except for people who still use log4j1. This package is for that second lot.

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
  <version>0.0.1</version>
</dependency>
```
Or from here on maven central, until such time that I create a release on github:  https://repo1.maven.org/maven2/com/randomnoun/common/log4j-one/0.0.1/

## Licensing

log4j-one is licensed under the BSD 2-clause license.
