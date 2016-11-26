package com.other.project.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.other.project.live.gruidefragments.AnchorHeadLineFragment;
import com.other.project.live.gruidefragments.ClassifyFragment;
import com.other.project.live.gruidefragments.MainFragment;
import com.other.project.live.gruidefragments.MyselfFragment;

/*
*
* My Live*/
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment showFragment;
    private RadioGroup mRadioGroup;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mRadioGroup = (RadioGroup) findViewById(R.id.bottom_radiogroup);

        mRadioGroup.setOnCheckedChangeListener(this);
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        showFragment = new MainFragment();
        transaction.add(R.id.container_framelayout, showFragment, MainFragment.TAG);
        transaction.commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.main_btn:
                swapFragment(MainFragment.TAG, MainFragment.class);

                break;
            case R.id.classify_btn:
                swapFragment(ClassifyFragment.TAG, ClassifyFragment.class);

                break;
            case R.id.anchor_btn:
                swapFragment(AnchorHeadLineFragment.TAG, AnchorHeadLineFragment.class);

                break;
            case R.id.myself_btn:
                swapFragment(MyselfFragment.TAG, MyselfFragment.class);

                break;
        }

    }


    public void swapFragment(String Tag, Class<? extends Fragment> cls) {


        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.hide(showFragment);


        try {

            showFragment = mFragmentManager.findFragmentByTag(Tag);

            if (showFragment != null) {

                transaction.show(showFragment);
            } else {
                showFragment = cls.getConstructor().newInstance();
                transaction.add(R.id.container_framelayout, showFragment, Tag);
            }
        } catch (Exception e) {

        }


        transaction.commit();
    }
}
