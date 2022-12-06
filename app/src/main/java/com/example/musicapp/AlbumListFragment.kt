package com.example.musicapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.musicapp.databinding.FragmentAlbumListBinding
import com.example.musicapp.view_models.AlbumViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

private const val TAG = "AlbumListFragment"
class AlbumListFragment : Fragment() {
    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AlbumViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v(TAG, "onCreateView")
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(TAG, "onViewCreated")

        viewModel.albums.observe(requireActivity()) { albums ->
            Log.v(TAG, "albums: $albums")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}