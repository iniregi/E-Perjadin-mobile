package com.example.e_perjadin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi views
        loginButton = findViewById(R.id.login_button);
        usernameEditText = findViewById(R.id.username_edittext);
        passwordEditText = findViewById(R.id.password_edittext);

        // Set click listener untuk tombol login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil nilai dari EditText username dan password
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Mengecek apakah username dan password tidak kosong
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    // Membuat permintaan login ke server
                    String url = "http://localhost/E-Perjadin/login.php";
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        String status = jsonResponse.getString("status");
                                        String message = jsonResponse.getString("message");
                                        if (status.equals("success")) {
                                            // Login berhasil
                                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                            // Lanjutkan ke aktivitas berikutnya setelah login sukses
                                            Intent intent = new Intent(MainActivity.this, FormPegawaiActivity.class);
                                            startActivity(intent);
                                        } else {
                                            // Login gagal
                                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Kesalahan saat melakukan permintaan HTTP
                            Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("username", username);
                            params.put("password", password);
                            return params;
                        }
                    };

                    // Menambahkan permintaan ke antrian permintaan
                    queue.add(stringRequest);
                }
            }
        });
    }

}

