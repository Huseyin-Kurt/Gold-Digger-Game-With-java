import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BOyuncusu extends Oyuncu {
	
	File dosya;
	FileWriter dosyaYazicisi;
	BufferedWriter yazici;
	
	public BOyuncusu(int satir,int sutun,int baslangicAltini,int hedefMaliyet,int hamleMaliyet,int hareketPuani,int altinSayisi) throws IOException {
		super(satir,sutun,baslangicAltini,hedefMaliyet,hamleMaliyet,hareketPuani,altinSayisi);
		
		dosya=new File("BKayit.txt");
		dosyaYazicisi=new FileWriter(dosya.getAbsoluteFile());
		yazici=new BufferedWriter(dosyaYazicisi);
	}

	@Override
	void hedefBelirleme(OyunAlani[][] oyunAlanlari, Ayarlar ayar) throws IOException {
		
		if(oyunAlanlari[hedefSatir][hedefSutun].durum.equals("bos"))
		{
			hedefVarmi=false;
		}
		
		if(hedefVarmi==false)
		{
			int kar=0;
			
			for(int i=0;i<ayar.satir;i++)
			{
				for(int j=0;j<ayar.sutun;j++)
				{
					if(hedefVarmi==false&&oyunAlanlari[i][j].durum.equals("altin"))
					{
						hedefSatir=i;
						hedefSutun=j;
						
						int satirFarki=Math.abs(mevcutSatir-i);
						int sutunFarki=Math.abs(mevcutSutun-j);
						int aradakiFark=satirFarki+sutunFarki;
						
						int carpan=0;
						
						if(aradakiFark%ayar.hareketMesafesi==0)
						{
							carpan=aradakiFark/ayar.hareketMesafesi;
						}
						
						else if(aradakiFark%ayar.hareketMesafesi!=0)
						{
							carpan=(aradakiFark/ayar.hareketMesafesi)+1;
						}
						
						kar=oyunAlanlari[i][j].deger-hedefMaliyeti-(carpan*hamleMaliyeti);
						
						hedefVarmi=true;
					}
					
					else if(hedefVarmi==true&&oyunAlanlari[i][j].durum.equals("altin")) {
						
						int satirFarki=Math.abs(mevcutSatir-i);
						int sutunFarki=Math.abs(mevcutSutun-j);
						int aradakiFark=satirFarki+sutunFarki;
						
						int carpan=0;
						
						if(aradakiFark%ayar.hareketMesafesi==0)
						{
							carpan=aradakiFark/ayar.hareketMesafesi;
						}
						
						else if(aradakiFark%ayar.hareketMesafesi!=0)
						{
							carpan=(aradakiFark/ayar.hareketMesafesi)+1;
						}
						
						int yeniKar=oyunAlanlari[i][j].deger-hedefMaliyeti-(carpan*hamleMaliyeti);
						
						if(yeniKar>kar)
						{
							kar=yeniKar;
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
				
				yazici.write(this.turSayisi+"."+" "+"B oyuncusu hedef olarak "+hedefSatir+","+hedefSutun+" alanýný belirledi.(-"+hedefMaliyeti+") mevcut altýn="+mevcutAltin+"\n");
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
			
			yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
			
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
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"B oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
		
		yazici.write(this.turSayisi+"."+" "+"B oyuncusu turunu "+mevcutSatir+","+mevcutSutun+" alanýnda tamamladý(-"+hamleMaliyeti+") mevcut altýn="+mevcutAltin+"\n");
		
		if(mevcutAltin<=0)
		{
			aktifOyuncu--;
			aktifmi=false;
			
			yazici.write(this.turSayisi+"."+" "+"B oyuncusunun parasý bitti.Artýk devam edemez!.Kalan oyuncu ="+aktifOyuncu);
			yazici.close();
		}
		
	}

}
