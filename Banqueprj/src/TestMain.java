public class TestMain {

    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(new Runnable(){
			@Override
	 public void run(){
				FenetreConnexion fen =new FenetreConnexion();
				fen.setVisible(true);


			}
			
			
		});*/

        Crypto c = new Crypto();
        for (int i = 0; i < 10; i++) {
            String str = c.encrypt("1");
            System.out.println(str);


        }
    }

}
