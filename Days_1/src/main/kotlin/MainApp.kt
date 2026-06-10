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







}