package ac.id.wordcounterwithjunittest

class TextAnalyzer {
    companion object {
        /**
         * Menghitung jumlah kata dalam teks
         * @param text Teks yang akan dihitung katanya
         * @return Jumlah kata dalam teks
         */
        fun countWords(text: String): Int {
            if (text.trim().isEmpty()) {
                return 0
            }
            return text.trim().split("\\s+".toRegex()).size
        }

        /**
         * Menghitung jumlah karakter dalam teks (termasuk spasi)
         * @param text Teks yang akan dihitung karakternya
         * @return Jumlah karakter dalam teks
         */
        fun countCharacters(text: String): Int {
            return text.length
        }

        /**
         * Menghitung jumlah karakter dalam teks (tidak termasuk spasi)
         * @param text Teks yang akan dihitung karakternya
         * @return Jumlah karakter dalam teks tanpa spasi
         */
        fun countCharactersWithoutSpaces(text: String): Int {
            return text.replace(" ", "").length
        }

        /**
         * Menghitung jumlah kalimat dalam teks
         * @param text Teks yang akan dihitung kalimatnya
         * @return Jumlah kalimat dalam teks
         */
        fun countSentences(text: String): Int {
            if (text.trim().isEmpty()) {
                return 0
            }

            // Menghitung kalimat berdasarkan tanda titik, tanda seru, dan tanda tanya
            val sentences = text.split("[.!?]".toRegex()).filter { it.trim().isNotEmpty() }
            return sentences.size
        }
    }
}