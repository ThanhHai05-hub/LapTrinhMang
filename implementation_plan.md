# 📚 Kế Hoạch Học I/O Streams - Lập Trình Mạng

## Mục tiêu
Xây dựng tài liệu học tập toàn diện về Java I/O Streams, từ cơ bản đến nâng cao, phù hợp chương trình Lập Trình Mạng - ĐH Nông Lâm. Mỗi phần đều có **lý thuyết dễ hiểu** + **bài tập thực hành từ nhỏ đến lớn**.

## Cấu trúc khóa học (7 Chương - 26 tiết)

### 📖 Lộ Trình Chi Tiết

| Chương | Nội dung | Bài tập | Lab tích hợp | Trạng thái |
|--------|----------|---------|--------------|------------|
| **Chương 1** | File Class - Nền tảng làm việc với file/thư mục | 5 bài | Lab 1 (thao tác file cơ bản) | ✅ **Hoàn thành** |
| **Chương 2** | Khái niệm Stream & Phân loại | 3 bài | Lab 2 (bộ lọc tìm kiếm file) | 🔜 **Đang học** |
| **Chương 3** | InputStream & OutputStream (byte stream) | 5 bài | Lab 3 (file nhị phân) | ⏳ Chờ |
| **Chương 4** | Filtered Stream (BufferedStream, DataStream) | 4 bài | — | ⏳ Chờ |
| **Chương 5** | Reader & Writer (character stream) | 5 bài | Lab 4 (file text & bảng mã) | ⏳ Chờ |
| **Chương 6** | InputStreamReader & OutputStreamWriter (cầu nối) | 3 bài | — | ⏳ Chờ |
| **Chương 7** | Object Stream (Serialization) | 4 bài | Lab 5 (truyền đối tượng), Lab 6 (quản lý SV) | ⏳ Chờ |

### 📁 Tài Liệu Đã Tạo

| File | Nội dung |
|------|----------|
| [chuong1_file_class.md](file:///c:/LapTrinhMang/Hoc_LTM/chuong1_file_class.md) | Lý thuyết + Bài tập Chương 1 |
| [chuong2_stream_concept.md](file:///c:/LapTrinhMang/Hoc_LTM/chuong2_stream_concept.md) | Lý thuyết + Bài tập + Lab 2 Chương 2 |

### 📁 Code Sinh Viên

| File | Chương |
|------|--------|
| [classFileBasic.java](file:///c:/LapTrinhMang/Hoc_LTM/src/Phan1/classFileBasic.java) | Chương 1 - Code mẫu |
| [baitap_classFile.java](file:///c:/LapTrinhMang/Hoc_LTM/src/Phan1/baitap_classFile.java) | Chương 1 - Bài tập ✅ |

## Phương pháp dạy

1. **Mỗi chương** → Giải thích bản chất bằng ví von đời thường → Code mẫu → Bài tập nhỏ → Lab tích hợp
2. **Bài tập** → Từ cực kỳ đơn giản → Tăng dần độ khó → Lab tổng hợp cuối chương
3. **Tương tác** → Sinh viên giải bài → Review code → Giải thích sai sót → Chuyển chương tiếp

## Cấu trúc thư mục

```
c:\LapTrinhMang\Hoc_LTM\
├── chuong1_file_class.md       ← Tài liệu Chương 1 ✅
├── chuong2_stream_concept.md   ← Tài liệu Chương 2 🔜
├── implementation_plan.md      ← Lộ trình tổng quan (file này)
└── src/
    └── Phan1/                  ← Code Chương 1 ✅
        ├── classFileBasic.java
        └── baitap_classFile.java
```
