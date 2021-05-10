package com.hllbr.navigationjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button2);
        //Bu fragment için bir adet textView tanımlamıştım diğer alandan farklı olarak onuda tanımlamam gerekiyorki işlemlerime devam edebileyim.
        TextView textView = view.findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Butona tıklandğında gerçekleşmesini istediğim işlemleri bu alanda belirtmeliyim
                //İşlemleri direkt olarak bu alanda gerçekleştirebilirim yada bu aladna Onclick için yazdığım metodu ifade edebilir ve işlemlerimi o metodun altına yazabilrim.
                //ben metodu bu alanda çağırmayı ve işlemleri metodun içiner yazmayı tercih ediyorum karışıklıkları önlemek amacıyla
                goToFirst(view);
            }
        });
       // getArguments()//getArguments bize bir bilgi bohçası döndürüyor bunların arasında benim istediğim age bilgiside bulunuyor.bu ifade bize null de dönebilir içinin boş olma durumu da söz konusu bu üzden sogu ile işlem yapıyorum

    if(getArguments() != null){
        int age = SecondFragmentArgs.fromBundle(getArguments()).getAge();
        //veriyi alabildiğime göre artık yansıtmam gerekiyor.
        textView.setText("Age : "+age);
    }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
    public void goToFirst(View view){
        NavDirections action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
        Navigation.findNavController(view).navigate(action);

    }
}
//Nvigationu esas kullanma sebebimiz veri aktarımındaki kolaylıkları keşfetmektir.
//biz bu alandan diğer alana age yani yaş verisi göndermek istiyorsak oluşturduğumuzmy_graph altında second activity'e tıklasyıp ardından argument sekmesine gitmeli ve argüman ekleyi seçmeliyiz
//daha sonra ise ne göndsermek istediğimizi verisnin cinsini seçmeli ve devam etmeliyiz.
//Navigation yapısının amacı işlemleri gösreselleştirerek işlem kolaylığı sağlamaktır.
