package com.example.lab_mobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    // Deklarasi view yang akan diubah datanya
    private TextView tvName, tvBio, tvUsernameTop, tvPosts, tvFollowers, tvFollowing;
    private ShapeableImageView ivProfileMain;
    private ImageView ivPost1, ivPost2, ivPost3;
    private Uri currentProfileImageUri;
    public UserProfile userDiani;

    // Launcher untuk menerima data kembali dari Edit Profile (NextActivity)
    private final ActivityResultLauncher<Intent> editProfileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    // Ambil data yang dikirim balik
                    String newName = result.getData().getStringExtra("name");
                    String newUsername = result.getData().getStringExtra("username");
                    String newBio = result.getData().getStringExtra("bio");
                    String newImageUriString = result.getData().getStringExtra("image_uri");
                    String newGender = result.getData().getStringExtra("gender");

                    // Update model data
                    if (newName != null) userDiani.setNama(newName);
                    if (newUsername != null) userDiani.setUsername(newUsername);
                    if (newBio != null) userDiani.setBio(newBio);
                    if (newGender != null) userDiani.setJenisKelamin(newGender);

                    // Update tampilan UI dengan data baru
                    tvName.setText(newName);
                    tvBio.setText(newBio);
                    tvUsernameTop.setText(newUsername);
                    
                    if (newImageUriString != null) {
                        currentProfileImageUri = Uri.parse(newImageUriString);
                        ivProfileMain.setImageURI(currentProfileImageUri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        userDiani = new UserProfile(
                "deee ",
                "dianins._",
                "born to die",
                "Perempuan",
                R.drawable.foto1,
                1648,
                1049,
                3
        );

        // Menangani padding sistem (status bar/navigasi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi View
        tvName = findViewById(R.id.tv_name);
        tvBio = findViewById(R.id.tv_bio);
        tvUsernameTop = findViewById(R.id.tv_username_top);
        tvPosts = findViewById(R.id.tv_posts);
        tvFollowers = findViewById(R.id.tv_followers);
        tvFollowing = findViewById(R.id.tv_following);
        Button btnEditProfile = findViewById(R.id.btn_edit_profile);
        ivProfileMain = findViewById(R.id.iv_profile_main);
        ivPost1 = findViewById(R.id.iv_post_1);
        ivPost2 = findViewById(R.id.iv_post_2);
        ivPost3 = findViewById(R.id.iv_post_3);

        tvName.setText(userDiani.getNama());
        tvBio.setText(userDiani.getBio());
        tvUsernameTop.setText(userDiani.getUsername());
        ivProfileMain.setImageResource(userDiani.getFotoResId());
        tvPosts.setText(String.valueOf(userDiani.getPosts()));
        tvFollowers.setText(String.valueOf(userDiani.getFollowers()));
        tvFollowing.setText(String.valueOf(userDiani.getFollowing()));


        // Klik tombol Edit Profil
        btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            
            // Kirim data saat ini ke halaman edit agar bisa diubah
            intent.putExtra("current_name", userDiani.getNama());
            intent.putExtra("current_username", userDiani.getUsername());
            intent.putExtra("current_bio", userDiani.getBio());
            intent.putExtra("current_gender", userDiani.getJenisKelamin());
            
            if (currentProfileImageUri != null) {
                intent.putExtra("current_image_uri", currentProfileImageUri.toString());
            } else {
                // Kirim resource ID awal jika foto belum pernah diganti
                intent.putExtra("current_image_res", userDiani.getFotoResId());
            }
            
            editProfileLauncher.launch(intent);
        });

        // Setup Post Click Listeners
        setupPostClick(ivPost1, R.drawable.kucing, "Mengabadikan sebuah moment itu penting, kenapa? karena di setiap potretan ada kenangan yang tidak bisa kita ulang kembali.");
        setupPostClick(ivPost2, R.drawable.kucing2, "Kesempatan tidak datang dua kali.");
        setupPostClick(ivPost3, R.drawable.foto1, "Profil saya.");
    }

    private void setupPostClick(ImageView iv, int postImageResId, String caption) {
        iv.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
            
            // Kirim data profil yang dinamis
            if (currentProfileImageUri != null) {
                intent.putExtra("profile_image_uri", currentProfileImageUri.toString());
            } else {
                intent.putExtra("profile_image_res", userDiani.getFotoResId());
            }
            
            intent.putExtra("post_image_res_id", postImageResId);
            intent.putExtra("username", userDiani.getUsername());
            intent.putExtra("caption", caption);
            startActivity(intent);
        });
    }
}
