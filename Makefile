APP_IMAGE_LIST ?= gateway-service auth-service rabbitmq-producer-service rabbitmq-consumer-service project-service task-service

start : down remove up

down :
	docker compose down

remove :
	docker image rm -f ${APP_IMAGE_LIST}

up:
	docker compose up -d

build:
	docker compose build

restart: down up

env:
	cp .env.example .env
	nano .env