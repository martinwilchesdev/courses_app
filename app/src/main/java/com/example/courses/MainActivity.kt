package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataResource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                CoursesApp(DataResource.topics)
            }
        }
    }
}

@Composable
fun CoursesApp(topics: List<Topic>) {
    TopicList(topics = topics)
}

@Composable
fun TopicCard(modifier: Modifier = Modifier, topic: Topic) {
    Card {
        Row {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = null
            )
            Column {
                Spacer(modifier.height(16.dp))
                Text(
                    stringResource(id = topic.name),
                    modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier.height(8.dp) )
                Text(topic.relatedCourses.toString())
            }
        }
    }
}

@Composable
fun TopicList(topics: List<Topic>) {
    LazyColumn {
        items(topics) {topic ->
            TopicCard(modifier = Modifier, topic = topic)
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        TopicList(DataResource.topics)
    }
}