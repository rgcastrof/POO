NAME = pencil
CC = g++
CFLAGS = -Wall -Iinclude

SRC = src/main.cpp src/Pencil.cpp src/Lead.cpp
OBJ = build/main.o build/Pencil.o build/Lead.o

all: $(NAME)

$(NAME): $(OBJ)
	$(CC) $(CFLAGS) -o $(NAME) $(OBJ)

build/main.o: src/main.cpp
	@mkdir -p build
	$(CC) $(CFLAGS) -c src/main.cpp -o build/main.o

build/Pencil.o: src/Pencil.cpp
	@mkdir -p build
	$(CC) $(CFLAGS) -c src/Pencil.cpp -o build/Pencil.o

build/Lead.o: src/Lead.cpp
	@mkdir -p build
	$(CC) $(CFLAGS) -c src/Lead.cpp -o build/Lead.o

clean:
	rm -rf build $(NAME)

