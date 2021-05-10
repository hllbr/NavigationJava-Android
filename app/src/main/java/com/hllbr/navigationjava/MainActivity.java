package com.hllbr.navigationjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//Bu ve benzeri projelerde build sekmesindfe bulunan build Project seçeneğine tıklanarak proje refresh edilmeli bazen uygulama yapılan değişiklikleri görme sorunuyla karşılaıyor sebebi budur bunu yapmamızın

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}