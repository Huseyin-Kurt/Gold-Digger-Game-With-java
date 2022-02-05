import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OyunSonuEkrani extends JPanel {
	
	ImageIcon arkaPlanResmi=new ImageIcon(new ImageIcon("oyunSonuEkraniResim.jpg").getImage().getScaledInstance(1366, 900, Image.SCALE_SMOOTH));
	JLabel arkaPlan;
	JLabel aYazisi,bYazisi,cYazisi,dYazisi;
	JLabel toplananAltin,harcananAltin,kasa;
	JTextField aToplanan,aHarcanan,aKasa;
	JTextField bToplanan,bHarcanan,bKasa;
	JTextField cToplanan,cHarcanan,cKasa;
	JTextField dToplanan,dHarcanan,dKasa;
	
	
	public OyunSonuEkrani(JFrame pencere,AOyuncusu a,BOyuncusu b,COyuncusu c,DOyuncusu d) {
		super();
		setLayout(null);
		
		pencere.setVisible(false);
		pencere.setSize(1366, 900);
		pencere.setLocationRelativeTo(null);
		pencere.setVisible(true);
		
		toplananAltin=new JLabel("Toplanan Altýn");
		toplananAltin.setFont(new Font("Arial", Font.PLAIN, 30));
		toplananAltin.setForeground(Color.white);
		toplananAltin.setBounds(300, 0, 200, 200);
		
		harcananAltin=new JLabel("Harcanan Altýn");
		harcananAltin.setFont(new Font("Arial", Font.PLAIN, 30));
		harcananAltin.setForeground(Color.white);
		harcananAltin.setBounds(600, 0, 200, 200);
		
		kasa=new JLabel("Kasadaki Altýn");
		kasa.setFont(new Font("Arial", Font.PLAIN, 30));
		kasa.setForeground(Color.white);
		kasa.setBounds(900, 0, 200, 200);
		
		aYazisi=new JLabel("A:");
		aYazisi.setFont(new Font("Arial", Font.PLAIN, 30));
		aYazisi.setForeground(Color.red);
		aYazisi.setBounds(200,100,100,100);
		
		aToplanan=new JTextField();
		aToplanan.setBounds(350,140,100,20);
		aToplanan.setText(Integer.toString(a.toplananAltin));
		
		aHarcanan=new JTextField();
		aHarcanan.setBounds(650,140,100,20);
		aHarcanan.setText(Integer.toString(a.harcananAltin));
		
		aKasa=new JTextField();
		aKasa.setBounds(950,140,100,20);
		aKasa.setText(Integer.toString(a.mevcutAltin));
		
		bYazisi=new JLabel("B:");
		bYazisi.setFont(new Font("Arial", Font.PLAIN, 30));
		bYazisi.setForeground(Color.green);
		bYazisi.setBounds(200,300,100,100);
		
		bToplanan=new JTextField();
		bToplanan.setBounds(350,340,100,20);
		bToplanan.setText(Integer.toString(b.toplananAltin));
		
		bHarcanan=new JTextField();
		bHarcanan.setBounds(650,340,100,20);
		bHarcanan.setText(Integer.toString(b.harcananAltin));
		
		bKasa=new JTextField();
		bKasa.setBounds(950,340,100,20);
		bKasa.setText(Integer.toString(b.mevcutAltin));
		
		cYazisi=new JLabel("C:");
		cYazisi.setFont(new Font("Arial", Font.PLAIN, 30));
		cYazisi.setForeground(Color.blue);
		cYazisi.setBounds(200,500,100,100);
		
		cToplanan=new JTextField();
		cToplanan.setBounds(350,540,100,20);
		cToplanan.setText(Integer.toString(c.toplananAltin));
		
		cHarcanan=new JTextField();
		cHarcanan.setBounds(650,540,100,20);
		cHarcanan.setText(Integer.toString(c.harcananAltin));
		
		cKasa=new JTextField();
		cKasa.setBounds(950,540,100,20);
		cKasa.setText(Integer.toString(c.mevcutAltin));
		
		dYazisi=new JLabel("D:");
		dYazisi.setFont(new Font("Arial", Font.PLAIN, 30));
		dYazisi.setForeground(Color.pink);
		dYazisi.setBounds(200,700,100,100);
		
		dToplanan=new JTextField();
		dToplanan.setBounds(350,740,100,20);
		dToplanan.setText(Integer.toString(d.toplananAltin));
		
		dHarcanan=new JTextField();
		dHarcanan.setBounds(650,740,100,20);
		dHarcanan.setText(Integer.toString(d.harcananAltin));
		
		dKasa=new JTextField();
		dKasa.setBounds(950,740,100,20);
		dKasa.setText(Integer.toString(d.mevcutAltin));
		
		
		
		arkaPlan=new JLabel(arkaPlanResmi);
		arkaPlan.setBounds(0, 0, 1366, 768);
		
		this.add(toplananAltin);
		this.add(harcananAltin);
		this.add(kasa);
		this.add(aYazisi);
		this.add(aToplanan);
		this.add(aHarcanan);
		this.add(aKasa);
		this.add(bYazisi);
		this.add(bToplanan);
		this.add(bHarcanan);
		this.add(bKasa);
		this.add(cYazisi);
		this.add(cToplanan);
		this.add(cHarcanan);
		this.add(cKasa);
		this.add(dYazisi);
		this.add(dToplanan);
		this.add(dHarcanan);
		this.add(dKasa);
		this.add(arkaPlan);
		
		pencere.add(this);
		
	}

}
