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

public class GenelAyarlarMenusu extends JPanel implements ActionListener {
	
	Ayarlar ayar;
	JFrame pencere;
	ImageIcon arkaPlanResmi=new ImageIcon(new ImageIcon("ayarlarMenusuResim.jpg").getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH));
	JLabel arkaPlan;
	JLabel satirYazisi,sutunYazisi,hareketMesafesiYazisi,baslangicAltiniYazisi,altinOraniYazisi,gizliAltinOraniYazisi;
	JTextField satir,sutun,hareketMesafesi,baslangicAltini,altinOrani,gizliAltinOrani;
	JButton tamamButonu,geriButonu;
	
	public GenelAyarlarMenusu(JFrame pencere,Ayarlar ayar) {
		
		super();
		setLayout(null);
		
		this.ayar=ayar;
		this.pencere=pencere;
		
		arkaPlan=new JLabel(arkaPlanResmi);
		arkaPlan.setBounds(0, 0, 1366, 768);
		
		satirYazisi=new JLabel("Dikey bölme sayýsý:");
		satirYazisi.setBounds(100,100,200,200);
		
		satir=new JTextField();
		satir.setText(Integer.toString(ayar.satir));
		satir.setBounds(250, 180, 50, 30);
		
		sutunYazisi=new JLabel("Yatay bölme sayýsý:");
		sutunYazisi.setBounds(100,200,200,200);
		
		sutun=new JTextField();
		sutun.setText(Integer.toString(ayar.sutun));
		sutun.setBounds(250, 280, 50, 30);
		
		hareketMesafesiYazisi=new JLabel("Hareket Mesafesi:");
		hareketMesafesiYazisi.setBounds(100,300,200,200);
		
		hareketMesafesi=new JTextField();
		hareketMesafesi.setText(Integer.toString(ayar.hareketMesafesi));
		hareketMesafesi.setBounds(250, 380, 50, 30);
		
		baslangicAltiniYazisi=new JLabel("Baþlangýç Altýný:");
		baslangicAltiniYazisi.setBounds(100, 400, 200, 200);
		
		baslangicAltini=new JTextField();
		baslangicAltini.setText(Integer.toString(ayar.baslangicAltini));
		baslangicAltini.setBounds(250, 480, 50, 30);
		
		altinOraniYazisi=new JLabel("Altýn Oraný(%):");
		altinOraniYazisi.setBounds(100, 500, 200, 200);
		
		altinOrani=new JTextField();
		altinOrani.setText(Integer.toString(ayar.altinOrani));
		altinOrani.setBounds(250, 580, 50, 30);
		
		gizliAltinOraniYazisi=new JLabel("Gizli Altýn Oraný(%):");
		gizliAltinOraniYazisi.setBounds(100, 600, 200, 200);
		
		gizliAltinOrani=new JTextField();
		gizliAltinOrani.setText(Integer.toString(ayar.gizliAltinOrani));
		gizliAltinOrani.setBounds(250, 680, 50, 30);
		
		tamamButonu=new JButton("Deðiþiklikleri Sakla");
		tamamButonu.addActionListener(this);
		tamamButonu.setBackground(Color.orange);
		tamamButonu.setFont(new Font("Arial", Font.PLAIN, 30));
		tamamButonu.setBounds(600, 150, 300, 100);
		
		geriButonu=new JButton("Geri");
		geriButonu.addActionListener(this);
		geriButonu.setBackground(Color.orange);
		geriButonu.setFont(new Font("Arial", Font.PLAIN, 30));
		geriButonu.setBounds(600, 550, 300, 100);
		
		
		
		
		
		add(satirYazisi);
		add(satir);
		add(sutunYazisi);
		add(sutun);
		add(hareketMesafesiYazisi);
		add(hareketMesafesi);
		add(baslangicAltiniYazisi);
		add(baslangicAltini);
		add(altinOraniYazisi);
		add(altinOrani);
		add(gizliAltinOraniYazisi);
		add(gizliAltinOrani);
		add(tamamButonu);
		add(geriButonu);
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
			ayar.satir=Integer.parseInt(satir.getText());
			ayar.sutun=Integer.parseInt(sutun.getText());
			ayar.hareketMesafesi=Integer.parseInt(hareketMesafesi.getText());
			ayar.baslangicAltini=Integer.parseInt(baslangicAltini.getText());
			ayar.altinOrani=Integer.parseInt(altinOrani.getText());
			ayar.gizliAltinOrani=Integer.parseInt(gizliAltinOrani.getText());
			
			this.setVisible(false);
			pencere.remove(this);
			AyarMenusu ayarMenusu=new AyarMenusu(pencere, ayar);
		}

	}

}
