package Phan1;

import java.io.File;
import java.io.IOException;

public class classFileBasic {
	public static void main(String[] args) throws IOException {
		String fileName = "D:\\TEMP\\file1.txt";
		File f1 = new File(fileName);
		// chỗ này chỉ tạo đối tượng file, không tạo file thật trên ổ đĩa ( đang là
		// đường dẫn hoiii)
		f1.createNewFile(); // tạo file

		// file có tồn tại không
		System.out.println("File tồn tại ? " + f1.exists());
		// kiểm tra có phải là file không
		System.out.println("File ? " + f1.isFile());
		// kiểm tra có phải là thư mục không
		System.out.println("Folder ? " + f1.isDirectory());
		// kiểm tra có quyền đọc không
		System.out.println("Can read? " + f1.canRead());
		// kiểm tra có quyền ghi không
		System.out.println("Can write? " + f1.canWrite());
		// kiểm tra xem có bị ẩn khôgn
		System.out.println("Hidden? " + f1.isHidden());

		// NHÓM LẤY THÔNG TIN
		// kiểm tra kích thước ( tính theo byte)
		System.out.println("Size? " + f1.length());
		// lấy tên file
		System.out.println("Name: " + f1.getName());
		// lấy đường dẫn tuyệt đối
		System.out.println(f1.getAbsolutePath());
		// lấy thư mục cha
		System.out.println(f1.getParent());
		// lấy thời gian sửa cuối cùng
		System.out.println(f1.lastModified());

		// TẠO XÓA ĐỔI TÊN
		String fileName2 = "D:\\TEMP\\foler_test";
		// tạo folder
		File f2 = new File(fileName2); // tạo file
		f2.mkdirs(); // tạo folder

		// xóa file hoặc thư mục rỗng
		// f2.delete();

		// đổi tên hoặc di chuyển
		String fileName3 = "D:\\TEMP\\foler_test_new";
		File f3 = new File(fileName3);

		System.out.println(f2.renameTo(f3));

		// NHÓM LIỆT KÊ
		String name1 = "D:\\TEMP\\Child";
		File dir = new File(name1);

		// dir.list(); là mảng String chứa tên của các file và thư mục
		File[] listFile = dir.listFiles(); // là mảng chứa các đối tượng file con

		// duyệt và in ra danh sách tên của thư mục và file có trong D:\\Child

		// đã có mảng file chứa các thưu mục và file có trong D:\\Child
		// Viết chương trình lấy ra toàn bộ tên file và tên thư mục trong D:\\Child
		// nếu là file thì in ra File + tên file, thư mục thì in ra Thư mục + tên thư
		// mục
		System.out.println("Hải");
		if (listFile != null) {
			for (File child : listFile) {
				String s = "";
				if (child.isFile()) {
					s += "File " + child.getName();
				} else {
					s += "Folder " + child.getName();
				}
				System.out.println(s);
			}

		}

	}

}
