package com.ricarvalho.help.post

import android.os.Bundle
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.transition.MaterialContainerTransform
import com.ricarvalho.help.common.ViewBindingFragment
import com.ricarvalho.help.databinding.FragmentPostDetailsBinding

class PostDetailsFragment : ViewBindingFragment<FragmentPostDetailsBinding>(FragmentPostDetailsBinding::class.java) {
    init {
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun FragmentPostDetailsBinding.onCreated(savedInstanceState: Bundle?) {
        toolbar.setup()
        pickPostImageButton.setOnClickListener {
            // TODO: Open image picker
            // TODO: Update postImage
        }
        kindImageButton.setOnClickListener {
            // TODO: Open kind picker
            // TODO: Update icon
        }
        locationAutoCompleteTextView.setup()
        newPostFab.setup()
    }

    private fun MaterialToolbar.setup() = setNavigationOnClickListener {
        findNavController().navigateUp()
    }

    private fun MaterialAutoCompleteTextView.setup() {
        // TODO: Fetch current location
        // TODO: Set adapter
    }

    private fun FloatingActionButton.setup() = setOnClickListener {
        // TODO: Save post (kind, image, title, location, description)
        findNavController().navigateUp()
    }
}