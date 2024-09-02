package com.example.istegelsinodev6.uix.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.istegelsinodev6.R

@Composable
fun BottomBarSayfa(navController: NavController) {
    val secilenItem = remember { mutableStateOf(0) }

    val selectedColor = Color(0xFF32a852)
    val unSelectedColor = Color(0xFFB2B9C1)

    Scaffold(
        bottomBar = {
            Column {
                Card(
                    modifier = Modifier.fillMaxWidth()
                    .background(Color.White),
                   // elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(horizontal = 3.dp, vertical = 6.dp)
                            .height(40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFFE9F5F1))
                                .padding(start = 8.dp, end = 10.dp)
                                .align(Alignment.CenterVertically)
                                .height(40.dp)
                        ) {
                            Text(
                                text = "Sepete Ekle Kazan",
                                color = Color(0xFF599F85),
                                textAlign = TextAlign.End,
                                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
                                modifier = Modifier.align(Alignment.CenterEnd)
                            )
                        }
                        Text(
                            text = "Minimum Alışveriş Tutarı\n225,00₺ kaldı",
                            color = Color(0xFF599F85),
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End,
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }
                BottomAppBar(
                    containerColor = Color.White,
                    contentColor = Color.White,
                    tonalElevation = 40.dp,
                    content = {
                        NavigationBarItem(
                            selected = secilenItem.value == 0,
                            onClick = {
                                secilenItem.value = 0
                                navController.navigate("anasayfa") { launchSingleTop = true }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.altlogo),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp),
                                    tint = if (secilenItem.value == 0) selectedColor else unSelectedColor
                                )
                            },
                            label = { Text(text = "istegelsin", color = Color.Gray) }
                        )
                        NavigationBarItem(
                            selected = secilenItem.value == 1,
                            onClick = {
                                secilenItem.value = 1
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.altara),
                                    contentDescription = "",
                                    modifier = Modifier.size(22.dp),
                                    tint = if (secilenItem.value == 1) selectedColor else unSelectedColor
                                )
                            },
                            label = { Text(text = "arama", color = Color.Gray) }
                        )
                        NavigationBarItem(
                            selected = secilenItem.value == 2,
                            onClick = {
                                secilenItem.value = 2
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.sepet),
                                    contentDescription = "",
                                    modifier = Modifier.size(64.dp),
                                    tint = Color.Unspecified,

                                    )
                            },
                            label = { Text(text = "0,00₺", color = Color.Gray) }
                        )
                        NavigationBarItem(
                            selected = secilenItem.value == 3,
                            onClick = {
                                secilenItem.value = 3
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.kampanya),
                                    contentDescription = "",
                                    modifier = Modifier.size(22.dp),
                                    tint = if (secilenItem.value == 3) selectedColor else unSelectedColor
                                )
                            },
                            label = { Text(text = "kampanya", color = Color.Gray) }
                        )
                        NavigationBarItem(
                            selected = secilenItem.value == 4,
                            onClick = {
                                secilenItem.value = 4
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.hesabim),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp),
                                    tint = if (secilenItem.value == 4) selectedColor else unSelectedColor
                                )
                            },
                            label = { Text(text = "hesabım", color = Color.Gray) }
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (secilenItem.value == 0) {
                Anasayfa(navController)
            }
        }
    }
}