package com.kapps.flowsyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kapps.flowsyt.ui.theme.FlowsYTTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowsYTTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Button(onClick = {
                        viewModel.startGenerate()
                    }) {
                        Text("Start Export")
                    }
                }
                if(viewModel.isLoading){
                    Dialog(
                        onDismissRequest = {}
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            CircularProgressIndicator(
                                color = Color.White
                            )
                            Text(
                                "Processing user data (${viewModel.progressState} %) ...",
                                color = Color.White,
                                style = MaterialTheme.typography.body1
                            )

                        }
                    }
                }
            }
        }
    }
}
