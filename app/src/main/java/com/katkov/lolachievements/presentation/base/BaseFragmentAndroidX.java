package com.katkov.lolachievements.presentation.base;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpDelegate;

import androidx.fragment.app.Fragment;

/**
 * This class will exist until introduced support AndroidX
 */

public class BaseFragmentAndroidX extends Fragment implements ErrorView {
    private boolean mIsStateSaved;
    private MvpDelegate<? extends BaseFragmentAndroidX> mMvpDelegate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        mIsStateSaved = false;

        getMvpDelegate().onAttach();
    }

    public void onResume() {
        super.onResume();

        mIsStateSaved = false;

        getMvpDelegate().onAttach();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mIsStateSaved = true;

        getMvpDelegate().onSaveInstanceState(outState);
        getMvpDelegate().onDetach();
    }

    @Override
    public void onStop() {
        super.onStop();

        getMvpDelegate().onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        getMvpDelegate().onDetach();
        getMvpDelegate().onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (getActivity().isFinishing()) {
            getMvpDelegate().onDestroy();
            return;
        }

        if (mIsStateSaved) {
            mIsStateSaved = false;
            return;
        }

        boolean anyParentIsRemoving = false;
        Fragment parent = getParentFragment();
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving();
            parent = parent.getParentFragment();
        }

        if (isRemoving() || anyParentIsRemoving) {
            getMvpDelegate().onDestroy();
        }
    }

    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);

        }

        return mMvpDelegate;
    }

    @Override
    public void showError(Error error) {
        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
    }
}
