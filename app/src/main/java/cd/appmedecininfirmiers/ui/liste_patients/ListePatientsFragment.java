package cd.appmedecininfirmiers.ui.liste_patients;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cd.appmedecininfirmiers.databinding.FragmentListPatientsBinding;

public class ListePatientsFragment extends Fragment {

    private FragmentListPatientsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListePatientsViewModel listePatientsViewModel =
                new ViewModelProvider(this).get(ListePatientsViewModel.class);

        binding = FragmentListPatientsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textDashboard;
        //listePatientsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}