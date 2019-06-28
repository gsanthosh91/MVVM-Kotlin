package com.lenovo.mvvm.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

/**
 *
 *
 */

public abstract class BaseActivity<B extends ViewDataBinding, T extends BaseViewModel> extends AppCompatActivity implements IView {
    @Inject
    protected T viewModel;
    protected B binding;

    /**
     * ViewModel must be initialized before bindView() is called
     * @param layout layout for the activity
     */
    protected final void bindView(int layout) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via activityComponent().inject(this)");
        }
        binding = DataBindingUtil.setContentView(this, layout);
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.clearSubscriptions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.detach();
    }

    @Override
    public void onError(@NotNull Throwable throwable) {
        Toast.makeText(this, "Error called on BaseActivity", Toast.LENGTH_LONG).show();
    }
}
