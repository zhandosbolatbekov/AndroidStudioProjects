package com.example.mac.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etBillAmount)
    EditText etBillAmount;
    @BindView(R.id.tvTipPercent)
    TextView tvTipPercent;
    @BindView(R.id.tvTipAmount)
    TextView tvTipAmount;
    @BindView(R.id.tvBillTotalAmount)
    TextView tvBillTotalAmount;

    final double REGULAR_TIP_PERCENTAGE = 10;
    final double GOOD_TIP_PERCENTAGE = 15;
    final double EXCELLENT_TIP_PERCENTAGE = 20;

    double percentage = 0;
    double tipTotal = 0;
    double billTotal = 0;
    double etValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setValues();
    }

    private void setValues() {

        tvTipPercent.setText(getString(R.string.main_msg_tippercent, percentage));
        tvTipAmount.setText(getString(R.string.main_msg_tiptotal, tipTotal));
        tvBillTotalAmount.setText(getString(R.string.main_msg_billtotalresult, billTotal));
    }

    @OnClick({R.id.ibRegularService, R.id.ibGoodService, R.id.ibExcellentService})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibRegularService:
                percentage = REGULAR_TIP_PERCENTAGE;
                break;
            case R.id.ibGoodService:
                percentage = GOOD_TIP_PERCENTAGE;
                break;
            case R.id.ibExcellentService:
                percentage = EXCELLENT_TIP_PERCENTAGE;
                break;
        }
        calculateBill();
        setValues();
    }

    @OnTextChanged(R.id.etBillAmount)
    public void onTextChanged() {

        calculateBill();
        setValues();
    }

    private void calculateBill() {

        if(percentage == 0)
            percentage = REGULAR_TIP_PERCENTAGE;

        String s = etBillAmount.getText().toString();

        if(!s.equals("") && !s.equals(".")) {
            etValue = Double.valueOf(s);
        } else {
            etValue = 0;
        }

        tipTotal = etValue * percentage / 100.0;
        billTotal = etValue + tipTotal;
    }

}
