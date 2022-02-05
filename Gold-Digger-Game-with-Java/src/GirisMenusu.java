import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GirisMenusu extends JPanel implements ActionListener {

	ImageIcon arkaPlanResmi=new ImageIcon(new ImageIcon("girisMenusuResim.jpg").getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
	JLabel arkaPlan;
	JButton basla,ayarlar;
	Ayarlar ayar;
	JFrame pencere;
	
	
	public GirisMenusu(JFrame pencere,Ayarlar ayar) {
		super();
		setLayout(null);
		
		this.ayar=ayar;
		this.pencere=pencere;
		
		arkaPlan=new JLabel(arkaPlanResmi);
		arkaPlan.setBounds(0, 0, 1366, 768);
		
		basla=new JButton("Basla!");
		basla.addActionListener(this);
		basla.setBackground(Color.orange);
		basla.setFont(new Font("Arial", Font.PLAIN, 50));
		basla.setBounds(500, 300, 300, 100);
		
		
		ayarlar=new JButton("Ayarlar");
		ayarlar.addActionListener(this);
		ayarlar.setBackground(Color.orange);
		ayarlar.setFont(new Font("Arial", Font.PLAIN, 50));
		ayarlar.setBounds(500, 500, 300, 100);
		
		
		
		
		
		
		add(basla);
		add(ayarlar);
		add(arkaPlan);
		
		
		
		this.pencere.add(this);
		this.pencere.setVisible(true);
		

		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("Ayarlar")) {
			this.setVisible(false);
			pencere.remove(this);
			AyarMenusu ayarMenusu=new AyarMenusu(pencere, ayar);
		}
		
		
		if(e.getActionCommand().equalsIgnoreCase("Basla!")) {
			this.setVisible(false);
			pencere.remove(this);
			try {
				OyunMenusu oyunMenusu=new OyunMenusu(pencere, ayar);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
