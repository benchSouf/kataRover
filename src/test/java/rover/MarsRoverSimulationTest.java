package rover;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rover.MarsRoverSimulation;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarsRoverSimulationTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStream = new ByteArrayOutputStream(); // Capture des erreurs
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err; // Sauvegarde de System.err
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Rediriger System.out et System.err pour capturer les sorties
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));

        // Créer un fichier temporaire qui simule input.txt
        tempFile = File.createTempFile("input", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("5 5\n");  // Taille du plateau
            writer.write("1 2 N\n"); // Position initiale du rover
            writer.write("LMLMLMLMM\n"); // Commandes
        }
    }

    @AfterEach
    void tearDown() {
        // Restaurer System.out et System.err après chaque test
        System.setOut(originalOut);
        System.setErr(originalErr);

        // Supprimer le fichier temporaire après le test
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void testMarsRoverSimulationWithValidInput() {
        // Simuler l'entrée en utilisant le fichier temporaire
        String[] args = {tempFile.getAbsolutePath()};
        MarsRoverSimulation.main(args);

        // Vérifier la sortie attendue
        String expectedOutput = "1 3 N\n"; // Résultat attendu après exécution
        assertEquals(expectedOutput.trim(), outputStream.toString().trim(),
                "Le résultat du rover n'est pas celui attendu !");
    }

    @Test
    void testMarsRoverSimulationWithMissingFile() {
        // Simuler un fichier inexistant
        String[] args = {"fichier_inexistant.txt"};
        MarsRoverSimulation.main(args);

        // Vérifier que le programme affiche un message d'erreur
        String expectedError = "Erreur : Fichier introuvable -> fichier_inexistant.txt";
        assertTrue(errorStream.toString().contains(expectedError),
                "Le message d'erreur attendu n'est pas affiché !");
    }

    @Test
    void testMarsRoverSimulationWithInvalidFormat() throws IOException {
        // Créer un fichier temporaire avec un format invalide
        File invalidFile = File.createTempFile("invalid_input", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(invalidFile))) {
            writer.write("5\n");  // Mauvais format, une seule valeur au lieu de "5 5"
        }

        String[] args = {invalidFile.getAbsolutePath()};
        MarsRoverSimulation.main(args);

        // Vérifier que le programme affiche une erreur de format
        assertTrue(errorStream.toString().contains("Erreur : Format incorrect"),
                "Le message d'erreur de format attendu n'est pas affiché !");

        // Supprimer le fichier temporaire
        invalidFile.delete();
    }
}
