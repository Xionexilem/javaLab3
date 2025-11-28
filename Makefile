compile:
	docker exec -it java-lab javac -d bin -sourcepath src $(find src -name "*.java")

run:
	docker exec -it java-lab java -cp /lab/bin Main

clean:
	rm -rf ./bin/*
