.PHONY: all doc clean

all:
	mkdir -p bin
	javac -sourcepath src -d bin src/*.java

doc:
	javadoc -linksource -d doc src/*.java

clean:
	rm -rf bin
