package com.laomao.ui.home;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by laomao on 16/10/19.
 */

public class HomeFragPresenter extends HomeFragContract.Presenter {

    @Override
    public void onStart() {

    }

    @Override
    public void getBlogs() {
        mModel.getBlogs().observeOn(AndroidSchedulers.mainThread())
                .subscribe(blogBean -> {
                    mView.blogResult(blogBean);
                });
    }
}
