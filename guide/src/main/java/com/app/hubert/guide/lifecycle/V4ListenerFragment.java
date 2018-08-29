package com.app.hubert.guide.lifecycle;

import android.support.v4.app.Fragment;

import com.app.hubert.guide.util.LogUtil;

/**
 * Created by hubert
 * <p>
 * Created on 2017/9/13.
 */

public class V4ListenerFragment extends Fragment {

    private final String note = "mFragmentLifecycle is null";

    FragmentLifecycle mFragmentLifecycle;

    public void setFragmentLifecycle(FragmentLifecycle lifecycle) {
        mFragmentLifecycle = lifecycle;
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("onStart: ");
        if (null == mFragmentLifecycle) {
            LogUtil.w(note);
        } else {
            mFragmentLifecycle.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d("onStop: ");
        if (null == mFragmentLifecycle) {
            LogUtil.w(note);
        } else {
            mFragmentLifecycle.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d("onDestroyView: ");
        if (null == mFragmentLifecycle) {
            LogUtil.w(note);
        } else {
            mFragmentLifecycle.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy: ");
        if (null == mFragmentLifecycle) {
            LogUtil.w(note);
        } else {
            mFragmentLifecycle.onDestroy();
        }
    }

}
