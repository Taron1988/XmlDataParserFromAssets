package examen.com.showxmldata;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<UserModel> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = findViewById(R.id.my_list);
        getXmlData();

        ListAdapter adapter = new ListAdapter(this, users);
        listView.setAdapter(adapter);
    }

    private void getXmlData() {
        XMLParserHandler parserHandler = new XMLParserHandler();
        try(InputStream in = getAssets().open("user.xml")) {;
            users = parserHandler.parse(in);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

}
