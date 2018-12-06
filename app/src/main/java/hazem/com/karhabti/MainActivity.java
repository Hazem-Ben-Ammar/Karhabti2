package hazem.com.karhabti;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;


public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText Nom, Adress, Num, Longitude, Latitude;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.addAgence);
        Nom = (EditText) findViewById(R.id.Nom);
        Adress = (EditText) findViewById(R.id.Adress);
        Num = (EditText) findViewById(R.id.num);
        Longitude = (EditText) findViewById(R.id.Longitude);
        Latitude = (EditText) findViewById(R.id.latitude);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("adding values");
                progressDialog.show();
                String nom = Nom.getText().toString();
                String adress = Adress.getText().toString();
                int num = Integer.parseInt(Num.getText().toString());
                float longitude = Float.parseFloat(Longitude.getText().toString());
                float latitude = Float.parseFloat(Latitude.getText().toString());
                Agence agence = new Agence(num, adress, nom, longitude, latitude);
                FirebaseFirestore DB = FirebaseFirestore.getInstance();
                FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                        .setTimestampsInSnapshotsEnabled(true)
                        .build();
                DB.setFirestoreSettings(settings);
                DB.collection("Agence").document().set(agence)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, "succes", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });
    }

}
