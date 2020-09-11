package com.tana.leaderboard;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.tana.leaderboard.databinding.DialigSubmitBinding;
import com.tana.leaderboard.services.DocsService;
import com.tana.leaderboard.services.DocsServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitVerifiedDialog extends DialogFragment {
    String mFirstName;
    String mLastName;
    String mEmailAddress;
    String mGithubLink;

    public SubmitVerifiedDialog(String firstName, String lastName, String emailAddress, String githubLink) {
        mFirstName = firstName;
        mLastName = lastName;
        mEmailAddress = emailAddress;
        mGithubLink = githubLink;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final DialigSubmitBinding submitBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                R.layout.dialig_submit, null, false);

        submitBinding.submitSuccessful.setVisibility(View.INVISIBLE);
        submitBinding.submitUnsuccessful.setVisibility(View.INVISIBLE);

        submitBinding.proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DocsService docsService = DocsServiceBuilder.buildService(DocsService.class);
                Call<Void> submitForm = docsService.postForm(mFirstName, mLastName, mEmailAddress, mGithubLink);

                submitForm.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        submitBinding.submitUnsuccessful.setVisibility(View.INVISIBLE);
                        submitBinding.submitConstraintLayout.setVisibility(View.INVISIBLE);
                        submitBinding.submitSuccessful.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        submitBinding.submitUnsuccessful.setVisibility(View.VISIBLE);
                        submitBinding.submitConstraintLayout.setVisibility(View.INVISIBLE);
                        submitBinding.submitSuccessful.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        submitBinding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(submitBinding.getRoot());

        return builder.create();
    }
}
