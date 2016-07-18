package com.repolho.truco.truco;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.repolho.truco.truco.domain.Pontos;
import com.repolho.truco.truco.util.Constants;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTxtSomaUmPontoNos;
    private TextView mTxtPontosNos;
    private TextView mTxtSubtraiUmPontoNos;

    private TextView mTxtBoisNos;
    private TextView mTxtBoisEles;

    private TextView mTxtSomaUmPontoEles;
    private TextView mTxtPontosEles;
    private TextView mTxtSubtraiUmPontoEles;


    private LinearLayout mTxtTabelaNosSoma3;
    private LinearLayout mTxtTabelaNosSoma6;
    private LinearLayout mTxtTabelaNosSoma9;
    private LinearLayout mTxtTabelaNosSoma12;
    private LinearLayout mTxtTabelaNosSubtrai3;
    private LinearLayout mTxtTabelaNosSubtrai6;


    private LinearLayout mTxtTabelaElesSoma3;
    private LinearLayout mTxtTabelaElesSoma6;
    private LinearLayout mTxtTabelaElesSoma9;
    private LinearLayout mTxtTabelaElesSoma12;
    private LinearLayout mTxtTabelaElesSubtrai3;
    private LinearLayout mTxtTabelaElesSubtrai6;

    private LinearLayout mTxtMaoDeOnzeEles;
    private LinearLayout mTxtMaoDeOnzeNos;

    private GridLayout mContentTabelaNos;
    private GridLayout mContentTabelaEles;

    private Pontos mPontos;
    public static final String EXTRA_PONTOS = "com.repolho.truco.truco.mainactivity.EXTRA_PONTOS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null){
            mPontos = savedInstanceState.getParcelable(EXTRA_PONTOS);
        }

        initViews();


        mPontos = new Pontos(
                0,
                0,
                0,
                0
        );

        updateUI();

        setupListeners();

    }

    private void setupListeners() {
        mTxtPontosNos.setOnClickListener(this);
        mTxtPontosEles.setOnClickListener(this);

        mTxtSomaUmPontoNos.setOnClickListener(this);
        mTxtSomaUmPontoEles.setOnClickListener(this);

        mTxtSubtraiUmPontoNos.setOnClickListener(this);
        mTxtSubtraiUmPontoEles.setOnClickListener(this);

        mTxtTabelaNosSoma3.setOnClickListener(this);
        mTxtTabelaNosSoma6.setOnClickListener(this);
        mTxtTabelaNosSoma9.setOnClickListener(this);
        mTxtTabelaNosSoma12.setOnClickListener(this);
        mTxtTabelaNosSubtrai3.setOnClickListener(this);
        mTxtTabelaNosSubtrai6.setOnClickListener(this);

        mTxtTabelaElesSoma3.setOnClickListener(this);
        mTxtTabelaElesSoma6.setOnClickListener(this);
        mTxtTabelaElesSoma9.setOnClickListener(this);
        mTxtTabelaElesSoma12.setOnClickListener(this);
        mTxtTabelaElesSubtrai3.setOnClickListener(this);
        mTxtTabelaElesSubtrai6.setOnClickListener(this);

    }

    private void initViews() {
        mTxtPontosNos = (TextView)findViewById(R.id.txtPontosNos);
        mTxtPontosEles = (TextView)findViewById(R.id.txtPontosEles);

        mTxtBoisNos = (TextView)findViewById(R.id.txtBoisNos);
        mTxtBoisEles = (TextView)findViewById(R.id.txtBoisEles);

        mTxtSomaUmPontoNos = (TextView)findViewById(R.id.txtSomaUmNos);
        mTxtSomaUmPontoEles = (TextView)findViewById(R.id.txtSomaUmEles);

        mTxtSubtraiUmPontoNos = (TextView)findViewById(R.id.txtSubstraiUmNos);
        mTxtSubtraiUmPontoEles = (TextView)findViewById(R.id.txtSubstraiUmEles);

        mTxtTabelaNosSoma3 = (LinearLayout)findViewById(R.id.txt_tabela_nos_soma_3);
        mTxtTabelaNosSoma6 = (LinearLayout)findViewById(R.id.txt_tabela_nos_soma_6);
        mTxtTabelaNosSoma9 = (LinearLayout)findViewById(R.id.txt_tabela_nos_soma_9);
        mTxtTabelaNosSoma12 = (LinearLayout)findViewById(R.id.txt_tabela_nos_soma_12);
        mTxtTabelaNosSubtrai3 = (LinearLayout)findViewById(R.id.txt_tabela_nos_subtrai_3);
        mTxtTabelaNosSubtrai6 = (LinearLayout)findViewById(R.id.txt_tabela_nos_subtrai_6);

        mTxtTabelaElesSoma3 = (LinearLayout)findViewById(R.id.txt_tabela_eles_soma_3);
        mTxtTabelaElesSoma6 = (LinearLayout)findViewById(R.id.txt_tabela_eles_soma_6);
        mTxtTabelaElesSoma9 = (LinearLayout)findViewById(R.id.txt_tabela_eles_soma_9);
        mTxtTabelaElesSoma12 = (LinearLayout)findViewById(R.id.txt_tabela_eles_soma_12);
        mTxtTabelaElesSubtrai3 = (LinearLayout)findViewById(R.id.txt_tabela_eles_subtrai_3);
        mTxtTabelaElesSubtrai6 = (LinearLayout)findViewById(R.id.txt_tabela_eles_subtrai_6);

        mTxtMaoDeOnzeEles = (LinearLayout)findViewById(R.id.item_mao_de_onze_eles);
        mTxtMaoDeOnzeNos = (LinearLayout)findViewById(R.id.item_mao_de_onze_nos);

        mContentTabelaNos = (GridLayout)findViewById(R.id.item_tabela_pontos_nos);
        mContentTabelaEles = (GridLayout)findViewById(R.id.item_tabela_pontos_eles);

    }

    private void updateUI() {
        mTxtPontosNos.setText(
                String.valueOf(mPontos.getNos())
        );
        mTxtPontosEles.setText(
                String.valueOf(mPontos.getEles())
        );

        mTxtBoisNos.setText(
                String.valueOf(mPontos.getBoisNos())
        );
        mTxtBoisEles.setText(
                String.valueOf(mPontos.getBoisEles())
        );


        mContentTabelaNos.setVisibility(View.VISIBLE);
        mContentTabelaEles.setVisibility(View.VISIBLE);
        mTxtMaoDeOnzeNos.setVisibility(View.GONE);
        mTxtMaoDeOnzeEles.setVisibility(View.GONE);

        if(mPontos.getNos() == 11 ){
            mTxtMaoDeOnzeNos.setVisibility(View.VISIBLE);
            mContentTabelaNos.setVisibility(View.GONE);
        }

        if(mPontos.getEles() == 11 ){
            mTxtMaoDeOnzeEles.setVisibility(View.VISIBLE);
            mContentTabelaEles.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /*Click Pontos*/
            case R.id.txtPontosNos:
                mPontos.somaNos(Constants.PONTOS_NORMAL);
                break;
            case R.id.txtPontosEles:
                mPontos.somaEles(Constants.PONTOS_NORMAL);
                break;
            /*Click action + */
            case R.id.txtSomaUmNos:
                mPontos.somaNos(Constants.PONTOS_NORMAL);
                break;
            case R.id.txtSomaUmEles:
                mPontos.somaEles(Constants.PONTOS_NORMAL);
                break;
            /*Click action - */
            case R.id.txtSubstraiUmNos:
                mPontos.subtraiNos(Constants.PONTOS_NORMAL);
                break;
            case R.id.txtSubstraiUmEles:
                mPontos.subtraiEles(Constants.PONTOS_NORMAL);
                break;
            /*Click tabela nos*/
            case R.id.txt_tabela_nos_soma_3:
                mPontos.somaNos(Constants.PONTOS_TRUCO);
                break;
            case R.id.txt_tabela_nos_soma_6:
                mPontos.somaNos(Constants.PONTOS_SEIS);
                break;
            case R.id.txt_tabela_nos_soma_9:
                mPontos.somaNos(Constants.PONTOS_NOVE);
                break;
            case R.id.txt_tabela_nos_soma_12:
                mPontos.somaNos(Constants.PONTOS_DOZE);
                break;
            case R.id.txt_tabela_nos_subtrai_3:
                mPontos.subtraiNos(Constants.PONTOS_TRUCO);
                break;
            case R.id.txt_tabela_nos_subtrai_6:
                mPontos.subtraiNos(Constants.PONTOS_SEIS);
                break;
            /*Click tabela nos*/
            case R.id.txt_tabela_eles_soma_3:
                mPontos.somaEles(Constants.PONTOS_TRUCO);
                break;
            case R.id.txt_tabela_eles_soma_6:
                mPontos.somaEles(Constants.PONTOS_SEIS);
                break;
            case R.id.txt_tabela_eles_soma_9:
                mPontos.somaEles(Constants.PONTOS_NOVE);
                break;
            case R.id.txt_tabela_eles_soma_12:
                mPontos.somaEles(Constants.PONTOS_DOZE);
                break;
            case R.id.txt_tabela_eles_subtrai_3:
                mPontos.subtraiEles(Constants.PONTOS_TRUCO);
                break;
            case R.id.txt_tabela_eles_subtrai_6:
                mPontos.subtraiEles(Constants.PONTOS_SEIS);
                break;

            default:
                return;
        }

        verificaTotalPontos();

        updateUI();
    }

    private void verificaTotalPontos() {
        boolean terminou = false;

        if(mPontos.getNos() >= 12 ){
            showToast("Nós ganhamos");
            mPontos.somaBoiNos(1);
            terminou = true;
        }

        if(mPontos.getEles() >= 12 ){
            showToast("Eles ganharam");
            mPontos.somaBoiEles(1);
            terminou = true;
        }

        if(terminou){
            mPontos.setEles(0);
            mPontos.setNos(0);
        }

        return;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_daily_message:
                showToast("menu_daily_message");
                break;
            case R.id.menu_instrucoes:
                showToast("menu_instrucoes");
                break;
            case R.id.menu_historico:
                showToast("menu_historico");
                break;
            case R.id.menu_restart:
                RestartDialog cdd = new RestartDialog(MainActivity.this);
                //cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
                break;
            case R.id.menu_sobre:
                showToast("menu_sobre");
                break;
            case R.id.menu_sugestao:
                showToast("menu_sugestao");
                break;
            default:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showToast(String message) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putParcelable(EXTRA_PONTOS,mPontos);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
