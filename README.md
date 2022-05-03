# LanguageLocalization

Language Localization,anlık dil değişimi yapabildiğiniz bir uygulamadır.
Ek olarak kullanıcının en son seçtiği dili saklayıp uygulama kapatılıp açıldığında en son seçilen dile göre uygulamayı açmayı hedeflemektedir.

Bunları yapabilmek için bilmemiz gerek iki sınıfımız var. Birincisi _Locale_, diğeri ise _SharedPreferences_.

Locale, uygulamızında farklı ülke standartlarını kullanabilmemize olarak sağlayan bir sınıftır
SharedPreferences ise cihaz tabanlı bir veritabanıdır.

SharedPreferences veri tabanında kullanıcının seçtiği dili tutmak ve uygulama tekrar açtıldığında tutulan dili almak için kullanacağız

Locale sınıfı ise uygulamanın dil ayarını değiştirmek için kullanılacaktır.

# Hazırlıklar #

strings.xml dosyalarını oluşturma

1. res > values > new > Values Resource File
2. File name : strings.xml
3. Available qualifiers > Locale > Language > tr

Default olarak gelen strings.xml ingilizce dili için kabul görmektedir. 

Bu değişkenleri kullabilmek için xml dosyasında kullanmak istediğimiz yerelere "@string/değişken_adı" şeklinde eklememiz gerektiğini unutmayın.

Kullandığınız bütün strings.xml dosyalarında aynı string itemlerin olması gerektiğini unutmayın, eğer translate etmek istemiyorsanız bunun için translatable="false" yapmanız yeterlidir.


##### attachBaseContext
Uygulama başlatılırken çalışan override fonsksiyonudur.

Verilen context nesnesine göre uygulamayı oluşturur.

wrapContext fonksiyonu ile daha önce SharedPreferences veritabanına kayıtlı dili alarak contextimizi yanı uygulamamızın kimliğini oluşturuyoruz ve attachBaseContext fonsiyonuna bu context ile uygulamayı başlatmasını istiyoruz

##### Dil değiştirme 
Dil değiştirme butonlarına tıklandığında ise LocaleChanger sınıfındaki overrideLocale fonksiyonuna gidilir.

Buradaki ilk hedef SharedPreferences içerisine seçilen dili kaydetmek.

Bunu ben 'Language' ismiyle saklıyorum.Çağırırkende bu isimle çağırıyorum.


Daha sonra Locale değişkenini ayarlıyoruz ve anlık olarak contexti güncelliyoruz.

Context şuan güncel fakat arayüz yenilenmediği için anlık bir değişiklik olmayacak.

Anlık değişikliği görebilmek içinse recreate() fonsiyonunu kullanıyoruz.

Bu fonksiyon bulunan activity sınıfını tekrar oluşturur.


Uygulamamız hazır.


