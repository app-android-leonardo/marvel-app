package br.com.marveltest;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import br.com.marveltest.base.BaseActivity;
import br.com.marveltest.call.resquest.ComicsRequestApi;

public class DetailComicsActivity extends BaseActivity {
    private int idCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comics);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(R.string.comics);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        DiscreteScrollView scrollView = findViewById(R.id.detail_discretescrollview);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            idCharacter = extras.getInt("id_character");
        }

        new ComicsRequestApi(this).call(service, scrollView, idCharacter, false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}