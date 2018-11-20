Selenium Example
================

Simple example of using Selenium with Java, directly and also from Cucumber.

Building
--------
Call:
```bash
:~$ gradle clean
:~$ gradle drivers
:~$ gradle build
```

Using
-----

For running the tests without Cucumber, call:
```
:~$ bin/tool.sh firefox
```
or
```
:~$ bin/tool.sh chrome
```

For running the tests **with Cucumber**, call:

```
:~$ bin/tool.sh cucumber
```