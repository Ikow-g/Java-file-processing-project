
import java.io.*;

public class Pelanggaran implements Serializable{
	private String pemain;
	private String kartu;
	private String sanksi;
	private String durasi_sanksi;
	private int idPertandingan;

	public Pelanggaran(String pemain, String kartu, String sanksi, String durasi, int id){
		this.pemain = pemain;
		this.kartu = kartu;
		this.sanksi = sanksi;
		this.durasi_sanksi = durasi;
		this.idPertandingan = id;
	}

	public int getIdPertandingan() {
		return idPertandingan;
	}

	public void setIdPertandingan(int idPertandingan) {
		this.idPertandingan = idPertandingan;
	}

	public String getPemain() {
		return pemain;
	}

	public void setPemain(String pemain) {
		this.pemain = pemain;
	}

	public String getKartu() {
		return kartu;
	}

	public void setKartu(String kartu) {
		this.kartu = kartu;
	}

	public String getSanksi() {
		return sanksi;
	}

	public void setSanksi(String sanksi) {
		this.sanksi = sanksi;
	}

	public String getDurasi_sanksi() {
		return durasi_sanksi;
	}

	public void setDurasi_sanksi(String durasi_sanksi) {
		this.durasi_sanksi = durasi_sanksi;
	}
	
	public void view_pelanggaran() {
		if(this.pemain.length()<16&&this.pemain.length()>8) {
			System.out.print("| "+this.pemain+"\t| "+this.kartu+"\t| ");
		}else {
			System.out.print("| "+this.pemain+"\t\t| "+this.kartu+"\t| ");
		}
		if(this.sanksi.length()>20) {
			System.out.println(this.sanksi+"\t| "+this.durasi_sanksi+"\t|");
		}else {
			System.out.println(this.sanksi+"\t\t| "+this.durasi_sanksi+"\t|");
		}
		
	}
}
