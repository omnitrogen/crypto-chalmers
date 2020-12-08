JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ElGamal.java

RUN_MAIN = ElGamal

default: classes

classes: $(CLASSES:.java=.class)

run: $(RUN_MAIN).class
	$(JVM) $(RUN_MAIN)

clean:
	$(RM) *.class
