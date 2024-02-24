<h3>Refleksi Week-1</h3>
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
Menurut Bjarne Stroustrup, clean code seharusnya elegant dan efisien, sedangkan kode yang redundan tidak efisien. Sebaiknya, kode dibuat pada class yang sama tetapi didalam fungsi yang berbeda.<br>

<h3>Refleksi Week-2</h3>
1. Code quality check sonarcloud mendeteksi 2 masalah, yaitu penggunaan System.out.println() dan <i>assignment</i> variabel yang tidak diperlukan. Masalah pertama, saya lupa menghapus fungsi System.out.println() yang saya gunakan untuk melakukan *debug* pada tutorial sebelumnya. Kedua, terdapat fungsi yang melakukan <i>assignment</i> variabel yang sebenarnya tidak diperlukan. Saya memperbaiki code dengan menghapus fungsi System.out.println() yang sudah tidak digunakan dan menghapus <i>assignment</i> variabel yang tidak diperlukan.<br>
<br>
2. Ya, implementasi workflow saat ini sudah dapat melakukan <i>testing</i> dan <i>deployment</i> secara otomatis saat ada push atau pull request. Setiap perubahan yang di-push ke repository akan secara otomatis dijalankan <i>test</i>, sehingga sudah memenuhi <i>practice Continuous Integration</i> (CI). <i>Deployment</i> aplikasi juga dilakukan secara otomatis setelah proses <i>testing</i>, sehingga sudah memenuhi <i>practice Continuous Deployment</i> (CD).
<br>
<h3>Refleksi Week-3</h3>
1. - SRP: Setiap class hanya memiliki satu tanggung jawab. Contohnya, class Car hanya digunakan untuk mendefinisikan model. Implementasi CRUD dilakukan oleh repository, logika bisnis oleh service, dan request handling oleh controller.<br>
- OCP: Menurut saya, software entities pada proyek sudah memenuhi OCP. Fungsi CRUD tidak dapat diubah karena akan mengubah fungsionalitasnya. Namun, fungsi-fungsi tersbut dapat dikembangkan misalnya, membuat fungsi yang dapat menghapus lebih dari satu instance model sekaligus.<br>
- LSP: Untuk saat ini belum ada class yang menggunakan inheritance, sehingga LSP dapat dikatakan terpenuhi. Saya menghilangkan inheritance pada CarController dan Product Controller karena tidak diperlukan.<br>
- ISP: Saya mengubah interface CarService menjadi CarServiceCRUD untuk menyesuaikan dan memfokuskan fungsionalitasnya. Hal yang sama juga dilakukan pada interface ProductService agar memenuhi ISP.<br>
- DIP: CarServiceImpl memiliki abstraksi CarService, begitu juga dengan ProductServiceImpl memiliki abstraksi ProductService.<br>

2. Penerapan prinsip SOLID membuat proyek menjadi lebih maintainable. Contohnya, SRP dapat mempermudah proses testing dan debugging karena setiap class memiliki fungsionalitas yang spesifik.
3. Proyek akan lebih sulit untuk di-maintain jika tidak menerapkan prinsip SOLID. Misalnya, jika kita mengimplementasikan seluruh fungsionalitas program dalam satu class saja, struktur proyek akan menjadi tidak teroganisir dan lebih sulit untuk diperbaiki jika ada kesalahan.
