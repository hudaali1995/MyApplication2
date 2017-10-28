package hudaali.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logup extends AppCompatActivity {
    private MySQLiteOpenHelper helper;
    private UserCRUD userCRUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logup);
        helper = new MySQLiteOpenHelper(this,"User_db",null,1);
        userCRUD =new UserCRUD(helper);
    }

    public void but_add(View v) {
        EditText email = (EditText) findViewById(R.id.editText8);
        EditText pass = (EditText) findViewById(R.id.editText6);
        EditText name = (EditText) findViewById(R.id.editText7);
        EditText confiemPass = (EditText) findViewById(R.id.editText10);

        String Name = name.getText().toString();
        String Pass = pass.getText().toString();
        String Email = email.getText().toString();
        String Confirm = confiemPass.getText().toString();
        boolean result = userCRUD.check(Email);
        if (Pass.equals("") || Email.equals("") || Name.equals("") || Confirm.equals("")) {
            Toast.makeText(getApplicationContext(), "Fill All Fields", Toast.LENGTH_LONG).show();
            return;
        }
        if (regexpass(Pass)){
            if (!Pass.equals(Confirm)) {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                return;
              }
        } else {
            Toast.makeText(getApplicationContext(), "Password must contain at least 8 of number and letter both upper and lower", Toast.LENGTH_LONG).show();
        }
        if(result == false) {
            User user = new User(Name, Email, Pass, Confirm);
            userCRUD.adduser(user);
            Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Logup.this, Home.class);
            startActivity(i);
         }else{
            Toast.makeText(getApplicationContext(), "This email is taken by another account ", Toast.LENGTH_LONG).show();
        }

    }
    public boolean regexpass (String password) {

        Pattern pattern;
        Matcher matcher;

        final String regex_pass= "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=\\\\S+$).{8,}$";

        pattern = Pattern.compile(regex_pass);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}
