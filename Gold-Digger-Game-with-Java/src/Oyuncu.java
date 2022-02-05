import java.io.IOException;

public abstract class Oyuncu {
	
	int mevcutSatir;
	int mevcutSutun;
	int hedefSatir;
	int hedefSutun;
	int mevcutAltin;
	int hedefMaliyeti;
	int hamleMaliyeti;
	int hareketPuani;
	int turSayisi=1;
	static int altinSayisi;
	static int aktifOyuncu;
	boolean hedefVarmi;
	boolean aktifmi;
	int toplananAltin;
	int harcananAltin;
	
	
public Oyuncu(int satir,int sutun,int baslangicAltini,int hedefMaliyet,int hamleMaliyet,int hareketPuani,int altinSayisi) {
	mevcutSatir=satir;
	mevcutSutun=sutun;
	mevcutAltin=baslangicAltini;
	this.hedefMaliyeti=hedefMaliyet;
	this.hamleMaliyeti=hamleMaliyet;
	this.hareketPuani=hareketPuani;
	hedefVarmi=false;
	this.altinSayisi=altinSayisi;
	this.aktifOyuncu=4;
	aktifmi=true;
	toplananAltin=0;
	harcananAltin=0;
}
	
abstract void hedefBelirleme(OyunAlani[][] oyunAlanlari,Ayarlar ayar) throws IOException;
abstract void hareketEtme(OyunAlani[][] oyunAlanlari) throws IOException;

}



