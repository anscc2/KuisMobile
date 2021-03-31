package com.example.kuismobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickBiodata(View view) {
        Intent i = new Intent(MainActivity.this, BiodataActivity.class);
        startActivity(i);
    }
    public void ClickLogout(View view) {logout(this); }

    static void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Seriuski?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void ClickHome(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        startActivity(i);
    }

    public void ClickMessage(View view) {
        Intent i = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            i = getPackageManager().getLaunchIntentForPackage(Telephony.Sms.getDefaultSmsPackage(this));
        }
        startActivity(i);
    }
}