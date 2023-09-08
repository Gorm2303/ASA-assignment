# Use an official base image, like Alpine, Ubuntu, Node, etc.
# Alpine is lightweight, and thus generally faster to pull and build
FROM node:14-alpine

# Set environment variables
# ENV VAR_NAME=var_value

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json first to leverage Docker caching
## COPY package*.json ./

# Install dependencies in the container
## RUN npm install

# Optionally, if you have global dependencies, install them as well
# RUN npm install -g some_global_package

# Copy the current directory contents into the container at /usr/src/app
COPY . .

# Expose the port the app runs on
EXPOSE 8080

# The command to run your application
CMD ["npm", "start"]
