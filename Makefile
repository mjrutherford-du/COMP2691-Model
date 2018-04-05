.PHONY: all doc clean

all:
	mkdir -p build
	javac -sourcepath src -d build src/*.java

doc:
	javadoc -linksource -d doc src/*.java

clean:
	rm -rf build
