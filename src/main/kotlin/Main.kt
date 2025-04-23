fun main() {
    println("Hello, this is a vulnerable Kotlin app.")

    // 🚨 Faux secret (clé API exposée)
    val apiKey = "AKIAFAKESECRET1234567890"
    println("Using API key: $apiKey")
}
