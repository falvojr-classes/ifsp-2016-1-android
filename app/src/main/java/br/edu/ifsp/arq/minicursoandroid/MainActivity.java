package br.edu.ifsp.arq.minicursoandroid;

import android.content.Intent;
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
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.editTextUsername);
        mPassword = (EditText) findViewById(R.id.editTextPassword);

        mLogin = (Button) findViewById(R.id.buttonLogin);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mUsername.getText())) {
                    mUsername.setError(getString(R.string.msg_required));
                } else {
                    mUsername.setError(null);
                }
                if (TextUtils.isEmpty(mPassword.getText())) {
                    mPassword.setError(getString(R.string.msg_required));
                } else {
                    mPassword.setError(null);
                }
                if (TextUtils.isEmpty(mUsername.getError()) && TextUtils.isEmpty(mPassword.getError())) {
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
