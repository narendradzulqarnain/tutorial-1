Refleksi 1<br>
Setelah belajar dari pemaparan materi di kelas, saya mulai mencoba mengimplementasikan clean code dalam program saya, termasuk tutorial.
Saya menggunakan nama yang jelas untuk penamaan variabel dan fungsi saya. Selain itu, implementasi fitur dibuat menggunakan fungsi-fungsi yang
kecil. Sebagai contoh, fungsi findProductbyId digunakan untuk mencari product berdasarkan idnya. Nama fungsi sesuai dengan kegunaannya. Variabel yang digunakan
juga jelas dan tidak ambigu. Kekurangan dari code saya mungkin ada pada comment. Code masih dapat ditambahkan sedikit comment untuk memperjelas fungsinya.

Refleksi 2<br>
1. Setelah mengimplementasikan unit test, saya merasa lebih yakin dengan fitur-fitur dan program yang saya buat. Dengan adanya fitur testing, saya juga bisa menguji 
program yang saya buat secara otomatis apabila terdapat perubahan pada code. Untuk memastikan unit test yang kita buat cukup, sebaiknya test dibuat dengan banyak kasus-kasus 
yang dapat terjadi pada program. Sebagai contoh, untuk function findProductbyId kita perlu men-cover kasus jika tidak terdapat product pada productData atau product tidak ada dalam productData.
Meskipun kita sudah menguji seluruh fitur pada product, error tetap saja bisa terjadi jika ada <i>edge cases</i> yang tidak diuji.<br>

2. Menurut saya, kita tidak perlu membuat class baru untuk test tersebut. Membuat class baru dengan setup dan inisialisasi yang sama akan menciptakan redundansi pada kode.
Menurut Bjarne Stroustrup, clean code seharusnya elegant dan efisien, sedangkan kode yang redundan tidak efisien. Sebaiknya, kode dibuat pada class yang sama tetapi didalam fungsi yang berbeda.
