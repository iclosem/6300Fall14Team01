JFLAGS = -g
JC = javac
JVM= java
FILE=
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
    
CLASSES = \
    ./src/edu/gatech/seclass/project1/ASL.java ./src/edu/gatech/seclass/project1/Main.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN) "tag" "delims" "./foo.txt"

clean:
	$(RM) -rf *.class