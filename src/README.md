# Farming Equipment Application
Repo:
https://github.com/Gorm2303/ASA-assignment

## Prerequisites
- Docker  
- Docker Compose (for Docker Compose setup)  
- A Docker Swarm cluster (for Docker Swarm setup)  
- Postman  

## Configuration
To run the docker-compose.yml with docker-compose, it might need to be edited.

## Starting with Docker Compose
Use this method for development environments or single-node deployments.

1. **Start the Services:**
To start all services defined in the docker-compose.yml file, run:  
    docker-compose up -d  

## Starting with Docker Swarm
Initialize a new swarm:  
    docker swarm init  
Deploy the stack to the swarm:  
    docker stack deploy -c docker-compose.yml   farming_application_stack  
To stop and remove the stack from the swarm, run:  
    docker stack rm farming_application_stack  

## Accessing the Services
Launch Postman:   
    Open the Postman application on your computer.  
Create a New Request:  
    Set the HTTP method to GET  
    Enter the URL http://localhost:5002/api/inventory  
Send the Request:  
    Click the Send button  
You should see a list of products in the response body  
