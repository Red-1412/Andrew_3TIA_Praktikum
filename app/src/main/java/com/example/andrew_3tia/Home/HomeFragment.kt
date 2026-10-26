package com.example.andrew_3tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andrew_3tia.Home.pertemuan5.LimaActivity
import com.example.andrew_3tia.Home.pertemuan6.EnamActivity
import com.example.andrew_3tia.Home.pertemuan9.NinthActivity
import com.example.andrew_3tia.LoginActivity
import com.example.andrew_3tia.R
import com.example.andrew_3tia.databinding.ActivityMainBinding
import com.example.andrew_3tia.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?= null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for requireContext() fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("Extra_User")
        val pass = requireActivity().intent.getStringExtra("Extra_Pass")

        binding.txtUsername.text ="user: $user"
        binding.txtPassword.text ="pass: $pass"

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Snackbar", Snackbar.LENGTH_LONG).setAction("waw") {
                // kembalikan item
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(requireContext(), "wkwkwkwkwkwk", Toast.LENGTH_LONG).show()
            }.show()
        }

        binding.btnalert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                }
                .setCancelable(false)
                .show()
        }

        binding.btntolima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }
        binding.btntoenam.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)
            startActivity(intent)
        }

        binding.btntoninth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        binding.btnlogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()

        }
    }
    }

