package com.example.testapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {

    val dataVm : DataVm by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowData(dataVm)
                    dataVm.getData()
                }
            }
        }
    }
}

@Composable
fun ShowData(dataVm: DataVm) {

    LazyColumn{
        itemsIndexed(items = dataVm.data){index, item ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)) {
                Column {
                   Text(text = item.title)

                   Spacer(modifier = Modifier.height(4.dp))

                    androidx.compose.foundation.Image(
                        painter = rememberAsyncImagePainter(model = item.thumbnailUrl),
                        contentDescription ="image" ,
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        contentScale = ContentScale.FillWidth)

                }
            }
        }
    }

}

