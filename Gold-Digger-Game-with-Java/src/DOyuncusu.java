import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DOyuncusu extends Oyuncu {
	
	File dosya;
	FileWriter dosyaYazicisi;
	BufferedWriter yazici;
	
	int aHedefSatir,aHedefSutun,bHedefSatir,bHedefSutun,cHedefSatir,cHedefSutun;
	
	public DOyuncusu(int satir,int sutun,int baslangicAltini,int hedefMaliyet,int hamleMaliyet,int hareketPuani,int altinSayisi) throws IOException
	{
		super(satir,sutun,baslangicAltini,hedefMaliyet,hamleMaliyet,hareketPuani,altinSayisi);
		dosya=new File("DKayit.txt");
		dosyaYazicisi=new FileWriter(dosya.getAbsoluteFile());
		yazici=new BufferedWriter(dosyaYazicisi);
	}
	
	void hedefCalma(AOyuncusu a,BOyuncusu b,COyuncusu c,OyunAlani[][] oyunAlanlari) throws IOException
	{
		
		aHedefSatir=a.hedefSatir;
		aHedefSutun=a.hedefSutun;
		
		bHedefSatir=b.hedefSatir;
		bHedefSutun=b.hedefSutun;
		
		cHedefSatir=c.hedefSatir;
		cHedefSutun=c.hedefSutun;
		
		
		
		if(hedefVarmi==false)
		{	
			int dTur;
			
			if(a.hedefVarmi==true)
			{		
			
				int  aTur=Math.abs(a.mevcutSatir-a.hedefSatir)+Math.abs(a.mevcutSutun-a.hedefSutun);
			
				if(aTur%hareketPuani==0)
				{
					aTur=aTur/hareketPuani;
				}
			
				else if(aTur%hareketPuani!=0)
				{
					aTur=(aTur/hareketPuani)+1;
				}
			
				dTur=Math.abs(mevcutSatir-a.hedefSatir)+Math.abs(mevcutSutun-a.hedefSutun);
			
				if(dTur%hareketPuani==0)
				{
					dTur=dTur/hareketPuani;
				}
			
				else if(dTur%hareketPuani!=0)
				{
					dTur=(dTur/hareketPuani)+1;
				}
			
				if(dTur<=aTur)
				{
					hedefVarmi=true;
					hedefSatir=a.hedefSatir;
					hedefSutun=a.hedefSutun;
					
					yazici.write(turSayisi+" D oyuncusu a nýn hedefi olan "+hedefSatir+","+hedefSutun+"belirledi. (-"+hedefMaliyeti+")a kalan tur="+aTur+" d kalan tur="+dTur+"\n");
				}
				
			
			}
			
			if(b.hedefVarmi==true&&hedefVarmi==false)
			{
			
				int  bTur=Math.abs(b.mevcutSatir-b.hedefSatir)+Math.abs(b.mevcutSutun-b.hedefSutun);
			
				if(bTur%hareketPuani==0)
				{
					bTur=bTur/hareketPuani;
				}
			
				else if(bTur%hareketPuani!=0)
				{
					bTur=(bTur/hareketPuani)+1;
				}
			
				dTur=Math.abs(mevcutSatir-b.hedefSatir)+Math.abs(mevcutSutun-b.hedefSutun);
			
				if(dTur%hareketPuani==0)
				{
					dTur=dTur/hareketPuani;
				}
			
				else if(dTur%hareketPuani!=0)
				{
					dTur=(dTur/hareketPuani)+1;
				}
			
				if(dTur<=bTur)
				{
					hedefVarmi=true;
					hedefSatir=b.hedefSatir;
					hedefSutun=b.hedefSutun;
					
					yazici.write(turSayisi+" D oyuncusu b nýn hedefi olan "+hedefSatir+","+hedefSutun+"belirledi.b kalan tur="+bTur+" d kalan tur="+dTur+"\n");
				}
			
			}
			
			if(c.hedefVarmi==true&&hedefVarmi==false)
			{
			
				int  cTur=Math.abs(c.mevcutSatir-c.hedefSatir)+Math.abs(c.mevcutSutun-c.hedefSutun);
			
				if(cTur%hareketPuani==0)
				{
					cTur=cTur/hareketPuani;
				}
			
				else if(cTur%hareketPuani!=0)
				{
					cTur=(cTur/hareketPuani)+1;
				}
			
				dTur=Math.abs(mevcutSatir-c.hedefSatir)+Math.abs(mevcutSutun-c.hedefSutun);
			
				if(dTur%hareketPuani==0)
				{
					dTur=dTur/hareketPuani;
				}
			
				else if(dTur%hareketPuani!=0)
				{
					dTur=(dTur/hareketPuani)+1;
				}
			
				if(dTur<=cTur)
				{
					hedefVarmi=true;
					hedefSatir=c.hedefSatir;
					hedefSutun=c.hedefSutun;
					
					yazici.write(turSayisi+" D oyuncusu c nýn hedefi olan "+hedefSatir+","+hedefSutun+"belirledi.c kalan tur="+cTur+" d kalan tur="+dTur+"\n");
				}

			}
			
			if(hedefVarmi==true)
			{
				mevcutAltin-=hedefMaliyeti;
				harcananAltin+=hedefMaliyeti;
			}
			
		}
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
					if(hedefVarmi==false&&oyunAlanlari[i][j].durum.equals("altin")&&aHedefSatir!=i&&aHedefSutun!=j&&bHedefSatir!=i&&bHedefSutun!=j&&cHedefSatir!=i&&cHedefSutun!=j)
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
					
					else if(hedefVarmi==true&&oyunAlanlari[i][j].durum.equals("altin")&&aHedefSatir!=i&&aHedefSutun!=j&&bHedefSatir!=i&&bHedefSutun!=j&&cHedefSatir!=i&&cHedefSutun!=j) {
						
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
				
				yazici.write(this.turSayisi+"."+" "+"D oyuncusu hedef olarak "+hedefSatir+","+hedefSutun+" alanýný belirledi.(-"+hedefMaliyeti+") mevcut altýn="+mevcutAltin+"\n");
			}
			
		}

	}

	@Override
	void hareketEtme(OyunAlani[][] oyunAlanlari) throws IOException {
		
		int temp=hareketPuani;
		
		
		if(mevcutSatir==hedefSatir&&mevcutSutun==hedefSutun)
		{
			mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
			toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
			
			yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
			
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
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki gizli altýný ortaya çýkardý!"+"\n");
				}
				
				else if(oyunAlanlari[mevcutSatir][mevcutSutun].durum.equals("altin"))
				{
					mevcutAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					toplananAltin+=oyunAlanlari[mevcutSatir][mevcutSutun].deger;
					
					yazici.write(this.turSayisi+"."+" "+"D oyuncusu "+mevcutSatir+","+mevcutSutun+" alanýndaki "+oyunAlanlari[mevcutSatir][mevcutSutun].deger+" altýný aldý.Mevcut altýn ="+mevcutAltin+"\n");
					
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
		
		yazici.write(this.turSayisi+"."+" "+"D oyuncusu turunu "+mevcutSatir+","+mevcutSutun+" alanýnda tamamladý(-"+hamleMaliyeti+") mevcut altýn="+mevcutAltin+"\n");
		
		
		if(mevcutAltin<=0)
		{
			aktifOyuncu--;
			aktifmi=false;
			
			yazici.write(this.turSayisi+"."+" "+"D oyuncusunun parasý bitti.Artýk devam edemez!.Kalan oyuncu ="+aktifOyuncu);
			yazici.close();
		}
	}

}
