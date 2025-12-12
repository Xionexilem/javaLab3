compile:
	docker exec -it java-lab javac -d /lab/bin $(shell docker exec -it java-lab find /lab/src -name "*.java")

run:
	docker exec -it java-lab java -cp /lab/bin ru.mitrakov.main.Main

clean:
	sudo rm -rf /lab/bin/*
