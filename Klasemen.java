
import java.io.*;

public class Klasemen implements Serializable, Score{
	private String nama_tim;
	private int menang;
	private int kalah;
	private int seri;
	private int goal;
	private int total_poin;

	public Klasemen(String nama_tim, int menang, int kalah, int seri, int goal, int total_poin){
		this.nama_tim = nama_tim;
		this.menang = menang;
		this.kalah = kalah;
		this.seri = seri;
		this.goal = goal;
		this.total_poin = total_poin;
	}

	public String getNama_tim() {
		return nama_tim;
	}

	public void setNama_tim(String nama_tim) {
		this.nama_tim = nama_tim;
	}

	public int getTotal_poin() {
		return total_poin;
	}

	public void setTotal_poin(int total_poin) {
		this.total_poin = total_poin;
	}

	public int getMenang() {
		return menang;
	}

	public void setMenang(int menang) {
		this.menang = menang;
	}

	public int getKalah() {
		return kalah;
	}

	public void setKalah(int kalah) {
		this.kalah = kalah;
	}

	public int getSeri() {
		return seri;
	}

	public void setSeri(int seri) {
		this.seri = seri;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	@Override
	public void menang() {
		this.total_poin+=3;
		this.menang++;
	}

	@Override
	public void kalah() {
		this.total_poin+=0;
		this.kalah++;
	}
	
	@Override
	public void seri() {
		this.total_poin+=1;
		this.seri++;
	}
	
	public void view_klasemen() {
		if(this.nama_tim.length()>16) {
			System.out.print("| "+this.nama_tim+" \t| "+this.menang+" | "+this.kalah+" | "+this.seri+" | "+this.goal);
		}else {
			System.out.print("| "+this.nama_tim+" \t\t| "+this.menang+" | "+this.kalah+" | "+this.seri+" | "+this.goal);
		}
		if(this.goal>=10) {
			System.out.println("| "+this.total_poin+"\t |");
		}else {
			System.out.println(" | "+this.total_poin+"\t |");
		}
	}
	
}
