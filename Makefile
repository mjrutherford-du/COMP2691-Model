JUNIT_JAR := lib/junit-4.12.jar
HAMCREST_JAR := lib/hamcrest-core-1.3.jar
CPSUITE := lib/takari-cpsuite.jar
BIN_DIR := bin

CLASSPATH := $(BIN_DIR):$(CPSUITE):$(JUNIT_JAR):$(HAMCREST_JAR)

.PHONY: compile doc clean test

compile:
	mkdir -p $(BIN_DIR)
	javac -cp $(CLASSPATH) -sourcepath src -d bin src/*.java

test: compile
	java -cp $(CLASSPATH) RunAllSuite

doc:
	javadoc -linksource -d doc `ls src/*.java | grep -v -e Test -e Suite`

clean:
	rm -rf bin
