JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AttackRSA.java\
	CubeRoot.java

RUN_MAIN = AttackRSA

default: classes

classes: $(CLASSES:.java=.class)

run: $(RUN_MAIN).class
	$(JVM) $(RUN_MAIN)

clean:
	$(RM) *.class
