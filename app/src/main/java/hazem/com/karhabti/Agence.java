package hazem.com.karhabti;


import com.google.firebase.firestore.FirebaseFirestore;


public class Agence
{
    private static final Object MainActivity = hazem.com.karhabti.MainActivity.class;
    FirebaseFirestore DB;
  private  int id,num;
  private   String Adress,Nom;
  private   float longitude,latitude;




    public Agence(int num, String adress, String nom, float longitude, float latitude) {
        this.num = num;
        Adress = adress;
        Nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getAdress() {
        return Adress;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
