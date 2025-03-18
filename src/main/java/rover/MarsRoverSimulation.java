package rover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        // Vérifier que l'argument du fichier est fourni
        if (args.length < 1) {
            System.err.println("Erreur : Aucun fichier d'entrée fourni !");
            return;
        }

        // Récupérer le fichier
        File inputFile = new File(args[0]);

        // Vérifier si le fichier existe
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.err.println("Erreur : Fichier introuvable -> " + args[0]);
            return;
        }

        // Lire le fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            // Lire la première ligne pour récupérer la taille du plateau
            if ((line = reader.readLine()) == null) {
                System.err.println("Erreur : Fichier vide !");
                return;
            }

            String[] plateauDimensions = line.split(" ");
            if (plateauDimensions.length != 2) {
                System.err.println("Erreur : Format incorrect pour la première ligne !");
                return;
            }

            int Xmax = Integer.parseInt(plateauDimensions[0]);
            int Ymax = Integer.parseInt(plateauDimensions[1]);

            RoverController controller = new RoverController(Xmax, Ymax);

            // Lire les rovers
            while ((line = reader.readLine()) != null) {
                // Lire position initiale du rover
                String[] position = line.split(" ");
                if (position.length != 3) {
                    System.err.println("Erreur : Format incorrect pour la position du rover !");
                    return;
                }

                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                Direction direction = Direction.valueOf(position[2]);

                // Lire la ligne suivante contenant les commandes
                String commands = reader.readLine();
                if (commands == null || commands.isEmpty()) {
                    System.err.println("Erreur : Commandes manquantes pour le rover !");
                    return;
                }

                // Création et traitement du rover
                Rover rover = new Rover(x, y, direction);
                controller.processCommands(rover, commands);

                // Affichage du résultat final
                System.out.println(rover);
            }

        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur : Valeurs numériques invalides !");
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : Direction invalide !");
        }
    }
}