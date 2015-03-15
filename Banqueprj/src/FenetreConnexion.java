import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class FenetreConnexion extends JFrame implements ActionListener {


    private JTextField fieldnumclient;
    private JPasswordField fieldmdp;
    private ArrayList<JButton> listb;
    private JButton b;

    public FenetreConnexion() {
        super();
        build();
    }

    private void build() {
        setTitle("Virement"); //On donne un titre � l'application
        setSize(900, 600); //On donne une taille � notre fen�tre
        setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
        setResizable(true); //On autorise la redimensionnement de la fen�tre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        // panel.setBackground(Color.white);

        JPanel panclavier = new JPanel();
        panclavier.setLayout(new GridLayout(5, 5));
        // panclavier.setBackground(Color.white);


        JPanel panconnexion = new JPanel();
        panconnexion.setLayout(new GridLayout(5, 2));
        // panconnexion.setBackground(Color.white);

        JPanel panebv = new JPanel();
        panebv.setSize(30, 30);
        panebv.setLayout(new FlowLayout());

        JPanel panebeff = new JPanel();
        panebeff.setSize(30, 30);
        panebeff.setLayout(new FlowLayout());

        JPanel panclient = new JPanel();
        panclient.setLayout(new FlowLayout());

        JPanel panmdp = new JPanel();
        panmdp.setLayout(new FlowLayout());


        listb = new ArrayList<JButton>();
        for (int i = 0; i < 25; i++) {
            if (i < 10) {
                b = new JButton("" + i);
                b.addActionListener(this);
                listb.add(b);
            } else {
                b = new JButton("");
                listb.add(b);
            }
        }

        Collections.shuffle(listb);

        for (int p = 0; p < 25; p++) {
            panclavier.add(listb.get(p));
        }

        panel.add(panclavier);

        JLabel numclient = new JLabel("Numero Client:");
        fieldnumclient = new JTextField();
        fieldnumclient.setColumns(20);
        panclient.add(numclient);
        panclient.add(fieldnumclient);
        panconnexion.add(panclient);


        JLabel mdpclient = new JLabel("Mot de Passe:");
        fieldmdp = new JPasswordField();
        fieldmdp.setColumns(20);
        panmdp.add(mdpclient);
        panmdp.add(fieldmdp);
        panconnexion.add(panmdp);

        JButton bv = new JButton("Valider");
        bv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = fieldnumclient.getText();
                ReadCVS reader = new ReadCVS();
                Crypto c = new Crypto();
                String test = ReadCVS.search(num);
                //On crypte le mot de passe entré et on le compare avec celui indiqué dans le fichier
                if (test != null && test.equals(c.encrypt(fieldmdp.getText()))) {

                    System.out.println("Connecion reussie");
                } else {
                    System.out.println("Echec !");
                }
            }
        });

        panebv.add(bv);
        panconnexion.add(panebv);


        JButton beff = new JButton(new ActionEffacer("Effacer"));
        panebeff.add(beff);
        panconnexion.add(panebeff);
        panel.add(panconnexion);
        return panel;

    }

    public void actionPerformed(ActionEvent e) {
        String str = ((JButton) e.getSource()).getText();
        str = fieldmdp.getText() + str;
        fieldmdp.setText(str);

    }

}

