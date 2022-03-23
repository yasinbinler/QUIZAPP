package com.odev.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Question extends AppCompatActivity {
    Button sika, sikb, sikc, sikd, geriButon, ileriButon;
    TextView soru, rsoru;
    ImageView soruResmi, rsika, rsikb, rsikc, rsikd;
    ConstraintLayout resimliLayout, dogruLayout;
    int soruNo = 0;
    int isaretSik = 0, zekaPuan;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int[] sikSecimleri = new int[46];
    Gson gson;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        if(sharedPreferences.getBoolean("ilkgiris",false)==false)
        sikSecimleri = gson.fromJson(sharedPreferences.getString("json", ""), int[].class);

        final ArrayList<Questions> zekaSorulari = new ArrayList();

        zekaSorulari.add(new Questions("1)\t12,89,1516,2223,2930\n" +
                "Sıradaki sayı aşağıdakilerden hangisi olmalıdır?\n", "3435", "3534", "3637", "3738", false, false, 1, 12));
        zekaSorulari.add(new Questions("2) aşağıdaki sayılardan hangisi diğerlerinden farklıdır?", "1855", "2962", "3664", "5841", false, false, 4, 8));
        zekaSorulari.add(new Questions("3) 37,34,28,19,?  Soru işaretli olan yere hangisi gelmelidir? ", "4", "7", "10", "11", false, false, 2, 5));
        zekaSorulari.add(new Questions("4) bir toplantıda 11 kişi birbiriyle el sıkışmıştır. Toplam kaç el sıkışma gerçekleşmiştir? ", "110", "100", "55", "45", false, false, 3, 11));
        zekaSorulari.add(new Questions("5) “YLİAMVMAEKZ”  karışık harflerle düzenli bir kelime oluşturulursa bu ne anlama gelirdi? ", "Damar İsmi", "ideoloji", "kuş türü", "Din", false, false, 2, 13));
        zekaSorulari.add(new Questions("6) “NLAERT”  karışık harflerle düzenli bir kelime oluşturulursa bu ne anlama gelirdi?", "kuş türü", "sebze", "spor aleti", "ev eşyası", false, false, 1, 10));
        zekaSorulari.add(new Questions("7) hangi sayı gruba uymamaktadır? ", "158", "44", "65", "2", true, false, 3, 8));

        zekaSorulari.add(new Questions("8) aşağıdaki kelimerden hangisi gruptaki diğer kelimelere en uzak anlamlıdır? ", "tutsak", "mahsur", "esir", "köle", false, false, 2, 12));
        zekaSorulari.add(new Questions("9) Eda kendisine yapılan ‘ Bilim kurgu filmlerinden hiç hoşlanmaz’\n eleştirisi üzerine şunları söyler: \n‘bilim kurgu filmlerinden hiç hoşlanmadığım kanısına varmışsınız. \nMadem öyle, onca dvd yi öylesine mi almışımdır sizce?' Yukarıdaki metne göre hangisi doğrudur?\n" +
                "Eda bilim kurgu filmlerini, \n", "Sevmediğini söylemiştir", "sevdiğini ima etmiştir", "sevdiğini söylemiştir", "sevmediğini ima etmiştir", false, false, 2, 7));
        zekaSorulari.add(new Questions("10)Her ne kadar zekanın tamamen kalıtsal olduğu düşünülse de, \nyapılan araştırmalar bu bilgiği çürütür niteliktedir.\n Araştırmalar göstermiştir ki, genetik faktörler kadar olmasa da \nçevresel faktörler de zekanın oluşumunda büyük rol oynamaktadır. \n" +
                "Zekanın oluşumunda etkenler ile ilgili  verilen oranlardan hangisi yukarıdaki metin ile uyumludur?", ")%100 kalıtımsal", ")%50 çevresel, %50 kalıtımsal", "%70 kalıtımsal, %30 çevresel  ", "%60 çevresel, %40 kalıtımsal", false, false, 3, 9));
        zekaSorulari.add(new Questions("11)aşağıdakilerden hangisi farklıdır? (tüm kareler eşit olarak düşünülsün.", "sorusika", "sorusikb", "sorusikc", "sorusikd", false, true, 2, 5));

        zekaSorulari.add(new Questions("12)Soru işaretli yere hangisi gelmelidir?", "sorusika1", "sorusikb1", "sorusikc1", "sorusikd1", true, true, 2, 15));
        zekaSorulari.add(new Questions("13) 1=4, 2=16,  3=64,  4=?", "110", "128", "228", "256", false, false, 4, 12));
        zekaSorulari.add(new Questions("14)9-3÷1/3+1 işleminin sonucu kaçtır?", "0", "1", "8", "9", false, false, 2, 15));
        zekaSorulari.add(new Questions("15) Soru işaretli yere hangisi gelmelidir?", "5", "7", "8", "9", true, false, 4, 8));
        zekaSorulari.add(new Questions("1. Önce güçlü yönlerinden başlayalım. Bir bütün olarak ele aldığımızda hangi şık sana en çok uyan özellikleri içinde barındırıyor?", "A)Neşeli, Cesur, İyimser", "b)İradeli, Maceraperest, Lider", "c)Fedakâr, Duyarlı, İnce düşünceli", "D)Barışçıl, Uysal, Sabırlı", false, false, 0));
        zekaSorulari.add(new Questions("2. İnsanlarla olan ilişkini nasıl tanımlarsın?", "a)İnsanlarla genellikle çabuk kaynaşan, sosyal biriyim.", "b)İnsanlara genellikle liderlik eden, dobra biriyim.", "C)İnsanlara genellikle yol gösteren, idealist biriyim.", "D)İnsanlara genellikle uyum sağlayan, çekingen biriyim.", false, false, 0));
        zekaSorulari.add(new Questions("3. Biraz da zayıf yönlerinden bahsedelim... Sana en uygun olan özellik grubunu seç bakalım.", "a)Kolay sinirlenen, Ne yapacağı belirsiz, Disiplinsiz", "b)Sabırsız, Dik kafalı, Sinirli", "c)Kinci, Karamsar, Huysuz", "d)Donuk, Kuşkulu, Miskin", false, false, 0));
        zekaSorulari.add(new Questions("4. İş ya da okul yaşantında nasıl biri olduğunu soralım öyleyse?", "a)Yaratıcı ve renkli fikirleri olan ve işine/okuluna dört elle sarılan", "b)Yüksek standartları olan, mükemmeliyetçi ve düzenli", "c)Daima hedefleri olan, iyi organize olmuş ve zorluklar karşısında yılmayan", "d)Kolay yollar bulabilen, düzenli ve anlaşmazlıkları önleyebilen", false, false, 0));
        zekaSorulari.add(new Questions("5. Peki ya en yakın arkadaşınla arandaki ilişki neye dayanıyor sence?", "a)Aramızdaki olağanüstü iletişime.", "b)Şefkate ve güvene.", "c)Birbirimizi idare etmeye.", "d)Eğlenceye.", false, false, 0));
        zekaSorulari.add(new Questions("6. Peki biraz da seni ebeveyn olarak düşünelim. Çocuğun varsa ya da ileride olursa, ona nasıl bir ebeveyn olursun?", "a)Onunla arkadaş gibi olurum. Eğlenceli bir ebeveyn olacağımdan hiç şüpheniz olmasın!", "b)Çocuğumu daima yetenekleri ve bilgi edinmesi konusunda cesaretlendiren bir ebeveyn olurum.", "c)Çocuklarımı daima organize eder, onlara doğruyu ve yanlışı gösteririm. Sonuçta onlara birinin yol göstermesi gerekiyor!", "d)Onlara daima zaman ayıran iyi bir ebeveyn olurum.", false, false, 0));
        zekaSorulari.add(new Questions("7. Sonlara doğru yaklaşıyoruz... Olumsuz durumlar karşısında nasıl bir tavır takınırsın?", "a)Hiçbir şey moralimi bozamaz. Kasvetli bir günü bile neşelendiririm!", "b)Sinirlerim bozulur, istemeden de olsa insanları kırmaya başlarım.", "c)Hemen karamsar bir havaya bürünürüm! Bütün olumsuzluklar da beni bulur zaten.", "d)Başlarda kaygılanırım ancak zamanla o eski kayıtsız hâlime dönerim.", false, false, 0));
        zekaSorulari.add(new Questions("8. Son soruya da cevap ver, sana karakter tipini söyleyelim artık... Sence kişinin karakterini bunlardan hangisi daha çok etkiler?", "a)Genetik özellikler tabii ki de.", "b)Tabii ki de içinde yetişilen aile faktörü.", "c)Yaşanılan çevre.", "d)Hepsi aynı derecede etkiliyor bence.", false, false, 0));
        zekaSorulari.add(new Questions("1)Hangisi hayalindeki çalışma sistemi?", "a)Maaşı bileyim, sigortam olsun ", "b)Değişken maaş sistemi, sigorta halledilir ", "c)Ne ekersem onu biçeyim", "", false, false, 0));
        zekaSorulari.add(new Questions("2)İş yerinin hangi vaadi daha çekici?", "a)Şirket arabası", "b)Düzenli şehir dışı toplantıları", "c)Düzenli yurt dışı eğitimleri", "", false, false, 0));
        zekaSorulari.add(new Questions("3)Hangisine para vermek seni daha çok yaralar?", "a)Taksiye", "b)Otoparka", "c)Tuvalete", "", false, false, 0));
        zekaSorulari.add(new Questions("4)Balayına nereye gitmek istersin?", "a)Burdur dışında herhangi bir yer", "b)Tayland", "c)Amerika", "", false, false, 0));
        zekaSorulari.add(new Questions("5)Hangi sistem sence daha güzel?", "a)Komünizm", "b)Sosyalizm", "c)Liberalizm", "", false, false, 0));
        zekaSorulari.add(new Questions("6)Hangisi asla yapmam dediğin şeylerden biri?", "a)Vejetaryen olmak", "b)Memur olmak", "c)Tekdüze yaşamak", "", false, false, 0));
        zekaSorulari.add(new Questions("7)Hangi şekilde zengin olma şansın daha yüksek dersin?", "a)Ya ne zengin olması ya", "b)Şans oyunlarıyla", "c)Güzel bir fikirle", "", false, false, 0));
        zekaSorulari.add(new Questions("1)Cinsiyetini öğrenerek testimize başlayalım, ne dersin?", "a)kız", "b)erkek", "", "", false, false, 0));
        zekaSorulari.add(new Questions("2)İşe/okula geç kaldın, acilen evden çıkman lazım, kapının önüne geldin ne yapardın?", "a)Tişörtümdeki lekeyi fark eder, çıkartıp tersten giyerdim", "b)Dönüp ütüyü fişten çekip çekmediğime bakardım", "c)Atımı hazırla efendi! Diye kapıcıya seslenirdim", "", false, false, 0));
        zekaSorulari.add(new Questions("3)Yol kenarında ağlayan minnoş bir çocuk gördün. Ee bir şey yapmayacak mısın?", "a)Bakkaldan bir çikolata alıp çocuğa veririm", "b)Susması için 4.5 TL teklif eder, kabul etmezse 5 TL ile işi bağlardım", "c)Çocuktur ağlar derim, çok üstüne düşmem", "", false, false, 0));
        zekaSorulari.add(new Questions("4)Cebinde 100 TL paran kaldı, ay başınaysa 14586248577 gün. Ama arkadaşların hafta sonu seni çağırıyor?", "a)Yok, sağ olun ben yedim de geldim", "b)Bir uğrarım ama çok kalamam bak", "c)Yanarlı dönerli meyve tabağı da söyler miyiz?", "", false, false, 0));
        zekaSorulari.add(new Questions("5)Sevgili dediğin...", "a)Çılgın olacak, bir gün orda bir gün burada delirmeceler yapabilecek", "b)Ağırbaşlı olacak, ayakları yere basacak, güven verecek", "c)Nefes alacak", "", false, false, 0));
        zekaSorulari.add(new Questions("6)En büyük yeteneğin ne peki?", "a)Asgari ücretle hayatta kalabiliyorum", "b)Akraba dırdırlarını meditasyon gücüyle yok ödebiliyorum", "c)Hayatta kimseye aldırmadan çok yükseklerden uçabiliyorum", "", false, false, 0));
        zekaSorulari.add(new Questions("7)Ve son soru: Düğününü nerede yapacaksın?", "a)Lorke düğün salonunda", "b)Sakin bir deniz kıyısında", "c)Kır düğünü iyidir ya", "", false, false, 0));
        zekaSorulari.add(new Questions("1)Favori meyven hangisidir?", "elma  ", "karpuz", "portakal", "muz", false, false, 0));
        zekaSorulari.add(new Questions("2)Bize gülüşünü tarif edebilir misin?", "a)Katıla katıla", "B)Küçük ve sevimli", "c)Ne gülmesi?", "", false, false, 0));
        zekaSorulari.add(new Questions("3)Dans ederken vücudun nerden hareket etmeye başlar?", "a)Kollarımdan", "b)Belimden", "c)Bacaklarımdan", "", false, false, 0));
        zekaSorulari.add(new Questions("4)Aşağıdaki çiçeklerden birini bizim için seçer misin?", "a)Gül", "b)Papatya", "c)Menekşe", "", false, false, 0));
        zekaSorulari.add(new Questions("5)Haftasonu sinemaya gidecek olsan hangi filmi seçerdin?", "a)Kaptan Amerika", "b)Marslı", "c)Korku Seansı 2", "", false, false, 0));
        zekaSorulari.add(new Questions("6)Ne tür yemeklerden hoşlanırsın?", "b)Hamburger ve pizza", "c)Suşi", "c)Ben veganım", "", false, false, 0));
        zekaSorulari.add(new Questions("7)Aşağıdaki taşlardan hangisi sana göre en güzeli?", "a)Yakut", "b)Altın", "c)Ametist", "", false, false, 0));
        zekaSorulari.add(new Questions("8)Saat akşam 7. Genelde o saatte ne yapıyor olursun?", "a)Meditasyon", "b)Happy Hour", "c)Ofis", "", false, false, 0));
        zekaSorulari.add(new Questions("9)Bu son soru: En sevdiğin tatlı nedir?", "a)Dondurma", "b)Tiramisu", "c)Brovni", "", false, false, 0));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        soru = findViewById(R.id.soru);
        sika = findViewById(R.id.sika);
        sikb = findViewById(R.id.sikb);
        sikc = findViewById(R.id.sikc);
        sikd = findViewById(R.id.sikd);
        soruResmi = findViewById(R.id.soruResmi);
        rsika = findViewById(R.id.rsika);
        rsikb = findViewById(R.id.rsikb);
        rsikc = findViewById(R.id.rsikc);
        rsikd = findViewById(R.id.rsikd);
        rsoru = findViewById(R.id.rsoru);
        geriButon = findViewById(R.id.geriButon);
        ileriButon = findViewById(R.id.ileriButon);
        resimliLayout = findViewById(R.id.resimliLayout);
        dogruLayout = findViewById(R.id.dogruLayout);
        switch (sharedPreferences.getInt("testno", 0)) {
            case 1:
                soruNo = 0;

                break;
            case 3:
                soruNo = 15;

                break;
            case 2:
                soruNo = 23;
                sikd.setVisibility(View.INVISIBLE);
                break;
            case 0:
                soruNo = 30;
                sikc.setVisibility(View.INVISIBLE);
                sikd.setVisibility(View.INVISIBLE);
                break;
            case 4:
                soruNo = 37;

                break;

        }
        ileriButon.setEnabled(false);
        dogruLayout.setVisibility(View.VISIBLE);
        soru.setText(zekaSorulari.get(soruNo).getQuestion());
        sika.setText(zekaSorulari.get(soruNo).getSika());
        sikb.setText(zekaSorulari.get(soruNo).getSikb());
        sikc.setText(zekaSorulari.get(soruNo).getSikc());
        sikd.setText(zekaSorulari.get(soruNo).getSikd());

        geriButon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        geriButon.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        geriButon.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        geriButon.setAlpha(1f);
                        soruNo--;
                        switch (sikSecimleri[soruNo])
                        {
                            case 1:
                                rsikc.setBackgroundColor(Color.GREEN);
                                rsika.setBackgroundColor(Color.TRANSPARENT);
                                rsikb.setBackgroundColor(Color.TRANSPARENT);
                                rsikd.setBackgroundColor(Color.TRANSPARENT);
                                sika.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                                break;
                            case 2:
                                rsikc.setBackgroundColor(Color.TRANSPARENT);
                                rsika.setBackgroundColor(Color.GREEN);
                                rsikb.setBackgroundColor(Color.TRANSPARENT);
                                rsikd.setBackgroundColor(Color.TRANSPARENT);
                                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                                break;
                            case 3:
                                rsikc.setBackgroundColor(Color.TRANSPARENT);
                                rsika.setBackgroundColor(Color.TRANSPARENT);
                                rsikb.setBackgroundColor(Color.GREEN);
                                rsikd.setBackgroundColor(Color.TRANSPARENT);
                                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                                break;
                            case 4:
                                rsikc.setBackgroundColor(Color.TRANSPARENT);
                                rsika.setBackgroundColor(Color.TRANSPARENT);
                                rsikb.setBackgroundColor(Color.TRANSPARENT);
                                rsikd.setBackgroundColor(Color.GREEN);
                                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                break;
                        }
                        if (soruNo == 0 || soruNo == 15 || soruNo == 23 || soruNo == 30 || soruNo == 37) {
                            geriButon.setVisibility(View.INVISIBLE);
                        }
                        if (sharedPreferences.getInt("testno", 0) == 1) {
                            if(sikSecimleri[soruNo]==zekaSorulari.get(soruNo).getDogruCvp())
                            zekaPuan -= zekaSorulari.get(soruNo).getPuan();
                        }
                        if (zekaSorulari.get(soruNo).isAnswerImaged()) {
                            //set button visibility situation
                            sika.setVisibility(View.INVISIBLE);
                            sikb.setVisibility(View.INVISIBLE);
                            sikc.setVisibility(View.INVISIBLE);
                            sikd.setVisibility(View.INVISIBLE);
                            rsika.setVisibility(View.VISIBLE);
                            rsikb.setVisibility(View.VISIBLE);
                            rsikc.setVisibility(View.VISIBLE);
                            rsikd.setVisibility(View.VISIBLE);

                            //set answer button images
                            rsika.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSika(), "drawable", getPackageName())));
                            rsikb.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSikb(), "drawable", getPackageName())));
                            rsikc.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSikc(), "drawable", getPackageName())));
                            rsikd.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSikd(), "drawable", getPackageName())));
                        } else {
                            sika.setVisibility(View.VISIBLE);
                            sikb.setVisibility(View.VISIBLE);
                            sikc.setVisibility(View.VISIBLE);
                            sikd.setVisibility(View.VISIBLE);
                            rsika.setVisibility(View.INVISIBLE);
                            rsikb.setVisibility(View.INVISIBLE);
                            rsikc.setVisibility(View.INVISIBLE);
                            rsikd.setVisibility(View.INVISIBLE);
                            sika.setText(zekaSorulari.get(soruNo).getSika());
                            sikb.setText(zekaSorulari.get(soruNo).getSikb());
                            sikc.setText(zekaSorulari.get(soruNo).getSikc());
                            sikd.setText(zekaSorulari.get(soruNo).getSikd());
                        }
                        if (zekaSorulari.get(soruNo).isQuestionImaged()) {
                            dogruLayout.setVisibility(View.INVISIBLE);
                            resimliLayout.setVisibility(View.VISIBLE);
                            switch (soruNo) {
                                case 6:
                                    soruResmi.setImageDrawable(getResources().getDrawable(R.drawable.tablosoru));
                                    break;
                                case 11:
                                    soruResmi.setImageDrawable(getResources().getDrawable(R.drawable.soruresmi));
                                    break;
                                case 14:
                                    soruResmi.setImageDrawable(getResources().getDrawable(R.drawable.soruresim2));
                                    break;
                            }

                            rsoru.setText(zekaSorulari.get(soruNo).getQuestion());

                        } else {
                            dogruLayout.setVisibility(View.VISIBLE);
                            resimliLayout.setVisibility(View.INVISIBLE);
                            soru.setText(zekaSorulari.get(soruNo).getQuestion());

                        }
                        switch (sharedPreferences.getInt("testno", 0)) {
                            case 0:
                                if(soruNo==30){
                                    sikc.setVisibility(View.INVISIBLE);
                                    sikd.setVisibility(View.INVISIBLE);
                                }else
                                    sikd.setVisibility(View.INVISIBLE);

                                break;
                            case 1:
                                break;
                            case 2:
                                sikd.setVisibility(View.INVISIBLE);
                                break;
                            case 3:
                                break;
                            case 4:
                                if(soruNo!=37)sikd.setVisibility(View.INVISIBLE);
                                else  sikd.setVisibility(View.VISIBLE);

                                break;
                        }
                        ileriButon.setEnabled(true);
                        break;
                }
                return false;
            }
        });

        ileriButon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ileriButon.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ileriButon.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        ileriButon.setAlpha(1f);
                        sikSecimleri[soruNo]=isaretSik;
                        soruNo++;

                        rsikc.setBackgroundColor(Color.TRANSPARENT);
                        rsika.setBackgroundColor(Color.TRANSPARENT);
                        rsikb.setBackgroundColor(Color.TRANSPARENT);
                        rsikd.setBackgroundColor(Color.TRANSPARENT);
                        sika.setBackground(getResources().getDrawable(R.drawable.fon));
                        sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                        sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                        sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                        if (soruNo == 1 || soruNo == 16 || soruNo == 24 || soruNo == 31 || soruNo == 38)
                            geriButon.setVisibility(View.VISIBLE);
                        switch (sharedPreferences.getInt("testno", 0)) {
                            case 0:
                                if (soruNo == 37) {
                                    startActivity(new Intent(Question.this, Sonuc.class));
                                    String json = gson.toJson(sikSecimleri);
                                    editor.putString("json", json);
                                    editor.putBoolean("ilkgiris",false);
                                    editor.commit();
                                    finish();
                                    return true;
                                }
                                break;
                            case 1:
                                if(sikSecimleri[soruNo-1]==zekaSorulari.get(soruNo-1).getDogruCvp())
                                    zekaPuan += zekaSorulari.get(soruNo - 1).getPuan();
                                if (soruNo == 15) {
                                    startActivity(new Intent(Question.this, Sonuc.class));
                                    String json = gson.toJson(sikSecimleri);
                                    editor.putInt("zekaPuan",zekaPuan);
                                    editor.putString("json", json);
                                    editor.putBoolean("ilkgiris",false);
                                    editor.commit();
                                    finish();
                                    return true;
                                }
                                break;
                            case 2:
                                if (soruNo == 30) {
                                    startActivity(new Intent(Question.this, Sonuc.class));
                                    String json = gson.toJson(sikSecimleri);
                                    editor.putString("json", json);
                                    editor.putBoolean("ilkgiris",false);
                                    editor.commit();
                                    finish();
                                    return true;
                                }
                                break;
                            case 3:
                                if (soruNo == 23) {
                                    startActivity(new Intent(Question.this, Sonuc.class));
                                    String json = gson.toJson(sikSecimleri);
                                    editor.putString("json", json);
                                    editor.putBoolean("ilkgiris",false);
                                    editor.commit();
                                    finish();
                                    return true;
                                }
                                break;
                            case 4:
                                if (soruNo == 46) {
                                    startActivity(new Intent(Question.this, Sonuc.class));
                                    String json = gson.toJson(sikSecimleri);
                                    editor.putString("json", json);
                                    editor.putBoolean("ilkgiris",false);
                                    editor.commit();
                                    finish();
                                    return true;
                                }
                                break;
                        }
                        if (zekaSorulari.get(soruNo).isAnswerImaged()) {
                            //set button visibility situation
                            sika.setVisibility(View.INVISIBLE);
                            sikb.setVisibility(View.INVISIBLE);
                            sikc.setVisibility(View.INVISIBLE);
                            sikd.setVisibility(View.INVISIBLE);
                            rsika.setVisibility(View.VISIBLE);
                            rsikb.setVisibility(View.VISIBLE);
                            rsikc.setVisibility(View.VISIBLE);
                            rsikd.setVisibility(View.VISIBLE);

                            //set answer button images
                            rsika.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSika(), "drawable", getPackageName())));
                            rsikb.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSikb(), "drawable", getPackageName())));
                            rsikc.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSikc(), "drawable", getPackageName())));
                            rsikd.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(zekaSorulari.get(soruNo).getSikd(), "drawable", getPackageName())));
                        } else {
                            sika.setVisibility(View.VISIBLE);
                            sikb.setVisibility(View.VISIBLE);
                            sikc.setVisibility(View.VISIBLE);
                            sikd.setVisibility(View.VISIBLE);
                            rsika.setVisibility(View.INVISIBLE);
                            rsikb.setVisibility(View.INVISIBLE);
                            rsikc.setVisibility(View.INVISIBLE);
                            rsikd.setVisibility(View.INVISIBLE);
                            sika.setText(zekaSorulari.get(soruNo).getSika());
                            sikb.setText(zekaSorulari.get(soruNo).getSikb());
                            sikc.setText(zekaSorulari.get(soruNo).getSikc());
                            sikd.setText(zekaSorulari.get(soruNo).getSikd());
                        }
                        if (zekaSorulari.get(soruNo).isQuestionImaged()) {
                            dogruLayout.setVisibility(View.INVISIBLE);
                            resimliLayout.setVisibility(View.VISIBLE);
                            switch (soruNo) {
                                case 6:
                                    soruResmi.setImageDrawable(getResources().getDrawable(R.drawable.tablosoru));
                                    break;
                                case 11:
                                    soruResmi.setImageDrawable(getResources().getDrawable(R.drawable.soruresmi));
                                    break;
                                case 14:
                                    soruResmi.setImageDrawable(getResources().getDrawable(R.drawable.soruresim2));
                                    break;
                            }

                            rsoru.setText(zekaSorulari.get(soruNo).getQuestion());

                        } else {
                            dogruLayout.setVisibility(View.VISIBLE);
                            resimliLayout.setVisibility(View.INVISIBLE);
                            soru.setText(zekaSorulari.get(soruNo).getQuestion());

                        }
                        ileriButon.setEnabled(false);
                        switch (sikSecimleri[soruNo])
                        {
                            case 1:
                                rsikc.setBackgroundColor(Color.GREEN);
                                rsika.setBackgroundColor(Color.TRANSPARENT);
                                rsikb.setBackgroundColor(Color.TRANSPARENT);
                                rsikd.setBackgroundColor(Color.TRANSPARENT);
                                sika.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                                ileriButon.setEnabled(true);
                                break;
                            case 2:
                                rsikc.setBackgroundColor(Color.TRANSPARENT);
                                rsika.setBackgroundColor(Color.GREEN);
                                rsikb.setBackgroundColor(Color.TRANSPARENT);
                                rsikd.setBackgroundColor(Color.TRANSPARENT);
                                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                                ileriButon.setEnabled(true);
                                break;
                            case 3:
                                rsikc.setBackgroundColor(Color.TRANSPARENT);
                                rsika.setBackgroundColor(Color.TRANSPARENT);
                                rsikb.setBackgroundColor(Color.GREEN);
                                rsikd.setBackgroundColor(Color.TRANSPARENT);
                                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                                ileriButon.setEnabled(true);
                                break;
                            case 4:
                                rsikc.setBackgroundColor(Color.TRANSPARENT);
                                rsika.setBackgroundColor(Color.TRANSPARENT);
                                rsikb.setBackgroundColor(Color.TRANSPARENT);
                                rsikd.setBackgroundColor(Color.GREEN);
                                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                                sikd.setBackground(getResources().getDrawable(R.drawable.fonselected));
                                ileriButon.setEnabled(true);
                                break;
                        }
                        switch (sharedPreferences.getInt("testno", 0)) {
                            case 0:
                                if(soruNo==30) {
                                    sikc.setVisibility(View.INVISIBLE);
                                    sikd.setVisibility(View.INVISIBLE);
                                }else sikd.setVisibility(View.INVISIBLE);
                                break;
                            case 1:
                                break;
                            case 2:
                                sikd.setVisibility(View.INVISIBLE);
                                break;
                            case 3:
                                break;
                            case 4:
                                if(soruNo!=37)sikd.setVisibility(View.INVISIBLE);
                                else  sikd.setVisibility(View.VISIBLE);

                                break;
                        }
                        break;
                }
                return true;
            }
        });


/*
        sika.setText(zekaSorulari.get(0).sika);
        sikb.setText(zekaSorulari.get(0).sikb);
        sikc.setText(zekaSorulari.get(0).sikc);
        sikd.setText(zekaSorulari.get(0).sikd);
*/
        rsika.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rsika.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        rsika.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        rsika.setAlpha(1f);
                        isaretSik = 1;
                        ileriButon.setEnabled(true);
                        rsikc.setBackgroundColor(Color.TRANSPARENT);
                        rsika.setBackgroundColor(Color.GREEN);
                        rsikb.setBackgroundColor(Color.TRANSPARENT);
                        rsikd.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        rsikb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rsikb.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        rsikb.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        rsikb.setAlpha(1f);
                        isaretSik = 2;
                        ileriButon.setEnabled(true);
                        rsikc.setBackgroundColor(Color.TRANSPARENT);
                        rsika.setBackgroundColor(Color.TRANSPARENT);
                        rsikb.setBackgroundColor(Color.GREEN);
                        rsikd.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        rsikc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rsikc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        rsikc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        rsikc.setAlpha(1f);
                        isaretSik = 3;
                        ileriButon.setEnabled(true);
                        rsikc.setBackgroundColor(Color.GREEN);
                        rsika.setBackgroundColor(Color.TRANSPARENT);
                        rsikb.setBackgroundColor(Color.TRANSPARENT);
                        rsikd.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        rsikd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rsikd.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        rsikd.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        rsikd.setAlpha(1f);
                        isaretSik = 4;
                        ileriButon.setEnabled(true);
                        rsikc.setBackgroundColor(Color.TRANSPARENT);
                        rsika.setBackgroundColor(Color.TRANSPARENT);
                        rsikb.setBackgroundColor(Color.TRANSPARENT);
                        rsikd.setBackgroundColor(Color.GREEN);

                        break;
                }
                return true;
            }
        });

        sika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isaretSik = 1;
                sika.setBackground(getResources().getDrawable(R.drawable.fonselected));
                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                ileriButon.setEnabled(true);

            }
        });
        sikb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isaretSik = 2;
                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                sikb.setBackground(getResources().getDrawable(R.drawable.fonselected));
                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                ileriButon.setEnabled(true);

            }
        });
        sikc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isaretSik = 3;
                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                sikc.setBackground(getResources().getDrawable(R.drawable.fonselected));
                sikd.setBackground(getResources().getDrawable(R.drawable.fon));
                ileriButon.setEnabled(true);

            }
        });
        sikd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isaretSik = 4;
                sika.setBackground(getResources().getDrawable(R.drawable.fon));
                sikb.setBackground(getResources().getDrawable(R.drawable.fon));
                sikc.setBackground(getResources().getDrawable(R.drawable.fon));
                sikd.setBackground(getResources().getDrawable(R.drawable.fonselected));
                ileriButon.setEnabled(true);

            }
        });

    }
}
