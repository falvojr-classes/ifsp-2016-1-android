package br.edu.ifsp.arq.minicursoandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.edu.ifsp.arq.minicursoandroid.entity.User;

public class ListViewActivity extends AppCompatActivity {

    public static final String KEY_USER = "MY_USER_KEY";

    private static final String[] PHONES = {
        "+55 16 111111111",
        "+55 16 222222222",
        "+55 16 333333333",
        "+55 16 444444444",
        "+55 16 555555555",
        "+55 16 666666666",
        "+55 16 777777777",
        "+55 16 888888888",
        "+55 16 999999999"
    };

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView = (ListView) findViewById(R.id.listViewPhones);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PHONES);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Link util: http://stackoverflow.com/questions/4275678/how-to-make-phone-call-using-intent-in-android
                final Intent goToSOPhoneCall = new Intent(Intent.ACTION_CALL /* ou Intent.ACTION_DIAL (não precisa de permissão no AndroidManifest.xml) */);
                goToSOPhoneCall.setData(Uri.parse("tel:" + PHONES[position]));
                startActivity(goToSOPhoneCall);
            }
        });

        //final User parceledUser = getIntent().getParcelableExtra(ListViewActivity.KEY_USER);
        //Toast.makeText(getBaseContext(), getString(R.string.msg_welcome) + parceledUser.getUsername(), Toast.LENGTH_LONG).show();
    }
}
