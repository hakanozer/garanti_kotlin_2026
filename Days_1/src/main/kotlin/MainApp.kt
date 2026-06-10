// Tek satırlı açıklama satıdır
/*
* çok satırlı açıklama satırı
* */

// main fonksiyonu
fun main() {

    // değişkenler ve veri tipleri
    // var, val
    // var -> değişken daha sonradan değişim yapılabilir.
    // val -> değişken daha sonradan değişimez.
    var name = "Ali"
    name = "Veli"
    println(name)

    val surname = "Kaya"
    println(surname)

    // Değişken türleri
    // String, Int, Double, Char, Boolean

    // String -> metinleri tutar
    val userName = "Erkan"
    val userSurname = "Kaya"
    val joined = "$userSurname $userName"
    println(joined)

    // Int -> Tam sayılar
    val age = 25
    val ageSum = age + 10
    println(ageSum)


    // Double -> Ondalıklı sayılar
    val pi = 3.14
    val radius = 5.0
    val area = pi * radius * radius
    println(area)

    // Char -> Karakterler
    val firstChar = 'A'
    println(firstChar)

    // Boolean -> True, False değerleri
    val isMarried = true
    println(isMarried)

    println("----------------------------------")
    // Tip Çıkarımı
    println(userSurname::class.simpleName)
    println(age::class.simpleName)
    println(area::class.simpleName)
    println(isMarried::class.simpleName)

    println("----------------------------------")
    // String Template
    val nameT = "Zeynep"
    val ageT = 28

    // Basit değişken yazdırma
    println("Merhaba $nameT")

    // işlem yaparak print
    println("Doğum Yılı: ${2026 - ageT}")
    println("Karakter Sayınız: ${nameT.count()}")

    // çok satırlı string template
    val report = """
        Ad: $nameT
        Yaş: $ageT
        Doğum Yılı: ${2026 - ageT}
        Durum: Aktif
    """.trimIndent()
    println(report)

    println("----------------------------------")
    // Non-Nullable
    var address = "İstanbul"
    println("$address - ${address.count()}")

    // Nullable
    var address2: String? = null
    // !! -> eminim burası null değil
    // println(address2!!.count())
    println(address2?.count())
    address2 = "Ankara"


    // null kontrol
    address2?.let {
        println("$address2 - ${address2.count()}")
    }

    println("----------------------------------")
    // Karşılaştırma Operatörleri
    val x = 5
    val y = 10
    println(x == y) // Eşit mi?
    println(x != y) // Eşit değil mi?
    println(x > y)  // Büyük mü?
    println(x < y)  // Küçük mü?
    println(x >= y) // Büyük veya eşit mi?
    println(x <= y) // Küçük veya eşit mi?

    println("----------------------------------")
    // Mantıksal Operatörler
    var status = false
    // && -> ve, iki veya birden fazla şartın sağlanması gerektiğinde kullanılır
    // || -> veya, iki veya birden fazla şarttan bir tanesinin geçerli olması durumunda kullanılır.
    // &&
    status = x > 4 && y > 9
    println(status)

    // ||
    status = x > 10 || y < 9
    println(status)

    println("----------------------------------")
    // Karar kontrol yapılar
    // if - else
    val scrore = 90
    if (scrore >= 55 ) {
        println("Geçtiniz")
    }else {
        println("Kaldınız")
    }

    println("----------------------------------")
    // else - if kullanımı
    if (scrore >= 90) {
        println("Pekiyi")
    } else if (scrore >= 75) {
        println("İyi")
    } else if (scrore >= 55) {
        println("Orta")
    } else {
        println("Kaldınız!!")
    }

    println("----------------------------------")
    // else - if - expression
    val sonuc = if (scrore >= 90) "Pekiyi"
                else if (scrore >= 75) "İyi"
                else if (scrore >= 55) "Orta"
                else "Kaldınız!!"
    println(sonuc)




}