package Phan1;

import java.io.File;
import java.io.IOException;

public class baitap_classFile {
	public static void main(String[] args) throws IOException {
		// bai 1.1
//		Yêu cầu: Viết chương trình kiểm tra xem thư mục C:\Windows có tồn tại hay không, nếu có thì in ra:
//			Đường dẫn tuyệt đối
//			Đó là file hay thư mục
//			Có thể đọc được không
		
		String path ="D:\\TEMP\\Child";
		File file = new File(path);
		
		if(file.exists()) {
			System.out.println(file.getAbsolutePath());
			if(file.isFile()) {
				System.out.println("Đây là file");
			}else {
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
		
		
		

		
 	}

}
