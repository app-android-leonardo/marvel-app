package br.com.marveltest.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import br.com.marveltest.R;

public class AndroidComponent {
    private Activity activity;
    private ProgressDialog progressBar;

    public AndroidComponent(Activity activity){
        this.activity = activity;
    }

    public void showMessage(String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    public void showProgress(String msg){
        progressBar = new ProgressDialog(activity);
        progressBar.setCancelable(false);
        progressBar.setMessage(msg);
        progressBar.show();
    }

    public void hideProgress(){
        if (progressBar != null) {
            progressBar.dismiss();
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void alert(String title, String message, final boolean isFinish) {
        final AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (isFinish){
                    activity.finish();
                }
            }
        });
        alert = builder.create();
        alert.show();
    }
}