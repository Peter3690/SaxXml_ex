package tulv.getxmlfromurl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            MySaxHandler handler = new MySaxHandler();

     /*       File file = new File("department-data.xml");*/
            InputStream in=this.getAssets().open("department.xml");
            saxParser.parse(in,handler);
    /*        saxParser.parse(file, handler);*/
            Toast.makeText(MainActivity.this, ""+handler.data, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}