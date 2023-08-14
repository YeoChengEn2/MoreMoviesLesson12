package sg.edu.rp.c346.id22022416.moremovieslesson12;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;
    TextView tvSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        tvSuccess = findViewById(R.id.tvSuccess);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(SecondActivity.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the movie?");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvSuccess.setText("Movie has been deleted.");
                    }
                });

                myBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder myBuilder2 = new AlertDialog.Builder(SecondActivity.this);
                        myBuilder2.setTitle("Danger");
                        myBuilder2.setMessage("Are you sure you want to discard the changes?");
                        myBuilder2.setCancelable(false);

                        myBuilder2.setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvSuccess.setText("Changes have been discarded.");
                            }
                        });

                        myBuilder2.setNeutralButton("DO NOT DISCARD",null);
                        AlertDialog myDialog = myBuilder2.create();
                        myDialog.show();
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }
}