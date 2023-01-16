package com.solusimediadata.asiq.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.solusimediadata.asiq.BuildConfig
import com.solusimediadata.asiq.MainActivity
import com.solusimediadata.asiq.R
import com.solusimediadata.asiq.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initView()
        initListener()
    }

    private fun initToolbar() {
        val activity = requireActivity() as MainActivity
        binding.toolbarLayout.toolbar.setupWithNavController(
            findNavController(),
            activity.appBarConfiguration
        )
    }

    private fun initView() {
        binding.lblVersion.text = getString(R.string.app_version, BuildConfig.VERSION_NAME)
    }

    private fun initListener() {
        binding.btnForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        binding.btnLogin.setOnClickListener {
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

        if (binding.txtUsername.text.toString().isBlank()) {
            binding.ilUsername.error = getString(R.string.error_empty_field)
            binding.txtUsername.requestFocus()
            return false
        }
        if (binding.txtPassword.text.toString().isBlank()) {
            binding.ilPassword.error = getString(R.string.error_empty_field)
            binding.txtPassword.requestFocus()
            return false
        }
        return true
    }

    private fun resetError() {
        binding.ilUsername.error = null
        binding.ilPassword.error = null
    }
}