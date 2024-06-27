package cd.appmedecininfirmiers.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;

import cd.appmedecininfirmiers.MainActivity;
import cd.appmedecininfirmiers.R;
import cd.appmedecininfirmiers.ui.intro_screen.IntroScreenActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        statuscolor();
        Objects.requireNonNull(getSupportActionBar()).hide();
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        init();
    }

    private void init() {
        usernameEditText = findViewById(R.id.inputUsername);
        passwordEditText = findViewById(R.id.inputPassword);
        loginButton = findViewById(R.id.button_connexion);
    }

    private void startHomeActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
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