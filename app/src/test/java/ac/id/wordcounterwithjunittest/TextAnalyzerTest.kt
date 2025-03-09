package ac.id.wordcounterwithjunittest
import org.junit.Test
import org.junit.Assert.*

class TextAnalyzerTest {

    /*
     * Test Case 1: Pengujian fungsi countWords
     * Deskripsi: Test ini mengecek apakah fungsi countWords dari kelas TextAnalyzer
     * dapat menghitung jumlah kata dengan benar dalam kalimat sederhana.
     * Input: "Hello world this is a test"
     * Expected Output: 6 (jumlah kata)
     */
    @Test
    fun countWords_simpleText_returnsCorrectCount() {
        val text = "Hello world this is a test"
        assertEquals(6, TextAnalyzer.countWords(text))
    }

    /*
     * Test Case 2: Pengujian fungsi countWords dengan teks kosong
     * Deskripsi: Test ini mengecek apakah fungsi countWords dari kelas TextAnalyzer
     * mengembalikan nilai 0 ketika diberi input teks kosong.
     * Input: ""
     * Expected Output: 0 (tidak ada kata)
     */
    @Test
    fun countWords_emptyText_returnsZero() {
        val text = ""
        assertEquals(0, TextAnalyzer.countWords(text))
    }

    /*
     * Test Case 3: Pengujian fungsi countCharactersWithoutSpaces
     * Deskripsi: Test ini mengecek apakah fungsi countCharactersWithoutSpaces
     * dapat menghitung jumlah karakter (tidak termasuk spasi) dengan benar.
     * Input: "Hello world"
     * Expected Output: 10 (jumlah karakter tanpa spasi)
     */
    @Test
    fun countCharactersWithoutSpaces_simpleText_returnsCorrectCount() {
        val text = "Hello world"
        assertEquals(10, TextAnalyzer.countCharactersWithoutSpaces(text))
    }

    /*
     * Test Case 4: Pengujian fungsi countSentences
     * Deskripsi: Test ini mengecek apakah fungsi countSentences
     * dapat menghitung jumlah kalimat dengan benar berdasarkan tanda
     * titik, tanda seru, dan tanda tanya.
     * Input: "Hello world. This is a test! How are you? I'm fine."
     * Expected Output: 4 (jumlah kalimat)
     */
    @Test
    fun countSentences_multipleTerminators_returnsCorrectCount() {
        val text = "Hello world. This is a test! How are you? I'm fine."
        assertEquals(4, TextAnalyzer.countSentences(text))
    }
}