package com.project.stockapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    // Constants:
    // TODO: Create the base URL
    private final String ALPHA_VINTAGE_URL = "https://www.alphavantage.co/query";

    // Member Variables:
    TextView mPriceTextView;
    Button mTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceTextView = (TextView) findViewById(R.id.priceLabel);
        mTestButton = (Button) findViewById(R.id.go_get_it_button);

        // TODO: Set an OnItemSelected listener on the spinner
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hardcode for now when calling function
                RequestParams params = new RequestParams();
                params.put("function", "TIME_SERIES_INTRADAY");
                params.put("symbol", "MSFT");
                params.put("interval", "1min");
                params.put("apikey", "WKU9BI51SRFH9VW6");
                letsDoSomeNetworking(ALPHA_VINTAGE_URL, params);
            }
        });
    }

    // TODO: complete the letsDoSomeNetworking() method
    private void letsDoSomeNetworking(String url, RequestParams params) {

        AlphaVantageApiClient.get(url, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
//                Log.d("StockApp", "JSON: " + response.toString());
                try {
                    JSONObject metaObject = response.getJSONObject("Meta Data");
                    String symbol = metaObject.getString("2. Symbol");
                    String lastRefreshed = metaObject.getString("3. Last Refreshed");

                    Log.d("StockApp", "symbol: " + symbol);
                    Log.d("StockApp", "high: " + lastRefreshed);
                    Log.d("StockApp", "Dorina: Gay as fuck");


//                updateUI
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


    }


}
