package com.choiz.apps.mileage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    static private final String LOG_TAG = "MainActivity";

    MileageDTO mDto = new MileageDTO();
    String mToday = "";
    Button mButtonSave, mButtonReset;
    EditText mEditDate, mEditDistance, mEditMoney, mEditGas, mEditPrice;
    TextView mTextStartDate, mTextTotalDistance, mTextTotalGas, mTextMileage, mTextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    private void init() {

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        mEditDate = (EditText) findViewById(R.id.editDate);
        mEditDistance = (EditText) findViewById(R.id.editDistance);
        mEditMoney = (EditText) findViewById(R.id.editMoney);
        mEditGas = (EditText) findViewById(R.id.editGas);
        mEditPrice = (EditText) findViewById(R.id.editPrice);
        mButtonSave = (Button) findViewById(R.id.buttonSave);
        mButtonReset = (Button) findViewById(R.id.buttonReset);
        mTextStartDate = (TextView) findViewById(R.id.textStartDate);
        mTextTotalDistance = (TextView) findViewById(R.id.textTotalDistance);
        mTextTotalGas = (TextView) findViewById(R.id.textTotalGas);
        mTextMileage = (TextView) findViewById(R.id.textMileage);
        mTextCount = (TextView) findViewById(R.id.textCount);

        // 날짜 항목에 오늘 날짜 넣기
        mEditDate.setText(getToday());
    }


    public void setListener() {

        // 주유금액과 단가로 주유량 계산해서 표시하기
        mEditPrice.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float money = 0f;
                float price = 0f;
                String strMoney = mEditMoney.getText().toString();
                String strPrice = mEditPrice.getText().toString();

                if (strMoney.length() > 0) {
                    money = Float.parseFloat(strMoney);
                }

                if (strPrice.length() > 0) {
                    price = Float.parseFloat(strPrice);
                }

                // 소수점 두자리에서 반올림
                if (price > 0) {
                    float gas = Math.round((money / price) * 100f) / 100f;
                    mEditGas.setText(Float.toString(gas));
                }
            }
        });
    }

    public String getToday() {
        Date today = new Date();
        mToday = today.toString();

        return dateToStr(today);
    }

    public String dateToStr(Date date) {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy년 M월 dd일 E요일", Locale.KOREAN);
        return transFormat.format(date);
    }

    public void onButtonSaveClicked(View view) {

        // 저장 버튼이 눌리면 입력된 데이터 문제가 있는지 확인하고 데이터를 저장하거나 재입력을 요구한다.
        if (isValidData()) {
            saveData();
        } else {
            sendMessage();
        }
    }

    public void onDateClicked(View view) {

    }

    public void onButtonResetClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 알림창의 속성 설정
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
                        Toast.makeText(getApplicationContext(), "초기화가 취소 되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();    // 알림창 객체 생성
        dialog.show();    // 알림창 띄우기
    }

    // 입력된 데이터 검증
    public boolean isValidData() {
        String date;
        String money;
        String price;
        String gas;
        String distance;

        date = mEditDate.getText().toString();
        money = mEditMoney.getText().toString();
        price = mEditPrice.getText().toString();
        gas = mEditGas.getText().toString();
        distance = mEditDistance.getText().toString();

        if (date.length() != 0 && money.length() != 0 && price.length() != 0
                && gas.length() != 0 && distance.length() != 0) {

            mDto.setDate(mToday);
            mDto.setDistance(distance);
            mDto.setGas(gas);
            mDto.setPrice(price);
            mDto.setMoney(money);

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
        Toast.makeText(this, "누락된 항목이 있습니다. 다시 한번 확인해주십시요.", Toast.LENGTH_SHORT).show();
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
