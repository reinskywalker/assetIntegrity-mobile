package com.solusimediadata.asiq.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.solusimediadata.asiq.MainActivity
import com.solusimediadata.asiq.R
import com.solusimediadata.asiq.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initListener()
    }

    private fun initToolbar() {
        val activity = requireActivity() as MainActivity
        binding.toolbarLayout.toolbar.setupWithNavController(
            findNavController(),
            activity.appBarConfiguration
        )
    }

    private fun initListener() {
        binding.btnBackToLogin.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnSend.setOnClickListener {
            if (validate()) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validate(): Boolean {
        resetError()

        if (binding.txtEmail.text.toString().isBlank()) {
            binding.ilEmail.error = getString(R.string.error_empty_field)
            binding.txtEmail.requestFocus()
            return false
        }
        return true
    }

    private fun resetError() {
        binding.ilEmail.error = null
    }
}