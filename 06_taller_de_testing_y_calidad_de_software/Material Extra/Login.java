package com.example.hp.cesfam;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.hp.cesfam.R.id.txtPass2;


public class Login extends AppCompatActivity {
    private EditText rut,pass;
    TextView recoverpass;
    String txtRut, txtPass;
    Button registro, Login;
    UserSessionManager sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            sesion=new UserSessionManager(getApplicationContext());

            ControllerActivity.actividadActual=this;
            setContentView(R.layout.activity_login);

            rut= findViewById(R.id.txtRut2);
            pass=findViewById(txtPass2);
            recoverpass=findViewById(R.id.olvidar);

            registro= findViewById(R.id.btnRegistro);
            registro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startIntent = new Intent(getApplicationContext(), Registro.class);
                    startActivity(startIntent);
                }
            });
            Login= findViewById(R.id.btnLogin);
            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Login();
                }
            });
            recoverpass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getApplicationContext(),RestablecerPass.class);
                    startActivity(i);
                }
            });

        }
        catch (Exception e)
        {
            String m = e.getMessage();
            Log.d("Error","Error: "+e.getMessage());
        }

    }
    public void dialogo(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setCancelable(true);
        alertDialog.setMessage("Datos Incorrectos");
        alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                pass.setText("");
                rut.setText("");
            }
        });
        AlertDialog alertDialog1=alertDialog.create();
        alertDialog1.show();
    }
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void Login(){
        inicializar(); //hace la llamada cuando el boton guardar es pinchado para validar los datos ingresados
        if(!validar()){
            Toast.makeText(this,"El registro ha fallado", Toast.LENGTH_SHORT).show();
        }
        else{

            JSONObject parametros = new JSONObject();
            try {
                parametros.put("rut", txtRut);
                parametros.put("password", txtPass);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new LoginClass.ValidarSesion().execute(parametros.toString());

        }

    }


    public boolean validar(){
        boolean valido=true;
        if(txtRut.isEmpty()){
            rut.setError("Rut invalido");
            valido=false;
        }
        if(txtRut.length()<9 || txtRut.length()>10){
            rut.setError("Debe ingresar un Rut valido");
            valido=false;
        }
        if(txtPass.isEmpty()){
            pass.setError("Ingrese contraseña");
            valido=false;
        }
        return valido;
    }
    public void inicializar(){
        txtRut=rut.getText().toString();
        txtPass= pass.getText().toString();

    }

    public  void recibirMensajeValdiacion(JSONObject mensaje)
    {
        try{
            String status=mensaje.getString("status");
            String data=mensaje.getString("paciente");


            JSONObject mainObject = new JSONObject(data);
            String id=mainObject.getString("idpaciente");
            String idestado=mainObject.getString("estado");


            if(status.equals("true")){

               Intent startIntent = new Intent(getApplicationContext(), Inicio.class);
               startActivity(startIntent);
               sesion.createUserLoginSession(id);
               sesion.createIdEstado(idestado);


            }

        }
        catch (Exception e){
            e.printStackTrace();
            dialogo();
        }//"status":true,"data":"Paciente fue agregado exitosamente"*/

    }
}


