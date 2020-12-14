package us.kikin.apps.android.doordashy.ui.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import us.kikin.apps.android.doordashy.EventObserver
import us.kikin.apps.android.doordashy.databinding.FragmentRestaurantListBinding

@AndroidEntryPoint
class RestaurantListFragment : Fragment() {

    private var _binding: FragmentRestaurantListBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: RestaurantViewModel by viewModels()
    private lateinit var adapter: RestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        // observe restaurant list
        viewModel.data.observe(
            viewLifecycleOwner,
            { restaurants ->
                if (restaurants.isNotEmpty()) {
                    binding.listProgress.isVisible = false
                }
                adapter.updateItems(restaurants)
            }
        )
        // observe navigation event
        viewModel.navigateToRestaurantEvent.observe(
            viewLifecycleOwner,
            EventObserver { navigateToRestaurantDetail(it) }
        )
    }

    private fun setupAdapter() {
        adapter = RestaurantAdapter(viewModel)
        binding.recyclerView.adapter = adapter
    }

    private fun navigateToRestaurantDetail(restaurantId: Long) {
        val action = RestaurantListFragmentDirections.restaurantDetailAction(restaurantId)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
