NAME = budega
CC = g++
CFLAGS = -Wall  -Iinclude

SRC = src/main.cpp src/Person.cpp src/Market.cpp
OBJ = build/main.o build/Person.o build/Market.o

all: $(NAME)

$(NAME): $(OBJ)
	$(CC) $(CFLAGS) -o $(NAME) $(OBJ)

build/main.o: src/main.cpp
	@mkdir -p build
	$(CC) $(CFLAGS) -c src/main.cpp -o build/main.o

build/Person.o: src/Person.cpp
	@mkdir -p build
	$(CC) $(CFLAGS) -c src/Person.cpp -o build/Person.o

build/Market.o: src/Market.cpp
	@mkdir -p build
	$(CC) $(CFLAGS) -c src/Market.cpp -o build/Market.o

clean:
	rm -rf build $(NAME)

