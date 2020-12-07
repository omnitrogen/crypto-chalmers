JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	FiatShamir.java

RUN_MAIN = FiatShamir

default: classes

classes: $(CLASSES:.java=.class)

run: $(RUN_MAIN).class
	$(JVM) $(RUN_MAIN)

clean:
	$(RM) *.class
