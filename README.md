# Java

-To run the java code, you should clone the repository to any of your directories

-Then in your command line, change your directory to the directory that you cloned the repository.

-Change your directory to the Java directory.

-Run ``javac PLproject.java``

-Run ``java PLproject [date]``

usage example:
```
javac PLproject.java
java PLproject 30/Nov/2017
```
the expected output will be:
```
{7628=10.129.2.1, 7629=10.131.2.1, 7630=10.128.2.1, 7631=10.129.2.1, 7632=10.131.2.1}
```
in the returning map;

linenumber is the key(7628,...)

ip address is the value of the key(10.129.2.1,...)

the last ip that was logged in is: 10.131.2.1

and has the linenumber: 7632.

# Python

-To run the python code, you should clone the repository to any of your directories

-Then in your command line, change your directory to the directory that you cloned the repository.

-Change your directory to the Python directory.

-Run ``python plproject.py [date]``

usage example:
```
python plproj.py 30/Nov/2017
```
the expected output will be:
```
['10.129.2.1', '10.131.2.1', '10.128.2.1', '10.129.2.1', '10.131.2.1']

```
in the returning list;

the last ip that was logged in is: 10.131.2.1

