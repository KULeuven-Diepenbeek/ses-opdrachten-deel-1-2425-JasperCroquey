# TODO: Vul deze Makefile zodat je met `make compile` alle bestanden in de `/src` directory compiled en linked, waarbij de object files in de `/build` directory komen, en dat de uiteindelijke binary `friendshiptester.bin` in de root directory terecht komt. Zorg er ook voor dat je met `make clean` de build directory en de binary verwijdert en dat je met `make run` het programma kan uitvoeren en dat je ook hier flags aan kan meegeven.

SRC = src
BUILD = build


TARGET = friendshiptester.bin


CC = gcc
CFLAGS = -Wall -Wextra -std=c11


SRCS = $(wildcard $(SRC)/*.c)
OBJS = $(patsubst $(SRC)/%.c,$(BUILD)/%.o,$(SRCS))


all: $(TARGET)


$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJS)


$(BUILD)/%.o: $(SRC)/%.c | $(BUILD)
	$(CC) $(CFLAGS) -c $< -o $@


$(BUILD):
	mkdir -p $(BUILD)


compile: $(TARGET)


run: $(TARGET)
	./$(TARGET) $(ARGS)



clean:
	rm -f $(TARGET)
	rm -rf $(BUILD)

