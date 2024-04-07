 package corteDos.actividad1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

 public class MainActivity extends AppCompatActivity {
     
     RecyclerView lista;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         lista= (RecyclerView) findViewById(R.id.RecyclerView1);
         new BackgroundTask().execute();

     }

     private class BackgroundTask extends AsyncTask<String,Integer,String> {

         @Override
         protected String doInBackground(String... strings) {

             int contador = 10;
             for(int i=0; i<10; i++ ){

                 try {
                     Thread.sleep(6000);
                     Log.e("Progreso: ",""+i);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
             return "se termino la tarea en back";
         }

         @Override
         protected void onProgressUpdate(Integer... values) {
             super.onProgressUpdate(values);
         }

         @Override
         protected void onPostExecute(String s) {

             Toast.makeText(MainActivity.this, "Termino la tarea en doBack", Toast.LENGTH_SHORT).show();
             Log.e("Terminados",""+s);
             super.onPostExecute(s);
         }
     }
}