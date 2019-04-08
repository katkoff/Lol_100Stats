package com.katkov.lolachievements.application.base

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpDelegate

/**
 * This class will exist until introduced support AndroidX
 */

open class BaseFragment : Fragment(), ErrorView {
    private var mIsStateSaved: Boolean = false
    private var mMvpDelegate: MvpDelegate<out BaseFragment>? = null

    val mvpDelegate: MvpDelegate<*>
        get() {
            if (mMvpDelegate == null) {
                mMvpDelegate = MvpDelegate(this)

            }

            return mMvpDelegate!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mvpDelegate.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        mIsStateSaved = false

        mvpDelegate.onAttach()
    }

    override fun onResume() {
        super.onResume()

        mIsStateSaved = false

        mvpDelegate.onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        mIsStateSaved = true

        mvpDelegate.onSaveInstanceState(outState)
        mvpDelegate.onDetach()
    }

    override fun onStop() {
        super.onStop()

        mvpDelegate.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        mvpDelegate.onDetach()
        mvpDelegate.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (activity!!.isFinishing) {
            mvpDelegate.onDestroy()
            closeScope()
            return
        }

        if (mIsStateSaved) {
            mIsStateSaved = false
            return
        }

        var anyParentIsRemoving = false
        var parent = parentFragment
        while (!anyParentIsRemoving && parent != null) {
            anyParentIsRemoving = parent.isRemoving
            parent = parent.parentFragment
        }

        if (isRemoving || anyParentIsRemoving) {
            mvpDelegate.onDestroy()
            closeScope()
        }
    }

    override fun showError(error: Error) =
        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()

    open protected fun closeScope() {}
}
