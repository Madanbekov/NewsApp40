package kg.geektech.newsapp40;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class Prefs {
    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("settings", context.MODE_PRIVATE);
    }

    public void saveBoardState() {
        preferences.edit().putBoolean("board_state", true).apply(); //Запись значений t/f
    }

    public boolean isBoardShown() {
        return preferences.getBoolean("board_state", false);
    }

    public void saveUserName(String nameEt) {
        preferences.edit().putString("editname",nameEt).apply();
    }
    public String getUserName(){
        return preferences.getString("editname","");
    }
    public void savePicture(String image){
        preferences.edit().putString("picture",image.toString()).apply();
    }
    public String getPicture(){
        return preferences.getString("picture","");
    }

}
