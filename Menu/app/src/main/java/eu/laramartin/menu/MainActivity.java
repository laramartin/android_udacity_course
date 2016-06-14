package eu.laramartin.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        Log.i("item1", "what I'm doing?");
        TextView item1TextView = (TextView) findViewById(R.id.menu_item_1);
        String item1String = item1TextView.getText().toString();
        Log.v("MainActivity", item1String);
        // Find second menu item TextView and print the text to the logs
        Log.i("item2", "working with logs");
        TextView item2TextView = (TextView) findViewById(R.id.menu_item_2);
        String item2String = item2TextView.getText().toString();
        Log.v("MainActivity", item2String);
        // Find third menu item TextView and print the text to the logs
        Log.i("item3", "this is cool!!");
        TextView item3TextView = (TextView) findViewById(R.id.menu_item_3);
        String item3String = item3TextView.getText().toString();
        Log.v("MainActivity", item3String);
    }
}