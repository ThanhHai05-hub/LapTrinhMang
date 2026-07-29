package Phan1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class baitap_classFile {
	// viết làm lấy ra kích thước thư mục
	public static long getSizeFolder(File folder) {
		long size = 0;
		File[] files = folder.listFiles();
		if (files != null) {
			for (File child2 : files) {
				if (child2.isFile()) {
					size += child2.length();
				} else {
					size += getSizeFolder(child2);
				}
			}
		}
		return size;

	}

	// viết hàm xóa thư mục
	public static boolean deleteFolder(File folder) {
		File[] list = folder.listFiles();
		if (list != null) {
			for (File child : list) {
				if (child.isFile()) {
					child.delete();
				} else {
					deleteFolder(child);
					child.delete();
				}
			}
		}
		return true;

	}

	public static void main(String[] args) throws IOException {
//	File file9 = new File("D:\\TEMP\\F0-copy");
//	boolean dss = deleteFolder(file9);
//	System.out.println(dss);
		// bai 1.1
//		Yêu cầu: Viết chương trình kiểm tra xem thư mục D:\\TEMP\\Child có tồn tại hay không, nếu có thì in ra:
//			Đường dẫn tuyệt đối
//			Đó là file hay thư mục
//			Có thể đọc được không

		String path = "D:\\TEMP\\Child";
		File file = new File(path);

		if (file.exists()) {
			System.out.println(file.getAbsolutePath());
			if (file.isFile()) {
				System.out.println("Đây là file");
			} else {
				System.out.println("Đây là thư mục");
			}
			System.out.println("Có thể đọc: " + file.canRead());
		}

//		Bài 1.2 ⭐ (Tạo file & thư mục)
//		Yêu cầu: Viết chương trình:
//
//		Tạo thư mục D:\\TEMP\\hello_new (kể cả khi TEMP chưa tồn tại)
//		Tạo file sinhvien.txt bên trong thư mục đó
//		In ra thông báo thành công kèm đường dẫn đầy đủ

		String path1 = "D:\\TEMP\\hello_new";
		File file2  = new File(path1);
		file2.mkdirs();
		
		String path2 = "D:\\TEMP\\hello_new\\sinhvien.txt";
		File file3=  new File(path2);
		if(file3.createNewFile()) {
			System.out.println("Tạo file thành công " + file3.getAbsolutePath());
		}else {
			System.out.println("Tạo file thất bại ");
		}

//		Bài 1.3 (liệt kê) 
//		Yêu cầu: Viết chương trình liệt kê tất cả file và thư mục trong D:\\TEMP\\Child. Với mỗi mục, in ra:
//
//		Tên
//		Loại (FILE hay THƯ MỤC)
//		Kích thước (nếu là file, tính bằng KB)

		String path100 = "D:\\TEMP\\F0";
		File file1 = new File(path100);

		String s = "";
		File[] listFile1 = file1.listFiles();
		if (listFile1 != null) {
			for (File child1 : listFile1) {
				s += child1.getName() + " ";
				if (child1.isFile()) {
					s += "FILE" + " ";
					s += child1.length() / 1024 + "\n";

				} else {
					s += "THƯ MỤC ";
					long sizeFloder1 = getSizeFolder(child1) / 1024;
					s += sizeFloder1 + "\n";
				}
			}
		}
		System.out.println(s);

//		Bài 1.4 ⭐⭐ (Đổi tên & Xoá)
//		Yêu cầu: Viết chương trình:
//
//		Tạo file old_name.txt trong thư mục C:\TestJava
//		Đổi tên thành new_name.txt
//		Kiểm tra xem file cũ còn tồn tại không, file mới có tồn tại không
//		Xoá file new_name.txt
//		Xoá thư mục C:\TestJava\BaiTap (nếu rỗng)	( mình sẽ viết hàm xóa thư mục luôn nhé, viết bằng đệ quy) 	
//		 tạo thư mục trước
		String da = "D:\\TEMP\\TestJava";
		String da2 = "D:\\TEMP\\TestJava\\old_name.txt";
		String da3 = "D:\\TEMP\\TestJava\\new_name.txt";
		File foler4 = new File(da);
		foler4.mkdirs();
		
		File file4 = new File(da2);
		file4.createNewFile();
		
		File file5 = new File(da3);
		file4.renameTo(file5);
		
		System.out.println("File cũ còn tồn tại: " + file4.exists());
		System.out.println("File mới còn tồn tại: " + file5.exists());
		
		file5.delete();
		
//		Bài 1.5 ⭐⭐⭐ (Tổng hợp)
//		Yêu cầu: Viết chương trình nhận đường dẫn từ bàn phím (Scanner), sau đó:
//
//		Nếu là file → In tên, kích thước, thời gian sửa cuối
//		Nếu là thư mục → In tên, số file con, số thư mục con
//		Nếu không tồn tại → In "Đường dẫn không tồn tại"		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào bàn phím đường dẫn: ");
		String pathFile34 = sc.nextLine();
		File file103 = new File(pathFile34);
		if (!file103.exists()) {
			System.out.println("Đường dẫn không tồn tại");
		} else if (file103.isFile()) {
			System.out.println(file103.getAbsolutePath());
			System.out.println(file103.length());
			System.out.println(file103.lastModified());

		}else {
			int slgFile =0;
			int slgFolder =0;
			File [] listFile23 = file103.listFiles();
			for(File af:listFile23) {
				if(af.isFile()) {
					slgFile +=1;
				}else {
					slgFolder +=1;
				}
			}
			System.out.println("Số lượng file: " + slgFile);
			System.out.println("Số lượng thư mục: " + slgFolder);
		}

	}

}
