package hudaali.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MySQLiteOpenHelper helper;
    private UserCRUD userCRUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MySQLiteOpenHelper(this,"User_db",null,1);
        userCRUD =new UserCRUD(helper);

    }
    public void btu_regrster(View v) {
        Intent i = new Intent(getApplicationContext(), Logup.class);
        startActivity(i);
    }
    public void but_login(View v) {
       EditText email = (EditText) findViewById(R.id.editText);
       EditText pass = (EditText) findViewById(R.id.editText2);
       String Email = email.getText().toString();
       String Pass = pass.getText().toString();
        String password = userCRUD.search(Email);
       if (Pass.equals("") || Email.equals("") ) {
           Toast.makeText(getApplicationContext(), "Fill All Fields", Toast.LENGTH_LONG).show();
           return;
       }else {
           if(pass.equals(password)){
               Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_LONG).show();
               Intent i = new Intent(getApplicationContext(), Home.class);
               i.putExtra("email",Email );
               startActivity(i);

           }else{
               Toast.makeText(getApplicationContext(), "pass or email is error", Toast.LENGTH_LONG).show();
           }
       }




    }




}