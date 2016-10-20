package com.example.deng.openactmanager.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

/**
 * 启动界面管理类
 * Created by deng on 2016/10/19.
 */

public class OpenActManager {

    private final String OPEN_ACTIVITY_KEY = "open_activity_key";

    private static OpenActManager manager;

    private static Intent intent;

    private OpenActManager() {

    }

    public static OpenActManager get() {
        if (manager == null) {
            synchronized (OpenActManager.class) {
                if (manager == null) {
                    manager = new OpenActManager();
                }
            }
        }
        intent = new Intent();
        return manager;
    }

    /**
     * 获取上一个界面传递过来的参数
     *
     * @param activity this
     * @param <T>      泛型
     * @return
     */
    public <T> T getParcelableExtra(Activity activity) {
        Parcelable parcelable = activity.getIntent().getParcelableExtra(OPEN_ACTIVITY_KEY);
        activity = null;
        return (T) parcelable;
    }

    /**
     * 启动一个Activity
     *
     * @param _this
     * @param _class
     */
    public void goActivity(Context _this, Class<? extends Activity> _class) {
        intent.setClass(_this, _class);
        _this.startActivity(intent);
        _this = null;
    }

    /**
     * 启动activity后kill前一个
     *
     * @param _this
     * @param _class
     */
    public void goActivityKill(Context _this, Class<? extends Activity> _class) {
        intent.setClass(_this, _class);
        _this.startActivity(intent);
        ((Activity) _this).finish();
        _this = null;
    }

    public void goActivityResult(Activity _this, Class<? extends Activity> _class, int requestCode) {
        intent.setClass(_this, _class);
        _this.startActivityForResult(intent, requestCode);
        _this = null;
    }

    public void goActivityResultKill(Activity _this, Class<? extends Activity> _class, int requestCode) {
        intent.setClass(_this, _class);
        _this.startActivityForResult(intent, requestCode);
        ((Activity) _this).finish();
        _this = null;
    }

    public void goActivity(Context _this, Class<? extends Activity> _class, Parcelable parcelable) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivity(intent);
        _this = null;
    }

    /**
     * 启动一个Activity
     * @param _this
     * @param _class
     * @param flags
     * @param parcelable 传递的实体类
     */
    public void goActivity(Context _this, Class<? extends Activity> _class, int flags, Parcelable parcelable) {
        intent.setClass(_this, _class);
        setFlags(flags);
        putParcelable(parcelable);
        _this.startActivity(intent);
        _this = null;
    }

    public void goActivityKill(Context _this, Class<? extends Activity> _class, Parcelable parcelable) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivity(intent);
        ((Activity) _this).finish();
        _this = null;
    }

    public void goActivityKill(Context _this, Class<? extends Activity> _class, int flags, Parcelable parcelable) {
        intent.setClass(_this, _class);
        setFlags(flags);
        putParcelable(parcelable);
        _this.startActivity(intent);
        ((Activity) _this).finish();
        _this = null;
    }

    public void goActivityResult(Activity _this, Class<? extends Activity> _class, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivityForResult(intent, requestCode);
        _this = null;
    }

    public void goActivityResult(Activity _this, Class<? extends Activity> _class, int flags, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        setFlags(flags);
        _this.startActivityForResult(intent, requestCode);
        _this = null;
    }

    public void goActivityResultKill(Activity _this, Class<? extends Activity> _class, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivityForResult(intent, requestCode);
        _this.finish();
        _this = null;
    }

    public void goActivityResultKill(Activity _this, Class<? extends Activity> _class, int flags, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        setFlags(flags);
        _this.startActivityForResult(intent, requestCode);
        _this.finish();
        _this = null;
    }

    private void setFlags(int flags) {
        if (flags < 0) return;
        intent.setFlags(flags);
    }

    private void putParcelable(Parcelable parcelable) {
        if (parcelable == null) return;
        intent.putExtra(OPEN_ACTIVITY_KEY, parcelable);
    }

}
