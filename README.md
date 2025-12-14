# ParkingLotApp-MahaSuraka
A Java-based Parking Lot Management System that dynamically allocates parking slots based on vehicle size. Implements OOP-driven architecture with separate model, service, and CLI layers. Supports parking, exiting, and status reporting without requiring any database, using clean in-memory storage. Designed as part of a take-home coding challenge.


The parking lot system models the lot with **N slots**, divided into:

- **SMALL**
- **LARGE**
- **OVERSIZE**

The system supports:

- Vehicle entry
- Vehicle exit
- Status display
- In-memory slot management

This project is written in **Java**, with a clean modular structure and object-oriented design.

## Features

- Automatically splits total slots into:
    - **50% Small**
    - **30% Large**
    - **20% Oversize**
        - Design choice; can be dynamic ( included in future improvements)
- Allows:
    - `PARK <plate> <SMALL|LARGE|OVERSIZE>`
    - `EXIT <plate>`
    - `STATUS`
    - `QUIT`
- Ensures vehicles park only in valid slot types:
    - SMALL cars → any slot
    - LARGE cars → LARGE or OVERSIZE
    - OVERSIZE → OVERSIZE only

## Project Structure

```
src/
 ├── Main.java
 ├── model/
 │     ├── Vehicle.java
 │     ├── VehicleType.java
 │     ├── ParkingSlot.java
 │     └── SlotSize.java
 ├── service/
 │     └── ParkingLotService.java
 └── cli/
       └── ParkingLotCLI.java
```

## How to Run

### Terminal:

- compile
    - cd src
    - javac Main.java
- Run
    - java Main 

### VS Code:

- Open project folder
- Open `Main.java`
- Click **Run**

## Test Commands

```
Enter total parking slots:
10
PARK KA01 SMALL
PARK KA02 LARGE
PARK KA03 SMALL
PARK KA04 OVERSIZE
EXIT KA02
STATUS
QUIT
```

## Future Enhancements

- Allow users to define slot distribution dynamically, either by entering precise slot counts or customizable percentage ratios.
- Add billing logic
- Add timestamp tracking
- Add GUI or web interface
- Add file-based or database persistence for saving parking state.

