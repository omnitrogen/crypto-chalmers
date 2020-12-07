JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	CryptoLib.java\
	CryptoLibTest.java

TEST_MAIN = CryptoLibTest

default: classes

classes: $(CLASSES:.java=.class)

test: $(TEST_MAIN).class
	$(JVM) $(TEST_MAIN)

clean:
	$(RM) *.class
