
import java.io.*;

public class Wasit implements Serializable{
//	Scanner read = new Scanner(System.in);
//	ListIterator li = null;
	
	private int id_wasit;
	private String nama_wasit;
	private int umur_wasit;
	private String posisi_wasit;
	private String pengalaman;

	//constructor
	public Wasit(int id, String nama, int umur, String posisi, String pengalaman){
		this.id_wasit = id;
		this.nama_wasit = nama;
		this.umur_wasit = umur;
		this.posisi_wasit = posisi;
		this.pengalaman = pengalaman;
	}

	public int getUmur() {
		return umur_wasit;
	}

	public void setUmur(int umur) {
		this.umur_wasit = umur;
	}

	public int getId_wasit() {
		return id_wasit;
	}

	public void setId_wasit(int id_wasit) {
		this.id_wasit = id_wasit;
	}

	public String getNama_wasit() {
		return nama_wasit;
	}

	public void setNama_wasit(String nama_wasit) {
		this.nama_wasit = nama_wasit;
	}

	public String getPosisi_wasit() {
		return posisi_wasit;
	}

	public void setPosisi_wasit(String posisi_wasit) {
		this.posisi_wasit = posisi_wasit;
	}

	public String getPengalaman() {
		return pengalaman;
	}

	public void setPengalaman(String pengalaman) {
		this.pengalaman = pengalaman;
	}
	
//	public void addWasit() {
//		int pos = 0;
//		//create file
//		try {
//            File Obj = new File("wasit.txt");
//            if (Obj.createNewFile()) {
//                System.out.println("File created: "+ Obj.getName());
//            }
//            else {
//                System.out.println("File already exists.");
//                pos=1;
//            }
//        }
//        catch (IOException e) {
//            System.out.println("An error has occurred.");
//            e.printStackTrace();
//        }
//		
//		System.out.print("Input id wasit: ");
//		this.id_wasit = read.nextInt();
//		System.out.print("Input nama wasit: ");read.nextLine();
//		this.nama_wasit = read.nextLine();
//		System.out.print("Input posisi wasit: ");
//		this.posisi_wasit = read.nextLine();
//		//pengalaman akan diambil dari pertandingan
//		
//		try {
//			if(pos==1) {
//				// Creates a Writer using FileWriter
//			     FileWriter output = new FileWriter("wasit.txt", true);
//			     
//			     // Writes string to the file
//			     output.write("\n"+this.getId_wasit()+" |"+this.getNama_wasit()+"\t\t|"+this.getPosisi_wasit()+"\t\t|"+this.getPengalaman());
//			     System.out.println("Data is written to the file.");
//			     
//			     // Closes the writer
//			     output.close();
//			}else {
//				// Creates a Writer using FileWriter
//			     FileWriter output = new FileWriter("wasit.txt");
//			     
//			     // Writes string to the file
//			     output.write(this.getId_wasit()+" |"+this.getNama_wasit()+"\t\t|"+this.getPosisi_wasit()+"\t\t|"+this.getPengalaman());
//			     System.out.println("Data is written to the file.");
//			     
//				  // Closes the writer
//				  output.close();
//			}
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
	
	public void view_wasit() {
		if(this.posisi_wasit.length()<16) {
			System.out.println("| "+ this.id_wasit +" | "+this.nama_wasit+"\t|  "+this.umur_wasit+"  | "+this.posisi_wasit  +"\t\t| "+this.pengalaman+"\t\t|");
		}
		else {
			System.out.println("| "+ this.id_wasit +" | "+this.nama_wasit+"\t|  "+this.umur_wasit+"  | "+this.posisi_wasit  +"\t| "+this.pengalaman+"\t\t|");
		}
	}

}
