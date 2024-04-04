package com.example.myhistoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var ageInput: EditText
    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialise
        ageInput = findViewById(R.id.ageInput)
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        resultTextView = findViewById(R.id.resultTextView)

        searchButton.setOnClickListener {
            generateHistory()
        }

        clearButton.setOnClickListener {
            clearInput()
        }
    }

    private fun generateHistory() {
        val ageText = ageInput.text.toString()
        if (ageText.isEmpty()) {
            resultTextView.text = "Please enter an age."
            return
        }

        val age = ageText.toIntOrNull()
        if (age == null) {
            resultTextView.text = "Invalid age format. Please enter a valid integer."
            return
        }

        if (age !in 20..100) {
            resultTextView.text = "Age must be between 20 and 100."
            return
        }

        val historicalFigure = when (age) {
            95 -> "Nelson Mandela: Nelson Mandela was a South African anti-apartheid revolutionary and political leader. He served as the president of South Africa from 1994 to 1999. He also spent 27 years in prison for his activism against apartheid before emerging as a global symbol of resistance"
            78 -> "Mahatma Gandhi: Mahatma Gandhi was born on October 2 on 1869 in India. He was a prominent leader in South Africa for the Indian independence movement against British colonial rule. Despite facing imprisonment and persecution, Gandhi remained steadfast in his pursuit of justice and worked tirelessly for the upliftment of the oppressed"
            44 -> "Pablo Escobar: Pablo Escobar was a notorious Colombian drug lord who ran one of the largest and most powerful drug-trafficking organizations in the world during the 1980s and early 1990s. Despite his death, Pablo Escobar's legacy continues to fascinate and serve as a cautionary tale about the destructive impact of organized crime"
            60 -> "Diego Maradona was an Argentine soccer player and one of the greatest athletes in the history of the sport. He was born on October 30, 1960 in Argentina. He is best known for leading Argentina to victory in the 1986 FIFA World Cup, where he scored the famous \"Hand of God\" goal and the \"Goal of the Century\" against England in the quarterfinals."
            34 -> "Ayrton Senna: Ayrton Senna, a Brazilian Formula One icon known for his unparalleled speed and fearless driving style, won three World Championships. Beyond racing, he was acclaimed for his philanthropic work in Brazil. Tragically, his life was cut short in a crash during the 1994 San Marino Grand Prix. Nevertheless, Senna's legacy endures as an inspiration to athletes and humanitarians globally."
            54 -> "Osama bin Laden: Osama bin Laden, founder of al-Qaeda, orchestrated numerous deadly attacks, including 9-11. He evaded capture for years until U.S. Navy SEALs killed him in Pakistan in 2011, a significant milestone in the fight against terrorism. His actions continue to shape global security strategies."
            40 -> "Paul Walker: Paul Walker, the American actor famous for his role in the \"Fast & Furious\" series, was born on September 12, 1973. Tragically, he died in a car accident on November 30, 2013, at age 40, leaving behind a legacy as a talented actor and philanthropist."
            96 -> "Elizabeth II: Queen Elizabeth II, born in 1926, has reigned as the monarch of the United Kingdom since 1952, making her the longest-reigning current monarch and a globally respected figure"
            56 -> "Abraham Lincoln:Abraham Lincoln, the 16th President of the United States, guided the nation through the Civil War and issued the Emancipation Proclamation to end slavery. His leadership and commitment to justice have left a lasting legacy in American history"
            24 -> "Lee Harvey Oswald: Lee Harvey Oswald, a former U.S. Marine, was accused of assassinating President John F. Kennedy in 1963. He was shot and killed by Jack Ruby before standing trial, leaving the motive for the assassination still debate"
            else -> null
        }

        val message = if (historicalFigure != null) "The historical figure is $historicalFigure."
        else "No historical figure found with the entered age."
        resultTextView.text = message
    }

    private fun clearInput() {
        ageInput.text.clear()
        resultTextView.text = ""
    }
}