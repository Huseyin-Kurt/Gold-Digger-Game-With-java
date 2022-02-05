import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AOyuncusu extends Oyuncu {
	
	File dosya;
	FileWriter dosyaYazicisi;
	BufferedWriter yazici;
	
	public AOyuncusu(int satir,int sutun,int baslangicAltini,int hedefMaliyet,int hamleMaliyet,int hareketPuani,int altinSayisi) throws IOException {
		super(satir,sutun,baslangicAltini,hedefMaliyet,hamleMaliyet,hareketPuani,altinSayisi);
		
		dosya=new File("AKayit.txt");
		dosyaYazicisi=new FileWriter(dosya.getAbsoluteFile());
		yazici=new BufferedWriter(dosyaYazicisi);
		
	}

	@Override
	void hedefBelirleme(OyunAlani[][] oyunAlanlari, Ayarlar ayar) throws IOException {
		
		if(oyunAlanlari[hedefSatir][hedefSutun].durum.equals("bos")) {
			hedefVarmi=false;
		}
		
		if(hedefVarmi==false)
		{
			double uzaklik=0;
			
			
			for(int i=0;i<ayar.satir;i++)
			{
				for(int j=0;j<ayar.sutun;j++)
				{

					if(hedefVarmi==false&&oyunAlanlari[i][j].durum.equals("altin")) {
						hedefSatir=i;
						hedefSutun=j;
						uzaklik=Math.sqrt(Math.pow(Math.abs(i-mevcutSatir), 2)+Math.pow(Math.abs(j-mevcutSutun), 2));
						hedefVarmi=true;
					}
					
					else if(hedefVarmi==true&&oyunAlanlari[i][j].durum.equals("altin")) {
						double yeniUzaklik=Math.sqrt(Math.pow(Math.abs(i-mevcutSatir), 2)+Math.pow(Math.abs(j-mevcutSutun), 2));
						
						if(yeniUzaklik<uzaklik)
						{
							uzaklik=yeniUzaklik;
							hedefSatir=i;
							hedefSutun=j;
						}
						
					}
				}
			}
			
			if(hedefVarmi==true)
			{
				mevcutAltin-=hedefMaliyeti;
				harcananAltin+=hedefMaliyeti;
				
				yazici.write(this.turSayisi+"."+" "+"A oyuncusu hedef olarak "+hedefSatir+","+hedefSutun+" alanýný belirledi.(-"+hedefMaliyeti+") mevcut altýn="+mevcutAltin+"\n");

			}
			
		}
		
	
		
		
	}
	
	@Override
	void hareketEtme(OyunAlani[][] oyunAlanlari) throws IOException
	{
		int temp=hareketPuani;
		
		if(mevcutSatir==hedefSatir&&mevcutSutun==hedefSutun)
		{
			mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
			toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
			
			yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
			
			oyunAlanlari[mevcutSatir][mevcutSutun].durum="bos";
			oyunAlanlari[mevcutSatir][mevcutSutun].setText("");
			oyunAlanlari[mevcutSatir][mevcutSutun].deger=0;
			oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.white);
			
			altinSayisi--;
			
		}
		
		
		
			
			while(mevcutSatir<hedefSatir&&hareketPuani>0)
			{
				mevcutSatir++;
				
				if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("gizliAltin")) {
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="altin";
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.yellow);
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
					
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="bos";
					oyunAlanlari[mevcutSatir][mevcutSutun].setText("");
					oyunAlanlari[mevcutSatir][mevcutSutun].deger=0;
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.white);
					altinSayisi--;
					
				}
				
				
				
				hareketPuani--;
			}
			
			while(mevcutSatir>hedefSatir&&hareketPuani>0)
			{
				mevcutSatir--;
				
				
				if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("gizliAltin")) {
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="altin";
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.yellow);
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
					
	
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="bos";
					oyunAlanlari[mevcutSatir][mevcutSutun].setText("");
					oyunAlanlari[mevcutSatir][mevcutSutun].deger=0;
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.white);
					altinSayisi--;
					
				}
				
				hareketPuani--;
			}
			
			while(mevcutSutun<hedefSutun&&hareketPuani>0)
			{
				mevcutSutun++;
				
				if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("gizliAltin")) {
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="altin";
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.yellow);
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
					
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="bos";
					oyunAlanlari[mevcutSatir][mevcutSutun].setText("");
					oyunAlanlari[mevcutSatir][mevcutSutun].deger=0;
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.white);
					altinSayisi--;
					
				}
				
				hareketPuani--;
			}
			
			while(mevcutSutun>hedefSutun&&hareketPuani>0)
			{
				mevcutSutun--;
				
				if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("gizliAltin")) {
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="altin";
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.yellow);
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
					
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"A oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
					oyunAlanlari[mevcutSatir][mevcutSutun].durum="bos";
					oyunAlanlari[mevcutSatir][mevcutSutun].setText("");
					oyunAlanlari[mevcutSatir][mevcutSutun].deger=0;
					oyunAlanlari[mevcutSatir][mevcutSutun].setBackground(Color.white);
					altinSayisi--;
					
				}
				
				hareketPuani--;
			}
			
			
		
		
		hareketPuani=temp;
		mevcutAltin-=hamleMaliyeti;
		harcananAltin+=hamleMaliyeti;
		
		yazici.write(this.turSayisi+"."+" "+"A oyuncusu turunu "+mevcutSatir+","+mevcutSutun+" alanýnda tamamladý(-"+hamleMaliyeti+") mevcut altýn="+mevcutAltin+"\n");
		
		if(mevcutAltin<=0)
		{
			aktifOyuncu--;
			aktifmi=false;
			
			yazici.write(this.turSayisi+"."+" "+"A oyuncusunun parasý bitti.Artýk devam edemez!.Kalan oyuncu ="+aktifOyuncu);
			yazici.close();
		}
		
	}

	
	

}
