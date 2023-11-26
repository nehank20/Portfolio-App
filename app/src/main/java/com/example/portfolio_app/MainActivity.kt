package com.example.portfolio_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio_app.ui.theme.PortfolioappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioappTheme {
                // A surface container using the 'background' color from the theme
                PortFolioApp()
            }
        }
    }
}

@Composable
fun PortFolioApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
    ) {

        var showProjects by remember {
            mutableStateOf(false)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        ) {

            AddSpace()
            Image(
                painter = painterResource(id = R.drawable.ic_profile_three),
                contentDescription = "profile_user",
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .border(width = 4.dp, color = Color.Green, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            AddSpace()
            Text(
                text = "Nehank Poilkar", style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            AddSpace()
            Text(
                text = "Android Compose Developer", style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                )
            )
            AddSpace()
            AddSpace()
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "instagram_logo",
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "/nehankpoilkar/instagram", style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface,

                        ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            AddSpace()
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_github),
                    contentDescription = "github_logo",
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "/nehankpoilkar/github", style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                    ), modifier = Modifier.padding(start = 8.dp)
                )
            }
            AddSpace()
            AddSpace()
            Button(onClick = {
                showProjects = !showProjects
            }) {
                Text(text = "My Projects")
            }

            AddSpace()
            AddSpace()
            AddSpace()
            AddSpace()


            if(showProjects){
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItem(project = it)
                    }
                }
            }

        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(modifier = Modifier.size(50.dp), painter = painterResource(id = R.drawable.ic_user), contentDescription = "user_image")
        Spacer(modifier = Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = project.name, style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = project.desc, style = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 14.sp
            ))
        }
    }
}

@Composable
fun AddSpace() {
    Spacer(modifier = Modifier.height(8.dp))
}

fun getProjectList(): List<Project> {
    return listOf<Project>(
        Project("Nexarc", "B2B app for MSME "),
        Project("Towntalk", "Newspaper app in local language")
    )
}

data class Project(val name: String, val desc: String)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioappTheme {
        PortFolioApp()
    }
}