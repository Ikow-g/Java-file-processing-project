
import java.io.*;

public class Pemain implements Serializable{
	private int id_pemain;
	private String nama_pemain;
	private int umur_pemain;
	private String posisi_pemain;
	private String timPemain;

	//constructor
	public Pemain(int id, String nama, int umur, String posisi, String timPemain){
		this.id_pemain = id;
		this.nama_pemain = nama;
		this.umur_pemain = umur;
		this.posisi_pemain = posisi;
		this.timPemain = timPemain;
	}

	public String getTimPemain() {
		return timPemain;
	}

	public void setTimPemain(String timPemain) {
		this.timPemain = timPemain;
	}

	public int getId_pemain() {
		return id_pemain;
	}

	public void setId_pemain(int id_pemain) {
		this.id_pemain = id_pemain;
	}

	public String getNama_pemain() {
		return nama_pemain;
	}

	public void setNama_pemain(String nama_pemain) {
		this.nama_pemain = nama_pemain;
	}

	public int getUmur_pemain() {
		return umur_pemain;
	}

	public void setUmur_pemain(int umur_pemain) {
		this.umur_pemain = umur_pemain;
	}

	public String getPosisi_pemain() {
		return posisi_pemain;
	}

	public void setPosisi_pemain(String posisi_pemain) {
		this.posisi_pemain = posisi_pemain;
	}
	
	public void view_pemain() {
		if(this.getNama_pemain().length()<8) {
			System.out.print("|"+ this.id_pemain +"\t|\t"	+	this.nama_pemain    +"\t\t|\t"+  this.umur_pemain  +"\t|\t");
		
		}else {
			System.out.print("|"+ this.id_pemain +"\t|\t"	+	this.nama_pemain    +"\t|\t"+  this.umur_pemain  +"\t|\t");
		
		}
		if(this.getPosisi_pemain().length()>8) {
			System.out.println(this.posisi_pemain  +"\t|\t"+     this.timPemain     +"\t|");
		}else {
			System.out.println(this.posisi_pemain  +"\t\t|\t"+     this.timPemain     +"\t|");
		}
	}

//	public void addPemain(){
//		ArrayList<Pemain> al = new ArrayList<Pemain>();
//		//pick tim
//		//show tim
//		try {
//			File myObj = new File("tim.txt");
//		    Scanner myReader = new Scanner(myObj);
//		    while (myReader.hasNextLine()) {
//		    	String data = myReader.nextLine();
//		    	System.out.println(data);
//		    }
//		    myReader.close();
//		} catch (FileNotFoundException e) {
//		    System.out.println("An error occurred.");
//		    e.printStackTrace();
//		}
//		
//		System.out.print("Pilih Tim yang ingin ditambah pemainnya[nomor ID] : ");
//		int noTim = read.nextInt();
//		
//		
//		int jumlah;
//		System.out.print("Mau menambah berapa pemain? : ");
//		jumlah = read.nextInt();
//		for(int i=0; i<jumlah; i++) {
//			System.out.print("ID Pemain   : ");
//			this.id_pemain = read.nextInt();
//			System.out.print("Nama Pemain : ");
//			this.nama_pemain = read.nextLine();
//			System.out.print("Umur        : ");
//			this.umur_pemain = read.nextInt();
//			System.out.print("Posisi      : ");
//			this.posisi_pemain = read.nextLine();
//			al.add(new Pemain(this.id_pemain,this.nama_pemain,this.umur_pemain,this.posisi_pemain,this.timPemain));
//		}
//	}
}
