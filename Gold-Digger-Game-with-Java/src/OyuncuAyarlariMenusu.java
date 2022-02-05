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
import javax.swing.JTextField;

public class OyuncuAyarlariMenusu extends JPanel implements ActionListener {
	
	JFrame pencere;
	Ayarlar ayar;
	ImageIcon arkaPlanResmi=new ImageIcon(new ImageIcon("ayarlarMenusuResim.jpg").getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
	JLabel arkaPlan;
	JLabel aHamlesiYazisi,aHedefYazisi,bHamlesiYazisi,bHedefYazisi,cHamlesiYazisi,cHedefYazisi,dHamlesiYazisi,dHedefYazisi;
	JTextField aHamlesi,aHedef,bHamlesi,bHedef,cHamlesi,cHedef,dHamlesi,dHedef;
	JButton geriButonu,tamamButonu;
	
	public OyuncuAyarlariMenusu(JFrame pencere,Ayarlar ayar) {
		
		super();
		setLayout(null);
		
		this.pencere=pencere;
		this.ayar=ayar;
		
		arkaPlan=new JLabel(arkaPlanResmi);
		arkaPlan.setBounds(0, 0, 1366, 768);
		
		aHamlesiYazisi=new JLabel("A hamlesi maliyeti:");
		aHamlesiYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		aHamlesiYazisi.setBounds(100,0,200,200);
		
		aHamlesi=new JTextField();
		aHamlesi.setText(Integer.toString(ayar.aHamlesi));
		aHamlesi.setBounds(250,80,50,30);
		
		aHedefYazisi=new JLabel("A hedefleme maliyeti:");
		aHedefYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		aHedefYazisi.setBounds(900,0,200,200);
		
		aHedef=new JTextField();
		aHedef.setText(Integer.toString(ayar.aHedef));
		aHedef.setBounds(1050,80,50,30);
		
		bHamlesiYazisi=new JLabel("B hamlesi maliyeti:");
		bHamlesiYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		bHamlesiYazisi.setBounds(100,200,200,200);
		
		bHamlesi=new JTextField();
		bHamlesi.setText(Integer.toString(ayar.bHamlesi));
		bHamlesi.setBounds(250,280,50,30);
		
		bHedefYazisi=new JLabel("B hedefleme maliyeti:");
		bHedefYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		bHedefYazisi.setBounds(900,200,200,200);
		
		bHedef=new JTextField();
		bHedef.setText(Integer.toString(ayar.bHedef));
		bHedef.setBounds(1050,280,50,30);
		
		cHamlesiYazisi=new JLabel("C hamlesi maliyeti:");
		cHamlesiYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		cHamlesiYazisi.setBounds(100,400,200,200);
		
		cHamlesi=new JTextField();
		cHamlesi.setText(Integer.toString(ayar.cHamlesi));
		cHamlesi.setBounds(250,480,50,30);
		
		cHedefYazisi=new JLabel("C hedefleme maliyeti:");
		cHedefYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		cHedefYazisi.setBounds(900,400,200,200);
		
		cHedef=new JTextField();
		cHedef.setText(Integer.toString(ayar.cHedef));
		cHedef.setBounds(1050,480,50,30);
		
		dHamlesiYazisi=new JLabel("D hamlesi maliyeti:");
		dHamlesiYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		dHamlesiYazisi.setBounds(100,600,200,200);
		
		dHamlesi=new JTextField();
		dHamlesi.setText(Integer.toString(ayar.dHamlesi));
		dHamlesi.setBounds(250,680,50,30);
		
		dHedefYazisi=new JLabel("D hedefleme maliyeti:");
		dHedefYazisi.setFont(new Font("Arial", Font.PLAIN, 15));
		dHedefYazisi.setBounds(900,600,200,200);
		
		dHedef=new JTextField();
		dHedef.setText(Integer.toString(ayar.dHedef));
		dHedef.setBounds(1050,680,50,30);
		
		geriButonu=new JButton("Geri");
		geriButonu.addActionListener(this);
		geriButonu.setBackground(Color.orange);
		geriButonu.setFont(new Font("Arial", Font.PLAIN, 30));
		geriButonu.setBounds(500, 250, 300, 100);
		
		
		tamamButonu=new JButton("Deðiþiklikleri Sakla");
		tamamButonu.addActionListener(this);
		tamamButonu.setBackground(Color.orange);
		tamamButonu.setFont(new Font("Arial", Font.PLAIN, 30));
		tamamButonu.setBounds(500, 450, 300, 100);
		
		
		add(aHamlesiYazisi);
		add(aHamlesi);
		add(aHedefYazisi);
		add(aHedef);
		add(bHamlesiYazisi);
		add(bHamlesi);
		add(bHedefYazisi);
		add(bHedef);
		add(cHamlesiYazisi);
		add(cHamlesi);
		add(cHedefYazisi);
		add(cHedef);
		add(dHamlesiYazisi);
		add(dHamlesi);
		add(dHedefYazisi);
		add(dHedef);
		add(geriButonu);
		add(tamamButonu);
		add(arkaPlan);
		
		
		this.pencere.add(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Geri")) {
			this.setVisible(false);
			pencere.remove(this);
			AyarMenusu ayarMenusu=new AyarMenusu(pencere, ayar);
		}
		
		else if(e.getActionCommand().equals("Deðiþiklikleri Sakla")) {
			ayar.aHamlesi=Integer.parseInt(aHamlesi.getText());
			ayar.aHedef=Integer.parseInt(aHedef.getText());
			ayar.bHamlesi=Integer.parseInt(bHamlesi.getText());
			ayar.bHedef=Integer.parseInt(bHedef.getText());
			ayar.cHamlesi=Integer.parseInt(cHamlesi.getText());
			ayar.cHedef=Integer.parseInt(cHedef.getText());
			ayar.dHamlesi=Integer.parseInt(dHamlesi.getText());
			ayar.dHedef=Integer.parseInt(dHedef.getText());
			
			this.setVisible(false);
			pencere.remove(this);
			AyarMenusu ayarMenusu=new AyarMenusu(pencere, ayar);
			
		}

	}

}