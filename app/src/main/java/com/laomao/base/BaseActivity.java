package com.laomao.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.laomao.tools.Tutil;

/**
 * Created by laomao on 16/9/10.
 */
public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity{
    public P mPresenter;
    public M mModel;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(getLayoutId());
        mContext=this;
        mPresenter= Tutil.getT(this,0);
        mModel=Tutil.getT(this,1);
        this.initView();
        if(this instanceof BaseView)
            mPresenter.setViewModel(this,mModel);
    }

    public abstract int getLayoutId();

    public abstract void initView();
}