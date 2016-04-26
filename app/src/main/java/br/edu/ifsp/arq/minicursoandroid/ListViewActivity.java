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
        "+55 16 987654321",
        "+55 16 997218281",
        "+55 16 876543219",
        "+55 16 765432198",
        "+55 16 654321987",
        "+55 16 543219876"
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

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Best Practices: http://stackoverflow.com/questions/4275678/how-to-make-phone-call-using-intent-in-android
                final Intent goToSOPhoneCall = new Intent(Intent.ACTION_CALL /* or Intent.ACTION_DIAL (no manifest permission needed) */);
                goToSOPhoneCall.setData(Uri.parse("tel:" + PHONES[position]));
                startActivity(goToSOPhoneCall);
                return true;
            }
        });

        final User parceledUser = getIntent().getParcelableExtra(ListViewActivity.KEY_USER);
        Toast.makeText(getBaseContext(), getString(R.string.msg_welcome, parceledUser.getUsername()), Toast.LENGTH_LONG).show();
    }
}
