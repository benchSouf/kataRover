# 🚀 Mars Rover Simulation

Mars Rover Simulation est une application Java qui simule le déplacement d'un rover sur une grille en fonction des commandes fournies par un fichier d'entrée.

---

## 📌 Fonctionnalités
- Simulation du déplacement d’un rover sur une grille 2D.
- Prise en charge des commandes `"L", "R", "M"` :
  - **L** : Tourne à gauche
  - **R** : Tourne à droite
  - **M** : Avance d’une case dans la direction actuelle
- Gestion des erreurs (fichier introuvable, format incorrect).
- Tests unitaires avec **JUnit 5**.

---

## 📦 Technologies utilisées
- **Java 17**
- **Maven** (gestion de projet)
- **JUnit 5** (tests unitaires)

---

## ⚙️ Installation et exécution

### 1️⃣ **Cloner le projet**
```bash
git clone  https://github.com/benchSouf/kataRover.git 
cd kataRover
exécuter sur le terminal la commande suivante :  java -jar rover.jar input.txt 
