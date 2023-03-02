# DockerHub username
DOCKERHUB_USERNAME ?= ${{DOCKERHUB_USERNAME}}

# DockerHub repository name
DOCKERHUB_REPOSITORY ?= ${{DOCKERHUB_REPOSITORY_NAME}}

APP_IMAGE_LIST ?= gateway-service auth-service project-service task-service

start : down remove up

down :
	docker compose down

remove :
	docker image rm -f ${APP_IMAGE_LIST}
	
up :
	docker compose up -d

build :
	docker compose build
#
# restart: down up
#
# env:
# 	cp .env.example .env
# 	nano .env

push :
	$(foreach img, ${APP_IMAGE_LIST}, \
		docker tag ${img} ${DOCKERHUB_USERNAME}/${DOCKERHUB_REPOSITORY}:${img} && \
		docker push ${DOCKERHUB_USERNAME}/${DOCKERHUB_REPOSITORY}:${img} &&) true
