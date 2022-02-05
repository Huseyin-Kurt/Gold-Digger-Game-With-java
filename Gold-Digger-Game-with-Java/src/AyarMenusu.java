import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AyarMenusu extends JPanel implements ActionListener {
	
	ImageIcon arkaPlanResmi=new ImageIcon(new ImageIcon("ayarMenusuResim.jpg").getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
	JLabel arkaPlan;
	JButton oyuncuAyarlari,genelAyarlar,geri;
	Ayarlar ayar;
	JFrame pencere;

	
	public AyarMenusu(JFrame pencere,Ayarlar ayar)
	{
		super();
		setLayout(null);
		
		this.ayar=ayar;
		this.pencere=pencere;
		
		arkaPlan=new JLabel(arkaPlanResmi);
		arkaPlan.setBounds(0, 0, 1366, 768);
		
		oyuncuAyarlari=new JButton("Oyuncu Ayarlarý");
		oyuncuAyarlari.addActionListener(this);
		oyuncuAyarlari.setBackground(Color.orange);
		oyuncuAyarlari.setFont(new Font("Arial", Font.PLAIN, 30));
		oyuncuAyarlari.setBounds(300, 300, 300, 100);
		
		genelAyarlar=new JButton("Genel Ayarlar");
		genelAyarlar.addActionListener(this);
		genelAyarlar.setBackground(Color.orange);
		genelAyarlar.setFont(new Font("Arial", Font.PLAIN, 30));
		genelAyarlar.setBounds(700, 300, 300, 100);
		
		geri=new JButton("Geri");
		geri.addActionListener(this);
		geri.setBackground(Color.orange);
		geri.setFont(new Font("Arial", Font.PLAIN, 50));
		geri.setBounds(500, 500, 300, 100);
		
		
		add(oyuncuAyarlari);
		add(genelAyarlar);
		add(geri);
		add(arkaPlan);
		
		
		this.pencere.add(this);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("Geri")) {
			this.setVisible(false);
			pencere.remove(this);
			GirisMenusu girisMenusu=new GirisMenusu(pencere, ayar);
		}
		
		else if(e.getActionCommand().equals("Genel Ayarlar")) {
			this.setVisible(false);
			pencere.remove(this);
			GenelAyarlarMenusu genelAyarlarMenusu=new GenelAyarlarMenusu(pencere,ayar);
			
		}
		
		
		else if(e.getActionCommand().equals("Oyuncu Ayarlarý")) {
			this.setVisible(false);
			pencere.remove(this);
			OyuncuAyarlariMenusu oyuncuAyarlariMenusu=new OyuncuAyarlariMenusu(pencere,ayar);
			
		}

	}

}
