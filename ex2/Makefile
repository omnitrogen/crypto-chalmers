JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	CBCXor.java

RUN_MAIN = CBCXor

default: classes

classes: $(CLASSES:.java=.class)

run: $(RUN_MAIN).class
	$(JVM) $(RUN_MAIN)

clean:
	$(RM) *.class
