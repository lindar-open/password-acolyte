package lindar.acolyte.password


class PasswordAcolyte {

    companion object {
        private val mostUsedPasswords = hashSetOf<String>()

        @JvmStatic
        fun loadPasswordsInMemory() {
            val bufferedReader = PasswordAcolyte.javaClass.getResourceAsStream("/top_100000.txt").bufferedReader()
            bufferedReader.useLines { lines -> lines.forEach { mostUsedPasswords.add(it) } }
        }

        @JvmStatic
        fun isWeak(password: String): Boolean {
            return mostUsedPasswords.contains(password)
        }
    }
}