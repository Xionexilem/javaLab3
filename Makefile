compile:
	docker exec -it java-lab chmod +x /lab/sripts/compile.sh
	docker exec -it java-lab /lab/sripts/compile.sh

run:
	docker exec -it java-lab java -cp /lab/bin Main

clean:
	rm -rf ./bin/*
