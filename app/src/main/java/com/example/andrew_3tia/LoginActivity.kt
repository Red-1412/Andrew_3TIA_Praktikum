package com.example.andrew_3tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andrew_3tia.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
//
//        val isLogin = sharedPref.getBoolean("isLogin", false)
//        if (isLogin) {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//            return
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val tombol_login : Button = findViewById(R.id.btn_login)
//        val username : EditText = findViewById(R.id.edt_text)
//        val Password : EditText = findViewById(R.id.edt_pass2)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtText.text.toString()
            val pass = binding.edtPass2.text.toString()

            if (user.isNotEmpty() && user == pass) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", user)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Extra_User",user)
                intent.putExtra("Extra_Pass",pass)
                startActivity(intent)
                finish()

            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            }


        }
    }
}