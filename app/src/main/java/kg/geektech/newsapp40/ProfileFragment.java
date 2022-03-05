package kg.geektech.newsapp40;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import kg.geektech.newsapp40.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private Uri uri;
    private Prefs prefs;
    private Intent intent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new Prefs(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(LayoutInflater.from(requireContext()),
                container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImage();
        saveUserName(prefs);
    }

    private ActivityResultLauncher<Intent> test = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        uri = result.getData().getData();
                        prefs.savePicture(String.valueOf(uri));
                        binding.imgView.setImageURI(uri);
                    }
                }
            });


    private void setImage() {
        binding.imgView.setOnClickListener(view -> {
            intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            test.launch(intent);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (prefs.getPicture() != null) uri = Uri.parse(prefs.getPicture());
        Glide.with(requireContext()).load(uri).circleCrop().into(binding.imgView);
    }

    private void saveUserName(Prefs prefs) {
        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                prefs.saveUserName(editable.toString());
            }
        });
        binding.etName.setText(prefs.getUserName());
    }
}