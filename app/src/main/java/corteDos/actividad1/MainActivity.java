 package corteDos.actividad1;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    ListView lista;
     ArrayList<String> listaItems = new ArrayList<>();
     ProgressBar barra;


     @SuppressLint("MissingInflatedId")
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         lista= (ListView) findViewById(R.id.ListView1);
         barra = findViewById(R.id.ProgressBarra);
         llenarLista();

     }

     public void llenarLista() {
         new ClaseAsincrona().execute();
     }
     private class ClaseAsincrona extends AsyncTask<Void, Void, ArrayList<String>> {

         @Override
         protected ArrayList<String> doInBackground(Void... voids) {
             int tiempo = 600;
             ArrayList<String> CargarLista= new ArrayList<>();
             for (int i = 0; i < 10; i++) {
                 CargarLista.add("Objeto" + i);
                 publishProgress(); // Notificar el progreso
                 try {
                     Thread.sleep(tiempo);

                 }catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             return CargarLista;
         }

         @Override
         protected void onProgressUpdate(Void... values) {
             super.onProgressUpdate(values);
             barra.incrementProgressBy(10);
         }

         @Override
         protected void onPostExecute(ArrayList<String> strings) {
             super.onPostExecute(strings);
             listaItems = strings;
             ArrayAdapter<String> adaptadorLista = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_checked, listaItems);
             lista.setAdapter(adaptadorLista);
         }
     }

     @Override
     protected void onDestroy() {
         super.onDestroy();
     }
 }