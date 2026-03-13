# LAB_MOBILE_3_2026

Repositori ini digunakan untuk mengumpulkan tugas Praktikum Pemrograman Mobile (Java/Android Native) Tahun 2026.

## 👥 Daftar Anggota

| NIM | Nama |
| :--- | :--- |
| H071211072 | DEWA RESCUE VIRGIAWANSYAH |
| H071241007 | AHMAD RIZKY AMIS |
| H071241016 | AQIILA ZAIZAAFUN KURNIAWAN |
| H071241025 | ZAHRA AULIA PUTRI |
| H071241034 | DEWI ASTUTI MUCHTAR |
| H071241043 | DIANI ANNISAH |
| H071241052 | ISNADIA NURFADILLAH |
| H071241063 | YUD BRYAWAN |
| H071241072 | ANDI FA'ATHIR EKA SAPUTRA A.A |
| H071241092 | NOVELIN FITRI PHANDIKA |
| H071241091 | MUHAMMAD FATHIR SYABHAN |

## 📂 Struktur Direktori

Setiap anggota wajib mengikuti struktur folder berikut untuk menjaga kerapian repositori:

```text
LAB_MOBILE_3_2026/
├── NIM_ANDA/
│   └── tugas-praktikum-1/
│       ├── app/
│       ├── build.gradle
│       └── ... (file project lainnya)
├── NIM_TEMAN_LAIN/
│   └── tugas-praktikum-1/
└── .gitignore

```

## ⚠️ Peringatan Penting (Harus Dibaca!)

Untuk menjaga ukuran repositori agar tetap ringan dan menghindari konflik, **DILARANG KERAS** melakukan *push* pada folder-folder hasil *generate* otomatis dari Android Studio seperti:

1. **`build/`** (sangat berat dan tidak diperlukan).
2. **`.gradle/`**
3. **`.idea/`**
4. **`*.iml`**
5. **`local.properties`** (berisi path SDK personal).

### Cara Menghindari:

Pastikan di dalam *root* repositori ini sudah terdapat file `.gitignore`. Jika belum, segera tambahkan sebelum melakukan `git commit`. Semua folder yang disebutkan di atas secara otomatis akan diabaikan oleh Git.

---

*Gunakan branch masing-masing sebelum melakukan merge ke branch utama (main/master) jika diperlukan.*

```

### Tips Tambahan untuk Kamu:
Agar teman-temanmu tidak lupa, kamu bisa membuat satu file bernama `.gitignore` di folder utama repositori. Kamu bisa mengambil template `.gitignore` standar untuk Android [di sini](https://github.com/github/gitignore/blob/main/Android.gitignore). Dengan adanya file itu, meskipun mereka mencoba *push* folder `build`, Git akan otomatis menolaknya.