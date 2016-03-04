package example.s.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ListView listView;
    EditText editText;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        arrayList = new ArrayList<String>();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
                String item = (String) adapter.getItem(position);

                  adapter.remove(item);
                arrayList.remove(item);
                  // adapter.add(item);
                  int number;
                  number = position + 1;
                  adapter.insert(item, number);


            }


        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
                String item = (String) adapter.getItem(position);
                adapter.remove(item);
                arrayList.remove(item);
                Toast.makeText(getApplicationContext(), "削除しました", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void add(View v) {
        String text;
        text = editText.getText().toString();
        Toast.makeText(getApplicationContext(), "追加しました", Toast.LENGTH_SHORT).show();

        adapter.add(text);
        arrayList.add(text);
        editText.setText("");



    }

    public void remove(View v){

        adapter.clear();
        arrayList.clear();
    }

    public void see(View v){
        Intent intent=new Intent(this,MainActivity2Activity.class);
        intent.putStringArrayListExtra("array", arrayList);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
