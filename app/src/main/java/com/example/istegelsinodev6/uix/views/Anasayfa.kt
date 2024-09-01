package com.example.istegelsinodev6.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import com.example.istegelsinodev6.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.istegelsinodev6.data.entity.Kategoriler
import com.example.istegelsinodev6.data.entity.Urunler

@Composable
fun Anasayfa(navController: NavController) {
    val kategorilerListesi = remember { mutableStateListOf<Kategoriler>() }
    val urunlerListesi = remember { mutableStateListOf<Urunler>() }


    LaunchedEffect(key1 = true) {
        kategorilerListesi.addAll(
            listOf(
                Kategoriler(1, "Kırmızı İndirimler", "kirmizi"),
                Kategoriler(2, "Okul İhtiyaçları", "mavi"),
                Kategoriler(3, "Yeni Ürünler", "mor"),
                Kategoriler(4, "Organik", "sari"),
                Kategoriler(5, "Ev Ekonomisi", "yesil"),
                Kategoriler(6, "Çok Satanlar", "turuncu"),
                Kategoriler(7, "Biz Taşıyalım", "koyuyesil"),
                Kategoriler(8, "Glutensiz", "koyumor"),
                Kategoriler(9, "Vegan", "haki"),
                Kategoriler(10, "Bitiriyoruz", "koyumavi")
            )
        )
    }

    LaunchedEffect(key1 = true) {
        urunlerListesi.addAll(
            listOf(
                Urunler(1, "Meyve,\nSebze", "image1"),
                Urunler(2, "Et,Tavuk,\nBalık", "image2"),
                Urunler(3, "Süt Ürünleri", "image3"),
                Urunler(4, "Kahvaltılık", "image4"),
                Urunler(5, "Temel Gıda", "image5"),
                Urunler(6, "Atıştırmalık", "image6"),
                Urunler(7, "Su,İçecek", "image7"),
                Urunler(8, "Donuk,Hazır \nGıda", "image8"),
                Urunler(9, "Fırın,Pastane", "image9"),
                Urunler(10, "Pasta ve Malzemeleri", "image10"),
                Urunler(11, "Tatlı,Dondurma", "image11"),
                Urunler(12, "Çay,Kahve", "image12"),
                Urunler(13, "Temizlik,\nDeterjan", "image13"),
                Urunler(14, "Kişisel Bakım", "image14"),
                Urunler(15, "Evcil Dostlara", "image15"),
                Urunler(16, "Bebek", "image16"),
                Urunler(17, "Ev Yaşam", "image17"),
                Urunler(18, "Vitamin,Dermo\nkozmetik", "image18"),
                Urunler(19, "Teknoloji,\nDijital Ürünler", "image19"),
                Urunler(20, "Kitap,Dergi", "image20")
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.istegelsinustlogo),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp),
                    tint = Color.Unspecified
                )
                Icon(
                    painter = painterResource(id = R.drawable.ustbar),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Unspecified
                )
            }
        }
        item {
            Icon(
                painter = painterResource(id = R.drawable.indirim),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 0.dp),
                tint = Color.Unspecified
            )
        }
        item {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(1),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                items(kategorilerListesi.size) { index ->
                    val kategori = kategorilerListesi[index]
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            val activity = (LocalContext.current as Activity)
                            Image(
                                bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(
                                        kategori.resim,
                                        "drawable",
                                        activity.packageName
                                    )
                                ),
                                contentDescription = "",
                                modifier = Modifier.size(90.dp, 90.dp)
                            )
                            Text(
                                text = kategori.ad,
                                modifier = Modifier.padding(top = 0.dp), // Removed extra padding
                                fontSize = 10.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            ) {
                for (i in 0 until 5) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 1.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (j in 0 until 4) {
                            val index = i * 4 + j
                            if (index < urunlerListesi.size) {
                                val urun = urunlerListesi[index]
                                Card(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .weight(1f)
                                        .height(150.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                        modifier = Modifier.padding(0.dp)
                                    ) {
                                        val activity = (LocalContext.current as Activity)
                                        Image(
                                            bitmap = ImageBitmap.imageResource(
                                                id = activity.resources.getIdentifier(
                                                    urun.resim,
                                                    "drawable",
                                                    activity.packageName
                                                )
                                            ),
                                            contentDescription = "",
                                            modifier = Modifier.size(90.dp, 90.dp)
                                        )
                                        Text(
                                            text = urun.ad,
                                            modifier = Modifier.padding(top = 1.dp),
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    }

