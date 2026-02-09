# Pet-Report-Manager
# 🐾 Huellas Felices – Pet Report Manager

A Java console application developed as part of the **Programming II (Intermediate)** course at UNED.  
The system helps a shelter manage reports of lost and found pets, supporting the recovery and reunion process.

## 🚀 Features
- Register lost or found pets with complete details
- Validate inputs (Costa Rican ID, phone, codes PDR/ENC/DOG/CAT, required fields)
- Consult reports by ID, species, or zone
- Generate reports:
  - **General**: full list of registered cases
  - **Grouped**: counts by type (lost/found) and species (dog/cat)
  - **Matches**: detect matches between lost and found pets using rules (species, color, zone, date window ≤ 7 days, microchip)
- Update existing reports (edit fields or mark as resolved)
- Console-based menu with clear navigation and error handling

## 🛠️ Technologies
- Java (NetBeans IDE)
- Object-Oriented Programming (OOP)
- ArrayList for dynamic data storage
- Exception handling with `try/catch`
- Input validation using regular expressions

## 📂 Project Structure
- `ReporteMascota.java` → main domain class (attributes, getters/setters, toString)
- `Main.java` → entry point with menu loop
- Additional helper classes for validation and report management

## 📊 Example Outputs
- **General Report**: shows all registered cases with ID, name, date, zone, type
- **Grouped Report**: counts by type and species
- **Coincidence Report**: pairs of lost/found pets that match criteria

## 🎯 Learning Outcomes
This project demonstrates:
- Applying Java OOP principles (encapsulation, modularity)
- Managing collections with ArrayList
- Implementing robust input validation
- Designing console-based interactive systems
- Building real-world logic for shelters and animal welfare

---

👩‍💻 Author: Elvia Sánchez Leiva  
📚 Course: Programming II – UNED  
