package com.choiz.apps.mileage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editDate;
    EditText editDistance;
    EditText editMoney;
    EditText editGas;
    EditText editLitre;
    Button buttonSave;
    Button buttonReset;
    TextView textStartDate;
    TextView textTotalDistance;
    TextView textTotalGas;
    TextView textMileage;
    TextView textCount;
    LinearLayout summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        summary = (LinearLayout) findViewById(R.id.summary);
        editDate = (EditText) findViewById(R.id.editDate);
        editDistance = (EditText) findViewById(R.id.editDistance);
        editMoney = (EditText) findViewById(R.id.editMoney);
        editGas = (EditText) findViewById(R.id.editGas);
        editLitre = (EditText) findViewById(R.id.editLitre);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        textStartDate = (TextView) findViewById(R.id.textStartDate);
        textTotalDistance = (TextView) findViewById(R.id.textTotalDistance);
        textTotalGas = (TextView) findViewById(R.id.textTotalGas);
        textMileage = (TextView) findViewById(R.id.textMileage);
        textCount = (TextView) findViewById(R.id.textCount);

    }

    public void onButtonSaveClicked(View view) {

        summary.setVisibility(View.VISIBLE);

    }

    public void onButtonResetClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 여기서 부터는 알림창의 속성 설정
        builder.setTitle("데이터 초기화 설정")        // 제목 설정
                .setMessage("데이터를 초기화 하시겠습니까?")        // 메세지 설정
                .setCancelable(false)        // 뒤로 버튼 클릭시 취소 가능 설정
                .setPositiveButton("초기화", new DialogInterface.OnClickListener() {
                    // 확인 버튼 클릭시 설정
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(getApplicationContext(), "데이터가 초기화 되었습니다.", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    // 취소 버튼 클릭시 설정
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();    // 알림창 객체 생성
        dialog.show();    // 알림창 띄우기
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
