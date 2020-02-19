package com.bhavaniprasad.paypaypal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {
    TextView textid,textamount,textstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        textid=findViewById(R.id.textid);
        textamount=findViewById(R.id.textamount);
        textstatus=findViewById(R.id.textstatus);

        Intent intent = getIntent();
        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("paymentdetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("paymentamount"));
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentamount) {
            try{
                textid.setText(response.getString("id"));
                textstatus.setText(response.getString("state"));
                textamount.setText(response.getString(String.format("$%s",paymentamount)));
            }
            catch (JSONException e){
                e.printStackTrace();
            }
    }
}
