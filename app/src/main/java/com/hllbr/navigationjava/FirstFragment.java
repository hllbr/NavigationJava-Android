package com.hllbr.navigationjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {
    /**Amacım bu alana girtilen bilgileri diğer alandan almak ilk projeden farklı olarak bu alanda buton da kullanmak
     *
     */
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Fragment içerisinde görünümler oluşturulduktan sonra çağrılacak metoddur.
        //Görünümleri bu alan çağrılmadan yazarsam uygulamam o görünümü tanımayabilir.Uygulamam çökebilir yada farklı sonuçlarla karşılaşabilirim.

        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button);
        //onClick methodunu alt satırdaki şekliyle yapmak en sağlıklı yönyem bizim için
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tıklandığında ne yapılasını istiyorsam bu alana yazamam yeterli olacaktır.
                goToSecond(view);//bizden bir adet görünüm isteniyor bu yapı için ve bizde bu yapıyoa görünüm olarak view'i parametre olarak verebilirim
            }
        });

    }
    //Bu alanda ayrı bir metod tanımlamak yerine bir adet dinleyici tanımlayarak işlemlerimizi yapmak daha mantıklı oalcağı için bir dinleyici tanımlamayı tercih ettim

    public void goToSecond(View view){
/*
Fragmentlarda buton OnClick yazıldığında aktifleşmiş gibi bit görünüm olmuyor .Burada onViewCreated çağırmalıyım öncelikle
 */
       // NavDirections action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();//İntentin fragmentlar için evrilmiş hali oalrak düşünebiliriz.
        FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        action.setAge(50);
        Navigation.findNavController(view).navigate(action);
        //burada kullandığımız yöntemin bir alternatifi daha bulunuyor bu yöntemler üzerinde sürekli etkin olarak değişiklikler yapıldığı için .
        //biz burdan veriyi yolluyarak diğer ekranda karşılamak istiyoruz
    }
}