package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.security.AccessControlContext

const val EXTRA_ANSER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE =
    "com.bignerdranch.android.geoquiz.answer_is_true"
private var answerIsTrue = false
private const val EXTRA_SCORE_IS_ZERO = "com.bignerdranch.android.geoquiz."
private var scoreIsZero = 0

class CheatActivity : AppCompatActivity() {
    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button
    private lateinit var scoreTextView: TextView
    private lateinit var showScoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)
        showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            setAnswerShownResult(true)
        }

        scoreIsZero = intent.getIntExtra(EXTRA_SCORE_IS_ZERO, 0)
        showScoreButton = findViewById(R.id.show_button_score)
        scoreTextView = findViewById(R.id.show_total_score)
        showScoreButton.setOnClickListener {
            var correctScore = 0
            val scoreText = {
                if (answerIsTrue) {
                    scoreIsZero = correctScore++
                } else scoreIsZero = correctScore
            }
            scoreTextView.setText(scoreIsZero)
            setScoreShownResult(true)
        }
    }

    private fun  setAnswerShownResult(isAnswerShown: Boolean){
        val data = Intent().apply {
            putExtra(EXTRA_ANSER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    private fun setScoreShownResult(isScoreShown: Boolean){
        val score = Intent().apply {
            putExtra(EXTRA_SCORE_IS_ZERO, isScoreShown)
        }
        setResult(Activity.RESULT_OK, score)
    }

    companion object{
        fun newIntent(packageContext: Context, answerIsTrue: Boolean, scoreIsZero: Int): Intent{
            return Intent(packageContext, CheatActivity::class.java).apply{
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
                putExtra(EXTRA_SCORE_IS_ZERO, scoreIsZero)
            }
        }
    }
}
