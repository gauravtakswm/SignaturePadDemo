package gauravtak.signaturepadandroiddemo.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


import gauravtak.signaturepadandroiddemo.R;
import gauravtak.signaturepadandroiddemo.custom_views.SignatureView;

public class SignatureActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout layout;
    private Context context;
    private SignatureView mSignature;
    private Button btnChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        context = this;
        initViews();
     }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_change_color:
                showAlertDialogOfColors();
                break;
        }
    }



    private void initViews() {
        mSignature = findViewById(R.id.signature_view);
        mSignature.setBackgroundColor(Color.WHITE);
        mSignature.setSignatureColor(Color.BLACK); //  by default color is set as Black
        btnChangeColor = (Button)findViewById(R.id.btn_change_color);
        btnChangeColor.setOnClickListener(this);

    }
    public void showAlertDialogOfColors() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true); // using true property, alert dialog can be cancelled using other touches of layout or witth back click
        builder.setTitle(getString(R.string.alert_title_choose_color_for_signature))
                .setItems(R.array.colors_list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                       setColorOfsignature(which);

                    }
                });

        builder.show();


    }

    private void setColorOfsignature(int which) {

       int colorValue = Color.BLACK;
       switch (which)
        {
            case 0:
                colorValue = Color.BLACK; // standard black android color
                break;
            case 1:
                colorValue = Color.RED; // standard red android color
                break;
            case 2:
                colorValue = Color.GREEN; // standard green android color
                break;
            case 3:
                colorValue = Color.BLUE; // standard blue android color
                break;
            case 4:
                colorValue = ContextCompat.getColor(context, R.color.colorLightSky);
                // custom light sky blue  color
                break;
            case 5:
                colorValue = ContextCompat.getColor(context,R.color.colorDarkSky); // custom dark sky blue  color
                break;
            default:
                    colorValue = Color.BLACK;

        }
        mSignature.setSignatureColor(colorValue);
    }
}
