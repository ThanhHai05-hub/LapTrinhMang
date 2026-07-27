# 📖 Chương 1: File Class - Nền Tảng Làm Việc Với File & Thư Mục

---

## 🎯 Mục tiêu chương này
- Hiểu **File class** là gì và tại sao cần nó
- Nắm vững các phương thức quan trọng của File class
- Biết cách tạo, xoá, đổi tên, kiểm tra file/thư mục bằng Java

---

## 1. Bản Chất File Class Là Gì?

### 🏠 Ví von đời thường

Hãy tưởng tượng bạn có một **tấm danh thiếp** ghi địa chỉ nhà ai đó:

```
📇 Danh thiếp:
   Địa chỉ: "123 Đường ABC, Quận 1, TP.HCM"
```

Tấm danh thiếp này **KHÔNG PHẢI** là ngôi nhà. Nó chỉ **chứa thông tin về đường đi đến ngôi nhà**. Bạn có thể:
- Đọc địa chỉ trên danh thiếp → Biết nhà ở đâu
- Kiểm tra xem nhà đó có tồn tại không → Đi đến đó xem thử
- Nhưng bạn **KHÔNG THỂ** ở trong tấm danh thiếp!

> [!IMPORTANT]
> **File class trong Java cũng giống hệt như vậy!**
> - `File` **KHÔNG PHẢI** là file thật trên ổ đĩa
> - `File` chỉ là một **đối tượng đại diện** (representation) cho đường dẫn đến file/thư mục
> - Nó giúp bạn **thao tác** với file/thư mục (tạo, xoá, kiểm tra...) nhưng **KHÔNG** đọc/ghi nội dung

### 📌 Định nghĩa chính thức

```
File class = Một lớp trong Java (java.io.File) đại diện cho đường dẫn 
             đến một file hoặc thư mục trên hệ thống.
```

**Nó làm được gì?**
- ✅ Tạo file/thư mục mới
- ✅ Xoá file/thư mục
- ✅ Đổi tên file/thư mục
- ✅ Kiểm tra file có tồn tại không
- ✅ Lấy thông tin (tên, kích thước, đường dẫn...)
- ✅ Liệt kê các file trong thư mục
- ❌ **KHÔNG** đọc nội dung file
- ❌ **KHÔNG** ghi nội dung vào file

> [!NOTE]
> Việc đọc/ghi nội dung file sẽ học ở **Chương 3** (InputStream/OutputStream) và **Chương 5** (Reader/Writer).

---

## 2. Cách Tạo Đối Tượng File

### 2.1 Import thư viện

```java
import java.io.File;  // Bắt buộc phải import
```

### 2.2 Ba cách tạo đối tượng File

```java
// ===== Cách 1: Truyền đường dẫn đầy đủ =====
File f1 = new File("C:\\Data\\test.txt");
// hoặc dùng dấu / (Java chấp nhận cả hai)
File f1b = new File("C:/Data/test.txt");

// ===== Cách 2: Tách thư mục cha và tên file =====
File f2 = new File("C:\\Data", "test.txt");
//                  ↑ thư mục cha   ↑ tên file

// ===== Cách 3: Dùng đối tượng File làm thư mục cha =====
File parentDir = new File("C:\\Data");
File f3 = new File(parentDir, "test.txt");
//                 ↑ File cha    ↑ tên file
```

> [!WARNING]
> **Tạo đối tượng `File` KHÔNG tạo file trên ổ đĩa!**
> ```java
> File f = new File("C:/Data/hello.txt"); 
> // Dòng này KHÔNG tạo file hello.txt trên ổ đĩa
> // Nó chỉ tạo một "tấm danh thiếp" trong bộ nhớ RAM
> ```

### 2.3 Dấu phân cách đường dẫn

| Hệ điều hành | Dấu phân cách | Ví dụ |
|--------------|----------------|-------|
| Windows | `\` (backslash) | `C:\Users\file.txt` |
| Linux/Mac | `/` (forward slash) | `/home/user/file.txt` |

Trong Java String, dấu `\` là ký tự đặc biệt (escape character), nên phải viết `\\`:

```java
// Windows - phải dùng \\ hoặc /
File f = new File("C:\\Users\\test.txt");  // ✅ Đúng
File f = new File("C:/Users/test.txt");    // ✅ Đúng (Java tự chuyển đổi)
File f = new File("C:\Users\test.txt");    // ❌ SAI! \U và \t là escape char

// Cách an toàn nhất - dùng File.separator
File f = new File("C:" + File.separator + "Users" + File.separator + "test.txt");
```

---

## 3. Các Phương Thức Quan Trọng Của File Class

### 3.1 Nhóm KIỂM TRA (kiểm tra thông tin)

```java
File f = new File("C:/Data/test.txt");

f.exists()        // → true/false : file/thư mục có tồn tại không?
f.isFile()        // → true/false : đây có phải là file không?
f.isDirectory()   // → true/false : đây có phải là thư mục không?
f.canRead()       // → true/false : có quyền đọc không?
f.canWrite()      // → true/false : có quyền ghi không?
f.isHidden()      // → true/false : có bị ẩn không?
```

**Ví dụ minh họa:**
```java
import java.io.File;

public class KiemTraFile {
    public static void main(String[] args) {
        File f = new File("C:/Windows");
        
        System.out.println("Tồn tại? " + f.exists());          // true
        System.out.println("Là file? " + f.isFile());           // false
        System.out.println("Là thư mục? " + f.isDirectory());   // true
        System.out.println("Đọc được? " + f.canRead());         // true
    }
}
```

### 3.2 Nhóm THÔNG TIN (lấy thông tin)

```java
File f = new File("C:/Data/test.txt");

f.getName()           // → "test.txt" : tên file/thư mục
f.getPath()           // → "C:\Data\test.txt" : đường dẫn (như bạn truyền vào)
f.getAbsolutePath()   // → "C:\Data\test.txt" : đường dẫn tuyệt đối
f.getParent()         // → "C:\Data" : thư mục cha
f.length()            // → 1024 (bytes) : kích thước file
f.lastModified()      // → 1627123456789 (milliseconds) : thời gian sửa cuối
```

**Ví dụ minh họa:**
```java
import java.io.File;

public class ThongTinFile {
    public static void main(String[] args) {
        File f = new File("C:/Windows/notepad.exe");
        
        if (f.exists()) {
            System.out.println("Tên: " + f.getName());           // notepad.exe
            System.out.println("Đường dẫn: " + f.getAbsolutePath());
            System.out.println("Thư mục cha: " + f.getParent()); // C:\Windows
            System.out.println("Kích thước: " + f.length() + " bytes");
        } else {
            System.out.println("File không tồn tại!");
        }
    }
}
```

### 3.3 Nhóm HÀNH ĐỘNG (tạo, xoá, đổi tên)

```java
File f = new File("C:/Data/test.txt");

// --- TẠO ---
f.createNewFile()     // Tạo file mới (trả về true nếu tạo thành công)
f.mkdir()             // Tạo 1 thư mục (thư mục cha phải tồn tại)
f.mkdirs()            // Tạo thư mục + tất cả thư mục cha nếu chưa có

// --- XOÁ ---
f.delete()            // Xoá file hoặc thư mục rỗng

// --- ĐỔI TÊN / DI CHUYỂN ---
File newF = new File("C:/Data/test2.txt");
f.renameTo(newF)      // Đổi tên hoặc di chuyển file
```

**Ví dụ: Tạo file mới:**
```java
import java.io.File;
import java.io.IOException;

public class TaoFile {
    public static void main(String[] args) {
        try {
            // Bước 1: Tạo thư mục (nếu chưa có)
            File dir = new File("C:/TestJava");
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                System.out.println("Tạo thư mục: " + (created ? "Thành công" : "Thất bại"));
            }
            
            // Bước 2: Tạo file trong thư mục
            File f = new File(dir, "hello.txt");
            if (f.createNewFile()) {
                System.out.println("Đã tạo file: " + f.getAbsolutePath());
            } else {
                System.out.println("File đã tồn tại rồi!");
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
```

> [!NOTE]
> **Tại sao phải dùng try-catch?**
> `createNewFile()` có thể gây ra lỗi (IOException) - ví dụ khi ổ đĩa đầy, không có quyền ghi, đường dẫn sai... Java bắt buộc bạn phải xử lý lỗi này.

### 3.4 Nhóm LIỆT KÊ (duyệt thư mục)

```java
File dir = new File("C:/Data");

dir.list()       // → String[] : mảng tên file/thư mục con
dir.listFiles()  // → File[]   : mảng đối tượng File con
```

**Ví dụ: Liệt kê tất cả file trong thư mục:**
```java
import java.io.File;

public class LietKeFile {
    public static void main(String[] args) {
        File dir = new File("C:/Windows");
        
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            
            if (children != null) {
                for (File child : children) {
                    String type = child.isDirectory() ? "[THƯ MỤC]" : "[FILE]";
                    System.out.println(type + " " + child.getName());
                }
                System.out.println("Tổng: " + children.length + " mục");
            }
        }
    }
}
```

---

## 4. Sơ Đồ Tổng Kết File Class

```
                    ┌─────────────────────────────────┐
                    │         java.io.File             │
                    │   (Đại diện cho đường dẫn)       │
                    └───────────────┬─────────────────┘
                                    │
            ┌───────────────────────┼───────────────────────┐
            │                       │                       │
     ┌──────▼──────┐        ┌──────▼──────┐         ┌──────▼──────┐
     │  KIỂM TRA   │        │  THÔNG TIN  │         │  HÀNH ĐỘNG  │
     ├─────────────┤        ├─────────────┤         ├─────────────┤
     │ exists()    │        │ getName()   │         │createNewFile│
     │ isFile()    │        │ getPath()   │         │ mkdir()     │
     │ isDirectory │        │ getParent() │         │ mkdirs()    │
     │ canRead()   │        │ length()    │         │ delete()    │
     │ canWrite()  │        │ lastModified│         │ renameTo()  │
     │ isHidden()  │        │ getAbsolute │         │ list()      │
     └─────────────┘        └─────────────┘         │ listFiles() │
                                                     └─────────────┘
```

---

## 5. Phân biệt Đường dẫn Tuyệt đối vs Tương đối

```java
// ĐƯỜNG DẪN TUYỆT ĐỐI (Absolute Path)
// → Bắt đầu từ gốc ổ đĩa, chỉ rõ vị trí chính xác
File f1 = new File("C:/Data/test.txt");        // Windows
File f2 = new File("/home/user/test.txt");     // Linux

// ĐƯỜNG DẪN TƯƠNG ĐỐI (Relative Path)  
// → Tính từ thư mục hiện tại của chương trình
File f3 = new File("test.txt");          // File ở cùng thư mục chạy chương trình
File f4 = new File("data/test.txt");     // File trong thư mục data/

// Kiểm tra thư mục hiện tại
System.out.println("Thư mục hiện tại: " + System.getProperty("user.dir"));
```

> [!TIP]
> **Khi nào dùng loại nào?**
> - **Tuyệt đối**: Khi bạn biết chính xác file ở đâu (VD: "C:/Windows/notepad.exe")
> - **Tương đối**: Khi file nằm trong project hoặc gần thư mục chạy chương trình. **Thường dùng hơn** vì code di chuyển được giữa các máy.

---

## 📝 Bài Tập Thực Hành

### Bài 1.1 ⭐ (Khởi động)
**Yêu cầu:** Viết chương trình kiểm tra xem thư mục `C:\Windows` có tồn tại hay không, nếu có thì in ra:
- Đường dẫn tuyệt đối
- Đó là file hay thư mục
- Có thể đọc được không

> **Gợi ý:** Dùng `exists()`, `getAbsolutePath()`, `isFile()`, `isDirectory()`, `canRead()`

### Bài 1.2 ⭐ (Tạo file & thư mục)
**Yêu cầu:** Viết chương trình:
1. Tạo thư mục `C:\TestJava\BaiTap` (kể cả khi `TestJava` chưa tồn tại)
2. Tạo file `sinhvien.txt` bên trong thư mục đó
3. In ra thông báo thành công kèm đường dẫn đầy đủ

> **Gợi ý:** Dùng `mkdirs()` và `createNewFile()`

### Bài 1.3 ⭐⭐ (Liệt kê)
**Yêu cầu:** Viết chương trình liệt kê tất cả file và thư mục trong `C:\Windows`. Với mỗi mục, in ra:
- Tên
- Loại (FILE hay THƯ MỤC)
- Kích thước (nếu là file, tính bằng KB)

> **Gợi ý:** Dùng `listFiles()`, `isFile()`, `isDirectory()`, `length() / 1024`

### Bài 1.4 ⭐⭐ (Đổi tên & Xoá)
**Yêu cầu:** Viết chương trình:
1. Tạo file `old_name.txt` trong thư mục `C:\TestJava`
2. Đổi tên thành `new_name.txt`
3. Kiểm tra xem file cũ còn tồn tại không, file mới có tồn tại không
4. Xoá file `new_name.txt`
5. Xoá thư mục `C:\TestJava\BaiTap` (nếu rỗng)

### Bài 1.5 ⭐⭐⭐ (Tổng hợp)
**Yêu cầu:** Viết chương trình nhận đường dẫn từ bàn phím (`Scanner`), sau đó:
- Nếu là file → In tên, kích thước, thời gian sửa cuối
- Nếu là thư mục → In tên, số file con, số thư mục con
- Nếu không tồn tại → In "Đường dẫn không tồn tại"

> **Gợi ý:** Dùng `Scanner`, `exists()`, `isFile()`, `isDirectory()`, `listFiles()`

---

> [!IMPORTANT]
> **Bắt đầu từ Bài 1.1 nhé!** Viết code vào file [Bai1.java](file:///c:/LapTrinhMang/Hoc_LTM/src/classFile/Bai1.java) rồi gửi cho mình review. Mình sẽ chấm và giải thích chi tiết trước khi chuyển sang bài tiếp theo! 💪
