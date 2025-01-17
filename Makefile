.PHONY: run_spring run_db stop_db clean_db run_all

# Default target: runs the Spring Boot application
run_spring:
	mvn spring-boot:run

# Target to start the PostgreSQL Docker container
run_db:
	docker run -d --name springboot-postgres \
		-e POSTGRES_USER=admin \
		-e POSTGRES_PASSWORD=admin \
		-e POSTGRES_DB=springboot \
		-p 5432:5432 \
		-v /Users/haribaskars/Development/Java/springcoredemo/data:/var/lib/postgresql/data \
		postgres

# Target to stop the Docker container
stop_db:
	docker stop springboot-postgres && docker rm springboot-postgres

# Target to clean up database data
clean_db:
	rm -rf /Users/haribaskars/Development/Java/springcoredemo/data/*

# Combined target to start both the database and Spring Boot
run_all: run_db run_spring
