
# Java-file-processing-project :indonesia:

File processing using java with OOP concept.




## Features
The goal is to have 2 actors which is admin and user. The main features in this project are:
- Create data and add it into file
- Update data
- Delete data
- Read data

## Usage/Examples

### File processing
For file processing itself, I used I/O stream in this project.

```javascript
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
```
Tim is one of the class, and I need to create each one of the
class who use file processing to be able to access data inside file.

### Constraints
There are a lot of details that need to be look out. For example
the constraint for duplicate ID.

```javascript
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
```
