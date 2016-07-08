package com.choiz.apps.mileage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    static private final String LOG_TAG = "MainActivity";

    MileageDTO dto;

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

        editDate.setText(new Date().toString());
        float money = Float.parseFloat(editMoney.getText().toString());
        float liter = Float.parseFloat(editLitre.getText().toString());
        float gas = money / liter;
        gas=Math.round(gas*100f)/100f;
        Log.d("GAS : " , gas+"" );
        editLitre.setText(gas+"");


    }

    public void onButtonSaveClicked(View view) {

        // 저장 버튼이 눌리면 입력된 데이터 문제가 있는지 확인하고 데이터를 저장하거나 재입력을 요구한다.
        if (isValidData()) {
            saveData();
        } else {
            sendMessage();
        }

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

    // 입력된 데이터 검증
    public boolean isValidData() {
        String date;
        String money;
        String litre;
        String gas;
        String distance;

        date = editDate.getText().toString();
        money = editMoney.getText().toString();
        litre = editLitre.getText().toString();
        gas = editGas.getText().toString();
        distance = editDistance.getText().toString();

//        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date convDate = null;
//        try {
//            convDate = transFormat.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Log.d("convDate", convDate.toString());
//
//
//        Log.d(LOG_TAG, " :: date : " + date + ", money : " + money + ", litre : "
//                + litre + ", gas : " + gas + ", distance : " + distance);


        if (date != null && money != null && litre != null && gas != null && distance != null) {
            dto = new MileageDTO();
            dto.setDate(date);
            dto.setDistance(distance);
            dto.setGas(gas);
            dto.setLitre(litre);
            dto.setMoney(money);

            Log.d(LOG_TAG, " - DTO : " + dto.toString() + " :: date : " + date + ", money : " + money + ", litre : "
                    + litre + ", gas : " + gas + ", distance : " + distance);

            return true;
        } else {
            return false;
        }
    }

    // 데이터 검증후 이상없으면 디비에 저장
    public void saveData() {

    }


    // 입력된 데이터에 이상이 있을시 재입력 요구하는 메시지 출력
    public void sendMessage() {

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
