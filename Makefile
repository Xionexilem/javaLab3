compile:
	docker exec -it java-lab chmod +x /lab/scripts/compile.sh
	docker exec -it java-lab /lab/scripts/compile.sh

run:
	docker exec -it java-lab java -cp /lab/bin Main

clean:
	rm -rf ./bin/*
