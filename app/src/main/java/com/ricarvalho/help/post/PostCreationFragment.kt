package com.ricarvalho.help.post

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.ricarvalho.help.common.ViewBindingFragment
import com.ricarvalho.help.databinding.FragmentPostCreationBinding as Binding

class PostCreationFragment : ViewBindingFragment<Binding>(Binding::class.java) {
    override fun Binding.onCreated(savedInstanceState: Bundle?) {
        toolbar.setup()
        pickPostImageButton.setup()
        setupCategoryField()
        setupKindField()
        setupSeveritySlider()
        setupLocationField()
        setupFloatingActionButton()
    }

    private fun Toolbar.setup() = setNavigationOnClickListener {
        findNavController().navigateUp()
    }

    private fun ImageButton.setup() = setOnClickListener {
        // TODO: Open image picker
        // TODO: Update postImage
    }

    private fun Binding.setupCategoryField() = categoryAutoCompleteTextView.apply {
        // TODO: Set adapter
    }

    private fun Binding.setupKindField() = kindAutoCompleteTextView.apply {
        // TODO: Set adapter
    }

    private fun Binding.setupSeveritySlider() {
        severitySlider.addOnChangeListener { slider, value, _ ->
            // TODO: Update severity text
        }
        // TODO: Set formatter
        // TODO: Set initial severity text?
    }

    private fun Binding.setupLocationField() = locationAutoCompleteTextView.apply {
        // TODO: Fetch current location
        // TODO: Set adapter
    }

    private fun Binding.setupFloatingActionButton() = newPostFab.setOnClickListener {
        // TODO: Save post (image, title, category, kind, severity, location, description)
        findNavController().navigateUp()
    }
}