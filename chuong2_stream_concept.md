# 📖 Chương 2: Khái Niệm Stream & Phân Loại

---

## 🎯 Mục tiêu chương này
- Hiểu **Stream là gì** và tại sao Java cần Stream
- Phân biệt được **Byte Stream** vs **Character Stream**
- Phân biệt được **Input Stream** vs **Output Stream**
- Hiểu **hệ thống phân cấp** các lớp Stream trong Java
- Biết khi nào dùng loại Stream nào

---

## 1. Stream Là Gì?

### 🌊 Ví von đời thường

Hãy tưởng tượng bạn có **2 bể nước** nối với nhau bằng một **ống dẫn nước**:

```
┌─────────┐                          ┌─────────┐
│  Bể A   │ ═══════ ỐNG DẪN ═══════ │  Bể B   │
│ (Nguồn) │ ──────→ Nước chảy ────→  │ (Đích)  │
└─────────┘                          └─────────┘
```

- **Bể A (nguồn)**: nơi chứa nước ban đầu
- **Ống dẫn**: con đường nước đi qua
- **Bể B (đích)**: nơi nhận nước
- **Nước chảy liên tục** theo một chiều (từ A → B)

> [!IMPORTANT]
> **Stream trong Java cũng giống hệt ống dẫn nước!**
> - **Stream** = "dòng chảy dữ liệu" giữa chương trình Java và nguồn/đích bên ngoài
> - Dữ liệu chảy **liên tục, tuần tự** (byte này đến, rồi byte tiếp theo...)
> - Mỗi Stream chỉ đi **MỘT CHIỀU** (hoặc đọc VÀO, hoặc ghi RA)

### 📌 Định nghĩa chính thức

```
Stream = Một chuỗi dữ liệu (sequence of data) được truyền tuần tự 
         giữa chương trình Java và một nguồn/đích dữ liệu bên ngoài.
```

**Nguồn/đích bên ngoài có thể là:**
- 📄 File trên ổ đĩa
- 🌐 Kết nối mạng (Socket) — **Đây là lý do môn Lập Trình Mạng cần học Stream!**
- ⌨️ Bàn phím (System.in)
- 🖥️ Màn hình console (System.out)
- 💾 Bộ nhớ (ByteArrayStream)

---

## 2. Tại Sao Cần Stream?

### ❌ Không có Stream thì sao?

Hãy tưởng tượng bạn muốn gửi 1GB dữ liệu qua mạng mà **KHÔNG** có Stream:

```
Cách "tải hết vào RAM":
    1. Đọc TOÀN BỘ 1GB vào bộ nhớ RAM    → 💥 Tràn RAM!
    2. Gửi 1 cục 1GB qua mạng            → 💥 Timeout!
    3. Bên nhận phải chờ hết 1GB          → 💥 Chờ mãi!
```

### ✅ Có Stream thì sao?

```
Cách dùng Stream:
    1. Đọc 1 phần nhỏ (VD: 4KB)     → ✅ Tốn ít RAM
    2. Gửi phần đó qua mạng         → ✅ Nhanh
    3. Đọc tiếp phần tiếp theo       → ✅ Liên tục
    4. ... lặp lại cho đến hết       → ✅ Hoàn thành!
```

> [!TIP]
> **Stream giống như xem video YouTube:**
> - YouTube **KHÔNG** tải hết video rồi mới phát
> - Nó tải từng phần nhỏ (buffer) rồi phát ngay → bạn xem được ngay
> - Đó chính là tư tưởng của **Stream**: xử lý dữ liệu **từng phần**, không cần tải hết!

---

## 3. Hai Chiều Của Stream

Stream chỉ đi **MỘT CHIỀU**. Vì vậy có 2 loại:

### 3.1 Input Stream (Dòng vào) — ĐỌC dữ liệu

```
  ┌──────────────┐         ┌─────────────────┐
  │  Nguồn dữ liệu │ ───→  │  Chương trình    │
  │  (File, Mạng)   │  ĐỌC  │  Java của bạn    │
  └──────────────┘         └─────────────────┘
       
  Ví dụ: Đọc file text, nhận dữ liệu từ server
```

- **Input** = đầu vào = dữ liệu **đi VÀO** chương trình
- Chương trình **ĐỌC** (read) dữ liệu từ bên ngoài

### 3.2 Output Stream (Dòng ra) — GHI dữ liệu

```
  ┌─────────────────┐         ┌──────────────┐
  │  Chương trình    │ ───→   │  Đích dữ liệu  │
  │  Java của bạn    │  GHI   │  (File, Mạng)   │
  └─────────────────┘         └──────────────┘
       
  Ví dụ: Ghi file text, gửi dữ liệu đến client
```

- **Output** = đầu ra = dữ liệu **đi RA** khỏi chương trình
- Chương trình **GHI** (write) dữ liệu ra bên ngoài

> [!NOTE]
> **Mẹo nhớ dễ:** Luôn nhìn từ góc độ **chương trình Java**:
> - **InputStream**: Dữ liệu chảy **VÀO** chương trình → **ĐỌC**
> - **OutputStream**: Dữ liệu chảy **RA** khỏi chương trình → **GHI**

---

## 4. Hai Loại Dữ Liệu: Byte Stream vs Character Stream

### 4.1 Byte Stream — Xử lý dữ liệu dạng BYTE (nhị phân)

```
Đơn vị truyền: 1 byte = 8 bit (giá trị 0-255)

Dùng cho:
  📷 Hình ảnh (.jpg, .png)
  🎵 Âm thanh (.mp3)
  🎬 Video (.mp4)
  📦 File nén (.zip, .rar)
  💾 File .exe, .class
  📄 Bất kỳ file nào (kể cả text!)
```

**Các lớp gốc (abstract):**
- `InputStream` — Đọc byte
- `OutputStream` — Ghi byte

### 4.2 Character Stream — Xử lý dữ liệu dạng KÝ TỰ (văn bản)

```
Đơn vị truyền: 1 character = 2 bytes (Unicode/UTF-16)

Dùng cho:
  📝 File text (.txt)
  📋 File CSV, JSON, XML
  💻 File source code (.java, .html)
  📖 Mọi thứ là VĂN BẢN có thể đọc được
```

**Các lớp gốc (abstract):**
- `Reader` — Đọc ký tự
- `Writer` — Ghi ký tự

### 4.3 So sánh Byte Stream vs Character Stream

| Tiêu chí | Byte Stream | Character Stream |
|-----------|-------------|-----------------|
| **Đơn vị dữ liệu** | 1 byte (8 bit) | 1 char (16 bit / 2 byte) |
| **Lớp gốc** | `InputStream` / `OutputStream` | `Reader` / `Writer` |
| **Dùng cho** | Mọi loại file (nhị phân + text) | Chỉ file văn bản (text) |
| **Hỗ trợ Unicode** | ❌ Không tự động | ✅ Có (UTF-16) |
| **Ví dụ lớp con** | `FileInputStream`, `FileOutputStream` | `FileReader`, `FileWriter` |
| **Khi nào dùng?** | Ảnh, video, file nén, file nhị phân | File .txt, .csv, .json, source code |

> [!WARNING]
> **Sai lầm thường gặp:** Dùng Byte Stream để đọc file tiếng Việt → ký tự bị **lỗi font (mojibake)**!
> ```
> Ví dụ: "Xin chào" → "Xin chÃ o" (bị lỗi vì byte stream không hiểu Unicode)
> ```
> → Khi xử lý **văn bản**, LUÔN dùng **Character Stream** (Reader/Writer)!

---

## 5. Sơ Đồ Phân Cấp Stream Trong Java

```
                        ┌──────────────────────────────────────┐
                        │        JAVA I/O STREAM SYSTEM        │
                        └──────────────────┬───────────────────┘
                                           │
                    ┌──────────────────────┴──────────────────────┐
                    │                                              │
          ┌─────────▼──────────┐                        ┌─────────▼──────────┐
          │   BYTE STREAM      │                        │ CHARACTER STREAM   │
          │  (xử lý byte)      │                        │ (xử lý ký tự)     │
          └────────┬───────────┘                        └────────┬───────────┘
                   │                                              │
        ┌──────────┴──────────┐                       ┌──────────┴──────────┐
        │                     │                       │                     │
  ┌─────▼──────┐       ┌─────▼───────┐         ┌─────▼──────┐       ┌─────▼──────┐
  │InputStream │       │OutputStream │         │   Reader   │       │   Writer   │
  │  (đọc)     │       │  (ghi)      │         │   (đọc)    │       │   (ghi)    │
  └─────┬──────┘       └─────┬───────┘         └─────┬──────┘       └─────┬──────┘
        │                     │                       │                     │
        │ Các lớp con:        │ Các lớp con:          │ Các lớp con:        │ Các lớp con:
        ├─FileInputStream     ├─FileOutputStream      ├─FileReader          ├─FileWriter
        ├─BufferedInputStream ├─BufferedOutputStream   ├─BufferedReader      ├─BufferedWriter
        ├─DataInputStream     ├─DataOutputStream       ├─InputStreamReader   ├─OutputStreamWriter
        ├─ObjectInputStream   ├─ObjectOutputStream     ├─StringReader        ├─StringWriter
        └─ByteArrayInputStream└─ByteArrayOutputStream └─CharArrayReader     └─PrintWriter
```

> [!IMPORTANT]
> **4 lớp "ông tổ" cần nhớ:**
> | Đọc | Ghi | Loại |
> |-----|-----|------|
> | `InputStream` | `OutputStream` | Byte (nhị phân) |
> | `Reader` | `Writer` | Character (văn bản) |
> 
> Tất cả các lớp Stream khác đều **kế thừa** từ 4 lớp này!

---

## 6. Vòng Đời Của Stream (Rất Quan Trọng!)

Mỗi Stream đều phải trải qua **3 bước**:

```
  ┌──────────┐        ┌──────────┐        ┌──────────┐
  │  1. MỞ   │  ───→  │ 2. DÙNG  │  ───→  │  3. ĐÓNG │
  │  (Open)  │        │  (R/W)   │        │  (Close) │
  └──────────┘        └──────────┘        └──────────┘
```

### Bước 1: Mở (Open) — Tạo kết nối
```java
FileInputStream fis = new FileInputStream("data.txt");
// → Mở "ống dẫn" từ file đến chương trình
```

### Bước 2: Sử dụng (Read/Write) — Đọc hoặc Ghi
```java
int data = fis.read();  // Đọc 1 byte
// → Nước (dữ liệu) chảy qua ống
```

### Bước 3: Đóng (Close) — Giải phóng tài nguyên
```java
fis.close();
// → Tháo ống, trả tài nguyên lại cho hệ thống
```

> [!CAUTION]
> **LUÔN LUÔN phải đóng Stream sau khi dùng xong!**
> Nếu không đóng:
> - 🔒 File bị khóa (chương trình khác không truy cập được)
> - 💾 Dữ liệu chưa ghi có thể bị mất (còn trong buffer)
> - 🧠 Rò rỉ bộ nhớ (memory leak)
> - 💥 Chạy lâu → hết tài nguyên → chương trình crash!

### Cách đóng Stream an toàn

**Cách 1: try-catch-finally (Java 6 trở về trước)**
```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("data.txt");
    // sử dụng stream
    int data = fis.read();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    // finally LUÔN chạy, dù có lỗi hay không
    if (fis != null) {
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Cách 2: try-with-resources (Java 7+) — ĐỀ XUẤT DÙNG!**
```java
// Stream tự động đóng khi thoát khỏi block try
try (FileInputStream fis = new FileInputStream("data.txt")) {
    int data = fis.read();
    // Sử dụng stream bình thường
} catch (IOException e) {
    e.printStackTrace();
}
// → fis.close() được gọi TỰ ĐỘNG ở đây!
```

> [!TIP]
> **Luôn dùng `try-with-resources`!** Nó ngắn gọn, an toàn, và không bao giờ quên đóng stream.
> Cú pháp: `try (TạoStream ở đây) { ... }`

---

## 7. System.in và System.out — Stream Bạn Đã Dùng Mà Không Biết!

Bạn đã dùng Stream từ bài đầu tiên mà không nhận ra:

```java
// System.out là một OutputStream (PrintStream) → GHI ra màn hình
System.out.println("Hello World");

// System.in là một InputStream → ĐỌC từ bàn phím
Scanner sc = new Scanner(System.in);  // Scanner bọc quanh InputStream
String name = sc.nextLine();
```

```
Bàn phím ──[System.in]──→ Chương trình Java ──[System.out]──→ Màn hình

                InputStream                      OutputStream
                  (đọc)                             (ghi)
```

> [!NOTE]
> Khi học Lập Trình Mạng, bạn sẽ thay thế:
> - `System.in` → `socket.getInputStream()` (đọc dữ liệu từ mạng)
> - `System.out` → `socket.getOutputStream()` (gửi dữ liệu qua mạng)
> 
> **Cách dùng y hệt nhau!** Đó là sức mạnh của Stream.

---

## 8. Tổng Kết Chương 2

```
┌──────────────────────────────────────────────────────────────┐
│                    TÓM TẮT CHƯƠNG 2                          │
├──────────────────────────────────────────────────────────────┤
│                                                              │
│  Stream = Dòng chảy dữ liệu (một chiều, tuần tự)            │
│                                                              │
│  ┌─────────────┐    ┌────────────────┐                       │
│  │ Theo CHIỀU  │    │ Theo LOẠI DL   │                       │
│  ├─────────────┤    ├────────────────┤                       │
│  │ Input (đọc) │    │ Byte (nhị phân)│                       │
│  │ Output (ghi)│    │ Char (văn bản) │                       │
│  └─────────────┘    └────────────────┘                       │
│                                                              │
│  4 lớp gốc: InputStream, OutputStream, Reader, Writer       │
│                                                              │
│  Vòng đời: MỞ → DÙNG → ĐÓNG (luôn đóng!)                   │
│                                                              │
│  try-with-resources = cách đóng stream an toàn nhất          │
│                                                              │
└──────────────────────────────────────────────────────────────┘
```

---

## 📝 Bài Tập Thực Hành Chương 2

> [!NOTE]
> Chương 2 tập trung vào **khái niệm**, nên các bài tập sẽ thiên về **hiểu lý thuyết** kết hợp **thực hành nhẹ** để chuẩn bị cho Chương 3 (nơi sẽ code nhiều hơn).

---

### Bài 2.1 ⭐ (Hiểu Stream qua System.in/System.out)

**Yêu cầu:** Viết chương trình **KHÔNG dùng Scanner**, chỉ dùng `System.in.read()` để:

1. Đọc **1 ký tự** từ bàn phím
2. In ra mã ASCII (giá trị byte) của ký tự đó
3. In ra ký tự đó (ép kiểu `(char)`)

**Mục đích:** Hiểu rằng `System.in` là một `InputStream`, và `read()` đọc từng byte một.

**Ví dụ chạy:**
```
Nhập 1 ký tự: A
Mã ASCII: 65
Ký tự: A
```

> **Gợi ý:** 
> - `System.in.read()` trả về `int` (mã ASCII)
> - Ép kiểu `(char)` để chuyển thành ký tự
> - Phải xử lý `IOException` (dùng `throws IOException` hoặc try-catch)

---

### Bài 2.2 ⭐⭐ (Phân biệt Byte vs Character)

**Yêu cầu:** Viết chương trình dùng `System.in.read()` để:

1. Đọc **nhiều ký tự** từ bàn phím (đọc cho đến khi gặp Enter)
2. Đếm tổng số **byte** đã đọc được
3. In ra **từng byte** (giá trị số) và **ký tự tương ứng**

**Mục đích:** Hiểu tại sao ký tự tiếng Việt (Unicode) cần Character Stream.

**Ví dụ chạy với input "Hi":**
```
Nhập chuỗi: Hi
Byte 1: 72  → Ký tự: H
Byte 2: 105 → Ký tự: i
Byte 3: 13  → Ký tự: (CR - Enter)
Byte 4: 10  → Ký tự: (LF - Enter)
Tổng: 4 byte
```

> **Gợi ý:** 
> - Dùng vòng lặp `while` đọc từng byte
> - `read()` trả về `-1` khi hết dữ liệu, nhưng với bàn phím thì sẽ gặp `\r\n` (Enter = 13, 10 trên Windows)
> - Dừng khi gặp byte có giá trị `10` (ký tự xuống dòng `\n`)

---

### Bài 2.3 ⭐⭐ (try-with-resources cơ bản)

**Yêu cầu:** Viết chương trình thực hiện:

1. Dùng `FileOutputStream` để **ghi** chuỗi `"Hello Stream!"` vào file `D:\TEMP\stream_test.txt`
2. Dùng `FileInputStream` để **đọc lại** nội dung file đó
3. In nội dung đọc được ra màn hình
4. **Bắt buộc** dùng `try-with-resources` để quản lý stream

**Mục đích:** Thực hành vòng đời Stream (Mở → Dùng → Đóng) và cú pháp try-with-resources.

> **Gợi ý:**
> - `FileOutputStream`: dùng `write(byte[])` để ghi — chuyển String thành byte[] bằng `"Hello".getBytes()`
> - `FileInputStream`: dùng `read()` trong vòng lặp while để đọc từng byte cho đến khi `read()` trả về `-1`
> - Import: `java.io.FileInputStream`, `java.io.FileOutputStream`
> - Nhớ tạo thư mục `D:\TEMP` trước nếu chưa có (dùng `File.mkdirs()`)

**Kết quả mong đợi:**
```
Đã ghi vào file thành công!
Nội dung đọc được: Hello Stream!
```

---

### 🔬 Lab 2: Bộ Lọc Tìm Kiếm File Trên Ổ Đĩa (Tích hợp từ Lab trong kế hoạch)

> [!IMPORTANT]
> Bài Lab này kết hợp kiến thức **Chương 1 (File class)** + **Chương 2 (khái niệm Stream)** để củng cố trước khi sang Chương 3.

**Yêu cầu:** Viết chương trình **File Finder** — tìm kiếm file trong một thư mục (và các thư mục con) theo tiêu chí:

1. Nhận từ bàn phím:
   - Đường dẫn thư mục gốc để tìm (VD: `D:\TEMP`)
   - Phần mở rộng file cần tìm (VD: `.txt`, `.java`, `.jpg`)

2. Duyệt **đệ quy** toàn bộ thư mục gốc và tất cả thư mục con

3. Với mỗi file tìm được có phần mở rộng phù hợp, in ra:
   - Đường dẫn đầy đủ
   - Kích thước (KB)
   - Thời gian sửa cuối (format đọc được, dùng `java.text.SimpleDateFormat`)

4. Cuối cùng in ra:
   - Tổng số file tìm được
   - Tổng kích thước tất cả file (MB)

**Ví dụ chạy:**
```
Nhập thư mục gốc: D:\TEMP
Nhập phần mở rộng (VD: .txt): .txt

=== KẾT QUẢ TÌM KIẾM ===
1. D:\TEMP\hello_new\sinhvien.txt - 0 KB - 29/07/2026 10:30:00
2. D:\TEMP\notes\todo.txt - 2 KB - 28/07/2026 15:45:30
3. D:\TEMP\Child\data\log.txt - 15 KB - 27/07/2026 08:00:00

Tổng: 3 file | 17 KB (0.02 MB)
```

> **Gợi ý:**
> - Viết hàm `searchFiles(File folder, String extension)` dùng đệ quy
> - Dùng `file.getName().endsWith(extension)` để kiểm tra phần mở rộng
> - Dùng `new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")` và `new Date(file.lastModified())` để format thời gian
> - Import: `java.io.File`, `java.util.Scanner`, `java.text.SimpleDateFormat`, `java.util.Date`
> - Dùng mảng hoặc biến đếm để tính tổng

---

> [!IMPORTANT]
> **Bắt đầu làm từ Bài 2.1 nhé!** Tạo file code trong package `Phan1` (hoặc tạo package mới `Phan2` nếu muốn tổ chức gọn hơn). Làm xong gửi mình review, rồi tiếp bài 2.2 → 2.3 → Lab 2! 💪
>
> **Lưu ý:** Bài 2.3 sẽ là cầu nối chuyển sang Chương 3 (InputStream & OutputStream), nên hãy cố gắng hoàn thành hết trước khi sang chương mới!
