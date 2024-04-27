# Yebelo-Spring-Developer-Assignment
# Monopoly Game

This is a simple implementation of the Monopoly game backend using Spring Boot.

# About
Monopoly is a multi-player economics-themed board game. In the game, players roll two dice to move around the game board, buying and trading properties and developing them with houses and hotels. Players collect rent from their opponents, aiming to drive them into bankruptcy

## Description

The project implements the backend logic for a simplified version of the Monopoly game. It includes entities for players, places, and the game itself. Players can buy and sell properties, and the game tracks player positions and balances.

## Installation

1. Clone the repository:

    ```bash
    git clone <repository-url>
    ```

2. Navigate to the project directory:

    ```bash
    cd monopoly-game
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## Usage

You can interact with the backend using RESTful endpoints. Below are some example endpoints:

- **Create Game**: `POST /api/create-game/`
  - Create a new game instance with two players.
- **Get role dice**: `GET /api/roll-die/{playerId}/{gameId}`
  - Retrieve player information by ID.
- **Get game status**: `GET /api/calculate-winner/{gameId}`

## Swagger Documentation

Swagger documentation is available at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

## Features

### Example System
Person A : http://localhost:8080/create-game/ >> Game Created Successfully
Person A : http://localhost:8080/roll-die/p1 >> Die rolled 11 and landed on Place ABC,
Unclaimed place and hence bought for $200. Remaining balance is $800.
Person B : http://localhost:8080/roll-die/p2 >> Die rolled 4 and landed on Place DEF, Unclaimed
place and hence bought for $150. Remaining balance is $850.
...
Person A : http://localhost:8080/roll-die/p1 >> Die rolled 1 and landed on Place DEF, paid rent
$100. Remaining balance is $700.
Person B : http://localhost:8080/roll-die/p2 >> Die rolled 4 and landed on Place UES, Unclaimed
place and hence bought for $150. Remaining balance is $700. Also Crossed “Start” gaining
+200. Remaining Balance $900.
...
Person A : http://localhost:8080/roll-die/p1 >> Die rolled 1 and landed on Place DEF, paid rent
$100. Remaining balance is $-100. Game Over, You lose!

### Completed

- **Create New Game**: Users can create a new game instance.
- **Get Game Status**: Users can retrieve the status of the game.
- **Calculate Player Balance**: Users can calculate a player's cash balance.

### TODOs

- **User Authentication and Authorization**: Implement user authentication and authorization to secure endpoints.
- **Token Features**: Implement token-based authentication and authorization for API access.
- **Jail and Banking Features**: Implement jail functionality and banking features such as mortgages, auctions, etc.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Maven

## Data Relationship Diagram

![image](https://github.com/Farheen-cell/Yebelo-Spring-Developer-Assignment/assets/103572478/9999668c-213e-4898-8003-730374fab49a)


The diagram illustrates the data relationships and system flow within the Monopoly game backend.

## Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

## Swagger Images 
 ### Image-1
![image](https://github.com/Farheen-cell/Yebelo-Spring-Developer-Assignment/assets/103572478/62273284-d179-4365-956c-25c67b6ea31b)


### Image-2
![image](https://github.com/Farheen-cell/Yebelo-Spring-Developer-Assignment/assets/103572478/8e468641-24ca-406a-aa2a-8b40f6453371)

### Image-3(schemas)
![image](https://github.com/Farheen-cell/Yebelo-Spring-Developer-Assignment/assets/103572478/00913d05-a0cf-4049-ab72-f837827aaa26)

### Image-4
![image](https://github.com/Farheen-cell/Yebelo-Spring-Developer-Assignment/assets/103572478/eda66f62-f55c-48b1-a6f8-8e6939f9ce3e)




