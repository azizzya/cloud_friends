db-local:
	docker run --rm \
	--name postgres \
	-e POSTGRES_DB=store \
	-e POSTGRES_USER=root \
	-e POSTGRES_PASSWORD=root \
	-p 5432:5432 \
	-d postgres:alpine

compile-app:
	./store/mvnw clean install -DskipTests -DGIGACHAT_AUTHTOKEN=${GIGACHAT_AUTHTOKEN} -f store/

clean-docker: compile-app
	docker system prune -a --volumes -f

run: clean-docker
	docker compose build
	docker compose up -d
