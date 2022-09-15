
import java.io.*;

public class Tim implements Serializable{
	
	private int id_tim;
	private String nama_tim;
	private String alamat_tim;
	private String pelatih;

	public Tim(int id_tim, String nama_tim, String alamat_tim, String pelatih){
		this.id_tim = id_tim;
		this.nama_tim = nama_tim;
		this.alamat_tim = alamat_tim;
		this.pelatih = pelatih;
	}
	
	
//	public void addTim() {
//		int pos = 0;
//		//create file
//		try {
//            File Obj = new File("tim.txt");
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
//		System.out.print("Input id tim: ");
//		this.id_tim = read.nextInt();
//		System.out.print("Input nama tim: ");read.nextLine();
//		this.nama_tim = read.nextLine();
//		System.out.print("Input alamat tim: ");
//		this.alamat_tim = read.nextLine();
//		System.out.print("Input nama pelatih: ");
//		this.pelatih = read.nextLine();
//		
//		try {
//			if(pos==1) {
//				// Creates a Writer using FileWriter
//			     FileWriter output = new FileWriter("tim.txt", true);
//			     
//			     // Writes string to the file
//			     output.write("\n"+this.getId()+"#"+this.getNama()+"#"+this.getAlamat()+"#"+this.getPelatih());
//			     System.out.println("Data is written to the file.");
//			     
//			     // Closes the writer
//			     output.close();
//			}else {
//				// Creates a Writer using FileWriter
//			     FileWriter output = new FileWriter("tim.txt");
//			     
//			     // Writes string to the file
//			     output.write("\n"+this.getId()+"#"+this.getNama()+"#"+this.getAlamat()+"#"+this.getPelatih());
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
	
	public int getId_tim() {
		return id_tim;
	}

	public void setId_tim(int id_tim) {
		this.id_tim = id_tim;
	}

	public String getNama_tim() {
		return nama_tim;
	}

	public void setNama_tim(String nama_tim) {
		this.nama_tim = nama_tim;
	}

	public String getAlamat_tim() {
		return alamat_tim;
	}

	public void setAlamat_tim(String alamat_tim) {
		this.alamat_tim = alamat_tim;
	}

	public String getPelatih() {
		return pelatih;
	}

	public void setPelatih(String pelatih) {
		this.pelatih = pelatih;
	}

	public void view_tim() {
		if(this.getNama_tim().length()>16) {
			System.out.print("|  "+ this.id_tim +"\t| "+this.nama_tim+"\t| "+  this.alamat_tim  +"\t\t| ");
		}else if(this.getNama_tim().length()<16&&this.getNama_tim().length()>8) {
			System.out.print("|  "+ this.id_tim +"\t| "+this.nama_tim+"\t\t| "+  this.alamat_tim  +"\t\t| ");
		}else {
		    System.out.print("|  "+ this.id_tim +"\t| "+this.nama_tim +"\t\t| "+  this.alamat_tim  +"\t\t| ");
		}
		
		if(this.getPelatih().length()<8) {
			System.out.println(this.pelatih  +"\t\t\t|");
		}else {
			System.out.println(this.pelatih  +"\t\t|");
		}
	    
	}
	
}
