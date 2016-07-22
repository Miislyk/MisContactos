package com.miislyk.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewTelefono;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(actionBar);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");

        textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        textViewTelefono = (TextView) findViewById(R.id.textViewTelefono);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);

        textViewNombre.setText(nombre);
        textViewTelefono.setText(telefono);
        textViewEmail.setText(email);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void llamar(View v) {
        String telefono = textViewTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    public void enviarMail(View v) {

        String email = textViewEmail.getText().toString();
        Intent emaiIntent = new Intent(Intent.ACTION_SEND);
        emaiIntent.setData(Uri.parse("mailto:"));
        emaiIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emaiIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emaiIntent, "Email"));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }
}
