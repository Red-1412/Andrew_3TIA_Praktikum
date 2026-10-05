package com.example.andrew_3tia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andrew_3tia.databinding.ActivityLoginBinding
import com.example.andrew_3tia.databinding.ActivityMainBinding
import com.example.andrew_3tia.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user = intent.getStringExtra("Extra_User")
        val pass = intent.getStringExtra("Extra_Pass")

        binding.txtUsername.text ="user: $user"
        binding.txtPassword.text ="pass: $pass"

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Snackbar", Snackbar.LENGTH_LONG).setAction("waw") {
                // kembalikan item
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "wkwkwkwkwkwk", Toast.LENGTH_LONG).show()
            }.show()
        }

        binding.btnalert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                .setCancelable(false)
                .show()
        }

        binding.btntolima.setOnClickListener {
            val intent = Intent(this, LimaActivity::class.java)
            startActivity(intent)
                }
        }


    }
