import javax.swing.JFrame;


public class Frame extends JFrame{
	
	public static void main(String args[]){
		new Frame();
	}

	Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.setSize(WIDTH, HEIGHT + 22);
        this.setVisible(true);  
        this.add(new Simulation());
	}
	
}
