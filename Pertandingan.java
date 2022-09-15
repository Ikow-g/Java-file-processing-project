
import java.io.*;

public class Pertandingan implements Serializable{
	private int id_pertandingan;
	private String stadion;
	private String kota;
	private String tanggal;
	private String jam;
	private String tim1;
	private int skor1;
	private String tim2;
	private int skor2;
	private String wasit;
	private String judul;
	
	public Pertandingan(int id_pertandingan, String stadion, String kota, String tanggal, String jam, String tim1,
			int skor1, String tim2, int skor2, String wasit, String judul) {
		this.id_pertandingan = id_pertandingan;
		this.stadion = stadion;
		this.kota = kota;
		this.tanggal = tanggal;
		this.jam = jam;
		this.tim1 = tim1;
		this.skor1 = skor1;
		this.tim2 = tim2;
		this.skor2 = skor2;
		this.wasit = wasit;
		this.judul = judul;
	}

	public int getId_pertandingan() {
		return id_pertandingan;
	}



	public void setId_pertandingan(int id_pertandingan) {
		this.id_pertandingan = id_pertandingan;
	}



	public String getStadion() {
		return stadion;
	}



	public void setStadion(String stadion) {
		this.stadion = stadion;
	}



	public String getKota() {
		return kota;
	}



	public void setKota(String kota) {
		this.kota = kota;
	}



	public String getTanggal() {
		return tanggal;
	}



	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}



	public String getJam() {
		return jam;
	}



	public void setJam(String jam) {
		this.jam = jam;
	}



	public String getTim1() {
		return tim1;
	}



	public void setTim1(String tim1) {
		this.tim1 = tim1;
	}



	public int getSkor1() {
		return skor1;
	}



	public void setSkor1(int skor1) {
		this.skor1 = skor1;
	}



	public String getTim2() {
		return tim2;
	}



	public void setTim2(String tim2) {
		this.tim2 = tim2;
	}



	public int getSkor2() {
		return skor2;
	}



	public void setSkor2(int skor2) {
		this.skor2 = skor2;
	}



	public String getWasit() {
		return wasit;
	}



	public void setWasit(String wasit) {
		this.wasit = wasit;
	}



	public String getJudul() {
		return judul;
	}



	public void setJudul(String judul) {
		this.judul = judul;
	}

	public void view_pertandingan(){
		System.out.println("| "+this.id_pertandingan+" |\t"+this.judul+"\t|\t"+this.tanggal+", "+this.jam+", "+this.stadion+", "+this.kota+"\t|\t"+this.skor1+" - "+this.skor2+"\t\t|");
	}

}
