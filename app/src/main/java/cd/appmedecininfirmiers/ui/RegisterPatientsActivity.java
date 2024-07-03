package cd.appmedecininfirmiers.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

import cd.appmedecininfirmiers.MainActivity;
import cd.appmedecininfirmiers.R;

public class RegisterPatientsActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView textSeConnecte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statuscolor();
        //EdgeToEdge.enable(this);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_register_patients);

        init();
        loginButton.setOnClickListener(v -> {
            startHomeActivity();
        });
        textSeConnecte.setOnClickListener(v -> {
            startSeConnecterActivity();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void startHomeActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void startSeConnecterActivity(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void init() {
        usernameEditText = findViewById(R.id.inputUsername);
        passwordEditText = findViewById(R.id.inputPassword);
        loginButton = findViewById(R.id.button_connexion);
        textSeConnecte = findViewById(R.id.connexionBtn);
    }

    public void statuscolor(){
//changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.vert));
        }
    }
}