# TODO
MAIN = app.py
TARGET = app.bin

compile:
	@echo "Compiling..."
	pyinstaller --onefile --name $(TARGET) $(MAIN)
	@echo "Done compiling."	
	
clean:
	@echo "Cleaning..."
	@rm -rf build dist __pycache__ *.spec
	@echo "Done cleaning."

test:
	@echo "Testing program $(MAIN) ..."
	@echo "---------------"
	python3 $(MAIN)
	@echo "---------------"
	@echo "Program exited."

run:
	@echo "Running program $(TARGET) ..."
	@echo "---------------"
	@cd dist && ./$(TARGET)
	@echo "---------------"
	@echo "Program exited."