SOURCES=$(wildcard */*.java)
RESULTS=$(SOURCES:%.java=%.class)

.PHONY: all clean

all: $(RESULTS)

%.class: %.java
	javac $<

clean:
	$(RM) -r $(RESULTS)
