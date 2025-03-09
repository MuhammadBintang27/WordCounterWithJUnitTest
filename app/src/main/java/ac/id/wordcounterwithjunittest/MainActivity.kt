package ac.id.wordcounterwithjunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputText: EditText
    private lateinit var resultWords: TextView
    private lateinit var resultChars: TextView
    private lateinit var resultCharsNoSpaces: TextView
    private lateinit var resultSentences: TextView
    private lateinit var btnClear: Button
    private lateinit var btnAnalyze: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        inputText = findViewById(R.id.editTextInput)
        resultWords = findViewById(R.id.textViewWordCount)
        resultChars = findViewById(R.id.textViewCharCount)
        resultCharsNoSpaces = findViewById(R.id.textViewCharNoSpacesCount)
        resultSentences = findViewById(R.id.textViewSentenceCount)
        btnClear = findViewById(R.id.buttonClear)
        btnAnalyze = findViewById(R.id.buttonAnalyze)

        // Set click listeners
        btnAnalyze.setOnClickListener {
            analyzeText()
        }

        btnClear.setOnClickListener {
            inputText.text.clear()
            clearResults()
        }

        // Optional: real-time analysis with TextWatcher
        inputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                // Uncomment the line below if you want live updates
                // analyzeText()
            }
        })
    }

    private fun analyzeText() {
        val text = inputText.text.toString()

        val wordCount = TextAnalyzer.countWords(text)
        val charCount = TextAnalyzer.countCharacters(text)
        val charNoSpacesCount = TextAnalyzer.countCharactersWithoutSpaces(text)
        val sentenceCount = TextAnalyzer.countSentences(text)

        resultWords.text = "Words: $wordCount"
        resultChars.text = "Characters (with spaces): $charCount"
        resultCharsNoSpaces.text = "Characters (no spaces): $charNoSpacesCount"
        resultSentences.text = "Sentences: $sentenceCount"
    }

    private fun clearResults() {
        resultWords.text = "Words: 0"
        resultChars.text = "Characters (with spaces): 0"
        resultCharsNoSpaces.text = "Characters (no spaces): 0"
        resultSentences.text = "Sentences: 0"
    }
}