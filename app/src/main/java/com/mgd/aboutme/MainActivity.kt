package com.mgd.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.mgd.aboutme.classes.MyName
import com.mgd.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // lateinit var nicknameEditText: EditText
    // private lateinit var nicknameTextView: TextView

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Matías Doto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        // obtengo las referencias de las views -> no necesito hacer esto -> el uso del binding lo reemplaza
        // nicknameEditText = findViewById<EditText>(R.id.nickname_edit)
        // nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // agrego listener al click del boton
        // findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        binding.doneButton.setOnClickListener { addNickname(it) }

    }

    private fun addNickname(view: View) {
        // asigno el texto del edittext al textview
        // nicknameTextView.text = nicknameEditText.text

        //oculto boton, edittext
        view.visibility = View.GONE
        // nicknameEditText.visibility = View.GONE

        // muestro textview con el nickname
        // nicknameTextView.visibility = View.VISIBLE

        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            invalidateAll()
        }

        // oculto el teclado del celular
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}