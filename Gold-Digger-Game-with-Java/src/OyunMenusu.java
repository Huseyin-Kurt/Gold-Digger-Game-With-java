import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OyunMenusu extends JPanel implements ActionListener {
	JFrame pencere;
	Ayarlar ayar;
	JPanel oyunPenceresi;
	GridLayout yonetici;
	JButton devamButonu;
	JLabel aSkorYazisi,bSkorYazisi,cSkorYazisi,dSkorYazisi;
	JTextField aSkor,bSkor,cSkor,dSkor;
	ImageIcon arkaPlanResmi=new ImageIcon(new ImageIcon("oyunMenusuResim.jpg").getImage().getScaledInstance(270, 1080, Image.SCALE_SMOOTH));
	JLabel arkaPlan;
	AOyuncusu aOyuncusu;
	BOyuncusu bOyuncusu;
	COyuncusu cOyuncusu;
	DOyuncusu dOyuncusu;
	OyunAlani[][] oyunAlanlari;
	int siraKontrol=1;

	
	
	
	public OyunMenusu(JFrame pencere,Ayarlar ayar) throws IOException {
		super();
		setLayout(null);
		
		this.pencere=pencere;
		this.ayar=ayar;
		
		pencere.setVisible(false);
		pencere.setSize(1920, 1080);
		pencere.setLocationRelativeTo(null);
		pencere.setVisible(true);
		
		yonetici=new GridLayout(ayar.satir,ayar.sutun);
		
		oyunPenceresi=new JPanel();
		oyunPenceresi.setSize(1680, 1050);
		oyunPenceresi.setLayout(yonetici);
		
		
		
		
		
		 oyunAlanlari=new OyunAlani[ayar.satir][ayar.sutun];
		 
		
		for(int i=0;i<ayar.satir;i++)
		{
			for(int j=0;j<ayar.sutun;j++)
			{	
				
				oyunAlanlari[i][j]=new OyunAlani(i,j,"bos");
				oyunAlanlari[i][j].setBackground(Color.white);
				oyunAlanlari[i][j].setFont(new Font("Arial", Font.PLAIN, 1650/ayar.sutun/2));
			}
		}
		
		int altinSayisi=(ayar.satir*ayar.sutun*ayar.altinOrani)/100;
		int kontrol=0;
		int altinCarpani=1;
		
		while(kontrol<altinSayisi)
		{
			int i=(int )(Math.random() * ayar.satir);
			int j=(int )(Math.random() * ayar.sutun);
			
			if((i!=0&&j!=0)&&(i!=ayar.satir-1&&j!=ayar.sutun-1)&&(i!=0&&j!=ayar.sutun-1)&&(i!=ayar.satir-1&&j!=0)&&oyunAlanlari[i][j].durum.equals("bos")) {
			
				oyunAlanlari[i][j].durum="altin";
				oyunAlanlari[i][j].deger=(altinCarpani++%5)*5;
				if(altinCarpani==5)
				{
					altinCarpani=1;
				}
				oyunAlanlari[i][j].setText(Integer.toString(oyunAlanlari[i][j].deger));
				oyunAlanlari[i][j].setBackground(Color.yellow);
				kontrol++;
				
			}
		}
		
		kontrol=0;
		int gizliAltinSayisi=altinSayisi*ayar.gizliAltinOrani/100;
		
		while(kontrol<gizliAltinSayisi)
		{
			int i=(int )(Math.random() * ayar.satir);
			int j=(int )(Math.random() * ayar.sutun);
			
			if((i!=0&&j!=0)&&(i!=ayar.satir-1&&j!=ayar.sutun-1)&&(i!=0&&j!=ayar.sutun-1)&&(i!=ayar.satir-1&&j!=0)&&oyunAlanlari[i][j].durum.equals("altin")) {
			
				oyunAlanlari[i][j].durum="gizliAltin";
				oyunAlanlari[i][j].setBackground(Color.orange);
				kontrol++;
				
			}
		}
		
		
		for(int i=0;i<ayar.satir;i++)
		{
			for(int j=0;j<ayar.sutun;j++) {
				
				oyunPenceresi.add(oyunAlanlari[i][j]);
				
			}
		}
		
		
		devamButonu=new JButton("DEVAM");
		devamButonu.addActionListener(this);
		devamButonu.setFont(new Font("Arial", Font.PLAIN, 30));
		devamButonu.setBackground(Color.MAGENTA);
		devamButonu.setBounds(1690,100,200,100);
		
		aSkorYazisi=new JLabel("A Altýn:");
		aSkorYazisi.setForeground(Color.red);
		aSkorYazisi.setFont(new Font("Arial", Font.PLAIN, 20));
		aSkorYazisi.setBounds(1690, 300, 100, 50);
		
		aSkor=new JTextField();
		aSkor.setText(Integer.toString(ayar.baslangicAltini));
		aSkor.setFont(new Font("Arial", Font.PLAIN, 20));
		aSkor.setBounds(1770,310,80,30);
		
		bSkorYazisi=new JLabel("B Altýn:");
		bSkorYazisi.setForeground(Color.green);
		bSkorYazisi.setFont(new Font("Arial", Font.PLAIN, 20));
		bSkorYazisi.setBounds(1690, 450, 100, 50);
		
		bSkor=new JTextField();
		bSkor.setText(Integer.toString(ayar.baslangicAltini));
		bSkor.setFont(new Font("Arial", Font.PLAIN, 20));
		bSkor.setBounds(1770,460,80,30);
		
		cSkorYazisi=new JLabel("C Altýn:");
		cSkorYazisi.setForeground(Color.blue);
		cSkorYazisi.setFont(new Font("Arial", Font.PLAIN, 20));
		cSkorYazisi.setBounds(1690, 600, 100, 50);
		
		cSkor=new JTextField();
		cSkor.setText(Integer.toString(ayar.baslangicAltini));
		cSkor.setFont(new Font("Arial", Font.PLAIN, 20));
		cSkor.setBounds(1770,610,80,30);
		
		dSkorYazisi=new JLabel("D Altýn:");
		dSkorYazisi.setForeground(Color.pink);
		dSkorYazisi.setFont(new Font("Arial", Font.PLAIN, 20));
		dSkorYazisi.setBounds(1690, 750, 100, 50);
		
		dSkor=new JTextField();
		dSkor.setText(Integer.toString(ayar.baslangicAltini));
		dSkor.setFont(new Font("Arial", Font.PLAIN, 20));
		dSkor.setBounds(1770,760,80,30);
		
		arkaPlan=new JLabel(arkaPlanResmi);
		arkaPlan.setBounds(1650, 0, 270, 1080);
		
		 aOyuncusu=new AOyuncusu(0, 0, ayar.baslangicAltini, ayar.aHedef, ayar.aHamlesi,ayar.hareketMesafesi,altinSayisi);
		 
		 oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setBackground(Color.red);
		 oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setText("A");
		 
		 bOyuncusu=new BOyuncusu(0, ayar.sutun-1, ayar.baslangicAltini,ayar.bHedef, ayar.bHamlesi, ayar.hareketMesafesi,altinSayisi);
		 
		 oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setBackground(Color.green);
		 oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setText("B");
		 
		 
		 cOyuncusu=new COyuncusu(ayar.satir-1, 0, ayar.baslangicAltini,ayar.cHedef,ayar.cHamlesi,ayar.hareketMesafesi,altinSayisi);
		 
		 oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setBackground(Color.blue);
		 oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setText("C");
		 
		 dOyuncusu=new DOyuncusu(ayar.satir-1, ayar.sutun-1,ayar.baslangicAltini,ayar.dHedef,ayar.dHamlesi,ayar.hareketMesafesi,altinSayisi);
		 
		 oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setBackground(Color.pink);
		 oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setText("D");
		 
		
		
		
		this.add(devamButonu);
		this.add(aSkorYazisi);
		this.add(aSkor);
		this.add(bSkorYazisi);
		this.add(bSkor);
		this.add(cSkorYazisi);
		this.add(cSkor);
		this.add(dSkorYazisi);
		this.add(dSkor);
		this.add(oyunPenceresi);
		this.add(arkaPlan);

		
		
		pencere.add(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("DEVAM")) {
			
			if(siraKontrol%4==1&&aOyuncusu.aktifmi==true)
			{
				
				try {
					aOyuncusu.hedefBelirleme(oyunAlanlari, ayar);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(aOyuncusu.hedefVarmi==true)
				{	
				
					if(oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].durum.equals("bos"))
					{
						oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setBackground(Color.white);
						oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setText("");
					}
				
					else if(oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].durum.equals("altin"))
					{
						oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setBackground(Color.yellow);
						oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setText(Integer.toString(oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].deger));
					}
				
					try {
						aOyuncusu.hareketEtme(oyunAlanlari);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				aOyuncusu.turSayisi++;
			
			}
			
			if(siraKontrol%4==2&&bOyuncusu.aktifmi==true)
			{
				try {
					bOyuncusu.hedefBelirleme(oyunAlanlari, ayar);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(bOyuncusu.hedefVarmi==true)
				{	
				
					if(oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].durum.equals("bos"))
					{
						oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setBackground(Color.white);
						oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setText("");
					}
				
					else if(oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].durum.equals("altin"))
					{
						oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setBackground(Color.yellow);
						oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setText(Integer.toString(oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].deger));
					}
				
					try {
						bOyuncusu.hareketEtme(oyunAlanlari);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				bOyuncusu.turSayisi++;
			}
			
			if(siraKontrol%4==3&&cOyuncusu.aktifmi==true)
			{
				
				try {
					cOyuncusu.gizliAltinCikarma(oyunAlanlari, ayar);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					cOyuncusu.hedefBelirleme(oyunAlanlari, ayar);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				if(cOyuncusu.hedefVarmi==true)
				{	
				
					if(oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].durum.equals("bos"))
					{
						oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setBackground(Color.white);
						oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setText("");
					}
				
					else if(oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].durum.equals("altin"))
					{
						oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setBackground(Color.yellow);
						oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setText(Integer.toString(oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].deger));
					}
				
					try {
						cOyuncusu.hareketEtme(oyunAlanlari);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				cOyuncusu.turSayisi++;
			}
			
			if(siraKontrol%4==0&&dOyuncusu.aktifmi==true)
			{
				
				try {
					dOyuncusu.hedefCalma(aOyuncusu, bOyuncusu, cOyuncusu, oyunAlanlari);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					dOyuncusu.hedefBelirleme(oyunAlanlari, ayar);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				if(dOyuncusu.hedefVarmi==true)
				{	
				
					if(oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].durum.equals("bos"))
					{
						oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setBackground(Color.white);
						oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setText("");
					}
				
					else if(oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].durum.equals("altin"))
					{
						oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setBackground(Color.yellow);
						oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setText(Integer.toString(oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].deger));
					}
				
					try {
						dOyuncusu.hareketEtme(oyunAlanlari);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				dOyuncusu.turSayisi++;
			}
			
				
				siraKontrol++;
				yenileme();
				
				if(aOyuncusu.altinSayisi==0||aOyuncusu.aktifOyuncu==1)
				{
					try {
						aOyuncusu.yazici.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						bOyuncusu.yazici.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						cOyuncusu.yazici.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						dOyuncusu.yazici.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					this.setVisible(false);
					pencere.remove(this);
					
					OyunSonuEkrani oyunSonuEkrani=new OyunSonuEkrani(pencere, aOyuncusu, bOyuncusu, cOyuncusu, dOyuncusu);
				}
				
				
		}
		
		

	}
	
	void yenileme()
	{
		this.setVisible(false);
		this.remove(oyunPenceresi);
		this.remove(arkaPlan);
		
		
		aSkor.setText(Integer.toString(aOyuncusu.mevcutAltin));
		oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setText("A");
		oyunAlanlari[aOyuncusu.mevcutSatir][aOyuncusu.mevcutSutun].setBackground(Color.red);
		
		bSkor.setText(Integer.toString(bOyuncusu.mevcutAltin));
		oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setText("B");
		oyunAlanlari[bOyuncusu.mevcutSatir][bOyuncusu.mevcutSutun].setBackground(Color.green);
		
		cSkor.setText(Integer.toString(cOyuncusu.mevcutAltin));
		oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setText("C");
		oyunAlanlari[cOyuncusu.mevcutSatir][cOyuncusu.mevcutSutun].setBackground(Color.blue);
		
		dSkor.setText(Integer.toString(dOyuncusu.mevcutAltin));
		oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setText("D");
		oyunAlanlari[dOyuncusu.mevcutSatir][dOyuncusu.mevcutSutun].setBackground(Color.pink);
		
		
		this.add(oyunPenceresi);
		this.add(arkaPlan);
		
		this.setVisible(true);
	}
	
	
	
	
	
	
}
