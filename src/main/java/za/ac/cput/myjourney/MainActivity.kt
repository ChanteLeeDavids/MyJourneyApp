package za.ac.cput.myjourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.ac.cput.myjourney.ui.theme.MyJourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageWave()
                Text(
                    text = "Welcome",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 60.sp
                )
                Text(
                    text = " To My Jetpack Compose Journey",
                    modifier = Modifier.padding(
                        top = 5.dp,
                        bottom = 16.dp
                    ),
                    fontSize = 20.sp,
                )
                ContentView()
            }
        }
    }
}

@Composable
fun ImageWave(){
    Image(painter = painterResource(id = R.drawable.welcome),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp, 150.dp)
    )
}

@Composable
fun ContentView(){
    var dialogState by remember{
        mutableStateOf(false)
    }

    Button(
        modifier = Modifier.padding(20.dp),
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(0.dp,0.dp),
        contentPadding = PaddingValues(20.dp,12.dp),
        border = BorderStroke(2.dp, Color.Blue),
        onClick = {
            dialogState = true
        },
        colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Blue,
            contentColor = White
        )
    ){
        Text(text = "Info",
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Image(painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
    }

    SystemAlertDialog(dialogState){
        dialogState = !it
    }

}

@Composable
fun SystemAlertDialog(dialogState: Boolean, onDismiss: (dialogState: Boolean) -> Unit){

    if(dialogState){

        AlertDialog(
            onDismissRequest = {
                onDismiss(dialogState)
            },
            title = {
                Text(
                    text = "My Jetpack Compose Journey",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5
                )
            },
            text = {
                Text(
                    text = "We are increasingly inclined to use a mobile phone for everything, from ordering food to booking an Uber, with the push of a few buttons. It makes our lives so much easier, and by choosing mobile programming as an elective, I am one step closer to being a part of the solution to modern-day problems.",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            },
            confirmButton = {
                TextButton(
                    shape = CircleShape,
                    elevation = ButtonDefaults.elevation(0.dp,0.dp),
                    contentPadding = PaddingValues(20.dp,12.dp),
                    border = BorderStroke(2.dp, Color.Blue),
                    onClick = {
                        onDismiss(dialogState)
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.White
                    )
                ){
                    Text(
                        "OK",
                        fontSize = 16.sp
                    )
                }
            },
        )

    }
}
