CC=gcc
CFLAGS=-c -Wall
LDFLAGS=
SOURCES=*.c
OBJECTS=$(SOURCES:.c=.o)
EXECUTABLE= main

all: $(SOURCES) $(EXECUTABLE)
    
$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.c.o:
	$(CC) $(CFLAGS) $< -o $@
