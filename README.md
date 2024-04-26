Quiz App using Spring Boot

This project implements a Quiz App backend using Spring Boot, providing an API to manage quizzes and answer questions. The API is built using Spring's RestController, facilitating interaction with the application.

Features

    Quiz Management: Questions are fetched from the database and can be accessed through the API.
    Dynamic Quizzes: Users can generate custom quizzes with random questions from the database.
    Answer Submission: Submit answers to the quiz and receive a count of correct responses.


To fetch questions from the database, make a GET request to the endpoint.
Generating a Custom Quiz

Create a custom quiz by making a POST request to the endpoint with the desired quiz parameters. This endpoint will return a quiz containing random questions from the database.
Submitting Answers

Submit answers to the quiz by making a POST request to the  endpoint with the quiz ID and the user's answers. The endpoint will return the count of correct answers.
