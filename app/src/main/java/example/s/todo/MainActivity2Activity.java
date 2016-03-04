package example.s.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity2Activity extends ActionBarActivity {
    ArrayList<String> labelList  = new ArrayList<String>();
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Intent intent = getIntent();
        labelList = intent.getStringArrayListExtra("array");
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        adapter.add(labelList);


        // ListViewのインスタンスを取得
        ListView list = (ListView)findViewById(R.id.listView2);

        // リストアイテムのラベルを格納するArrayListをインスタンス化
        //ArrayList<String> labelList = new ArrayList<String>();

        // "List Item + ??"を20個リストに追加
        //for(int i=1; i<=20; i++){
          //  labelList.add("List Item "+i);
   // }

        // Adapterのインスタンス化
        // 第三引数にlabelListを渡す
        CustomAdapter mAdapter = new CustomAdapter(this, 0, labelList);

        // リストにAdapterをセット
        list.setAdapter(mAdapter);

        // リストアイテムの間の区切り線を非表示にする
        list.setDivider(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
