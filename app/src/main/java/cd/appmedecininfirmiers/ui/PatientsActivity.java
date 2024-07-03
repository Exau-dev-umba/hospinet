package cd.appmedecininfirmiers.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import cd.appmedecininfirmiers.R;
import cd.appmedecininfirmiers.database.dao.PatientsDataSource;
import cd.appmedecininfirmiers.ui.data.model.Patient;

public class PatientsActivity extends AppCompatActivity {
    private PatientsDataSource datasource;
    private Button ajoutPatientButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_patients);

        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ajoutPatientButton.setOnClickListener(v -> {
            startRegisterPatientActivity();
        });

        datasource = new PatientsDataSource(this);
        datasource.open();

        List<Patient> values = datasource.getAllPatient();

    }

    private void init() {
        ajoutPatientButton = findViewById(R.id.text_home);
    }

    private void startRegisterPatientActivity(){
        startActivity(new Intent(this, RegisterPatientsActivity.class));
        finish();
    }
}