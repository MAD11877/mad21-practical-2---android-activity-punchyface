package sg.edu.np.mad.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    User myUser = new User("John", "tall", 1, true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button follow = findViewById(R.id.followbtn);

        helloFollow(follow,myUser.followed);
        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (myUser.followed == false){
                    myUser.followed = true;
                    follow.setText("Unfollow");
                    Log.v(TAG, "Successfully followed " + myUser.name);
                }
                else {
                    myUser.followed = false;
                    follow.setText("Follow");
                    Log.v(TAG, "Successfully unfollowed " + myUser.name);
                }

            }
        });


    }
    public static void helloFollow(Button follow, boolean followed){
        if (followed == false){
            follow.setText("Follow");
        }
        else {
            follow.setText("Unfollow");
        }
    }
    public static class User{
        String name;
        String description;
        int id;
        boolean followed;

        public User(){}
        public User(String name, String description, int id, boolean followed){
            this.name = name;
            this.description = description;
            this.id = id;
            this.followed = followed;
        }
    }
}