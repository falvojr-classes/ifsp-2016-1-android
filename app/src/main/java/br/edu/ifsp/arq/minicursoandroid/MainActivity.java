package br.edu.ifsp.arq.minicursoandroid;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.minicursoandroid.entity.User;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private TextInputLayout mUsernameLayout;
    private TextInputLayout mPasswordLayout;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.editTextUsername);
        mPassword = (EditText) findViewById(R.id.editTextPassword);

        mUsernameLayout = (TextInputLayout) findViewById(R.id.editTextUsernameLayout);
        mPasswordLayout = (TextInputLayout) findViewById(R.id.editTextPasswordLayout);

        mLogin = (Button) findViewById(R.id.buttonLogin);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid = true;
                if (TextUtils.isEmpty(mUsername.getText())) {
                    mUsernameLayout.setError(getString(R.string.msg_required));
                    isValid = false;
                } else {
                    mUsernameLayout.setErrorEnabled(false);
                }
                if (TextUtils.isEmpty(mPassword.getText())) {
                    mPasswordLayout.setError(getString(R.string.msg_required));
                    isValid = false;
                } else {
                    mPasswordLayout.setErrorEnabled(false);
                }
                if (isValid) {
                    final User user = new User();
                    user.setUsername(mUsername.getText().toString());

                    final Intent goToListView = new Intent(getBaseContext(), ListViewActivity.class);
                    goToListView.putExtra(ListViewActivity.KEY_USER, user);
                    startActivity(goToListView);
                }
            }
        });
    }
}
