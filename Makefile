JFLAGS = -g
JC = javac
JVM= java
FILE=
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
    
CLASSES = \
    averageSentanceLength.java 

MAIN = averageSentanceLength

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN) "tag" "delims" "./foo.txt"

clean:
	$(RM) *.class
