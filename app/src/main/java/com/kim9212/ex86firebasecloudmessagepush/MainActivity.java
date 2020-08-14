package com.kim9212.ex86firebasecloudmessagepush;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickbtn(View view) {
        //앱을 fcm서버에 등록하는 과정이 필요함.
        //앱을 Fcm서버에 등록하면 앱을 식별할수 있는 고유 토큰값(문자열)을 줌
        //INSTANCE ID을 통해 앱들(디바이스들)을 구별하여 메세지가 전달되는것임

        FirebaseInstanceId firebaseInstanceId= FirebaseInstanceId.getInstance();
        Task<InstanceIdResult> task=firebaseInstanceId.getInstanceId();
        task.addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                String token=task.getResult().getToken();
                Log.i("TAG",token);
            }
        });
    }
}