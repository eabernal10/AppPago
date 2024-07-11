package com.example.pago;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_total;
    private EditText edt_numero;
    private EditText edt_otros;
    private RadioGroup rgrupo;
    private Button btn_calcular;
    private Button btn_salir;
    private TextView txtPropina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //ENLAZAMOS LOS CONTROLES
        edt_total= (EditText) findViewById(R.id.edt_total);
        edt_numero= (EditText) findViewById(R.id.edt_numero);
        edt_otros= (EditText) findViewById(R.id.edt_otros);
        rgrupo= (RadioGroup) findViewById(R.id.rgrupo);
        btn_calcular= (Button) findViewById(R.id.btn_calcular);
        btn_salir= (Button) findViewById(R.id.btn_salir);
        txtPropina= (TextView) findViewById(R.id.txtPropina);
        btn_calcular.setOnClickListener(this);
        btn_salir.setOnClickListener(this);

        rgrupo.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.r15 || checkedId == R.id.r20) {
            edt_otros.setText("");
            edt_otros.setEnabled(false);
            }
            if (checkedId == R.id.rotros) {
                edt_otros.setText("");
                edt_otros.setEnabled(true);
                edt_otros.requestFocus();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_calcular:
                int radioCheckedId = rgrupo.getCheckedRadioButtonId();
                if (radioCheckedId==R.id.r15)
                {
                    txtPropina.setText(Double.parseDouble(edt_total.getText().toString())*0.15+"");
                }
                if (radioCheckedId==R.id.r20)
                {
                    txtPropina.setText(Double.parseDouble(edt_total.getText().toString()) * 0.20 + "");
                }
                if (radioCheckedId==R.id.rotros)
                {
                    txtPropina.setText(Double.parseDouble(edt_total.getText().toString()) *
                            (Double.parseDouble(edt_otros.getText().toString()) / 100) + "");
                }
                break;
            case R.id.btn_salir:
                finish();
                break;
        }
    }

}
