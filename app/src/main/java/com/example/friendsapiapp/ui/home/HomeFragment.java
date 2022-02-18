package com.example.friendsapiapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.friendsapiapp.R;
import com.example.friendsapiapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    EditText edt1,edt2;
    AppCompatButton btn1;
    String getName,getRollNo;
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        edt1=(EditText) root.findViewById(R.id.edt1);
        edt2=(EditText) root.findViewById(R.id.edt2);
        btn1=(AppCompatButton) root.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=edt1.getText().toString();
                getRollNo=edt2.getText().toString();
                Toast.makeText(getActivity(),getName, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),getRollNo, Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}