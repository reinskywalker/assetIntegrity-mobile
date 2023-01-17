package com.solusimediadata.asiq.ui.profile

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.solusimediadata.asiq.R
import com.solusimediadata.asiq.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        //todo profile header can be set as toolbar
        val iconColorOrange = ContextCompat.getColor(requireContext(), R.color.orange_500)
        val iconColorPurple = ContextCompat.getColor(requireContext(), R.color.purple_500)
        binding.btnProfile.apply {
            imgIcon.setColorFilter(iconColorOrange, PorterDuff.Mode.SRC_IN)
            imgIcon.setImageResource(R.drawable.ic_baseline_face_24)
            lblTitle.text = getString(R.string.profile)
            this.root.setOnClickListener {

            }
        }
        binding.btnChangePassword.apply {
            imgIcon.setColorFilter(iconColorOrange, PorterDuff.Mode.SRC_IN)
            imgIcon.setImageResource(R.drawable.ic_baseline_lock_24)
            lblTitle.text = getString(R.string.change_password)
            this.root.setOnClickListener {

            }
        }
        binding.btnContactUs.apply {
            imgIcon.setColorFilter(iconColorPurple, PorterDuff.Mode.SRC_IN)
            imgIcon.setImageResource(R.drawable.ic_baseline_support_agent_24)
            lblTitle.text = getString(R.string.contact_us)
            this.root.setOnClickListener {

            }
        }
        binding.btnTermAndService.apply {
            imgIcon.setColorFilter(iconColorPurple, PorterDuff.Mode.SRC_IN)
            imgIcon.setImageResource(R.drawable.ic_baseline_text_snippet_24)
            lblTitle.text = getString(R.string.term_of_service)
            this.root.setOnClickListener {

            }
        }
        binding.btnAbout.apply {
            imgIcon.setColorFilter(iconColorPurple, PorterDuff.Mode.SRC_IN)
            imgIcon.setImageResource(R.drawable.ic_baseline_info_24)
            lblTitle.text = getString(R.string.about)
            this.root.setOnClickListener {

            }
        }
    }
}