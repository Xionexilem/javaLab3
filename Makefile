compile:
	docker exec -it java-lab javac -d bin ./src/*

run:
	docker exec -it java-lab java -cp /lab/bin Main

clean:
	rm -rf ./bin/*
