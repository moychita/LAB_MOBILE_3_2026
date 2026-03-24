# Tugas Praktikum Pemrograman Mobile: Activity & Intent

Proyek ini adalah implementasi replika antarmuka profil Instagram yang dikembangkan menggunakan Java dan Android Studio. Fokus utama tugas ini adalah penerapan **Layouting**, **Explicit Intent**, dan **Activity Result API** untuk manajemen data antar halaman.

## 📋 Kebutuhan Tugas

Sesuai dengan instruksi praktikum, aplikasi ini memenuhi kriteria berikut:

1. Layouting Serupa: Implementasi desain yang mempertahankan struktur serta elemen utama profil Instagram (Header, Bio, Statistik, Highlights, dan Feed Grid)[^3][^7].

2. Aksi onClick: Menambahkan navigasi dari halaman profil ke halaman "Edit Profile"[^4].

3. Edit Data: Pengguna dapat mengubah nama, username, bio, jenis kelamin, hingga foto profil[^5].

4. Data Synchronization: Setiap perubahan data pada halaman Edit ditampilkan kembali secara akurat pada halaman profil utama[^6].

## 🛠️ Fitur & Implementasi Teknis

### 1. Navigasi & Komunikasi (Intent)

- **Activity Result API**: Menggunakan `ActivityResultLauncher` untuk menangani alur balik data (_callback_) dari `NextActivity` ke `MainActivity` secara modern dan efisien.
- **Reusable Editor**: Menggunakan `EditFieldActivity` sebagai komponen input tunggal yang dapat digunakan kembali untuk berbagai field teks (Nama, Username, Bio).

### 2. Manajemen Identitas Visual

- **Photo Picker**: Integrasi dengan `PickVisualMedia` untuk memilih foto profil secara dinamis dari galeri perangkat.
- **Resource vs URI Handling**: Logika programatis untuk beralih antara foto bawaan aplikasi (_Resource Drawable_) dan foto pilihan pengguna (_URI_).

### 3. Komponen Antarmuka (UI)

- **ShapeableImageView**: Digunakan untuk membuat foto profil dan highlight berbentuk lingkaran sesuai standar desain Instagram.
- **NestedScrollView & GridLayout**: Menyusun konten feed agar tetap responsif dan dapat di-scroll dengan lancar pada berbagai ukuran layar.
- **Edge-to-Edge**: Pengaturan padding sistem (Window Insets) agar UI mengisi area layar secara maksimal hingga ke bawah status bar.

## 📂 Struktur Proyek

- `MainActivity.java`: Halaman profil utama yang menampilkan data model `UserProfile`.
- `NextActivity.java`: Halaman menu edit profil untuk memilih field yang akan diubah atau mengganti foto.
- `EditFieldActivity.java`: Form input dinamis untuk mengubah data teks.
- `PostDetailActivity.java`: Tampilan detail saat salah satu item feed pada grid diklik.
- `UserProfile.java`: Kelas model untuk menyimpan state data pengguna.

## 🚀 Cara Menjalankan

1. Pastikan Android Studio telah terinstal.
2. Clone repository dan lakukan **Sync Gradle**.
3. Jalankan aplikasi di Emulator atau perangkat fisik (Min. API Level 24).
4. Klik tombol **Edit Profil** untuk menguji fungsionalitas perubahan data.

---

_Dibuat untuk memenuhi Tugas Praktikum Pemrograman Mobile - NIM H071241043_
