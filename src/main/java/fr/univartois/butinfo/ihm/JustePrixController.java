/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JustePrixController {
        
        static final Random MYSTER_NUMBER = new Random();
        static final int MAX_NUMBER = 100;
        private int number = MYSTER_NUMBER.nextInt(MAX_NUMBER);
        private boolean finded = false;
        private int nbTrying = 0;
        private int point = 5;
        
    /**
     * Le label de l'application, où l'on va pouvoir afficher des messages.
     * Ce label sera initialisé automatiquement par JavaFX grâce �  l'annotation
     * {@link FXML}.
     */
    @FXML
    private Label welcomeText;
    @FXML
    private Label clue;
    @FXML
    private Label pointLabel;
    @FXML
    private TextField answer;
    @FXML
    private Label nombredev;
    
    
    
    /**
     * Cette méthode exécute une action lorsque l'utilisateur clique sur le bouton de la
     * fenêtre.
     * Le lien avec le bouton de l'application sera réalisé automatiquement par JavaFX
     * grâce �  l'annotation {@link FXML}.
     */
    @FXML
    protected void onConfirmButtonClick() {
            try {
                    if (finded) answer.setText(String.format("%d", number));
                    else {
                        int nb = Integer.parseInt(answer.getText());
                        if (nb == number) {
                                clue.setText("C'est bon !");
                                answer.setText(String.format("%d", number));
                                finded = true;
                                point++;
                        }
                        else if (nb > number) clue.setText("C'est moins !");
                        else clue.setText("C'est plus !");
                        nombredev.setText("nombre deviner  :"+ nb);
                    }
            }
        catch (Exception e) {
                clue.setText("Ne mettez que des nombres entiers...");
        }
            nbTrying++;
            refresh();
    }
    
    @FXML
    protected void onSolutionButtonClick() {
            if (nbTrying > 20) {
                    answer.setText(String.format("%d", number));
                    point--;
            } else answer.setText("Tentes encore...");
            refresh();
    }
    
    @FXML
    protected void onRestartButtonClick() {
            if (finded) {
                number = MYSTER_NUMBER.nextInt(MAX_NUMBER);
                finded = false;
                nbTrying = 0;
            }
            else if (point >= 5) {
                    point -= 5;
                number = MYSTER_NUMBER.nextInt(MAX_NUMBER);
                finded = false;
                nbTrying = 0;
            }
            else clue.setText("Vous n'avez pas assez de points pour cela.");
            refresh();
    }
    
    private void refresh() {
            pointLabel.setText(String.format("%d points", point));
    }

        
}