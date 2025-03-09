package ac.id.wordcounterwithjunittest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /*
     * Test Case 1: Pengujian UI untuk analisis teks sederhana
     * Deskripsi: Test ini mengecek apakah UI aplikasi dapat menerima input teks dari
     * pengguna, melakukan analisis saat tombol Analyze ditekan, dan
     * menampilkan hasil yang benar untuk jumlah kata.
     * Input: EditText="Hello world this is a test"
     * Action: Klik tombol Analyze
     * Expected Output: TextView dengan teks "Words: 6"
     */
    @Test
    fun testWordCount() {
        // Input teks ke EditText
        onView(withId(R.id.editTextInput)).perform(
            typeText("Hello world this is a test"),
            closeSoftKeyboard()
        )

        // Klik tombol Analyze
        onView(withId(R.id.buttonAnalyze)).perform(click())

        // Verifikasi hasil jumlah kata
        onView(withId(R.id.textViewWordCount)).check(matches(withText("Words: 6")))
    }

    /*
     * Test Case 2: Pengujian UI untuk analisis jumlah karakter
     * Deskripsi: Test ini mengecek apakah UI aplikasi dapat menerima input teks dari
     * pengguna, melakukan analisis saat tombol Analyze ditekan, dan
     * menampilkan hasil yang benar untuk jumlah karakter (dengan dan tanpa spasi).
     * Input: EditText="Hello world"
     * Action: Klik tombol Analyze
     * Expected Output:
     *   - TextView dengan teks "Characters (with spaces): 11"
     *   - TextView dengan teks "Characters (no spaces): 10"
     */
    @Test
    fun testCharacterCount() {
        // Input teks ke EditText
        onView(withId(R.id.editTextInput)).perform(typeText("Hello world"), closeSoftKeyboard())

        // Klik tombol Analyze
        onView(withId(R.id.buttonAnalyze)).perform(click())

        // Verifikasi hasil jumlah karakter (dengan spasi)
        onView(withId(R.id.textViewCharCount))
            .check(matches(withText("Characters (with spaces): 11")))

        // Verifikasi hasil jumlah karakter (tanpa spasi)
        onView(withId(R.id.textViewCharNoSpacesCount))
            .check(matches(withText("Characters (no spaces): 10")))
    }

    /*
     * Test Case 3: Pengujian UI untuk tombol Clear
     * Deskripsi: Test ini mengecek apakah tombol Clear dapat mengosongkan input teks
     * dan mereset hasil analisis ke nilai 0.
     * Steps:
     * 1. Input teks ke EditText
     * 2. Klik tombol Analyze untuk menampilkan hasil
     * 3. Klik tombol Clear
     * 4. Verifikasi bahwa input teks kosong dan hasil analisis telah di-reset
     */
    @Test
    fun testClearButton() {
        // Input teks ke EditText dan analisis
        onView(withId(R.id.editTextInput)).perform(
            typeText("Test sentence"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.buttonAnalyze)).perform(click())

        // Klik tombol Clear
        onView(withId(R.id.buttonClear)).perform(click())

        // Verifikasi input teks kosong
        onView(withId(R.id.editTextInput)).check(matches(withText("")))

        // Verifikasi hasil telah di-reset
        onView(withId(R.id.textViewWordCount)).check(matches(withText("Words: 0")))
        onView(withId(R.id.textViewCharCount))
            .check(matches(withText("Characters (with spaces): 0")))
        onView(withId(R.id.textViewCharNoSpacesCount))
            .check(matches(withText("Characters (no spaces): 0")))
        onView(withId(R.id.textViewSentenceCount)).check(matches(withText("Sentences: 0")))
    }
}