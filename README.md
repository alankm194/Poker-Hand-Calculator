# Poker Hand Calculator

A simple console based application to determine who wins in a standard poker game 

## Installation

Go to parent directory of Poker Hand Calculator
 and run
```bash
mvn clean package
```

execute as java jar to run application 
```bash
java -jar target/PokerHandCalculator-1.0-SNAPSHOT.jar
```
## Usage

To enter in valid user input please enter in the format of 


```
Player 1: [hand] Player 2: [hand]
```
where hand is a list of 2-3 letter representing a card, each
card is separated by a space.

example of valid input below 
```
Player 1: 4H 5H 6H 10S 9C Player 2: AC 6D 9C 10S 4H
```

### Valid Face values 
 - 2: Two
 - 3: Three
 - 4: Four
 - 5: Five
 - 6: Six
 - 7: Seven
 - 8: Eight
 - 9: Nine
 - 10: Ten
 - J: Jack
 - Q: Queen 
 - K: King
 - A: Ace

### Valid Suit values
-  D: Diamond
-  C: Club
-  H: Heart
-  S: Spades

