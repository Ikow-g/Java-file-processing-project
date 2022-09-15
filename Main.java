import java.io.*;
import java.util.*;

public class Main {
	static Scanner read = new Scanner(System.in);
	
	public static void title() {
        System.out.println("===============================================================================================");
        System.out.println(" ______   _____   _____  _____  _____   _____     ____   _____   ____  _      _  ____    ____");
        System.out.println("||       ||    | ||     ||     ||      ||    |   ||   | ||      ||     ||\\   || ||   \\  ||   |");
        System.out.println("||_____  ||    | ||     ||     ||____  ||____|   ||___| ||  __  ||___  || \\  || ||    | ||___|");
        System.out.println("      || ||    | ||     ||     ||      ||  \\     ||   | ||    | ||     ||  \\ || ||    | ||   |");
        System.out.println(" _____|| ||____| ||____ ||____ ||____  ||   \\    ||   | ||____| ||___  ||   \\|| ||___/  ||   |");
        System.out.println("===============================================================================================");
    }
	
	public static int login() { 	
		User user = new User("user","user","user");
		User admin = new User("admin","admin","admin");
		String username, password;
//		char[] password;
		System.out.println("=====");
		System.out.print("Username: ");
		username = read.next();
		System.out.print("Password: ");
//		Console cons = System.console();
//		if(cons==null) {
//			System.out.println("no console");
//			System.exit(0);
//		}
//		password = cons.readPassword("Password: ");
		password = read.next();
		if(username.equals(user.getUser())&&password.equals(user.getPass())){
			return 1;
		}else if(username.equals(admin.getUser())&&password.equals(admin.getPass())){
			return 2;
		}else{
			System.out.println("Username atau password salah!");
			return 0;
		}
    }
	
	public static void menu_user() {
	    System.out.println("USER MENU");
	    System.out.println("====");
	    System.out.println("1. View Data");
	    System.out.println("2. View Klasemen");
	    System.out.println("3. Logout");
	    System.out.println("4. Exit Program");
	}
	
	public static void menu_admin() {
	    System.out.println("ADMIN MENU");
	    System.out.println("====");
	    System.out.println("1. Tambah Data Pertandingan");
		System.out.println("2. Tambah Tim");
		System.out.println("3. Tambah Pemain");
		System.out.println("4. Tambah Wasit");
		System.out.println("5. Logout");
		System.out.println("6. Exit Program");
	}
	
	
	public static void main(String[] args) throws Exception {
		ListIterator li = null;
		
		//tim============================================================================
		Tim tim = new Tim(0, null, null, null);
		ObjectOutputStream oosT = null;
		ObjectInputStream oisT = null;
		//write
		File filetim = new File("tim.txt");
		ArrayList<Tim> aTim = new ArrayList<Tim>();
		//read
		if(filetim.isFile()) {
			oisT = new ObjectInputStream(new FileInputStream(filetim));
			aTim = (ArrayList<Tim>)oisT.readObject();
			oisT.close();
		}
		
		//pemain==========================================================================
		Pemain pemain = new Pemain(0, null, 0, null, null);
		ObjectOutputStream oosP = null;
		ObjectInputStream oisP = null;
		//write
		File filepemain = new File("pemain.txt");
		ArrayList<Pemain> aPemain = new ArrayList<Pemain>();
		//read
		if(filepemain.isFile()) {
			oisP = new ObjectInputStream(new FileInputStream(filepemain));
			aPemain = (ArrayList<Pemain>)oisP.readObject();
			oisP.close();
		}
		
		//wasit===========================================================================
		Wasit wasit = new Wasit(0, null, 0, null, null);
		ObjectOutputStream oosW = null;
		ObjectInputStream oisW = null;
		//write
		File fileWasit = new File("wasit.txt");
		ArrayList<Wasit> aWasit = new ArrayList<Wasit>();
		//read
		if(fileWasit.isFile()) {
			oisW = new ObjectInputStream(new FileInputStream(fileWasit));
			aWasit = (ArrayList<Wasit>)oisW.readObject();
			oisW.close();
		}
		
		//pertandingan====================================================================
		Pertandingan pertandingan = new Pertandingan(0, null, null, null, null, null, 0, null, 0, null, null);
		ObjectOutputStream oosPer = null;
		ObjectInputStream oisPer = null;
		//write
		File filepertandingan = new File("pertandingan.txt");
		ArrayList<Pertandingan> aPertandingan = new ArrayList<Pertandingan>();
		//read
		if(filepertandingan.isFile()) {
			oisPer = new ObjectInputStream(new FileInputStream(filepertandingan));
			aPertandingan = (ArrayList<Pertandingan>)oisPer.readObject();
			oisPer.close();
		}
		
		//pelanggaran=====================================================================
		Pelanggaran pelanggaran = new Pelanggaran(null, null, null, null, 0);
		ObjectOutputStream oosPel = null;
		ObjectInputStream oisPel = null;
		//write
		File filepelanggaran = new File("pelanggaran.txt");
		ArrayList<Pelanggaran> aPelanggaran = new ArrayList<Pelanggaran>();
		//read
		if(filepelanggaran.isFile()) {
			oisPel = new ObjectInputStream(new FileInputStream(filepelanggaran));
			aPelanggaran = (ArrayList<Pelanggaran>)oisPel.readObject();
			oisPel.close();
		}
		
		//KLASEMEN=======================================================================
		Klasemen klasemen = new Klasemen(null, 0, 0, 0, 0, 0);
		ObjectOutputStream oosK = null;
		ObjectInputStream oisK = null;
		//write
		File fileklasemen = new File("klasemen.txt");
		ArrayList<Klasemen> aKlasemen = new ArrayList<Klasemen>();
		//read
		if(fileklasemen.isFile()) {
			oisK = new ObjectInputStream(new FileInputStream(fileklasemen));
			aKlasemen = (ArrayList<Klasemen>)oisK.readObject();
			oisK.close();
		}
		
		title();
		System.out.println("Menu");
		int flag=1;
		int log=0;
		
		while(flag==1) {
			log = login();
			if(log==1){//user
				System.out.println("You are LOGIN as USER");
		        int menu = 0;
		        do{
		        	menu_user();
			        System.out.print("Pilih menu: ");
			        menu = read.nextInt();
			        switch (menu) {
			          case 1: {
			        	  int menu1 = 0;
			        	  do{
					            System.out.println("====");
					            System.out.println("1. View Data Pertandingan");
					            System.out.println("2. View Data Tim");
					            System.out.println("3. View Data Pemain");
					            System.out.println("4. View Data Wasit");
				                System.out.println("5. Back");
								System.out.println("6. Exit Program");  
				                System.out.print("Pilih menu: ");
				                menu1 = read.nextInt();
						  
					            switch (menu1) {
					              	// view data pertandingan
					              	case 1: {
					              		System.out.println("_________________________________________________________________________________________________________________________");
										System.out.println("|  ID  |\t\tJudul\t\t\t|\t\tWaktu & Tempat\t\t\t|\tHasil Akhir\t|");
										System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
										
					              		if (aPertandingan.isEmpty()) {
					              		System.out.println("no data");
					              		} else {
					              			int i = 0;
					              			while (i < aPertandingan.size()) {
					              				aPertandingan.get(i).view_pertandingan();
					              				i++;
					              			}
					              		}
					              		System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
					              		
					              		int id_pertandingan;
										boolean found = false;
					              		String detail = "y";
					              		
					              		while(detail.equals("y")) {
					              			System.out.print("Ingin melihat detail pertandingan? [y/n] : ");
					              			detail = read.next();
					              			if(detail.equals("y")) {
					              				do {
													System.out.print("ID Pertandingan           : ");
													id_pertandingan = read.nextInt();
													
													//cek
													li = aPertandingan.listIterator();
													while(li.hasNext()) {
														Pertandingan e = (Pertandingan)li.next();
														if(e.getId_pertandingan() == id_pertandingan) {
															id_pertandingan = e.getId_pertandingan();
															found=true;
														}
													}
													if(!found) {
														System.out.println("Pertandingan tidak ditemukan");
													}
												}while(found==false);
					              				
					              				System.out.println("Tabel Pelanggaran dalam pertandingan dengan ID : "+id_pertandingan);
					              				System.out.println("________________________________________________________________________________");
					              				System.out.println("|\tNama Pemain\t| Kartu\t|\t\tSanksi\t\t| Durasi Sanksi\t|");
					              				System.out.println("|-------------------------------------------------------------------------------|");
					              				li = aPelanggaran.listIterator();
					              				while(li.hasNext()) {
					              					Pelanggaran e = (Pelanggaran)li.next();
					              					if(e.getIdPertandingan() == id_pertandingan) {
					              						e.view_pelanggaran();
					              					}
					              				}
					              				System.out.println("|-------------------------------------------------------------------------------|");
					              			}else if(!detail.equals("y")&&!detail.equals("n")) {
					              				System.out.println("Pilihan hanya y/n...");
					              			}else{
                                                break;
                                            }
					              		}
					              	break;
					              	}
										
					              // view data tim
					              	case 2: {
					              		System.out.println("_________________________________________________________________________________");
									    System.out.println("| ID Tim |\tNama Tim\t|\tAlamat Tim\t|\tPelatih\t\t|");
									    System.out.println("|-------------------------------------------------------------------------------|");
					              		if (aTim.isEmpty()) {
					              			System.out.println("no data");
					              		} else {
					              			int i = 0;
					              			while (i < aTim.size()) {
					              				aTim.get(i).view_tim();
					              				i++;
					              			}
					              		}
					              		System.out.println("|-------------------------------------------------------------------------------|");
					                
					              		int id_tim;
										boolean found = false;
					              		String detail = "y";
					              		String timName = null;
					              		
					              		while(detail.equals("y")) {
					              			
					              			System.out.print("Ingin melihat pemain dari Tim? [y/n] : ");
					              			detail = read.next();
					              			if(detail.equals("y")) {
					              				do {
					              					
													System.out.print("ID Tim           : ");
													id_tim = read.nextInt();
													
													//cek
													li = aTim.listIterator();
													while(li.hasNext()) {
														Tim e = (Tim)li.next();
														if(e.getId_tim() == id_tim) {
															id_tim = e.getId_tim();
															timName = e.getNama_tim();
															found=true;
														}
													}
													if(!found) {
														System.out.println("Tim tidak ditemukan");
													}
												}while(found==false);
					              				
					              				System.out.println("Tabel Pemain dalam Tim dengan ID : "+id_tim);
					              				System.out.println("_________________________________________________________________________________________________");
											    System.out.println("|  ID  |\tNama\t\t|\tUmur\t|\tPosisi\t\t|\tTim\t\t|");
											    System.out.println("|-----------------------------------------------------------------------------------------------|");
							              		li = aPemain.listIterator();
					              				while(li.hasNext()) {
					              					Pemain e = (Pemain)li.next();
					              					if(e.getTimPemain().equals(timName)) {
					              						e.view_pemain();
					              					}
					              				}
					              				System.out.println("|-----------------------------------------------------------------------------------------------|");
					              			}else if(!detail.equals("y")&&!detail.equals("n")) {
					              				System.out.println("Pilihan hanya y/n...");
					              			}else{
                                                break;
                                            }
					              		}
					              		
					              	break;
					              	}
										
					              // view data pemain
					              	case 3: {
					              		System.out.println("_________________________________________________________________________________________________");
									    System.out.println("|  ID  |\tNama\t\t|\tUmur\t|\tPosisi\t\t|\tTim\t\t|");
									    System.out.println("|-----------------------------------------------------------------------------------------------|");
					              		
					              		if (aPemain.isEmpty()) {
					              			System.out.println("no data");
					              		} else {
					              			int i = 0;
					              			while (i < aPemain.size()) {
					              				aPemain.get(i).view_pemain();
					              				i++;
					              			}
					              		}
					              		System.out.println("|-----------------------------------------------------------------------------------------------|");
					                break;
					              	}
									
					              	// view data wasit
									case 4: {
										System.out.println("_________________________________________________________________________________________________________");
									    System.out.println("|  ID  |   Nama Wasit   | Umur |\tPosisi Wasit\t|\t\tPengalaman Wasit\t\t|");
									    System.out.println("|-------------------------------------------------------------------------------------------------------|");
						                if (aWasit.isEmpty()) {
						                  System.out.println("no data");
						                } else {
						                	int i = 0;
			                  				while (i < aWasit.size()) {
			                  					aWasit.get(i).view_wasit();
			                  					i++;
			                  				}
			                			}
						                System.out.println("|-------------------------------------------------------------------------------------------------------|");
			                		break;
			              			}		
									// Back
					                case 5:{
					                    
					                    break;
									}
									case 6:{
										System.out.println("Thankyou for using~");
										System.exit(0);
							
									}
									//menu tidak ada
			              			default: {
				            	  		System.out.println("Menu yang anda pilih tidak ada.");
				                		break;
			              			}
			            		}
		                	}while(menu1!=5);
			        	  	break;
			          	}
			          	case 2: {
			          		System.out.println("_________________________________________________");
			          		System.out.println("|\tNama Tim\t| W | L | D | G | Points |");
			          		System.out.println("|------------------------------------------------|");
			          		if (aKlasemen.isEmpty()) {
			          			System.out.println("no data");
			        	  	} else {
			        	  		int i = 0;
			              		while (i < aKlasemen.size()) {
			            	  		aKlasemen.get(i).view_klasemen();
			                		i++;
			              		}
			        	  	}
			        	  	System.out.println("|------------------------------------------------|");
			        	  	break;
			          	}
			          	case 3: {
				            // flag2=1;
				            // flag=0;
				            // System.exit(0);
			        	  	break;
			          	}
						case 4:{
							System.exit(0);
							break;
						}
						default: {
			        	  	System.out.println("Menu yang anda pilih tidak ada.");
			            	break;
			          	}
			        }
				}while(menu!=3);
		        
			}else if(log==2){//admin
			    System.out.println("You are LOGIN as ADMIN");
				int flag2=0;
				while(flag2==0) {
					menu_admin();
					int menu=0;
					System.out.print("Pilih menu: ");
					menu = read.nextInt();
					switch(menu) {
						//case 1 =================================================================================================== case 1
						case 1:{
							//cek tim
							int brpTim=0;
							while(brpTim<aTim.size()) {
								brpTim++;
							}
							
							if(aTim.isEmpty()||brpTim<2) {
								System.out.println("Tim tidak ada atau hanya ada 1, tolong tambahkan tim terlebih dahulu!");
								break;
							}
							
							//cek pemain
							if(aPemain.isEmpty()) {
								System.out.println("Pemain tidak ada, tolong tambahkan pemain terlebih dahulu!");
								break;
							}
							
							//cek wasit
							if(aWasit.isEmpty()) {
								System.out.println("Wasit tidak ada, tolong tambahkan wasit terlebih dahulu!");
								break;
							}
							
							//display pertandingan
							System.out.println("_________________________________________________________________________________________________________________________");
							System.out.println("|  ID  |\t\tJudul\t\t\t|\t\tWaktu & Tempat\t\t\t|\tHasil Akhir\t|");
							System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
							int z=0;
							while(z<aPertandingan.size()) {
								aPertandingan.get(z).view_pertandingan();
								z++;
							}
							System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
							//cek
							int id_pertandingan;
							boolean found = false;
							
							do {
								int pos = 0;
								System.out.print("ID Pertandingan           : ");
								id_pertandingan = read.nextInt();
								
								//cek
								li = aPertandingan.listIterator();
								while(li.hasNext()) {
									Pertandingan e = (Pertandingan)li.next();
									if(e.getId_pertandingan() == id_pertandingan) {
										System.out.println("ID duplikat, mohon input kembali...");
										pos+=1;
									}
								}
								if(pos==0) {
									found=true;
									break;
								}
							}while(found==false);
							
							System.out.print("Stadion                   : ");read.nextLine();
							String stadion = read.nextLine();
							System.out.print("Kota                      : ");
							String kota = read.nextLine();
							System.out.print("Tanggal [dd/mm/yyyy]      : ");
							String tanggal = read.nextLine();
							System.out.print("Waktu [hh:mm]             : ");
							String jam = read.nextLine();
							
							int noTim1=0, noTim2=0;
							boolean found1 = false;
							boolean found2 = false;
							String name1 = null;
							String name2 = null;
							int skor1 = 0;
							int skor2 = 0;
							
							//display tim dulu
							System.out.println("_________________________________________________________________________________");
						    System.out.println("| ID Tim |\tNama Tim\t|\tAlamat Tim\t|\tPelatih\t\t|");
						    System.out.println("|-------------------------------------------------------------------------------|");
		              		
							int i=0;
							while(i<aTim.size()) {
								aTim.get(i).view_tim();
								i++;
							}
							System.out.println("|-------------------------------------------------------------------------------|");
							
							//input tim
							do {
								System.out.print("Pilih Tim 1[nomor ID Tim] : ");
								noTim1 = read.nextInt();
								
								//cek
								li = aTim.listIterator();
								while(li.hasNext()) {
									Tim e = (Tim)li.next();
									if(e.getId_tim() == noTim1) {
										name1 = e.getNama_tim();
										System.out.println("Tim 1: "+ e.getNama_tim());
										found1 = true;
										System.out.print("Skor Tim 1                : ");
										skor1 = read.nextInt();
									}
								}
								if(!found1) {
									System.out.println("Tim tidak ditemukan...");
								}
							}while(found1==false);
							
							//tim 2
							do {
								System.out.print("Pilih Tim 2[nomor ID Tim] : ");
								noTim2 = read.nextInt();
									
								//cek
								if(noTim2!=noTim1) {
									li = aTim.listIterator();
									while(li.hasNext()) {
										Tim e = (Tim)li.next();
										if(e.getId_tim() == noTim2) {
											name2 = e.getNama_tim();
											System.out.println(e.getNama_tim());
											found2 = true;
											System.out.print("Skor Tim 2                : ");
											skor2 = read.nextInt();
										}
									}
									if(!found2) {
										System.out.println("Tim tidak ditemukan...");
									}
								}else {
									System.out.println("Harus dengan Tim yang berbeda!");
								}
							}while(noTim2==noTim1||found2==false);
							
						
							String judul = name1+" VS "+name2;
							
							//display wasit
							System.out.println("_________________________________________________________________________________________________________");
						    System.out.println("|  ID  |   Nama Wasit   | Umur |\tPosisi Wasit\t|\t\tPengalaman Wasit\t\t|");
						    System.out.println("|-------------------------------------------------------------------------------------------------------|");
			                
							int x=0;
							while(x<aWasit.size()) {
								aWasit.get(x).view_wasit();
								x++;
							}
							System.out.println("|-------------------------------------------------------------------------------------------------------|");
							//input wasit
							boolean foundW = false;
							
							String wasit_name = null;
							int umurWasit;
							String posisiWasit;
							String pengalaman;
							
							do {
								System.out.print("Wasit [nomor ID Wasit]    : ");
								int noWasit = read.nextInt();
								
								//cek
								li = aWasit.listIterator();
								while(li.hasNext()) {
									Wasit e = (Wasit)li.next();
									if(e.getId_wasit() == noWasit) {
										wasit_name = e.getNama_wasit();
										umurWasit = e.getUmur();
										posisiWasit = e.getPosisi_wasit();
										if(e.getPengalaman()==null) {
											pengalaman = judul+" - "+stadion;
										}else {
											pengalaman = e.getPengalaman()+", "+judul+" - "+stadion;
										}
										li.set(new Wasit(noWasit,wasit_name,umurWasit,posisiWasit,pengalaman));
										System.out.println(e.getNama_wasit());
										
										foundW = true;
										
									}
								}
								if(!foundW) {
									System.out.println("Wasit tidak ditemukan...");
								}
							}while(foundW==false);
							
							//pelanggaran
							int timPelanggar;
							int pemainPelanggar;
							String ada = "n";
							
							do {
								String timName = null;
								System.out.print("Apakah ada pelanggaran? [y/n] : ");
								ada = read.next();
								if(ada.equals("y")) {
									//show 2 tim saat pertandingan
									System.out.println("___________________________________________________________________________________");
								    System.out.println("| ID Tim |    Nama Tim    |  Alamat Tim  |  Pelatih  |");
								    System.out.println("|----------------------------------------------------------------------------------|");
									
								    li = aTim.listIterator();
									while(li.hasNext()) {
										Tim e = (Tim)li.next();
										if(e.getId_tim() == noTim1 || e.getId_tim()== noTim2) {
											e.view_tim();
										}
									}	
									System.out.println("|----------------------------------------------------------------------------------|");
									
									//input tim
									boolean po = false;
									do {
										System.out.print("Pilih Tim Pemain[nomor ID Tim] : ");
										timPelanggar = read.nextInt();
										
										//cek
										li = aTim.listIterator();
										while(li.hasNext()) {
											Tim e = (Tim)li.next();
											if(noTim1 == timPelanggar && e.getId_tim()==timPelanggar) {
												timName = e.getNama_tim();
												System.out.println(timName);
												po = true;
											}else if(noTim1 != timPelanggar && noTim2 == timPelanggar && e.getId_tim()==timPelanggar) {
												timName = e.getNama_tim();
												System.out.println(timName);
												po = true;
											}
										}
										if(!po) {
											System.out.println("Tim tidak ditemukan...");
										}
									}while(po==false);
									
									//display player from choosen tim
									boolean pem = false;
									li = aPemain.listIterator();
									while(li.hasNext()) {
										Pemain e = (Pemain)li.next();
										if(e.getTimPemain().equals(timName)) {
											e.view_pemain();
											pem = true;
										}
									}
									if(!pem) {
										System.out.println("Pemain tidak ditemukan...");
										ada="n";
									}else {
										System.out.print("Mau berapa pemain? : ");
										int jum = read.nextInt();
										for(int h=0; h<jum; h++) {
											boolean pem2 = false;
											do {
												System.out.print("Pilih Pemain [nomor ID Pemain] : ");
												int num = read.nextInt();
												li = aPemain.listIterator();
												while(li.hasNext()) {
													Pemain e = (Pemain)li.next();
													if(e.getId_pemain() == num && e.getTimPemain().equals(timName)) {
														String pemainName = e.getNama_pemain();
														System.out.print("Kartu [merah/kuning] : ");read.nextLine();
														String kartu = read.nextLine();
														System.out.print("Sanksi               : ");
														String sanksi = read.nextLine();
														System.out.print("Durasi Sanksi      : ");
														String durasiSanksi = read.nextLine();
														
														//write pelanggaran
														aPelanggaran.add(new Pelanggaran(pemainName,kartu,sanksi,durasiSanksi,id_pertandingan));
														
														pem2 = true;
													}
												}
												if(!pem2) {
													System.out.println("Pemain tidak ditemukan...");
													break;
												}
											}while(pem2==false);
										}
									}
								}else if(ada.equals("n")) {
									break;
								}else if(!ada.equals("y")||!ada.equals("n")){
									System.out.println("Pilih hanya y/n...");
								}
							}while(!ada.equals("n"));
							
							//skoring
							if(skor1>skor2) {
								//tim1 win
								
								//cek
								li = aKlasemen.listIterator();
								while(li.hasNext()) {
									Klasemen e = (Klasemen)li.next();
									if(e.getNama_tim().contains(name1)) {
										e.menang();
										e.setGoal((e.getGoal()+skor1));
									}else if(e.getNama_tim().contains(name2)) {
										e.kalah();
										e.setGoal((e.getGoal()+skor2));
									}
								}
								
								
							}else if(skor1<skor2) {
								//tim2 win
								li = aKlasemen.listIterator();
								while(li.hasNext()) {
									Klasemen e = (Klasemen)li.next();
									if(e.getNama_tim().contains(name1)) {
										e.kalah();
										e.setGoal((e.getGoal()+skor1));
									}else if(e.getNama_tim().contains(name2)) {
										e.menang();
										e.setGoal((e.getGoal()+skor2));
									}
								}
								
							}else if(skor1==skor2) {
								li = aKlasemen.listIterator();
								while(li.hasNext()) {
									Klasemen e = (Klasemen)li.next();
									if(e.getNama_tim().contains(name1)) {
										e.seri();
										e.setGoal((e.getGoal()+skor1));
									}else if(e.getNama_tim().contains(name2)) {
										e.seri();
										e.setGoal((e.getGoal()+skor2));
									}
								}
							}
							
							//sort klasemen
							Collections.sort(aKlasemen, new Comparator<Klasemen>(){
								public int compare(Klasemen k1, Klasemen k2) {
									if(k2.getTotal_poin()==k1.getTotal_poin()) {
										return k2.getGoal() - k1.getGoal();
									}else {
										return k2.getTotal_poin() - k1.getTotal_poin();
									}
								}
							});
							
							
							oosK = new ObjectOutputStream(new FileOutputStream(fileklasemen));
							oosK.writeObject(aKlasemen);
							oosK.close();
							
							oosPel = new ObjectOutputStream(new FileOutputStream(filepelanggaran));
							oosPel.writeObject(aPelanggaran);
							oosPel.close();
							
							oosW = new ObjectOutputStream(new FileOutputStream(fileWasit));
							oosW.writeObject(aWasit);
							oosW.close();
							
							aPertandingan.add(new Pertandingan(id_pertandingan,stadion,kota,tanggal,jam,name1,skor1,name2,skor2,wasit_name,judul));
							oosPer = new ObjectOutputStream(new FileOutputStream(filepertandingan));
							oosPer.writeObject(aPertandingan);
							oosPer.close();
							
							break;
						}
						//case 2 =================================================================================================== case 2
						case 2:{
							
							//display
							System.out.println("_________________________________________________________________________________");
						    System.out.println("| ID Tim |\tNama Tim\t|\tAlamat Tim\t|\tPelatih\t\t|");
						    System.out.println("|-------------------------------------------------------------------------------|");
		              		
							if(aTim.isEmpty()) {
								System.out.println("no data");
							}else {
								int i=0;
								while(i<aTim.size()) {
									aTim.get(i).view_tim();
									i++;
								}
							}
							System.out.println("|-------------------------------------------------------------------------------|");
							
							//cek
							int id_tim;
							boolean found = false;
							
							do {
								int pos = 0;
								System.out.print("ID Tim       : ");
								id_tim = read.nextInt();
								
								//cek
								li = aTim.listIterator();
								while(li.hasNext()) {
									Tim e = (Tim)li.next();
									if(e.getId_tim() == id_tim) {
										System.out.println("ID duplikat, mohon input kembali...");
										pos+=1;
									}
								}
								if(pos==0) {
									found=true;
									break;
								}
							}while(found==false);
							
							System.out.print("Nama tim     : ");read.nextLine();
							String nama_tim = read.nextLine();
							System.out.print("Alamat tim   : ");
							String alamat_tim = read.nextLine();
							System.out.print("Nama pelatih : ");
							String pelatih = read.nextLine();
							
							aKlasemen.add(new Klasemen(nama_tim, 0, 0, 0, 0, 0));
							oosK = new ObjectOutputStream(new FileOutputStream(fileklasemen));
							oosK.writeObject(aKlasemen);
							oosK.close();
							
							aTim.add(new Tim(id_tim,nama_tim,alamat_tim,pelatih));
							oosT = new ObjectOutputStream(new FileOutputStream(filetim));
							oosT.writeObject(aTim);
							oosT.close();
							
							break;
						}
						//case 3 =================================================================================================== case 3
						case 3:{
							if(aTim.isEmpty()) {
								System.out.println("Tim tidak ada, tolong tambahkan tim terlebih dahulu!");
								break;
							}
							
							//display pemain
							System.out.println("Tabel Pemain");
							System.out.println("_________________________________________________________________________________________________");
						    System.out.println("|  ID  |\tNama\t\t|\tUmur\t|\tPosisi\t\t|\tTim\t\t|");
						    System.out.println("|-----------------------------------------------------------------------------------------------|");
		              		
							int z=0;
							while(z<aPemain.size()) {
								aPemain.get(z).view_pemain();
								z++;
							}
							System.out.println("|-----------------------------------------------------------------------------------------------|");
							//display tim dulu
							System.out.println("_________________________________________________________________________________");
						    System.out.println("| ID Tim |\tNama Tim\t|\tAlamat Tim\t|\tPelatih\t\t|");
						    System.out.println("|-------------------------------------------------------------------------------|");
		              		
							int i=0;
							while(i<aTim.size()) {
								aTim.get(i).view_tim();
								i++;
							}
							System.out.println("|-------------------------------------------------------------------------------|");
							
							
							String name = null;
							//cek
							boolean found = false;
							
							do {
								System.out.print("Pilih Tim yang ingin ditambah pemainnya[nomor ID Tim] : ");
								int noTim = read.nextInt();
								li = aTim.listIterator();
								while(li.hasNext()) {
									Tim e = (Tim)li.next();
									if(e.getId_tim() == noTim) {
										name = e.getNama_tim();
										System.out.println(e.getNama_tim());
										found = true;
									}
								}
								if(!found) {
									System.out.println("Tim tidak ditemukan...");
								}
							}while(found==false);
							
							pemain.setTimPemain(name);
							int jumlah;
							System.out.print("Mau menambah berapa pemain? : ");
							jumlah = read.nextInt();
							for(int k=0; k<jumlah; k++) {
								System.out.println("Pemain ke-"+(k+1)+"  :");
								int id_pemain;
								boolean found2 = false;
								do {
									int pos = 0;
									System.out.print("ID Pemain     : ");
									id_pemain = read.nextInt();
									
									//cek
									li = aPemain.listIterator();
									while(li.hasNext()) {
										Pemain e = (Pemain)li.next();
										if(e.getId_pemain() == id_pemain) {
											System.out.println("ID duplikat, mohon input kembali...");
											pos+=1;
										}
									}
									if(pos==0) {
										found2=true;
										break;
									}
								}while(found2==false);
								
								System.out.print("Nama Pemain   : ");read.nextLine();
								String nama_pemain = read.nextLine();
								System.out.print("Umur Pemain   : ");
								int umur_pemain = read.nextInt();
								System.out.print("Posisi Pemain : ");read.nextLine();
								String posisi_pemain = read.nextLine();
								aPemain.add(new Pemain(id_pemain,nama_pemain,umur_pemain,posisi_pemain,name));
							}
							oosP = new ObjectOutputStream(new FileOutputStream(filepemain));
							oosP.writeObject(aPemain);
							oosP.close();
							
							break;
						}
						//case 4 =================================================================================================== case 4
						case 4:{
							
							//display wasit
							System.out.println("___________________________________________________________________________________");
						    System.out.println("|  ID  |   Nama Wasit   | Umur |\tPosisi Wasit\t|\t\tPengalaman Wasit\t\t|");
						    System.out.println("|----------------------------------------------------------------------------------|");
							
							if(aWasit.isEmpty()) {
								System.out.println("no data");
							}else {
								int i=0;
								while(i<aWasit.size()) {
									aWasit.get(i).view_wasit();
									i++;
								}
							}
							System.out.println("|----------------------------------------------------------------------------------|");
							
							boolean found = false;
							int id_wasit;
							
							do {
								int pos = 0;
								System.out.print("ID Wasit     : ");
								id_wasit = read.nextInt();
								
								//cek
								li = aWasit.listIterator();
								while(li.hasNext()) {
									Wasit e = (Wasit)li.next();
									if(e.getId_wasit() == id_wasit) {
										System.out.println("ID duplikat, mohon input kembali...");
										pos+=1;
									}
								}
								if(pos==0) {
									found=true;
									break;
								}
							}while(found==false);
							
							
							System.out.print("Nama Wasit   : ");read.nextLine();
							String nama_wasit = read.nextLine();
							System.out.print("Umur Wasit   : ");
							int umur = read.nextInt();
							System.out.print("Posisi Wasit : ");read.nextLine();
							String posisi_wasit = read.nextLine();
							
							aWasit.add(new Wasit(id_wasit,nama_wasit,umur,posisi_wasit,null));
							oosW = new ObjectOutputStream(new FileOutputStream(fileWasit));
							oosW.writeObject(aWasit);
							oosW.close();
							
							break;
						}
						case 5:{
							
							flag2=1;
							System.out.println("Thankyou for using~");
							break;
						}
						case 6:{
//							flag2=1;
//							flag=0;
							System.exit(0);
							break;
						}
						default:{
							System.out.println("Menu yang anda pilih tidak ada.");
							break;
						}
					}
				}
			}
		}
		
	}
}
