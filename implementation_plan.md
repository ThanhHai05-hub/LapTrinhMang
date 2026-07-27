# 📚 Kế Hoạch Học I/O Streams - Lập Trình Mạng

## Mục tiêu
Xây dựng tài liệu học tập toàn diện về Java I/O Streams, từ cơ bản đến nâng cao, phù hợp chương trình Lập Trình Mạng - ĐH Nông Lâm. Mỗi phần đều có **lý thuyết dễ hiểu** + **bài tập thực hành từ nhỏ đến lớn**.

## Cấu trúc khóa học (7 Chương - 26 tiết)

### 📖 Phần Lý Thuyết (10 tiết)

| Chương | Nội dung | Số bài tập |
|--------|----------|------------|
| **Chương 1** | File Class - Nền tảng làm việc với file/thư mục | 5 bài |
| **Chương 2** | Khái niệm Stream & Phân loại | 3 bài |
| **Chương 3** | InputStream & OutputStream (byte stream) | 5 bài |
| **Chương 4** | Filtered Stream (BufferedStream, DataStream) | 4 bài |
| **Chương 5** | Reader & Writer (character stream) | 5 bài |
| **Chương 6** | InputStreamReader & OutputStreamWriter (cầu nối) | 3 bài |
| **Chương 7** | Object Stream (Serialization) | 4 bài |

### 🔧 Phần Thực Hành (16 tiết)

| Lab | Nội dung | Chương liên quan |
|-----|----------|-----------------|
| **Lab 1** | Thao tác file & thư mục (tạo, xoá, đổi tên, tìm kiếm) | Chương 1 |
| **Lab 2** | Xây dựng bộ lọc tìm kiếm file trên ổ đĩa | Chương 1 |
| **Lab 3** | Thao tác file nhị phân (đọc, ghi, chỉnh sửa) | Chương 3, 4 |
| **Lab 4** | Thao tác file text (đọc, ghi, chuyển đổi bảng mã) | Chương 5, 6 |
| **Lab 5** | Truyền đối tượng trên mạng | Chương 7 |
| **Lab 6** | Quản lý sinh viên với CSDL file nhị phân | Tổng hợp |

## Phương pháp dạy

1. **Mỗi chương** → Giải thích bản chất bằng ví von đời thường → Code mẫu → Bài tập nhỏ
2. **Bài tập** → Từ cực kỳ đơn giản → Tăng dần độ khó → Bài tập tổng hợp
3. **Tương tác** → Sinh viên giải bài → Review code → Giải thích sai sót

## Cấu trúc thư mục dự kiến

```
c:\LapTrinhMang\Hoc_LTM\src\
├── classFile/          ← Chương 1: File class
├── streamBasic/        ← Chương 2-3: Stream cơ bản
├── filteredStream/     ← Chương 4: Filtered Stream
├── readerWriter/       ← Chương 5-6: Reader/Writer
├── objectStream/       ← Chương 7: Object Stream
└── labs/               ← Các bài Lab tổng hợp
```

## Thứ tự thực hiện

Bắt đầu từ **Chương 1: File Class** → Đưa lý thuyết → Đưa bài tập 1.1 → Chờ sinh viên giải → Review → Tiếp bài 1.2...

> [!IMPORTANT]
> Bạn có muốn mình bắt đầu ngay từ **Chương 1: File Class** không? Mình sẽ giảng lý thuyết và đưa bài tập đầu tiên cho bạn giải luôn!
