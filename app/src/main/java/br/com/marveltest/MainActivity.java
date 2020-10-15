package br.com.marveltest;

import androidx.appcompat.app.ActionBar;
import android.os.Bundle;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import br.com.marveltest.base.BaseActivity;
import br.com.marveltest.call.resquest.CharacterRequestApi;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(R.string.character);
            actionBar.hide();
        }

        DiscreteScrollView scrollView = findViewById(R.id.picker);
        new CharacterRequestApi(this).call(service, scrollView);
    }
}